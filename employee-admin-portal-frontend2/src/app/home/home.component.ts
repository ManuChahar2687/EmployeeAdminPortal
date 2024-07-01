import { Component, OnInit } from '@angular/core';
import { EmployeeDataService } from '../service/data/employee-data.service';
import { ActivatedRoute } from '@angular/router';
import { MyProfileComponent } from '../my-profile/my-profile.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  constructor(
    private route: ActivatedRoute,
  ) {
   }

  ngOnInit(): void {
  }

  
  

}
