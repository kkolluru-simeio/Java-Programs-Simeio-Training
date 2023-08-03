package com.groupon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.groupon.model.Cart;
import com.groupon.model.Deal;
import com.groupon.model.Order;
import com.groupon.model.User;
import com.groupon.service.ICartService;
import com.groupon.service.IDealService;
import com.groupon.service.IOrderService;
import com.groupon.service.IUserService;
import com.groupon.utils.CSVHelper;
import com.groupon.utils.CartQueries;
import com.groupon.utils.DealQueries;
import com.groupon.utils.LogQueries;
import com.groupon.utils.OrderQueries;
import com.groupon.utils.UserQueries;

@SpringBootApplication
public class OwnDomainRestJdbcApplication implements CommandLineRunner {

	@Autowired
	IUserService userService;
	
	@Autowired
	IDealService dealService;
	
	@Autowired
	ICartService cartService;
	
	@Autowired
	IOrderService orderService;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private CSVHelper csvHelper;
	

	public static void main(String[] args) {
		SpringApplication.run(OwnDomainRestJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("dropping any tables that exist with same name as cart");
		jdbcTemplate.execute(CartQueries.QUERYDROPTABLE);
		
		System.out.println("dropping any tables that exist with same name as orders");
		jdbcTemplate.execute(OrderQueries.QUERYDROPTABLE);
		
		System.out.println("dropping any tables that exist with same name as accessLog");
		jdbcTemplate.execute(LogQueries.QUERYDROPTABLE);
		
		System.out.println("dropping any tables that exist with same name as deal");
		jdbcTemplate.execute(DealQueries.QUERYDROPTABLE);
		
		System.out.println("dropping any tables that exist with same name as user");
		jdbcTemplate.execute(UserQueries.QUERYDROPTABLE);
		
		System.out.println("dropping any sequence that exist with same name as DEAL_SEQ");
		jdbcTemplate.execute(DealQueries.QUERYDROPSEQ);
		
		System.out.println("dropping any sequence that exist with same name as LOG_SEQ");
		jdbcTemplate.execute(LogQueries.QUERYDROPSEQ);
		
		System.out.println("creating deals sequence");
		jdbcTemplate.execute(DealQueries.CREATESEQ);
		
		System.out.println("creating log sequence");
		jdbcTemplate.execute(LogQueries.CREATESEQ);
		
		System.out.println("creating deals table");
		jdbcTemplate.execute(DealQueries.CREATEQUERY);
		System.out.println("creating user table");
		jdbcTemplate.execute(UserQueries.CREATEQUERY);
		System.out.println("creating user log");
		jdbcTemplate.execute(LogQueries.CREATEQUERY);
		System.out.println("creating cart table");
		jdbcTemplate.execute(CartQueries.CREATEQUERY);
		System.out.println("creating orders table");
		jdbcTemplate.execute(OrderQueries.CREATEQUERY);
		

		
		List<Deal> dealList = csvHelper.getDealList("deals.csv");
		System.out.println("Adding deals via command line");
		dealList.stream().forEach(deal -> System.out.println(deal));
		dealList.stream().forEach(deal -> dealService.addDeal(deal));

		
		List<User> userList = csvHelper.getUserList("users.csv");
		System.out.println("At users via command line ");
		userList.stream().forEach(user -> System.out.println(user));
		userList.stream().forEach(user -> userService.addUser(user));
		
		List<Cart> cartList = csvHelper.getCartList("cart.csv");
		System.out.println("Adding cart items via command line");
		cartList.stream().forEach(cartItem -> System.out.println(cartItem));
		cartList.stream().forEach(cartItem -> cartService.addDealToCart(cartItem.getDealId(), cartItem.getUserId()));

	
		List<Order> orderList = csvHelper.getOrderList("orders.csv");
		System.out.println("Adding orders via command line");
		orderList.stream().forEach(order -> System.out.println(order));
		orderList.stream().forEach(order -> orderService.addDealToOrders(order.getDealId(), order.getUserId(), order.getAvailabilityStatus()));

	}

}
