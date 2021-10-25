package com.reviewtwits.service;

import com.reviewtwits.entity.Product;
import com.reviewtwits.message.request.ProductReq;
import com.reviewtwits.repository.ProductRepo;
import com.reviewtwits.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    ProductRepo productRepo;
    ProjectRepo projectRepo;

    public ProductService(ProductRepo productRepo, ProjectRepo projectRepo) {
        this.productRepo = productRepo;
        this.projectRepo = projectRepo;
    }

    public Product DisplayProductFromDatabase(String path, String domain) {
        return productRepo.findProductByPathAndProject_Domain(path, domain);
    }

    public Product submitProductToDatabase(Product product) {
        product.setProject(projectRepo.findProjectByProjectId(product.getProjectId()));
        return productRepo.save(product);
    }

    public Product setSales(String path, String domain, int sales) {
        Product product = productRepo.findProductByPathAndProject_Domain(path, domain);
        if(product == null)
            return null;
        product.setSales(product.getSales() + sales);
        return productRepo.save(product);
    }

    public Product setReviews(String path, String domain, int reviews) {
        Product product = productRepo.findProductByPathAndProject_Domain(path, domain);
        if(product == null)
            return null;
        product.setReviews(product.getReviews() + reviews);
        return productRepo.save(product);
    }

    public Product setIncome(String path, String domain, int income) {
        Product product = productRepo.findProductByPathAndProject_Domain(path, domain);
        if(product == null)
            return null;
        product.setIncome(product.getIncome() + income);
        return productRepo.save(product);
    }

    public Product increaseView(String path, String domain) {
        Product product = productRepo.findProductByPathAndProject_Domain(path, domain);
        if(product == null)
            return null;
        product.setView(product.getView() + 1);
        return productRepo.save(product);
    }
}
