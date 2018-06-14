package com.apps.AppStore.service;
import java.util.Collection;
import java.util.HashSet;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.apps.AppStore.pojo.UserDetail;
import com.apps.AppStore.repository.UserDetailRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
@Component
public class AuthenticationService implements UserDetailsService {
	
	@Autowired 
	private UserDetailRepository userRepository;
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
    	//logger.debug(" deleting app  based on App code  ",id);
    	MongoClient client = new MongoClient("localhost", 27017);
		MongoDatabase database = client.getDatabase("santhoshDB");
		MongoCollection<Document> collection = database
				.getCollection("userDetails");		
		ObjectMapper mapper = new ObjectMapper();		
		String logName=username;				
		Bson bsonFilter = Filters.eq("username",logName);		
		FindIterable<Document> findIt = collection.find(bsonFilter);		 
		UserDetail userDetails;		
               for(Document document : findIt){
                   System.out.println(document);
                   
                	   userDetails= mapper.readValue(document.toJson(), UserDetail.class);               
                       String loginUserName= userDetails.getUsername();     	
    	                    try {
                                	if(username == null ||  username.isEmpty()){
        		                    throw new UsernameNotFoundException("User not found");
        	                    }
        	
                                  UserDetails user = userRepository.findByUsername(username);
           // String name=((Object) user).getAuthentication();            
           // Authentication auth = ((Object) user).getAuthentication();
           // String name = auth.getName(); //get logged in username      		
          //  model.addAttribute("username", name);            
           Collection<? extends GrantedAuthority> isAuthorities= user.getAuthorities();            
            if (user == null || isAuthorities==null ) {
            	throw new UsernameNotFoundException("User not found");
            }                       
          String loginUser= user.getUsername();
          String loginPassword= user.getPassword();  
          
          return new User(loginUser, loginPassword, new HashSet<GrantedAuthority>());            
            //return new User(user.getAuthentication().getUsername(), user.getAuthentication().getPassword(), new HashSet<GrantedAuthority>());
        	} catch (Exception e) {
            throw new UsernameNotFoundException("User not found");
        }        return null;

               
                   }
               }

}
}

    
