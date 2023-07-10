package com.example.AvanzaSolutionsBookStore.Controller.RequestPojo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ApiResponse {
	
	@NonNull
	private String message;
	
	@NonNull
	private String token;
	
	
	JSONArray array=null;
	private JSONObject jsonobj=null;
	HashMap<String,String> data=null;
	private List<String> errors;

}
