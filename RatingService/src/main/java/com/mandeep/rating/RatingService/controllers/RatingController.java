package com.mandeep.rating.RatingService.controllers;

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
import org.springframework.web.servlet.function.EntityResponse;

import com.mandeep.rating.RatingService.entities.Rating;
import com.mandeep.rating.RatingService.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	@Autowired
	RatingService ratingService;
	
	@PostMapping
	public ResponseEntity<Rating> saveRating(@RequestBody Rating rating){
		Rating rating1 = ratingService.saveRating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
	}
	@GetMapping("/{ratingId}")
	public ResponseEntity<Rating> getRatingById(@PathVariable String ratingId){
		Rating rating = ratingService.getRatingById(ratingId);
		return ResponseEntity.ok(rating);
	}
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings(){
		List<Rating> ratingList = ratingService.getAllRatings();
		return ResponseEntity.ok(ratingList);
	}
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
		List<Rating> ratingList = ratingService.getRatingByUserId(userId);
		return ResponseEntity.ok(ratingList);
	}
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
		List<Rating> ratingList = ratingService.getRatingByHotelId(hotelId);
		return ResponseEntity.ok(ratingList);
	}
}