package com.fuadrabbi.eommerce_backend.api.model.dao;

import com.fuadrabbi.eommerce_backend.model.LocalUser;
import org.springframework.data.repository.CrudRepository;

public interface LocalUserDAO extends CrudRepository<LocalUser, Long> {
}
