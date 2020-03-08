/**
 * 
 */
package com.misco.server.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.misco.server.dto.TbProduct;

/**
 * @author liuwei feign 组件 开启注解 类似和被调用者类似spring mvc 调用 fallback 指定熔断方法
 */
@FeignClient(name = "misco-product", fallback = ProductFeignForBack.class) // name 就是服务的名称 和 value 一样 ,熔断降级和异常的 feign 和
																			// hystrix 都是一样的 需要在feign配置开启就可以了
public interface ProductFeign {
	@GetMapping("/product/{id}") // 不支持正则 对参数 比如 {id:\\d+}
	public TbProduct findById(@PathVariable("id") Long id);

	@GetMapping("/product/wait/{id}") // 不支持正则 对参数 比如 {id:\\d+}
	public TbProduct waitfindById(@PathVariable("id") Long id);
}
