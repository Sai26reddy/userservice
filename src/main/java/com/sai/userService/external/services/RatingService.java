package com.sai.userService.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.sai.userService.model.Rating;

@FeignClient(name = "rating-service")
public interface RatingService {
	
	@PostMapping("/ratings")
	Rating createRating(Rating rating);
	
	@PutMapping("/ratings/{ratingId}")
	Rating updateRating(@PathVariable  String ratingId, Rating ratings);
}
