package com.claimsmanagement.policymodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.claimsmanagement.policymodule.model.Provider;

@Repository
public interface ProviderRepo extends JpaRepository<Provider, Long> {

}
