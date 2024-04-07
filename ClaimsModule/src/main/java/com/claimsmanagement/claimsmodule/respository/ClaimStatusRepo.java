package com.claimsmanagement.claimsmodule.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.claimsmanagement.claimsmodule.model.Claim;

public interface ClaimStatusRepo extends JpaRepository<Claim,Long>{
	// to retrieve the claim details from database
    public List<Claim> findAll();
	
    //to retrieve the claim based on claimId,policyId,memberId
	public Claim findByClaimIdAndPolicyIdAndMemberId(Long claimId, Long policyId, Long memberId);
	
	//to retrieve the claim based on claimId
	public Claim findByClaimId(Long claimId);
	
	//to retrieve the claim based on policyId
	public Claim findByPolicyId(Long policyId);
	
	//to retrieve the claim based on memberId
	public Claim findByMemberId(Long memberId);
	
	 @Query("SELECT c FROM Claim c WHERE c.claimId IN (:claimID) order by c.claimId")
		public List<Claim> findByClaimId(@Param("claimID") List<Long> claimId);

}
