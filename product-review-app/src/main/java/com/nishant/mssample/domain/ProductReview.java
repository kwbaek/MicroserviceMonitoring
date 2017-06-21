package com.nishant.mssample.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product_review")
public class ProductReview {
	
	@Id
    private String id;
			
	private String item_id;
	
	private String reviewer_id;
	
	@Indexed(unique = true)
	private int rating;
	
	private String review_title;
	
	private String review_details;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getReviewer_id() {
		return reviewer_id;
	}

	public void setReviewer_id(String reviewer_id) {
		this.reviewer_id = reviewer_id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReview_title() {
		return review_title;
	}

	public void setReview_title(String review_title) {
		this.review_title = review_title;
	}

	public String getReview_details() {
		return review_details;
	}

	public void setReview_details(String review_details) {
		this.review_details = review_details;
	}
	
	

}
