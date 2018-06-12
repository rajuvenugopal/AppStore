import { AuthService } from './../service/auth.service';

import { Router, ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent  {
  invalidLogin: boolean;
 
  constructor(
    private router: Router,
    private authService : AuthService,
    private route : ActivatedRoute) { }

  signIn(credentials) {
    this.authService.login(credentials)
        .subscribe( result => {
          if(result){  
            let returnUrl = this.route.snapshot.queryParamMap.get('returnUrl')
            this.router.navigate([returnUrl || 'login']);
          }
          else
          this.invalidLogin = true;
        });
  }

 

}
