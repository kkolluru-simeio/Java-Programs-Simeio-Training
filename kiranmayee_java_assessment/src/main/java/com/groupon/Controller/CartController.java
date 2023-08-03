package com.groupon.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupon.exceptions.UserNotFoundException;
import com.groupon.model.Deal;
import com.groupon.service.ICartService;

@RestController
@RequestMapping("/deal-api")
public class CartController {

	@Autowired
	ICartService cartService;

	/*
	 * http://localhost:8080/deal-api/users/HYRKP1/cart 
	 * sample body 
	 * { "dealId":3 }
	 */
	@PostMapping("/users/{userId}/cart")
	ResponseEntity<Void> addDealToCart(@RequestBody Deal deal, @PathVariable("userId") String userId) {
		// System.out.println("Received info" + deal.getExpiryDate());
		cartService.addDealToCart(deal.getDealId(), userId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "deal added to cart");
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();
	}

	/*
	 * http://localhost:8080/deal-api/users/HYRKP1/cart/3
	 */
	@DeleteMapping("/users/{userId}/cart/{dealId}")
	ResponseEntity<Void> deleteDealFromCart(@PathVariable("userId") String userId, @PathVariable("dealId") int dealId) {
		cartService.deleteDealFromCart(dealId, userId);
		return ResponseEntity.accepted().build();
	}

	/*
	 * returns list of deals the user has in his cart url:
	 * http://localhost:8080/deal-api/users/HYRKP1/cart
	 * sample output: 
	 * [ { "dealId": 1, "outletId": 2, "expiryDate": "2023-07-31T23:59:59", "originalPrice":
	 * 1300.0, "discountedPrice": 9000.0, "category": "spa", "noOfPurchases": 50 },
	 * { "dealId": 3, "outletId": 3, "expiryDate": "2023-06-30T23:59:59",
	 * "originalPrice": 500.0, "discountedPrice": 200.0, "category": "food",
	 * "noOfPurchases": 30 } ]
	 */
	@GetMapping("/users/{userId}/cart")
	ResponseEntity<List<Deal>> getUserCart(@PathVariable("userId") String userId) {
		System.out.println("getting all the deals");
		List<Deal> dealList = cartService.getAllDealsInCart(userId);
		if (dealList.size() == 0)
			throw new UserNotFoundException("incorrect user id");
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "returning all deals in the usercart");
		ResponseEntity<List<Deal>> responseEntity = new ResponseEntity<List<Deal>>(dealList, headers, HttpStatus.OK);
		return responseEntity;
	}

}