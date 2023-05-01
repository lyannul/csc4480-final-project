import { Plant, PlantType } from "@/interfaces";
import React, { useState, useEffect } from "react";
import axios from "axios";

const PurchaseForm = ({ setOpen, plantType }: any) => {
  const [formData, setFormData] = useState<Plant>({
    plantID: Math.floor(Math.random() * (1234568910 + 1)),
    customerID: 0,
    plantType: plantType,
    height: Math.floor(Math.random() * (74 + 1) + 1),
    hydrated: 0,
    sunlightStatus: 0,
  });

  function handleSubmit(event: any) {
    event.preventDefault();
    axios
      .post("http://localhost:8080/plants", formData)
      .then((response) => setOpen(false))
      .catch((error) => console.error(error));
  }

  function handleChange(event: any) {
    const { name, value } = event.target;
    setFormData((prevFormData: any) => ({
      ...prevFormData,
      [name]: value,
    }));
  }

  return (
    <form onSubmit={(e) => handleSubmit(e)} className="bg-dark">
      <div className="grid gap-6 mb-6 md:grid-cols-2 bg-dark">
        <div>
          <label
            htmlFor="plant_id"
            className="block mb-2 text-sm font-medium text-white"
          >
            Plant ID
          </label>
          <input
            type="text"
            id="plant_id"
            name="plantID"
            className="border btext-sm rounded-lg foblock w-full p-2.5 bg-gray-700 border-gray-600 placeholder-gray-400 text-white focus:ring-blue-500 focus:border-blue-500"
            value={formData?.plantID}
            onChange={handleChange}
            disabled
            required
          />
        </div>
        <div>
          <label
            htmlFor="customer_id"
            className="block mb-2 text-sm font-medium text-white"
          >
            Customer ID
          </label>
          <input
            type="text"
            id="customer_id"
            name="customerID"
            className="border text-sm rounded-lg foblock w-full p-2.5 bg-gray-700 border-gray-600 placeholder-gray-400 text-white focus:ring-blue-500 focus:border-blue-500"
            value={formData?.customerID}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label
            htmlFor="plantType"
            className="block mb-2 text-sm font-medium text-white"
          >
            Plant Type
          </label>
          <input
            type="text"
            id="plantType"
            name="plantType"
            className="border text-sm rounded-lg foblock w-full p-2.5 bg-gray-700 border-gray-600 placeholder-gray-400 text-white focus:ring-blue-500 focus:border-blue-500"
            value={formData?.plantType}
            onChange={handleChange}
            disabled
            required
          />
        </div>
      </div>
      <button
        type="submit"
        className="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center bg-blue-600 hover:bg-blue-700 focus:ring-blue-800"
      >
        Submit
      </button>
    </form>
  );
};

export default PurchaseForm;
