package com.mandeep.rating.RatingService.services;

import java.util.List;

import com.mandeep.rating.RatingService.entities.Rating;

public interface RatingService {
	Rating saveRating(Rating rating);
	Rating getRatingById(String ratingId);
	List<Rating> getAllRatings();
	List<Rating> getRatingByUserId(String userId);
	List<Rating> getRatingByHotelId(String hotelId);
}
