package com.reviewtwits.repository;

import com.reviewtwits.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    Product save(Product product);
    Product findProductByPathAndProject_Domain(String path, String project_domain);
    ArrayList<Product> findProductsByProject_ProjectId(String projectId);
}
