package com.apps.AppStore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.apps.AppStore.pojo.UserDetail;

@Repository
public interface UserDetailRepository extends MongoRepository<UserDetail, String> {
	  
	  public UserDetails findByUsername(String username);
	  
}
