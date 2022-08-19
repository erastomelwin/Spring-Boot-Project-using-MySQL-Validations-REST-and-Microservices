package com.example.demo.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	 Boolean existsByName(String name);
	
	@Transactional
	@Modifying
	@Query("update User u set u.coinDenominations= :coinDenominations, u.noOfCoins= :noOfCoins, u.noOfHours= :noOfHours where u.userId= :userId")
	void setUserInfoById(String coinDenominations, Integer noOfCoins, Double noOfHours, Integer userId); 
}
