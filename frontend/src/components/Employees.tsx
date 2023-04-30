import { useState, useEffect } from "react";
import axios from "axios";
import { Employees } from "../interfaces";

const Employees = () => {
  const [employees, setEmployees] = useState<Array<Employees>>([]);

  useEffect(() => {
    fechEmployees();
  }, []);

  const fechEmployees = async () => {
    const response = await axios
      .get("http://localhost:8080/employees")
      .then((response) => {
        setEmployees(response.data);
      })
      .catch((e) => console.log(e));
  };

  return (
    <div>
      {employees.map((employee) => (
        <div key={employee.employeeID}>
          <p className="text-red">
            Name: {employee.firstName} {employee.lastName}
          </p>
          <p>LocationId: {employee.locationID}</p>
        </div>
      ))}
    </div>
  );
};

export default Employees;
