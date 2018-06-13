import { Subscription } from 'rxjs/Subscription';
import { EditComponent } from './../edit/edit.component';
import { DataserviceService } from './../service/dataservice.service';
import { Component, OnInit } from '@angular/core';
import { Router ,ActivatedRoute} from '@angular/router';
import { AuthService } from './../service/auth.service';
import { AppStore } from './../models/AppStore';

@Component({
  selector: 'app-demo',
  templateUrl: './demo.component.html',
  styleUrls: ['./demo.component.scss']
})
export class DemoComponent implements OnInit {
  id: number;
  private sub: any;
  products;

  subscription: Subscription;  
  appfilter:AppStore[]; 
  copyapps:AppStore[]; //for taking the appstore data
  dashfilter:AppStore[];
  filteredproducts:any[]=[];
  categoryproducts:any[]=[];
  Categories = ['Finance' , 'AI' , 'Telecom' ,
  'Block Chain' , 'eductaion' ,'gamification'];
  displayMode=1;
  isActive:true;



  constructor(private route: ActivatedRoute, 
              private router: Router,
              private service : DataserviceService,
              private authService: AuthService) {

                this.subscription= this.service.getApps()
                .subscribe(response => {
                  this.filteredproducts= this.copyapps = this.appfilter =
                   response.json();
                 console.log(response.json);
                }); 

               }

// navigatetoedit(){
// 	 this.router.navigate(['/edit']);
// }

filter(query:string){
  this.filteredproducts=(query) ?
  this.appfilter.filter(item=> item.name.toLowerCase()
  .includes(query.toLowerCase())) : this.appfilter;
}

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      let id = params['id'];
     console.log(id);
      this.service.getAppDetails(id)
        .subscribe(response => {
          this.products = response.json();
          
          console.log(this.products);
        
        });
    });

   
  }

}
