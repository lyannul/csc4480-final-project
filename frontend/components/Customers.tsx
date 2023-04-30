import { useState, useEffect } from "react";
import axios from "axios";

const Customers = () => {
  const [customers, setCustomers] = useState([]);

  useEffect(() => {
    async function fetchCustomers() {
      const response = await axios.get("/api/customer");
      setCustomers(response.data);
    }
    fetchCustomers();
  }, []);

  return (
    <div>
      {customers.map((customer) => (
        <div key={customer.CustomerID}>
          <p>
            Name: {customer.FirstName} {customer.LastName}
          </p>
          <p>Username: {customer.UserName}</p>
        </div>
      ))}
    </div>
  );
};

export default Customers;
