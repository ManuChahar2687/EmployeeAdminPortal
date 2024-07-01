import { Component, OnInit } from '@angular/core';
import { EmployeeDataService } from '../service/data/employee-data.service';
import { Router } from '@angular/router';
import { Employee } from '../entities/Employee';
import { Address } from '../entities/Address';
import { Department } from '../entities/Department';
import { Meeting } from '../entities/Meetings';


@Component({
  selector: 'app-list-employees',
  templateUrl: './list-employees.component.html',
  styleUrls: ['./list-employees.component.css']
})
export class ListEmployeesComponent implements OnInit {

  // department: Department = new Department(0,'');
  // meeting: Meeting = new Meeting(0,'','','','');
  // address: Address = new Address(0,'','','','','');
  // employees: Employee = new Employee(0,'','','',[this.department],[this.meeting],[this.address]);
  employee:Employee[] = [];

  constructor(
    private employeeService: EmployeeDataService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.refreshEmployeeList();
    
  }

  refreshEmployeeList() {
    // console.log("refreshEmployeeList from HomeComponent.ts");
    this.employeeService.getAllEmployees()
    .subscribe(
      response => {
        console.log(response);
        this.employee=response;
        console.log(this.employee[0].addresses);
      }
    )
  }

  addEmployee() {
    this.router.navigate(['employee',-1]);
  }

  updateEmployee(id:any) {
    console.log("updateEmployee from list-employee");
    this.router.navigate(['employee',id]);
    console.log("updateEmployee from list-employee 2nd");

  }

  deleteEmployee(id:any) {
    this.employeeService.deleteEmployee(id).subscribe(
      response => {
        console.log(response);
        this.refreshEmployeeList();
      }
    )
  }

}
