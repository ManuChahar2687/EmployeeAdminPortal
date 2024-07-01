import { Component, Injectable, OnInit } from '@angular/core';
import { EmployeeDataService } from '../service/data/employee-data.service';
import { AuthenticationService } from '../service/auth/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})

@Injectable({
  providedIn: 'root'
})
export class HeaderComponent implements OnInit {

  id = 0;
  role='';
  isUserLoggedIn=false;

  constructor(
    private authService: AuthenticationService,
    private router: Router,
  ) { 
    this.getStoredValues();
  }

  ngOnInit(): void { 

  }

  getStoredValues() {
    const storedId = localStorage.getItem('id');
    this.id = storedId!=null? +storedId : 0;

    const storedRole = localStorage.getItem('role');
    this.role = storedRole!=null? storedRole: '';

    this.isUserLoggedIn=this.authService.isUserLoggedIn();
    this.router.navigate(['myprofile',this.id]);

  }

  refreshPage() {
    window.location.reload();
  }

  signingOut() {
    window.location.reload();
  }

  

  

}
