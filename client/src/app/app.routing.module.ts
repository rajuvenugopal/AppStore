import { AuthGuardService } from './service/auth-guard.service';
import { AdminAuthGuardService } from './service/admin-auth-guard.service';
import { AddProductComponent } from './add-product/add-product.component';
import { AddAppComponent } from './add-app/add-app.component';
import { LoginComponent } from './login/login.component';
import { PresentationComponent } from './presentation/presentation.component';
import { Routes, RouterModule } from '@angular/router';
import { Component, NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { DemoComponent } from './demo/demo.component';
import { EditComponent } from './edit/edit.component';


const appRoutes: Routes = [
	{
        path: '',
        redirectTo: '/login',		
        pathMatch: 'full'  
    },
    { path: 'login', component: LoginComponent },
    
    {path: 'demo/:id', component: DemoComponent},

    {path: 'edit', component: EditComponent},

    {path: 'presentation', component : PresentationComponent},

  

    {path: 'add-app', component: AddAppComponent, 
    canActivate: [AuthGuardService]},

    {path: 'add-product', component: AddProductComponent, 
    canActivate: [AuthGuardService]}    
      ]

@NgModule({
    imports: [RouterModule.forRoot(appRoutes)],
    exports: [RouterModule]
})
export class AppRoutingModule {

}
