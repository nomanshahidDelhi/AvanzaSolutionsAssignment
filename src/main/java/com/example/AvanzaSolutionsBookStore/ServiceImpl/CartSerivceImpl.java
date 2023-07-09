package com.example.AvanzaSolutionsBookStore.ServiceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AvanzaSolutionsBookStore.Model.AddtoCart;
import com.example.AvanzaSolutionsBookStore.Model.Books;
import com.example.AvanzaSolutionsBookStore.Model.CheckoutCart;
import com.example.AvanzaSolutionsBookStore.Repository.AddToCartRepo;
import com.example.AvanzaSolutionsBookStore.Repository.CheckoutRepo;
import com.example.AvanzaSolutionsBookStore.Service.CartService;


@Service
public class CartSerivceImpl implements CartService {

	@Autowired
	AddToCartRepo addCartRepo;
	
	@Autowired
	CheckoutRepo checkOutRepo;
	
	@Autowired
	BookServiceImpl bookServiceImpl;
    private static final Logger logger = LoggerFactory.getLogger(CartSerivceImpl.class);

	@Override
	public List<AddtoCart> addCartbyUserIdAndBookId(long bookId, long userId,int qty,double price) throws Exception {
		try {
			if(addCartRepo.getCartByBookIdAnduserId(userId, bookId).isPresent()){
				throw new Exception("Book is already exist.");
			}
			AddtoCart obj = new AddtoCart();
			obj.setQty(qty);
			obj.setUser_id(userId);
			Books book = bookServiceImpl.getBooksById(bookId);
			obj.setBooks(book); 
			//TODO price has to check with qty
			obj.setPrice(price);
			addCartRepo.save(obj);		
			return this.getCartByUserId(userId);	
		}catch(Exception e) {
			e.printStackTrace();
			logger.error(""+e.getMessage());
			throw new Exception(e.getMessage());
		}
		
	}

	@Override
	public List<AddtoCart> getCartByUserId(long userId) {
		return addCartRepo.getCartByuserId(userId);
	}

	@Override
	public List<AddtoCart> removeCartByUserId(long cartId, long userId) {
		addCartRepo.deleteCartByIdAndUserId(userId, cartId);
		return this.getCartByUserId(userId);
	}

	@Override
	public void updateQtyByCartId(long cartId, int qty, double price) throws Exception {
		addCartRepo.updateQtyByCartId(cartId,price,qty);
	}

	@Override
	public Boolean checkTotalAmountAgainstCart(double totalAmount,long userId) {
		double total_amount =addCartRepo.getTotalAmountByUserId(userId);
		if(total_amount == totalAmount) {
			return true;
		}
		System.out.print("Error from request "+total_amount +" --db-- "+ totalAmount);
		return false;
	}

	@Override
	public List<CheckoutCart> getAllCheckoutByUserId(long userId) {
		return checkOutRepo.getByuserId(userId);
	}

	@Override
	public List<CheckoutCart> saveBooksForCheckout(List<CheckoutCart> tmp) throws Exception {
		try {
			long user_id = tmp.get(0).getUser_id();
			if(tmp.size() >0) {
				checkOutRepo.saveAll(tmp);
				this.removeAllCartByUserId(user_id);
				return this.getAllCheckoutByUserId(user_id);
			}	
			else {
				throw  new Exception("Should not be empty");
			}
		}catch(Exception e) {
			throw new Exception("Error while checkout "+e.getMessage());
		}
		
	}

	@Override
	public List<AddtoCart> removeAllCartByUserId(long userId) {
		addCartRepo.deleteAllCartByUserId(userId);
		return null;
	}

}
