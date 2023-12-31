package com.example.AvanzaSolutionsBookStore.Controller;

import java.util.HashMap;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AvanzaSolutionsBookStore.Controller.RequestPojo.ApiResponse;
import com.example.AvanzaSolutionsBookStore.Model.User;
import com.example.AvanzaSolutionsBookStore.Service.UserService;


@RestController
@RequestMapping("api/signup")
public class SignUpController {
	@Autowired
	UserService userservice;
	
	
	@RequestMapping("user")//get or post
	public ResponseEntity<?> userLogin(@RequestBody HashMap<String,String> signupRequest) {
		try {
			User user = userservice.signUpUser(signupRequest);
			return  ResponseEntity.ok(user);
		}catch(Exception e ) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
}

