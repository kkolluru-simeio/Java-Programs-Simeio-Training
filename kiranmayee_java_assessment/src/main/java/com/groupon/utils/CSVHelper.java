
package com.groupon.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import com.groupon.model.Cart;
import com.groupon.model.Deal;
import com.groupon.model.Order;
import com.groupon.model.User;


@Component
public class CSVHelper {
    public static final String TYPE="text/csv";
    public static String[] headers = {"firstName","middleName","lastName","email","dateOfBirth", "securityQuestion", "securityAnswer", "city"};

    public List<User> getUserList(String fileName){
        List<User> users = new ArrayList<>();
        try(FileReader reader = new FileReader(fileName);
        BufferedReader bufferedReader =new BufferedReader(reader);
        CSVParser parser = new CSVParser(bufferedReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withTrim());){

        List<CSVRecord> records = parser.getRecords();
            for (CSVRecord csvRecord:records) {
                User user = new User();
                user.setFirstName(csvRecord.get("firstName"));
                user.setMiddleName(csvRecord.get("middleName"));
                user.setLastName(csvRecord.get("lastName"));
                user.setEmail(csvRecord.get("email"));
                user.setDateOfBirth(Date.valueOf(csvRecord.get("dateOfBirth")));
                user.setSecurityQuestion(csvRecord.get("securityQuestion"));
                user.setSecurityAnswer(csvRecord.get("securityAnswer"));
                user.setCity(csvRecord.get("city"));
                users.add(user);
            }
            return  users;
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("Failed to get users from csv");
        }
    }
    
    public List<Deal> getDealList(String fileName){
        List<Deal> deals = new ArrayList<>();
        try(FileReader reader = new FileReader(fileName);
        BufferedReader bufferedReader =new BufferedReader(reader);
        CSVParser parser = new CSVParser(bufferedReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withTrim());){

        List<CSVRecord> records = parser.getRecords();
            for (CSVRecord csvRecord:records) {
                Deal deal = new Deal();
                deal.setOutletId(Integer.parseInt(csvRecord.get("outletId")));
                deal.setOriginalPrice(Double.parseDouble(csvRecord.get("originalPrice")));
                deal.setCategory(csvRecord.get("category"));
                deal.setNoOfPurchases(Integer.parseInt(csvRecord.get("noOfPurchases")));
                deal.setExpiryDate(LocalDateTime.parse(csvRecord.get("expiryDate")));
                deal.setDiscountedPrice(Double.parseDouble(csvRecord.get("discountedPrice")));
                
                deals.add(deal);
            }
            return  deals;
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("Failed to get deals from csv");
        }
    }
    
    public List<Order> getOrderList(String fileName){
        List<Order> orders = new ArrayList<>();
        try(FileReader reader = new FileReader(fileName);
        BufferedReader bufferedReader =new BufferedReader(reader);
        CSVParser parser = new CSVParser(bufferedReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withTrim());){

        List<CSVRecord> records = parser.getRecords();
            for (CSVRecord csvRecord:records) {
                Order order = new Order();
               order.setDealId(Integer.parseInt(csvRecord.get("dealId")));
               order.setUserId(csvRecord.get("userId"));
               order.setAvailabilityStatus(Integer.parseInt(csvRecord.get("availabilityStatus")) == 0 ? Boolean.FALSE : Boolean.TRUE);
                orders.add(order);
            }
            return  orders;
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("Failed to get orders from csv");
        }
    }
    
    public List<Cart> getCartList(String fileName){
        List<Cart> cartItems = new ArrayList<>();
        try(FileReader reader = new FileReader(fileName);
        BufferedReader bufferedReader =new BufferedReader(reader);
        CSVParser parser = new CSVParser(bufferedReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withTrim());){

        List<CSVRecord> records = parser.getRecords();
            for (CSVRecord csvRecord:records) {
                Cart cartItem = new Cart();
                cartItem.setDealId(Integer.parseInt(csvRecord.get("dealId")));
                cartItem.setUserId(csvRecord.get("userId"));
                cartItems.add(cartItem);
            }
            return  cartItems;
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("Failed to get orders from csv");
        }
    }


    public String getCSVFile(String fileName){
        return fileName;
    }

}