package com.claimsmanagement.policymodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.claimsmanagement.policymodule.model.Policy;

@Repository
public interface PolicyRepo extends JpaRepository<Policy, Long> {

}
