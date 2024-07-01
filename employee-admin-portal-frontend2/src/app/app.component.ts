import { Component } from '@angular/core';
import { AuthenticationService } from './service/auth/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'employee-admin-portal';

  constructor(
    private authService: AuthenticationService
  ) {
    if (window.onload) {
      this.onPageReload();
    }
  }

  onPageReload() {
    this.authService.logout();
  }


}
