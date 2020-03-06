/**
 * 
 */
package com.misco.server.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.misco.server.dto.TbProduct;

/**
 * @author liuwei
 * feign 组件
 * 开启注解
 * 类似和被调用者类似spring mvc 调用
 * 
 */
@FeignClient(name = "misco-product")//name 就是服务的名称 和 value 一样
public interface ProductFeign {
	@GetMapping("/product/{id}")//不支持正则 对参数 比如 {id:\\d+}
	public TbProduct findById(@PathVariable("id") Long id);
}
