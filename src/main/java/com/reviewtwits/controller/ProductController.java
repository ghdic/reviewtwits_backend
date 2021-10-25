package com.reviewtwits.controller;

import com.reviewtwits.entity.Product;
import com.reviewtwits.message.request.ProductReq;
import com.reviewtwits.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("")
    private Product getProduct(ProductReq productReq) {
        return productService.DisplayProductFromDatabase(productReq.getPath(), productReq.getDomain());
    }

    @PostMapping("")
    private Product submitProduct(@RequestBody Product product) {
        return productService.submitProductToDatabase(product);
    }

    @PostMapping("/sales/increase")
    private Product increaseSalesProduct(@RequestBody ProductReq productReq) {
        return productService.setSales(productReq.getPath(), productReq.getDomain(), 1);
    }

    @PostMapping("/sales/decrease")
    private Product decreaseSalesProduct(@RequestBody ProductReq productReq) {
        return productService.setSales(productReq.getPath(), productReq.getDomain(), -1);
    }

    @PostMapping("/reviews/increase")
    private Product increaseReviewsProduct(@RequestBody ProductReq productReq) {
        return productService.setReviews(productReq.getPath(), productReq.getDomain(), 1);
    }

    @PostMapping("/reviews/decrease")
    private Product decreaseReviewsProduct(@RequestBody ProductReq productReq) {
        return productService.setReviews(productReq.getPath(), productReq.getDomain(), -1);
    }

    @PostMapping("/income/increase")
    private Product increaseIncomeProduct(@RequestBody ProductReq productReq) {
        return productService.setIncome(productReq.getPath(), productReq.getDomain(), productReq.getIncome());
    }

    @PostMapping("/income/decrease")
    private Product decreaseIncomeProduct(@RequestBody ProductReq productReq) {
        return productService.setIncome(productReq.getPath(), productReq.getDomain(), -productReq.getIncome());
    }

    @PostMapping("/view")
    private Product increaseViewProduct(@RequestBody ProductReq productReq) {
        return productService.increaseView(productReq.getPath(), productReq.getDomain());
    }
}
