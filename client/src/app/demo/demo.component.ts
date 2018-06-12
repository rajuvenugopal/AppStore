import { DataserviceService } from './../service/dataservice.service';
import { Component, OnInit } from '@angular/core';
import { Router ,ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-demo',
  templateUrl: './demo.component.html',
  styleUrls: ['./demo.component.scss']
})
export class DemoComponent implements OnInit {
  id: number;
  private sub: any;
  products;

  constructor(private route: ActivatedRoute, 
              private router: Router,
              private service : DataserviceService) { }

// navigatetoedit(){
// 	 this.router.navigate(['/edit']);
// }

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
