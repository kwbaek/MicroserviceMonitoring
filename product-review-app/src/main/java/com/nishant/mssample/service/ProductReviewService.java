/**
 * 
 */
package com.nishant.mssample.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.nishant.mssample.dao.ProductReviewRepositoryCustom;
import com.nishant.mssample.domain.ProductReviewCount;

/**
 * @author nishant
 *
 */
@Service
public class ProductReviewService {
	private static final Logger LOG = Logger.getLogger(ProductReviewService.class.getName());
	@Autowired
	ProductReviewRepositoryCustom customRepository;
	
	@HystrixCommand(fallbackMethod = "getRatingCountsFallback")
	public List<ProductReviewCount> getRatingCounts(String id) {
		LOG.log(Level.INFO," In ProductReviewService getRatingCounts");
        return customRepository.getProductReviewCount(id);
    }
	
	public List<ProductReviewCount> getRatingCountsFallback(String id) {
		LOG.log(Level.INFO," In ProductReviewService fallback");
    	
        return new ArrayList<ProductReviewCount>();
    }

}
