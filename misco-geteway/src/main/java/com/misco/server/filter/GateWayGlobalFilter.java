/**
 * 
 */
package com.misco.server.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * @author liuwei
 * gateway 全局filter
 */
@Slf4j
@Component
public class GateWayGlobalFilter implements GlobalFilter,Ordered{

	/**
	 * 和zuulFilter 一样 这个值越小 越先执行
	 */
	@Override
	public int getOrder() {
		return 0;
	}

	//执行顺序
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		log.info("gateway 全局过滤器");
		return chain.filter(exchange);
	}
}
