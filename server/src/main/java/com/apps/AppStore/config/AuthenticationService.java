package com.apps.AppStore.service;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.apps.AppStore.repository.UserDetailRepository;
@Component
public class AuthenticationService implements UserDetailsService {
	@Autowired 
	private UserDetailRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
    	
    	
    	
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
                   try {
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
            
            
            if (user == null || user..getAuthorities()) {
            	throw new UsernameNotFoundException("User not found");
            }
            return new User(user.getAuthentication().getUsername(), user.getAuthentication().getPassword(), new HashSet<GrantedAuthority>());
        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found");
        }        return null;
}*/}
    }