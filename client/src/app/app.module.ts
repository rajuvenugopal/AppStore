import { AddProductComponent } from './add-product/add-product.component';
import { MockBackend } from '@angular/http/testing';
import { fakeBackendProvider } from './helper/fake-backend';
import { AdminAuthGuardService } from './service/admin-auth-guard.service';
import { AuthService } from './service/auth.service';
import { AuthGuardService } from './service/auth-guard.service';
import { DataserviceService } from './service/dataservice.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { BootstrapModalModule } from 'ng2-bootstrap-modal';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule, BaseRequestOptions } from '@angular/http';
import * as $ from 'jquery';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app.routing.module';
import { DemoComponent } from './demo/demo.component';
import { EditComponent } from './edit/edit.component';
import { PresentationComponent } from './presentation/presentation.component';
import { LoginComponent } from './login/login.component';
import { AddAppComponent } from './add-app/add-app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
//import { AppCardComponent } from './app-card/app-card.component';




@NgModule({
  declarations: [
    AppComponent,
    DemoComponent,
    EditComponent,
    PresentationComponent,
    LoginComponent,
    AddAppComponent,
    AddProductComponent,
    NavbarComponent,
    FooterComponent
    //AppCardComponent
  
    
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    BootstrapModalModule,
    FormsModule,
    HttpModule
  ],

  providers: [
    DataserviceService,
    AuthGuardService,
    AuthService,
    AdminAuthGuardService,

    // Fake backend providers below should be enabled

    // fakeBackendProvider,
    // MockBackend,
    // BaseRequestOptions
],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
