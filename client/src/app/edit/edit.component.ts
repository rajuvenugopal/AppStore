import { AuthService } from './../service/auth.service';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { AppStore } from './../models/AppStore';
import { DataserviceService } from './../service/dataservice.service';
import { Component, OnInit,Input } from '@angular/core';
import { Router ,ActivatedRoute} from '@angular/router';
import { Subscription } from 'rxjs/Subscription';


@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.scss']
})
export class EditComponent implements OnInit {

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
   
  statusproducts:any[];
  
 constructor(private route: ActivatedRoute, 
              private router: Router,
              private service: DataserviceService,
              private authService: AuthService) { 
      this.subscription= this.service.getApps()
                .subscribe(response => {
                  this.filteredproducts= this.copyapps = this.appfilter =
                  this.statusproducts = response.json();
                 console.log(response.json);
                }); 
  }
// Search filter for search bar in home page
    filter(query:string){
      this.filteredproducts=(query) ?
      this.appfilter.filter(item=> item.name.toLowerCase()
      .includes(query.toLowerCase())) : this.appfilter;
    }


/// filter method for dashboard
filterBy(filter:string)
{

  
switch(filter)
{
 case 'dashboard':



 this.filteredproducts=this.copyapps;
 let resultArray = [];
 for (let item of this.filteredproducts) {
   if(item.dashboard === 'true' ){
     resultArray.push(item);
   //  console.log('iside '+ resultArray);
   }
   
 }

 this.filteredproducts=resultArray;
 
 console.log('show only dashbord');


 break;

 case 'Latest':

 this.filteredproducts=this.appfilter.filter(item=> item.createdby.toLowerCase()
 .includes('Raju Venugopal'.toLowerCase())) ;

 console.log('show only latest for latst my using created by later we will use date for latest');
 break;


 case 'visited':

 this.filteredproducts=this.appfilter.filter(item=> item.categories.toLowerCase()
 .includes('Education'.toLowerCase())) ;

 console.log(this.filteredproducts);
 console.log('show only visited im using visited for category' );
 break;

 case 'all':
 this.filteredproducts=this.copyapps;
 console.log('show only visited im using visited for category');
 break;
}

 
}
/// end of dashboard
 

// For checkbox
changeCheckbox(category:string) {
  this.filteredproducts=(category) ?
  this.appfilter.filter(item=> item.business.toLowerCase()
  .includes(category.toLowerCase())) : this.appfilter;
  console.log(this.filteredproducts);
  console.log(category);
}





navigatetodemopage(){
	 this.router.navigate(['/demo']);
}


onDisplayModeChange(mode: number): void {

  this.displayMode = mode;
console.log( this.displayMode);

}

  ngOnInit() {
  }
  ngOnDestroy(){
    this.subscription.unsubscribe();
  }

}

