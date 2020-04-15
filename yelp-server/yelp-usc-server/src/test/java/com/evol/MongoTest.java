//package com.evol;
//
//import com.evol.domain.model.Review;
//import com.evol.repository.ReviewRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.*;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author sn
// * @version 1.0
// * @since 2019/11/7
// * 参考： RedisTemplate介绍 https://www.cnblogs.com/shamo89/p/8622152.html
// */
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class MongoTest {
//
//    @Autowired
//    private ReviewRepository reviewRepository;
//
//    @Test
//    public void testMongoAll() {
//        reviewRepository.deleteAll();
//
//        // save a couple of customers
//        reviewRepository.save(new Review(1, 2, new Date(), "正文1", 2, 3, 4, 1, 2));
//        reviewRepository.save(new Review(2, 3, new Date(), "2", 21, 31, 41, 1, 21));
//
//        // fetch all customers
//        System.out.println("Customers found with findAll():");
//        System.out.println("-------------------------------");
//        for (Review review : reviewRepository.findAll()) {
//            System.out.println(review);
//        }
//        System.out.println();
//
//        // fetch an individual customer
//        System.out.println("Customer found with findById(2):");
//        System.out.println("--------------------------------");
//        System.out.println(reviewRepository.findById(2));
//
//        System.out.println("Customers found with findByBusinessId(1):");
//        System.out.println("--------------------------------");
//        for (Review review : reviewRepository.findByBusinessId(1)) {
//            System.out.println(review);
//        }
//    }
//
//
//}
//
