package com.mandeep.rating.RatingService.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mandeep.rating.RatingService.entities.Rating;
import com.mandeep.rating.RatingService.exceptions.ResourceNotFoundException;
import com.mandeep.rating.RatingService.repositories.RatingRepository;
import com.mandeep.rating.RatingService.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService {
	@Autowired
	RatingRepository ratingRepo;
	/*@Autowired
	RestTemplate restTemplate;*/
	@Override
	public Rating saveRating(Rating rating) {
		String randomId=UUID.randomUUID().toString();
		rating.setRatingId(randomId);
		return ratingRepo.save(rating);
	}

	@Override
	public Rating getRatingById(String ratingId) {
		// TODO Auto-generated method stub
		return ratingRepo.findById(ratingId).orElseThrow(()->new ResourceNotFoundException("Rating not found for the given id:"+ratingId));
	}

	@Override
	public List<Rating> getAllRatings() {
		return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		return ratingRepo.findByUserId(userId);//orElseThrow(()->new ResourceNotFoundException("Rating not found for the given userId:"+userId));;
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return ratingRepo.findByHotelId(hotelId);//.orElseThrow(()->new ResourceNotFoundException("Rating not found for the given hotelId:"+hotelId));;
	}

}
