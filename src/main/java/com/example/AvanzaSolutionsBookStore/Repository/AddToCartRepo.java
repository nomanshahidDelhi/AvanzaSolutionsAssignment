package com.example.AvanzaSolutionsBookStore.Repository;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.AvanzaSolutionsBookStore.Model.AddtoCart;

@Repository
public interface AddToCartRepo extends JpaRepository<AddtoCart,Long> {

	
	//remove cart by userid and cartId,
	//getCartByuserId
	
	@Query("Select sum(addCart.price) FROM AddtoCart addCart WHERE addCart.user_id=:user_id")
	Long getTotalAmountByUserId(@Param("user_id")Long user_id);
	@Query("Select addCart  FROM AddtoCart addCart WHERE addCart.user_id=:user_id")
	List<AddtoCart> getCartByuserId(@Param("user_id")Long user_id);
	@Query("Select addCart  FROM AddtoCart addCart ")
	Optional<AddtoCart> getCartByuserIdtest();
	@Query("Select addCart  FROM AddtoCart addCart WHERE addCart.books.id= :book_id and addCart.user_id=:user_id")
	Optional<AddtoCart> getCartByBookIdAnduserId(@Param("user_id")Long user_id,@Param("book_id")Long book_id);
	@Modifying
    @Transactional
	@Query("DELETE  FROM AddtoCart addCart WHERE addCart.id =:cart_id   and addCart.user_id=:user_id")
	void deleteCartByIdAndUserId(@Param("user_id")Long user_id,@Param("cart_id")Long cart_id);
	@Modifying
    @Transactional
	@Query("DELETE  FROM AddtoCart addCart WHERE   addCart.user_id=:user_id")
	void deleteAllCartByUserId(@Param("user_id")Long user_id);
	
	@Modifying
    @Transactional
	@Query("DELETE  FROM AddtoCart addCart WHERE addCart.user_id=:user_id")
	void deleteAllCartUserId(@Param("user_id")Long user_id);
	@Modifying
    @Transactional
	@Query("update AddtoCart addCart set addCart.qty=:qty,addCart.price=:price WHERE addCart.id=:cart_id")
	void updateQtyByCartId(@Param("cart_id")Long cart_id,@Param("price")double price,@Param("qty")Integer qty);
	
}
