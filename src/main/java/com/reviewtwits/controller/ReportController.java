package com.reviewtwits.controller;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.core.Repo;
import com.reviewtwits.entity.Report;
import com.reviewtwits.service.ReportService;
import com.reviewtwits.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/order")
public class ReportController {

    @Autowired
    FirebaseAuth firebaseAuth;
    @Autowired
    ReportService reportService;


    @PostMapping("")
    private Report submitReportPost(@RequestBody Report report) {
        return reportService.submitReportToDatabase(report);
    }

    @PostMapping("/{orderId}")
    private Report updateStatus(@PathVariable("orderId")int orderId, @RequestBody String status) {
        return reportService.updateStatusToDatabase(orderId, status);
    }

    @GetMapping("/product/{productId}")
    private ArrayList<Report> getReportDataFromProductId(@PathVariable("productId")int productId) {
        return reportService.displayReportDataFromProductId(productId);
    }

    @GetMapping("/user")
    private ArrayList<Report> getReportDataFromUid(@RequestHeader("Authorization") String authorization) {
        return reportService.displayReportDataFromUserUid(TokenUtil.parseUid(firebaseAuth, authorization));
    }

    @GetMapping("/user/pending")
    private ArrayList<Report> getReportDataPending(@RequestHeader("Authorization") String authorization) {
        return reportService.displayReportDataFromStatusPending(TokenUtil.parseUid(firebaseAuth, authorization));
    }
}
