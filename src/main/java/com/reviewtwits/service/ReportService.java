package com.reviewtwits.service;

import com.google.firebase.database.core.Repo;
import com.reviewtwits.entity.Report;
import com.reviewtwits.repository.ReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ReportService {

    @Autowired
    ReportRepo reportRepo;
    @Autowired
    UserService userService;

    public Report submitReportToDatabase(Report report) {
        report.setUser(userService.loadUserByUsername(report.getUid()));
        return reportRepo.save(report);
    }

    public Report updateStatusToDatabase(int orderId, String status) {
        Report report = reportRepo.findReportByOrderId(orderId);
        if(report == null)
            return null;
        report.setStatus(status);
        return reportRepo.save(report);
    }

    public ArrayList<Report> displayReportDataFromProductId(int productId) {
        return reportRepo.findReportByProductId(productId);
    }

    public ArrayList<Report> displayReportDataFromUserUid(String userUid) {
        return reportRepo.findReportByUser_Uid(Sort.by(Sort.Direction.DESC, "orderId"), userUid);
    }

    public ArrayList<Report> displayReportDataFromStatusPending(String userUid) {
        return reportRepo.findReportByUser_UidAndStatusEquals(Sort.by(Sort.Direction.DESC, "orderId"), userUid, "pending");
    }
}
