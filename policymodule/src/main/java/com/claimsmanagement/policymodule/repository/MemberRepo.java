package com.claimsmanagement.policymodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.claimsmanagement.policymodule.model.Member;

@Repository
public interface MemberRepo extends JpaRepository<Member, Long> {

	
}
