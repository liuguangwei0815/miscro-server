package com.misco.server.service;

import java.util.List;

import com.misco.server.entity.TbProduct;

public interface TbProductService {
	// 根据id查询
	TbProduct findById(Long id);

	// 查询全部
	List<TbProduct> findAll();

	// 保存
	void save(TbProduct product);

	// 更新
	void update(TbProduct product);

	// 删除
	void delete(Long id);
}
