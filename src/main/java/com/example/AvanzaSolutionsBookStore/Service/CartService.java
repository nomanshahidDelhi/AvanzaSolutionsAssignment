package com.example.AvanzaSolutionsBookStore.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.AvanzaSolutionsBookStore.Model.AddtoCart;
import com.example.AvanzaSolutionsBookStore.Model.CheckoutCart;


@Service
public interface CartService {
	List<AddtoCart> addCartbyUserIdAndBookId(long bookId,long userId,int qty,double price) throws Exception;
	void updateQtyByCartId(long cartId,int qty,double price) throws Exception;
	List<AddtoCart> getCartByUserId(long userId);
	List<AddtoCart> removeCartByUserId(long cartId,long userId);
	List<AddtoCart> removeAllCartByUserId(long userId);
	Boolean checkTotalAmountAgainstCart(double totalAmount,long userId);
	List<CheckoutCart> getAllCheckoutByUserId(long userId);
	List<CheckoutCart> saveBooksForCheckout(List<CheckoutCart> tmp)  throws Exception;
	
	
	//CheckOutCart
}

