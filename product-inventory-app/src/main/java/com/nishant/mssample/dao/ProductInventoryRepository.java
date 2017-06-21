package com.nishant.mssample.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nishant.mssample.domain.ProductInventory;

@Repository
public interface ProductInventoryRepository extends MongoRepository<ProductInventory, String>, ProductInventoryRepositoryCustom {
	
}
