package com.fuadrabbi.eommerce_backend.model.dao;

import com.fuadrabbi.eommerce_backend.model.Product;
import org.springframework.data.repository.ListCrudRepository;

public interface ProductDAO extends ListCrudRepository<Product, Long> {
}
