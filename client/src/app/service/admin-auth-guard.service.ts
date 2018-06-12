import { CanActivate } from '@angular/router';
import { Injectable } from '@angular/core';
import { AuthGuardService } from './auth-guard.service';

@Injectable()
export class AdminAuthGuardService extends AuthGuardService {

  // canActivate() {
  //   let isAuthenticated = super.canActivate();
  //   if (!isAuthenticated)
  //     return false; 

  //   if (this.authService.currentUser.admin)
  //     return true; 

  //   this.router.navigate(['/no-access']);
  //   return false;
  // }
  
}
