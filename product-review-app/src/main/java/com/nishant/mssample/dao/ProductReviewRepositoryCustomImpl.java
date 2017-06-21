package com.nishant.mssample.dao;

import java.util.List;

//imports as static
import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;

import com.nishant.mssample.domain.ProductReview;
import com.nishant.mssample.domain.ProductReviewCount;

@Component
public class ProductReviewRepositoryCustomImpl implements ProductReviewRepositoryCustom{

	@Autowired
	MongoTemplate mongoTemplate;

	public List<ProductReviewCount> getProductReviewCount(String productId) {

		Aggregation agg = newAggregation(match(Criteria.where("item_id").is(productId)), group("rating").count().as("total"),
				project("total").and("rating").previousOperation(), sort(Sort.Direction.DESC, "total")

		);

		// Convert the aggregation result into a List
		AggregationResults<ProductReviewCount> groupResults = mongoTemplate.aggregate(agg, ProductReview.class, ProductReviewCount.class);
		List<ProductReviewCount> result = groupResults.getMappedResults();

		return result;

	}
}