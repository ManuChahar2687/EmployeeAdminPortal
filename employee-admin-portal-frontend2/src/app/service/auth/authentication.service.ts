import { Injectable } from '@angular/core';
import { Route, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(
    private route: Router
  ) { }

  authenticate(username: string, password: string) {
    if(username=='manu' && password=='hehe'){
      sessionStorage.setItem('authenticateUser',username);
      return true;
    } else {
      return false;
    }
  }

  isUserLoggedIn() {
    let user = localStorage.getItem('token');
    return user!=null;
  }


  logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('id');
    localStorage.removeItem('role');
    this.route.navigate(['login']);
  }
  
}
