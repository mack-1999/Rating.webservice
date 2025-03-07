package com.hotel.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.rating.dto.RatingDto;
import com.hotel.rating.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	RatingService ratingService;
	
	// Add rating
	@PostMapping("/add")
	public ResponseEntity<RatingDto> addRating(@RequestBody RatingDto rating){
		return ResponseEntity.status(HttpStatus.CREATED).body(this.ratingService.addRating(rating));
	}
	
	// Get all ratings
	@GetMapping("/getall")
	public ResponseEntity<List<RatingDto>> getAllRating(){
		return ResponseEntity.ok(this.ratingService.getAllRatings());
	}
	
	// Get all ratings by userId
	@GetMapping("/getall/user/{userId}")
	public ResponseEntity<List<RatingDto>> getAllRatingByUserId(@PathVariable String userId){
		return ResponseEntity.ok(this.ratingService.getAllByUserId(userId));
	}
	
	// Get all ratings by hotelId
	@GetMapping("/getall/hotel/{hotelId}")
	public ResponseEntity<List<RatingDto>> getAllRatingByHotelId(@PathVariable String hotelId){
		return ResponseEntity.ok(this.ratingService.getAllByHotelId(hotelId));
	}
	
}
