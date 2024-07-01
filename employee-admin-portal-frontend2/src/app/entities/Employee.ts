import { Address } from "./Address";
import { Department } from "./Department";
import { Meeting } from "./Meetings";
import { Role } from "./Role";

export class Employee {
    constructor(
      public empId:number,
      public name:string,
      public phoneNumber:string,
      public email:string,
      public department:Department[],
      public meetings:Meeting[],
      public addresses:Address[],
      public role:Role[],
      public password:string,
      public authorities:string[]
    ) { }
}

// export interface Employee {
    
//   empId:number;
//   name:string;
//   phoneNumber:string;
//   email:string;
//   department:Department[];
//   meetings:Meeting[];
//   addresses:Address[];
//   role:Role[];
//   password:string;
//   authorities:string[];
// }