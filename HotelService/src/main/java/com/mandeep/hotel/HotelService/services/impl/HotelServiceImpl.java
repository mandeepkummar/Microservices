package com.mandeep.hotel.HotelService.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mandeep.hotel.HotelService.entities.Hotel;
import com.mandeep.hotel.HotelService.exceptions.ResourceNotFoundException;
import com.mandeep.hotel.HotelService.repositories.HotelRepository;
import com.mandeep.hotel.HotelService.services.HotelService;
@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	private HotelRepository hotelRepo;
	//@Autowired
	//private RestTemplate restTemplate;
	@Override
	public Hotel addHotel(Hotel hotel) {
		String randomId=UUID.randomUUID().toString();
		hotel.setId(randomId);
		return hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		return hotelRepo.findAll();
	}

	@Override
	public Hotel getHotel(String id) {
		return hotelRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel with given Id not found"+id));
	}

}
