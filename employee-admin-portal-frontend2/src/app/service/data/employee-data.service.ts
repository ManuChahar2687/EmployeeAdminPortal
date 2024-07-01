import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { API_URL } from 'src/app/app.constants';
import { Employee } from 'src/app/entities/Employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeDataService {

  constructor(
    private http:HttpClient
  ) { }




  getAllEmployees() {
    return this.http.get<Employee[]>(`${API_URL}/employees`);
  }

  getEmployeeById(id:any) {
    return this.http.get<Employee>(`${API_URL}/employees/${id}`);
  }

  createEmployee(employee:Employee) {
    console.log("inside createEmployee of employee-data.service");
    return this.http.post<Employee>(`${API_URL}/employees`,employee);
  }

  updateEmployee(employee:Employee, id:any) {
    return this.http.put<Employee>(`${API_URL}/employees/${id}`,employee);
  }

  deleteEmployee(id:any) {
    return this.http.delete<Employee>(`${API_URL}/employees/${id}`);
  }

  
}
