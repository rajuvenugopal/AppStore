import { Injectable } from '@angular/core';
import { Http ,Jsonp, URLSearchParams} from '@angular/http';

@Injectable()
export class DataserviceService {

  // private url ='http://jsonplaceholder.typicode.com/posts';

  // Dummy Service
  //  private url='https://api.jsonbin.io/b/5b156ec97a973f4ce578526e';
  
  // Santhosh Service
  private url='http://localhost:8080';

  constructor(private http:Http) { 

  }

  // For cards page
  getApps()
  {

    return this.http.get(this.url + '/getApps');
  }


  // For details page
  getAppDetails(id)
  {
    console.log("getAppDetails");
    return this.http.get(this.url + '/getAppsByCode?id=' + id);
   
  }

}
