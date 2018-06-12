import { Component, OnInit } from '@angular/core';
import { Router ,ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-presentation',
  templateUrl: './presentation.component.html',
  styleUrls: ['./presentation.component.scss']
})
export class PresentationComponent implements OnInit {

  constructor(private route: ActivatedRoute, 
    private router: Router) { }

  ngOnInit() {
  }

}
