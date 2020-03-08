/**
 * 
 */
package com.misco.server.feign;

import org.springframework.stereotype.Component;

import com.misco.server.dto.TbProduct;

/**
 * @author liuwei
 * ProductFeign 的熔断降级方法
 */
@Component //将该方法注册到spring 容器
public class ProductFeignForBack implements ProductFeign {
	//熔断方法
	@Override
	public TbProduct findById(Long id) {
		return new TbProduct("feign 熔断方法");
	}

	@Override
	public TbProduct waitfindById(Long id) {
		return new TbProduct("feign 熔断方法 wait");
	}
}
