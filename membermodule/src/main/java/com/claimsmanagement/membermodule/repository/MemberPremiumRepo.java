package com.claimsmanagement.membermodule.repository;


import org.springframework.stereotype.Repository;
import com.claimsmanagement.membermodule.model.Premium;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface MemberPremiumRepo extends JpaRepository<Premium,Long>{
	
	
	public Premium findByMemberIdAndPolicyId(Long memberId, Long policyId);	
	
}
