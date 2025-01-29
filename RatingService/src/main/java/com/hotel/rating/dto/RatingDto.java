package com.hotel.rating.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class RatingDto implements Serializable {

	private String ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
	
}
