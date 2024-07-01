import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeeDataService } from '../service/data/employee-data.service';
import { AuthenticationService } from '../service/auth/authentication.service';
import { LoginService } from '../service/loginauth/LoginService';
import { AuthInterceptor } from '../service/auth/AuthInterceptor';
import { HeaderComponent } from '../header/header.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  id = 0;
  role=''
  username = '';
  password = '';
  message = '';

  constructor(
    private router: Router,
    private auth: LoginService,
    private interceptor: AuthInterceptor,
    private header: HeaderComponent
  ) { }

  ngOnInit(): void {
    // this.tempMethod();
  }

  handleLogin(username: string, password: string) {
    this.auth.login(username, password)
      .subscribe(
        data => {
          localStorage.setItem('token',data.jwtToken);
          console.log(data);
          this.id=data.empId;
          this.role=data.role;
          localStorage.setItem('id',this.id.toString());
          localStorage.setItem('role',this.role.toString());
          this.header.getStoredValues();
          this.header.refreshPage();
          this.router.navigate(['myprofile',this.id]);
        },
        error => {
          console.error('Login failed',error);
          this.message='Invalid Credentials!';
          this.username='';
          this.password='';
          this.router.navigate(['login']);
        }
      )
  }

  // tempMethod() {
  //   this.router.navigate(['home']);
  // }

}
