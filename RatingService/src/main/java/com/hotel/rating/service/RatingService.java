package com.hotel.rating.service;

import java.util.List;

import com.hotel.rating.dto.RatingDto;

public interface RatingService {
	
	// Added a Rating
	RatingDto addRating(RatingDto ratingDto);
	
	// Get all Ratings in DB
	List<RatingDto> getAllRatings();
	
	// Get all ratings of particular user
	List<RatingDto> getAllByUserId(String userId);
	
	// Get all ratings of particular hotel
	List<RatingDto> getAllByHotelId(String hotelId);
}
