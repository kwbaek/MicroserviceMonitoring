package com.nishant.mssample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nishant.mssample.dao.ProductRepository;
import com.nishant.mssample.domain.Product;

@RestController
public class ProductDetailController {

	
//	@Autowired
//	ProductReviewRepository repository;
	
	@Autowired
	ProductRepository productRepository;
	
 
    @RequestMapping(value = "/proddetail/{itemid}", method = RequestMethod.GET)
    public Product getDetailByItem(@PathVariable("itemid") String id) {
    	System.out.println(" In ProductDetailController getDetailByItem");
        return productRepository.findFirstByItemId(id);
    }
}
