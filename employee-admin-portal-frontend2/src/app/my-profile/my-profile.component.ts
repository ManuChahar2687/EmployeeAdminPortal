import { Component, OnInit } from '@angular/core';
import { Department } from '../entities/Department';
import { Meeting } from '../entities/Meetings';
import { Address } from '../entities/Address';
import { Employee } from '../entities/Employee';
import { EmployeeDataService } from '../service/data/employee-data.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Role } from '../entities/Role';

@Component({
  selector: 'app-my-profile',
  templateUrl: './my-profile.component.html',
  styleUrls: ['./my-profile.component.css']
})
export class MyProfileComponent implements OnInit {

  id: number = 0;
  department: Department = new Department(0, '');
  meeting: Meeting = new Meeting(0, '', '', '', '');
  address: Address = new Address(0, '', '', '', '', '');
  role: Role = new Role(0, '');
  // employee: Employee = new Employee(0, '', '', '', [this.department], [this.meeting], [this.address], [this.role], '', []);
  employee!: Employee;

  constructor(
    private route: ActivatedRoute,
    private employeeService: EmployeeDataService,
    private router: Router
  ) {
    this.id = this.route.snapshot.params['id'];
    // console.log(this.employeeService.getEmployeeById(this.id).subscribe(data => {data}));
    this.employeeService.getEmployeeById(this.id)
      .subscribe(
        data => {
          console.log(data);
          this.employee = data;
          console.log(this.employee);
            this.address = data.addresses[0];
            this.department = data.department[0];
            this.meeting = data.meetings[0];
            this.role = data.role[0];

        }
      )
      
    
  }

  ngOnInit(): void {
    // console.log("calling from my-profile constructor", this.employee);
    // console.log(this.employee.roles[0]);
    
  }

  updateEmployee() {
    console.log("updateEmployee from list-employee");
    this.router.navigate(['employee', this.id]);
    console.log("updateEmployee from list-employee 2nd");

  }

}
