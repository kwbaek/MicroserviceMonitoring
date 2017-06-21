package com.nishant.mssample.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nishant.mssample.domain.ProductReview;

@Repository
public interface ProductReviewRepository extends MongoRepository<ProductReview, String>, ProductReviewRepositoryCustom {
	
}
