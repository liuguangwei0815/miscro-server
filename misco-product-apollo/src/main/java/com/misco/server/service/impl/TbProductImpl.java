package com.misco.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misco.server.dao.TbProductResposity;
import com.misco.server.entity.TbProduct;
import com.misco.server.service.TbProductService;

@Service
public class TbProductImpl implements TbProductService {

	@Autowired
	TbProductResposity tbProductResposity;

	@Override
	public TbProduct findById(Long id) {
		return tbProductResposity.findById(id).get();
	}

	@Override
	public List<TbProduct> findAll() {
		return (List<TbProduct>) tbProductResposity.findAll();
	}

	@Override
	public void save(TbProduct product) {
		tbProductResposity.save(product);
	}

	@Override
	public void update(TbProduct product) {
		save(product);
	}

	@Override
	public void delete(Long id) {
		tbProductResposity.deleteById(id);
	}

}
