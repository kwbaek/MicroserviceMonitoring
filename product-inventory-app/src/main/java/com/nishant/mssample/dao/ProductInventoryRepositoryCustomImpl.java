package com.nishant.mssample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.nishant.mssample.domain.ProductInventory;

@Component
public class ProductInventoryRepositoryCustomImpl implements ProductInventoryRepositoryCustom{

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<ProductInventory> getInventoryByItemId(String productId) {
		  Query query = new Query();

		  
		      query.addCriteria(Criteria.where("item_id")
		        .is(productId));
		  
		List<ProductInventory> prodInventoryList =  mongoTemplate.find(query, ProductInventory.class);
		return prodInventoryList;
	}
}