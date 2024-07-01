import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ListEmployeesComponent } from './list-employees/list-employees.component';
import { LogoutComponent } from './logout/logout.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { MenuComponent } from './menu/menu.component';
import { EmployeeFormComponent } from './employee-form/employee-form.component';
import { RouteGuardService } from './service/route-guard.service';
import { MyProfileComponent } from './my-profile/my-profile.component';

const routes: Routes = [
  { path: '', component:LoginComponent },
  { path: 'login', component:LoginComponent},
  { path: 'home', component:HomeComponent, canActivate:[RouteGuardService]},
  { path: 'employee', component:ListEmployeesComponent, canActivate:[RouteGuardService]},
  { path: 'employee/:id', component:EmployeeFormComponent, canActivate:[RouteGuardService]},
  { path: 'logout', component:LogoutComponent, canActivate:[RouteGuardService]},
  { path: 'menu', component:MenuComponent, canActivate:[RouteGuardService]},
  { path: 'myprofile/:id', component:MyProfileComponent, canActivate:[RouteGuardService]},
  { path: '**', component:PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
