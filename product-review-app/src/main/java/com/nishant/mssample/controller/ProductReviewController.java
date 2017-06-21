package com.nishant.mssample.controller;

import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nishant.mssample.domain.ProductReviewCount;
import com.nishant.mssample.service.ProductReviewService;

@RestController
public class ProductReviewController {

	private static final Logger LOG = Logger.getLogger(ProductReviewController.class.getName());
//	@Autowire
//	ProductReviewRepository repository;
	
	@Autowired
	ProductReviewService productReviewService;
	
 
    @RequestMapping(value = "/prodreview/count/{itemid}", method = RequestMethod.GET)
    public List<ProductReviewCount> getRatingCounts(@PathVariable("itemid") String id) {
    	LOG.log(Level.INFO," In ProductReviewController getRatingCounts");
        return productReviewService.getRatingCounts(id);
    }
}
