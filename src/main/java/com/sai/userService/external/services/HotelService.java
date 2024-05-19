package com.sai.userService.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sai.userService.model.Hotel;

@FeignClient(name = "hotel-service")
public interface HotelService {
	
	@GetMapping("/hotels/{hotelId}")
	Hotel getHOtelById(@PathVariable String hotelId);
}
