package com.nishant.mssample.dao;

import java.util.List;

import com.nishant.mssample.domain.ProductReviewCount;

public interface ProductReviewRepositoryCustom {

	public List<ProductReviewCount> getProductReviewCount(String productId);
}
