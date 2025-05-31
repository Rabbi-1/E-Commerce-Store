package com.fuadrabbi.eommerce_backend.service;

import com.fuadrabbi.eommerce_backend.model.LocalUser;
import com.fuadrabbi.eommerce_backend.model.WebOrder;
import com.fuadrabbi.eommerce_backend.model.dao.WebOrderDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private WebOrderDAO webOrderDAO;

    public OrderService(WebOrderDAO webOrderDAO) {
        this.webOrderDAO = webOrderDAO;
    }
    public List<WebOrder> getOrders(LocalUser user) {
        return webOrderDAO.findByUser(user);
    }
}
