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
// 	public ApiResponse( String message, List<String> errors) {
//	        super();
//	        this.message = message;
//	        this.errors = errors;
//	    }
// 	
//		public ApiResponse( HashMap<String,String> data,String token) {
//		       this.data = data;
//		       this.token = token;
//		}
//		public ApiResponse( JSONArray array,String token) {
//		       this.array = array;
//		       
//		       this.token = token;
//		}
//		public ApiResponse( JSONObject jsonobj,String token) {
//		       this.jsonobj = jsonobj;
//		       this.token = token;
//		}
//	  	public ApiResponse( String token,String message, List<String> errors) {
//	        super();
//	        this.token = token;
//	        this.message = message;
//	        this.errors = errors;
//	    }
//	 
//	    public ApiResponse( String message, String error) {
//	        super();
//	        this.message = message;
//	        errors = Arrays.asList(error);
//	    }

}
