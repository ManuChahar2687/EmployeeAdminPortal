import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { LogoutComponent } from './logout/logout.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { ListEmployeesComponent } from './list-employees/list-employees.component';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { MenuComponent } from './menu/menu.component';
import { EmployeeFormComponent } from './employee-form/employee-form.component';
import { AuthInterceptor } from './service/auth/AuthInterceptor';
import { MyProfileComponent } from './my-profile/my-profile.component';
import { RoleValidatorDirective } from './employee-form/roleValidatorDirective';
// import { EmployeeComponent } from './entities/employee/employee.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    LogoutComponent,
    HeaderComponent,
    FooterComponent,
    PageNotFoundComponent,
    ListEmployeesComponent,
    MenuComponent,
    EmployeeFormComponent,
    MyProfileComponent,
    RoleValidatorDirective
    // EmployeeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi:true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
