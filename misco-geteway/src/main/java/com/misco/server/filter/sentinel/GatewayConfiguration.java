package com.misco.server.filter.sentinel;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.result.view.ViewResolver;
import org.springframework.web.server.ServerWebExchange;

import com.alibaba.csp.sentinel.adapter.gateway.common.SentinelGatewayConstants;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiDefinition;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiPathPredicateItem;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiPredicateItem;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.GatewayApiDefinitionManager;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayFlowRule;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayRuleManager;
import com.alibaba.csp.sentinel.adapter.gateway.sc.SentinelGatewayFilter;
import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
import com.alibaba.csp.sentinel.adapter.gateway.sc.exception.SentinelGatewayBlockExceptionHandler;

import reactor.core.publisher.Mono;

//@Configuration 测试网关高可用 先注释这个sentinel 的流控
public class GatewayConfiguration {

	private final List<ViewResolver> viewResolvers;

	private final ServerCodecConfigurer serverCodecConfigurer;

	public GatewayConfiguration(ObjectProvider<List<ViewResolver>> viewResolversProvider,
			ServerCodecConfigurer serverCodecConfigurer) {
		this.viewResolvers = viewResolversProvider.getIfAvailable(Collections::emptyList);
		this.serverCodecConfigurer = serverCodecConfigurer;
	}

	/**
	 * 配置限流的异常处理器:SentinelGatewayBlockExceptionHandler
	 */
	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public SentinelGatewayBlockExceptionHandler sentinelGatewayBlockExceptionHandler() {
		return new SentinelGatewayBlockExceptionHandler(viewResolvers, serverCodecConfigurer);
	}

	/**
	 * 配置限流过滤器
	 */
	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public GlobalFilter sentinelGatewayFilter() {
		return new SentinelGatewayFilter();
	}

	@PostConstruct
	public void initBlockHandlers() {
		BlockRequestHandler blockRequestHandler = new BlockRequestHandler() {
			public Mono<ServerResponse> handleRequest(ServerWebExchange serverWebExchange, Throwable throwable) {
				Map map = new HashMap<>();
				map.put("code", 001);
				map.put("message", "对不起,接口限流了");
				return ServerResponse.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(BodyInserters.fromObject(map));
			}
		};
		GatewayCallbackManager.setBlockHandler(blockRequestHandler);
	}

	/**
	 * 配置初始化的限流参数
	 * 
	 */
	@PostConstruct
	public void initGatewayRules() {
		Set<GatewayFlowRule> rules = new HashSet<>();
//		rules.add(
//			new GatewayFlowRule("order-service") //资源名称
//					.setCount(1) // 限流阈值
//					.setIntervalSec(1) // 统计时间窗口，单位是秒，默认是 1 秒
//		);
//		rules.add(new GatewayFlowRule("order-service")
//				.setCount(1)
//				.setIntervalSec(1)
//				.setParamItem(new GatewayParamFlowItem()
//						.setParseStrategy(SentinelGatewayConstants.PARAM_PARSE_STRATEGY_URL_PARAM).setFieldName("id")
//				)
//		);
		/**
		 * routes: - id: misco-product #路由id 自定义 1秒只能有2个进来
		 */
		rules.add(new GatewayFlowRule("misco-product")// route id
				.setCount(2) // 统计数
				.setIntervalSec(1) // 间隔
		);
		
		
//		rules.add(new GatewayFlowRule("order-service")
//				.setCount(1)
//				.setIntervalSec(1)
//				.setParamItem(new GatewayParamFlowItem()
//						.setParseStrategy(SentinelGatewayConstants.PARAM_PARSE_STRATEGY_URL_PARAM).setFieldName("id")
//				)
//		);
		
		GatewayRuleManager.loadRules(rules);
	}

	/**
	 * 自定义api 分流规则 1、定义分组 2、对小组配置限流规则 /** routes: - id: misco-product #路由id 自定义
	 * 1秒只能有2个进来 
	 */
	@PostConstruct
	private void initCustomizedApis() {
		Set<ApiDefinition> definitions = new HashSet<>();
		//添加限流分组 ，然后在initGatewayRules 添加规则
		ApiDefinition api1 = new ApiDefinition("product_api").setPredicateItems(new HashSet<ApiPredicateItem>() {
			{	
				//路径
				add(new ApiPathPredicateItem().setPattern("/product-service/product/**")//模糊匹配
						.setMatchStrategy(SentinelGatewayConstants.URL_MATCH_STRATEGY_PREFIX));
			}
		});
		ApiDefinition api2 = new ApiDefinition("order_api").setPredicateItems(new HashSet<ApiPredicateItem>() {
			{
				add(new ApiPathPredicateItem().setPattern("/order-service/order"));// 完整匹配
			}
		});
		
		definitions.add(api1);
		definitions.add(api2);
		GatewayApiDefinitionManager.loadApiDefinitions(definitions);
	}
}
