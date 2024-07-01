import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeDataService } from '../service/data/employee-data.service';
import { Employee } from '../entities/Employee';
import { Department } from '../entities/Department';
import { Meeting } from '../entities/Meetings';
import { Address } from '../entities/Address';
import { Role } from '../entities/Role';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-employee-form',
  templateUrl: './employee-form.component.html',
  styleUrls: ['./employee-form.component.css']
})
export class EmployeeFormComponent implements OnInit {

  id: number = 0;
  department: Department = new Department(0, '');
  meeting: Meeting = new Meeting(0, '', '', '', '');
  address: Address = new Address(0, '', '', '', '', '');
  role: Role = new Role(0, '');
  employee: Employee = new Employee(0, '', '', '', [this.department], [this.meeting], [this.address], [this.role],'',[]);
  // employee!: Employee 

  constructor(
    private route: ActivatedRoute,
    private employeeService: EmployeeDataService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    if (this.id != -1) {
      this.employeeService.getEmployeeById(this.id)
        .subscribe(
          data => {
            this.employee = data
              this.address = data.addresses[0],
              this.department = data.department[0],
              this.meeting = data.meetings[0],
              this.role = data.role[0]
          }
        )
        console.log(this.employee);
    }

  }

  saveEmployee() {
    if (this.id == -1) {
      console.log("save employee()->id=-1 from employee-form.ts, ", this.employee.name, this.employee.email);
      console.log("EMPLOYEE: ", this.employee);

      this.employeeService.createEmployee(this.employee)

        .subscribe(
          data => {
            this.router.navigate(['employee'])
          }
        )
    } else {
      console.log("save employee()->id!=-1 from employee-form.ts, ", this.employee.empId, this.id, this.employee.name, this.employee.email);
      this.employeeService.updateEmployee(this.employee, this.id)
        .subscribe(
          data => {
            // this.router.navigate(['employee'])
            window.location.reload();
          }
        )
    }

    

  }

  

}
