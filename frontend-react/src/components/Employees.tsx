import { useState, useEffect } from "react";
import axios from "axios";
import { Employee } from "../interfaces";

const Employees = () => {
  const [employees, setEmployees] = useState<Employee[]>([]);

  useEffect(() => {
    fechEmployees();
  }, []);

  const fechEmployees = async () => {
    axios
      .get<Employee[]>("http://localhost:8080/employees")
      .then((response) => {
        setEmployees(response.data);
      })
      .catch((e) => console.log(e));
  };

  const deleteEmployee = async (id: number) => {
    axios
      .delete(`http://localhost:8080/employees/${id}`)
      .then((response) => {
        console.log("Employee deleted successfully");
        setEmployees(employees.filter((e) => e.employeeID !== id));
      })
      .catch((error) => {
        console.error("Error deleting employee:", error);
      });
  };

  const handleEdit = (employeeID: number) => {};

  const handleDelete = (employeeID: number) => { deleteEmployee(employeeID)};

  return (
    <div className="relative overflow-x-auto shadow-md sm:rounded-lg">
      <table className="w-full text-sm text-left text-gray-500 dark:text-gray-400">
        <thead className="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
          <tr>
            <th scope="col" className="px-6 py-3">
              Name
            </th>
            <th scope="col" className="px-6 py-3">
              Employee ID
            </th>
            <th scope="col" className="px-6 py-3">
              Locaiton ID
            </th>
            <th scope="col" className="px-6 py-3">
              Action
            </th>
          </tr>
        </thead>
        <tbody>
          {employees.map((e) => (
            <tr key={e.employeeID} className="bg-white border-b dark:bg-gray-900 dark:border-gray-700">
              <th
                scope="row"
                className="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white"
              >
                {e.firstName} {e.mInit} {e.lastName}
              </th>
              <td className="px-6 py-4">{e.employeeID}</td>
              <td className="px-6 py-4">{e.locationID}</td>
              <td className="px-6 py-4 grid grid-cols-2 gap-4">
                <button
                  className="font-medium text-blue-600 dark:text-blue-500 hover:underline"
                  onClick={() => handleEdit(e.employeeID)}
                >
                  Edit
                </button>
                <button
                  className="font-medium text-red-600 dark:text-red-500 hover:underline"
                  onClick={() => handleDelete(e.employeeID)}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Employees;
