import { Plant, PlantType } from "@/interfaces";
import React, { useState, useEffect } from "react";
import axios from "axios";

const PlantForm = ({setOpen}: any) => {
  const [formData, setFormData] = useState<PlantType>({
    typeName: "",
    description: "",
    price: 0,
    color: "",
    locationID: 0,
    waterNeeds: "",
    soilType: ""
  });

  function handleSubmit(event: any) {
    event.preventDefault();
    axios
      .post("http://localhost:8080/plant_types", formData)
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
            htmlFor="typeName"
            className="block mb-2 text-sm font-medium text-white"
          >
            Type Name
          </label>
          <input
            type="text"
            id="typeName"
            name="typeName"
            className="border btext-sm rounded-lg foblock w-full p-2.5 bg-gray-700 border-gray-600 placeholder-gray-400 text-white focus:ring-blue-500 focus:border-blue-500"
            placeholder="Type Name"
            value={formData?.typeName}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label
            htmlFor="description"
            className="block mb-2 text-sm font-medium text-white"
          >
            Description
          </label>
          <input
            type="text"
            id="description"
            name="description"
            className="border text-sm rounded-lg block w-full p-2.5 bg-gray-700 border-gray-600 placeholder-gray-400 text-white focus:ring-blue-500 focus:border-blue-500"
            placeholder="Description"
            value={formData?.description}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label
            htmlFor="price"
            className="block mb-2 text-sm font-medium text-white"
          >
            Price
          </label>
          <input
            type="number"
            id="price"
            name="price"
            className="border text-sm rounded-lg ock w-full p-2.5 bg-gray-700 border-gray-600 placeholder-gray-400 text-white focus:ring-blue-500 focus:border-blue-500"
            placeholder="Price"
            value={formData?.price}
            onChange={handleChange}
            pattern="[0-9]+"
            required
          />
        </div>
        <div>
          <label
            htmlFor="color"
            className="block mb-2 text-sm font-medium text-white"
          >
            Color
          </label>
          <input
            type="text"
            id="color"
            name="color"
            className="border text-sm rounded-lg ock w-full p-2.5 bg-gray-700 border-gray-600 placeholder-gray-400 text-white focus:ring-blue-500 focus:border-blue-500"
            placeholder="Color"
            value={formData?.color}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label
            htmlFor="locationID"
            className="block mb-2 text-sm font-medium text-white"
          >
            Location ID
          </label>
          <input
            type="number"
            id="locationID"
            name="locationID"
            className="border text-sm rounded-lg ock w-full p-2.5 bg-gray-700 border-gray-600 placeholder-gray-400 text-white focus:ring-blue-500 focus:border-blue-500"
            placeholder="Location ID"
            value={formData?.locationID}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label
            htmlFor="water"
            className="block mb-2 text-sm font-medium text-white"
          >
            Water Needs
          </label>
          <input
            type="text"
            id="water"
            name="waterNeeds"
            className="border text-sm rounded-lg ock w-full p-2.5 bg-gray-700 border-gray-600 placeholder-gray-400 text-white focus:ring-blue-500 focus:border-blue-500"
            placeholder="Water Needs"
            value={formData?.waterNeeds}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label
            htmlFor="soil"
            className="block mb-2 text-sm font-medium text-white"
          >
            Soil Type
          </label>
          <input
            type="text"
            id="soil"
            name="soilType"
            className="border text-sm rounded-lg ock w-full p-2.5 bg-gray-700 border-gray-600 placeholder-gray-400 text-white focus:ring-blue-500 focus:border-blue-500"
            placeholder="Soil Type"
            value={formData?.soilType}
            onChange={handleChange}
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

export default PlantForm;
