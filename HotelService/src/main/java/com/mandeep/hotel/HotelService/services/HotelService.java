package com.mandeep.hotel.HotelService.services;

import java.util.List;

import com.mandeep.hotel.HotelService.entities.Hotel;

public interface HotelService {
	Hotel addHotel(Hotel hotel);
	List<Hotel> getAllHotel();
	Hotel getHotel(String id);
}
