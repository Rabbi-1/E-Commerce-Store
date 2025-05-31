package com.fuadrabbi.eommerce_backend.service;

import com.fuadrabbi.eommerce_backend.model.Product;
import com.fuadrabbi.eommerce_backend.model.dao.ProductDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }
    public List<Product> getProducts() {
        return productDAO.findAll();
    }

}
