package com.fuadrabbi.eommerce_backend.model.dao;

import com.fuadrabbi.eommerce_backend.model.VerificationToken;
import org.springframework.data.repository.ListCrudRepository;

public interface VerificationTokenDAO extends ListCrudRepository<VerificationToken, Long> {

}
