/**
 * 
 */
package com.misco.server.filter;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * @author liuwei gateway 提供的限流过滤的 过滤条件 有ip 有 参数 有路径 配置类 - name:
 *         RequestRateLimiter #gateway 提供的限流过滤器 args: key-resolver:
 *         '#{@pathKeyResolver}' #prEl 获取这个过滤条件器 比如这个列返回的是路径 或者 参数 或者ip等 那么 这个路径
 *         。。ip、就会放到令牌桶离去 redis-rate-limiter.replenishRate: 1 #令牌桶中的美妙能放进去的令牌数
 *         频率 每秒1个令牌 redis-rate-limiter.burstCapacity: 3 # 表示这个redis令牌桶的总大小只有3个
 *         超过这个值去拒绝qps 或者等待
 * 
 */
@Configuration
@Slf4j
public class PathKeyResolverConfig {

	// 请求路径
	// 这个bean的名称必须和我们yml 配置的 key-resolver prEl 表达式的变量一样 key-resolver :
	// '#{@PathKeyResolver}'
	// ServerWebExchange 类似我们zuul 的 RequestContext 可以获取路径 ip
	@Bean
	public KeyResolver pathKeyResolver() {
		return new KeyResolver() {
			@Override
			public Mono<String> resolve(ServerWebExchange exchange) {
				log.info("gateway 通过RequestLateLimiter 过滤器 ，条件为 路径 ：{},那么这个路径将会被放到令牌桶中"
						+ exchange.getRequest().getPath());
				return Mono.just(exchange.getRequest().getPath().toString());
			}
		};
	}

//	// 请求参数 进行限流 ,那么这个key 一定要特定的key 进行限流 可以指定特定key 进行限流操作
//	@Bean
//	@Primary
//	public KeyResolver pathParamResolver() {
//		return exchange ->
//		// 这是参数
//		Mono.just(exchange.getRequest().getQueryParams().getFirst("userId"));
//		// ip限流
//		//Mono.just(exchange.getRequest().getHeaders().getFirst("X-Forwarded-For"));
//	}

}
