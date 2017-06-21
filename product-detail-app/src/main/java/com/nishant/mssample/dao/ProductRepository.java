package com.nishant.mssample.dao;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.nishant.mssample.domain.Product;

//@Repository("productRepository")
public interface ProductRepository extends MongoRepository<Product, String> {

	Product findFirstByItemId(String itemId);
}
