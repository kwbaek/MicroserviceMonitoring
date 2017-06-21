package com.nishant.mssample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nishant.mssample.dao.ProductInventoryRepository;
import com.nishant.mssample.domain.ProductInventory;

@RestController
public class ProductInventoryController {

	
	@Autowired
	ProductInventoryRepository repository;
	
//	@Autowired
//	ProductInventoryRepositoryCustom customRepository;
	
 
    @RequestMapping(value = "/prodinventory/{itemid}", method = RequestMethod.GET)
    public List<ProductInventory> getInventoryByItem(@PathVariable("itemid") String id) {
    	System.out.println(" In ProductInventoryController getInventoryByItem");
        return repository.getInventoryByItemId(id);
    }
}
