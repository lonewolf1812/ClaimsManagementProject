package com.claimsmanagement.membermodule.model;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Member {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long memberId;
	private String name;
	private int age;
	private String phoneNumber;
	
	public Member() {
		super();
	}
	
	public Member(Long memberId, String name, int age, String phoneNumber) {
		super();
		this.memberId = memberId;
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}

		
	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", name=" + name + ", age=" + age + ", phoneNumber=" + phoneNumber
				+ "]";
	}
	
	
}
