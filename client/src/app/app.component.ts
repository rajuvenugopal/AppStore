import {  AuthService} from './service/auth.service';
import {    Component}from '@angular/core';
import {    Router, ActivatedRoute}from '@angular/router';

declare var $: any;
@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss']
})

export class AppComponent {

    constructor(
        private authService: AuthService
    ) {}

	
    onChange(e) {

		alert ('dkbd');
        e.preventDefault();
         $("#wrapper").toggleClass("toggled");
    }

    ngOnInit() {

    }

}