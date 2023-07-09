package com.example.AvanzaSolutionsBookStore.ServiceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AvanzaSolutionsBookStore.Model.User;
import com.example.AvanzaSolutionsBookStore.Repository.UserRepository;
import com.example.AvanzaSolutionsBookStore.Service.UserService;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	 
	 
	@Override
	public User findByMobile(String mobile) throws Exception {
		return userRepo.findByMobile(mobile).orElseThrow(()->new Exception("User Not found.."));
	}

	@Override
	public User getUserDetailById(long userId) throws Exception {
		
		return userRepo.findById(userId).orElseThrow(()->new Exception("User Not found.."));
	}

	@Override
	public User signUpUser(HashMap<String, String> signupRequest) throws Exception {
		try {
			if(userRepo.findByMobile(signupRequest.get("mobile")).isPresent()) {
				throw new Exception("User is already registered with Mobile No.");
			}
			User user = new User();
			user.setName(signupRequest.get("name"));
			user.setEmail(signupRequest.get("email"));
			user.setMobile(signupRequest.get("mobile"));
			user.setPassword(signupRequest.get("password"));
			user.setCreated_at(dtf.format(now));
			userRepo.save(user);
			return user;
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
}
