package com.apps.AppStore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.apps.AppStore.pojo.AppDetails;

@RepositoryRestResource(collectionResourceRel = "AppDetails", path = "AppDetails")
public interface AppDetailsRepository extends MongoRepository<AppDetails, String> {

	//List<AppDetails> findByLastName(@Param("name") String name);

}