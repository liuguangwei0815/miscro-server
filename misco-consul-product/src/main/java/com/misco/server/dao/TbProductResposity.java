/**
 * 
 */
package com.misco.server.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.misco.server.entity.TbProduct;

/**
 * @author liuwei
 *
 */
public interface TbProductResposity extends CrudRepository<TbProduct, Long> ,JpaSpecificationExecutor<TbProduct>{

}
