package com.example.AvanzaSolutionsBookStore.Controller;


import java.util.ArrayList;


import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AvanzaSolutionsBookStore.Controller.RequestPojo.ApiResponse;
import com.example.AvanzaSolutionsBookStore.JWTConfiguration.ShoppingConfiguration;
import com.example.AvanzaSolutionsBookStore.Model.AddtoCart;
import com.example.AvanzaSolutionsBookStore.Model.CheckoutCart;
import com.example.AvanzaSolutionsBookStore.Service.CartService;



@RestController
@RequestMapping("api/order")
public class CheckoutController {
	
	@Autowired
	CartService cartService;
	
	
	@PostMapping("checkout_order")
  	public ResponseEntity<?> checkout_order(@RequestBody HashMap<String,String> addCartRequest) {
		try {
			String keys[] = {"userId","pay_type","deliveryAddress"};
			if(ShoppingConfiguration.validationWithHashMap(keys, addCartRequest)) {
						
			}
			long user_Id = Long.parseLong(addCartRequest.get("userId"));
			double total_payable_amount = cartService.checkTotalAmountAgainstCart(user_Id);
			System.out.println("total_payable_amount:"+total_payable_amount);
				List<AddtoCart> cartItems = cartService.getCartByUserId(user_Id);
				List<CheckoutCart> tmp = new ArrayList<CheckoutCart>();
				for(AddtoCart addCart : cartItems) {
					String orderId = ""+getOrderId();
					CheckoutCart cart = new CheckoutCart();
					cart.setPayment_type(addCartRequest.get("pay_type"));
					cart.setPrice(total_payable_amount);
					cart.setUser_id(user_Id);
					cart.setOrder_id(orderId);
					cart.setBooks(addCart.getBooks());
					cart.setQty(addCart.getQty());
					cart.setDelivery_address(addCartRequest.get("deliveryAddress"));
					tmp.add(cart);
				}
				cartService.saveBooksForCheckout(tmp);
				HashMap<String,String> data= new HashMap<>();;
				data.put("total_payable_amount", Double.toString(total_payable_amount));
				return ResponseEntity.ok(new ApiResponse("Order placed successfully", "", null, null, data, null));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
	
	
	@PostMapping("getOrdersByUserId")
		public ResponseEntity<?> getOrdersByUserId(@RequestBody HashMap<String,String> ordersRequest) {
		try {
			String keys[] = {"userId"};	
			return ResponseEntity.ok(new ApiResponse("Order placed successfully", ""));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}
	
	
	public int getOrderId() {
	    Random r = new Random( System.currentTimeMillis() );
	    return 10000 + r.nextInt(20000);
	}
}
