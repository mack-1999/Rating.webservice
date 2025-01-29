package com.hotel.rating.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.rating.entities.Rating;

public interface RatingRepo extends JpaRepository<Rating, String> {

	// Custom finder Methods
	List<Rating> findByUserId(String userId);
	List<Rating> findByHotelId(String hotelId);
	
}
