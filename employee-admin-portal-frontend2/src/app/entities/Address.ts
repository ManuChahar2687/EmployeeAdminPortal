export class Address {
    constructor(
      public addressId:number,
      public houseNumber:string,
      public streetName:string,
      public city:string,
      public zip:string,
      public country:string
    ) { }
}