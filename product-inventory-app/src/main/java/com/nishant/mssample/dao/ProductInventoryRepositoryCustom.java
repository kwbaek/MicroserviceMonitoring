package com.nishant.mssample.dao;

import java.util.List;

import com.nishant.mssample.domain.ProductInventory;

public interface ProductInventoryRepositoryCustom {

	public List<ProductInventory> getInventoryByItemId(String productId);
}
