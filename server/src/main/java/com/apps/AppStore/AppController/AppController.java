package com.apps.AppStore.AppController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.apps.AppStore.pojo.AppDetails;
import com.apps.AppStore.repository.AppDetailsRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;
import org.bson.conversions.Bson;


@RestController
public class AppController {
	
	private static final Logger logger = LoggerFactory.getLogger(AppController.class);
	 
	  private static final String template = "Hello, %s!";
	  private String upload_DIR="/AppStore/src/main/java/UploadDiru";
	    
    @Autowired
    AppDetailsRepository appDetailsRepository;

    //  get App Based on app ID
    
    @RequestMapping(method=RequestMethod.GET, value="/getAppsByCode")      
    public AppDetails getApps(@RequestParam(value="id") String id) {    	    	
    	System.out.println(" Fetching App detailes based on App code  " + id);     	
    	
    	MongoClient client = new MongoClient("localhost", 27017);
		MongoDatabase database = client.getDatabase("AppStore");
		MongoCollection<Document> collection = database
				.getCollection("AppsInfo");		
		ObjectMapper mapper = new ObjectMapper();
		Bson query = eq("id", id);
		List<Document> documents = (List<Document>) collection.find(query).into(
				new ArrayList<Document>());
 
               for(Document document : documents){ 
            	              	  
            	 
                  System.out.println(document);
                   try {
                	   return  mapper.readValue(document.toJson(), AppDetails.class);
					  
				} catch (JsonParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
               
               }
               client.close();               
               return null;
    }
    
    // Showing all Apps Info
    
    @RequestMapping(method=RequestMethod.GET, value="/getApps")      
    public List<AppDetails> searchApps() {     	
    	System.out.println(" Fetching Apps ");  
    	
    	
    	MongoClient client = new MongoClient("localhost", 27017);
		MongoDatabase database = client.getDatabase("AppStore");
		MongoCollection<Document> collection = database
				.getCollection("AppsInfo");		
		ObjectMapper mapper = new ObjectMapper();
		List<Document> documents = (List<Document>) collection.find().into(
				new ArrayList<Document>());
		
		AppDetails appDetails;
		List<AppDetails>  appsList=new ArrayList<>();
 
               for(Document document : documents){
                   System.out.println(document);
                   try {
                	    appDetails= mapper.readValue(document.toJson(), AppDetails.class);
                	    appsList.add(appDetails);
				} catch (JsonParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
               }
               client.close();               
               return appsList;
    }
    
    // Deleting App By ID
    @RequestMapping(value = "/deleteAppByCode", method = RequestMethod.DELETE)      
    public void deleteApp(@RequestParam(value="id") String id) {    	
    	logger.debug(" deleting app  based on App code  ",id);
    	MongoClient client = new MongoClient("localhost", 27017);
		MongoDatabase database = client.getDatabase("AppStore");
		MongoCollection<Document> collection = database
				.getCollection("AppsInfo");   
    collection.deleteOne(new Document("id", id));
    client.close();
    	
    }
    
    
   /* @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject validUserLogin(@QueryParam(value="userDetails") String userDetails){
        JSONObject json = null;
        try{
            System.out.println("Service running from validUserLogin :"+userDetails);
            json = new JSONObject(userDetails);
      
*/    /*
*
    @RequestMapping(value = "/createNewApp", method = RequestMethod.POST) 
    @Consumes("application/json")
    @Produces("application/json")   
    @ResponseBody    
    public void createNewApp(@RequestParam(value="appDetails") String appDetails) {
    	ObjectMapper mapper = new ObjectMapper();
		String jsonString;
    	JSONObject json = null;
        try{
            System.out.println("Service running from validUserLogin :"+appDetails);
            json = new JSONObject(appDetails);
    
    	
    	MongoClient client = new MongoClient("localhost", 27017);
		MongoDatabase database = client.getDatabase("santhoshDB");
		MongoCollection<Document> collection = database
				.getCollection("AppsInfo");	
		
		
		jsonString = mapper.writeValueAsString(appDetails);
		
		 Document doc = Document.parse(jsonString);
		 //collection.insertOne(doc);
		
		BasicDBObject obj = (BasicDBObject)JSON.parse(appDetails);		
		 //Document doc = Document.parse(obj);
		collection.insertOne(obj);
		//boolean status = insertIntoCollection(collection, appDetails);		
		
		
		
		//System.out.println("Status of Insert: " + status);
    
        }
        
    }*/
    public static boolean insertIntoCollection( final MongoCollection<Document> collections, final AppDetails appDetails){
		ObjectMapper mapper = new ObjectMapper();
		String jsonString;
		 boolean status = true;

		 try {

			 jsonString = mapper.writeValueAsString(appDetails);
			 System.out.println(String.format("Item #%s: %s", appDetails.getId(),jsonString));
			 Document doc = Document.parse(jsonString);
			 collections.insertOne(doc);
		 } catch (MongoWriteException mwe) {
			 status = false;
			 
			   } catch (IOException e) {
			 
			     status = false;
			 
			   }
			 
			   return status;
			 
			 }
    // Updating App Using App ID
    
    @RequestMapping(value = "/updateApp/{appDetails}", method = RequestMethod.PUT) 
    @ResponseBody      
    public void modifyApp(@PathVariable AppDetails appDetails) {
    	logger.debug(" updated the app   ",appDetails);
    	appDetailsRepository.insert(appDetails);
    	
    }
    
    // Uploading A Image 
    
    @RequestMapping(value = "/uploadImage/{appDetails}", method = RequestMethod.POST) 
    @ResponseBody      
    public void saveuploadFile(MultipartFile file) throws IOException{
    	
    	/*byte[] bytes=file.getBytes();
    	//Path paths=Paths.get(uri);
    	Files.write(paths, bytes);*/
    }


}
