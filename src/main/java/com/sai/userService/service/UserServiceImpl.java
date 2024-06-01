package com.sai.userService.service;

import com.sai.userService.exception.ResourceNotFoundException;
import com.sai.userService.external.services.HotelService;
import com.sai.userService.model.Hotel;
import com.sai.userService.model.Rating;
import com.sai.userService.model.User;
import com.sai.userService.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;



@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		String randomUserId= UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		List<User> users =  userRepository.findAll();
		List<User> finalusers = users.stream().map(user->{
			Rating[] ratingarray = restTemplate.getForObject("http://rating-service/ratings/"+user.getUserId(), Rating[].class);
			List<Rating> ratings = Arrays.stream(ratingarray).toList();
			logger.info("{}", ratings);
			List<Rating> finalratings =  ratings.stream().map(rating->{
			ResponseEntity<Hotel> entity = restTemplate.getForEntity("http://hotel-service/hotels/"+rating.getHotelId(), Hotel.class);
			Hotel hotel = entity.getBody();
			rating.setHotel(hotel);
			return rating;
			}).collect(Collectors.toList());
			user.setRatings(finalratings);
			return user;
		}).collect(Collectors.toList());
		return users;
	}

	@Override
	public User getUser(String userId) {
		User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user with given id is not found on server !! :"+ userId));
		Rating[] ratingarray = restTemplate.getForObject("http://rating-service/ratings/"+userId, Rating[].class);
		List<Rating> ratings = Arrays.stream(ratingarray).toList();
		logger.info("{}", ratings);
		List<Rating> finalratings =  ratings.stream().map(rating->{
		Hotel hotel = hotelService.getHOtelById(rating.getHotelId());
		rating.setHotel(hotel);
		return rating;
		}).collect(Collectors.toList());
		user.setRatings(finalratings);
		return user;
	}

	@Override
	public User deleteUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
