export type Customer = {
  FirstName: string;
  MInit: string;
  LastName: string;
  CustomerId: number;
  UserName: string;
  WebPassword: string;
};

export type Employee = {
  firstName: string;
  mInit: string;
  lastName: string;
  employeeID: number;
  locationID: number;
};

export type Plant = {
  plantID: number;
  customerID: number;
  plantType: string;
  height: number;
  hydrated: number;
  sunlightStatus: number;
};

export type PlantType = {
  typeName: string;
  description: string;
  price: number;
  color: string;
  locationID: number;
  waterNeeds: string;
  soilType: string;
};
