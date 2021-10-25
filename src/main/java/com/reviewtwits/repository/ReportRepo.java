package com.reviewtwits.repository;

import com.reviewtwits.entity.Report;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Repository
public interface ReportRepo extends JpaRepository<Report, Integer> {
    Report save(Report report);
    Report findReportByOrderId(int orderId);
    ArrayList<Report> findReportByProductId(int productId);
    ArrayList<Report> findReportByUser_Uid(Sort sort, String user_uid);
    ArrayList<Report> findReportByUser_UidAndStatusEquals(Sort sort, String user_uid, String status);
    void deleteByOrderId(int orderId);
}
