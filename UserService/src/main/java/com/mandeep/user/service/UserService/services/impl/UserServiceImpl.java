package com.mandeep.user.service.UserService.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mandeep.user.service.UserService.entities.Hotel;
import com.mandeep.user.service.UserService.entities.Rating;
import com.mandeep.user.service.UserService.entities.User;
import com.mandeep.user.service.UserService.exceptions.ResourceNotFoundException;
import com.mandeep.user.service.UserService.repositories.UserRepository;
import com.mandeep.user.service.UserService.services.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepo;
	@Autowired
	RestTemplate restTemplate;
	@Override
	public User saveUser(User user) {
		String randomId=UUID.randomUUID().toString();
		user.setUserId(randomId);
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User getUser(String userId) {
		User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found in Server"+userId));
		Rating[] forObject = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+userId, Rating[].class);
		System.out.println("Rating ka data aa gaya bhai********** "+(forObject[0].getHotelId()));
		List<Rating> ratings = Arrays.stream(forObject).toList();
		List<Rating> ratingList = ratings.stream().map(rating->{
			ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/463fdade-ab05-4682-8d0d-b938af63c113", Hotel.class);
			Hotel hotel = forEntity.getBody();
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());
		user.setRatings(ratingList);
		return user;
	}

}
