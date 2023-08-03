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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.groupon.exceptions.DealNotFoundException;
import com.groupon.exceptions.UserNotFoundException;
import com.groupon.model.Deal;
import com.groupon.service.IOrderService;

@RestController
@RequestMapping("/deal-api")
public class OrderController {

	@Autowired
	IOrderService orderService;

	/*
	 * http://localhost:8080/deal-api/users/HYRKP1/orders sample body { "dealId":3 }
	 */
	@PostMapping("/users/{userId}/orders")
	ResponseEntity<Void> addDealToOrders(@RequestBody Deal deal, @PathVariable("userId") String userId) {
		// last param true indicates that the deal is unused. by default it is set to 1
		// for all the deals insereted from frontend.
		orderService.addDealToOrders(deal.getDealId(), userId, true);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "deal added to orders");
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();
	}

	@PutMapping("/users/{userId}/orders/consume")
	ResponseEntity<Void> updateAvailabilityStatus(@RequestParam("dealId") int dealId,
			@PathVariable("userId") String userId) {
		orderService.updateAvailabilityStatus(dealId, userId, false);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "deal added to orders");
		return ResponseEntity.accepted().build();
	}

	@DeleteMapping("/users/{userId}/orders/{dealId}")
	ResponseEntity<Void> deleteDealFromOrders(@PathVariable("userId") String userId,
			@PathVariable("dealId") int dealId) {
		orderService.deleteDealFromOrders(dealId, userId);
		return ResponseEntity.accepted().build();
	}

	/*
	 * returns list of deals the user has so far ordered:
	 * http://localhost:8080/deal-api/users/HYRKP1/orders sample output: [ {
	 * "dealId": 1, "outletId": 2, "expiryDate": "2023-07-31T23:59:59",
	 * "originalPrice": 1300.0, "discountedPrice": 9000.0, "category": "spa",
	 * "noOfPurchases": 50 }, { "dealId": 3, "outletId": 3, "expiryDate":
	 * "2023-06-30T23:59:59", "originalPrice": 500.0, "discountedPrice": 200.0,
	 * "category": "food", "noOfPurchases": 30 } ]
	 */
	@GetMapping("/users/{userId}/orders")
	ResponseEntity<List<Deal>> getAllDealsBoughtByUser(@PathVariable("userId") String userId) {
		System.out.println("getting all the deals ordered by user");
		List<Deal> dealList = orderService.getAllDealsBoughtByUser(userId);
		if (dealList.size() == 0)
			throw new DealNotFoundException("no deals purchased by user yet");
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "returning all deals ordered by user");
		ResponseEntity<List<Deal>> responseEntity = new ResponseEntity<List<Deal>>(dealList, headers, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/users/{userId}/orders/unusedDeals")
	ResponseEntity<List<Deal>> getUnusedDealsByUser(@PathVariable("userId") String userId) {
		System.out.println("getting all the deals ordered by user");
		List<Deal> dealList = orderService.getUnusedDealsByUser(userId);
		if (dealList.size() == 0)
			throw new DealNotFoundException("no unused deals left");
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "returning all the deals that are unused by user");
		ResponseEntity<List<Deal>> responseEntity = new ResponseEntity<List<Deal>>(dealList, headers, HttpStatus.OK);
		return responseEntity;
	}

}