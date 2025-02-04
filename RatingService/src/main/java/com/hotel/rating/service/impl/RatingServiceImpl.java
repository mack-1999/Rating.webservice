package com.hotel.rating.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.hotel.rating.dto.RatingDto;
import com.hotel.rating.entities.Rating;
import com.hotel.rating.repository.RatingRepo;
import com.hotel.rating.service.RatingService;

public class RatingServiceImpl implements RatingService{
	
	@Autowired
	RatingRepo ratingRepo;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public RatingDto addRating(RatingDto ratingDto) {
		// Generate & Set random hotel id
		String randomHotelId = UUID.randomUUID().toString();
		ratingDto.setRatingId(randomHotelId);
		
		// Converting DTO to entity class
		Rating ratingData = modelMapper.map(ratingDto, Rating.class);
				
		// Save data into DB
		Rating savedRatingData = this.ratingRepo.save(ratingData);
				
		// Return DTO
		return modelMapper.map(savedRatingData, RatingDto.class);
	}

	@Override
	public List<RatingDto> getAllRatings() {
		List<Rating> results = this.ratingRepo.findAll();
		
		List<RatingDto> ratingDtos = results.stream()
				.map((rating) -> this.modelMapper.map(rating, RatingDto.class)).collect(Collectors.toList());
		
		return ratingDtos;
	}

	@Override
	public List<RatingDto> getAllByUserId(String userId) {
		// Find user id in DB or else throw an user defined exception
		List<Rating> results = this.ratingRepo.findByUserId(userId);

		List<RatingDto> userRatingsDtos = results.stream()
				.map((rating) -> this.modelMapper.map(rating, RatingDto.class)).collect(Collectors.toList());
		
		return userRatingsDtos;
	}

	@Override
	public List<RatingDto> getAllByHotelId(String hotelId) {
		// Find Hotel id in DB or else throw an user defined exception
		List<Rating> results = this.ratingRepo.findByHotelId(hotelId);

		List<RatingDto> hotelRatingsDtos = results.stream()
				.map((rating) -> this.modelMapper.map(rating, RatingDto.class)).collect(Collectors.toList());
		
		return hotelRatingsDtos;
	}

}
