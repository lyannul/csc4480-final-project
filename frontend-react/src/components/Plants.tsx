import { Plant } from "@/interfaces";
import axios from "axios";
import React, { useState, useEffect } from "react";
import { RiSunLine, RiCloudFill } from "react-icons/ri";
import { GiWaterDrop } from "react-icons/gi";
import { FiXCircle } from "react-icons/fi";
import { getImage } from "@/utils/getImage";
import Image from "next/image";

const labels = [
  "Plant",
  "Plant ID",
  "Customer ID",
  "Plant Type",
  "Height",
  "Hydrated",
  "Sunlight Status",
  "Action",
];

const Plants = () => {
  const [plants, setPlants] = useState<Plant[]>([]);

  useEffect(() => {
    fetchPlants();
  }, []);

  const fetchPlants = async () => {
    axios
      .get<Plant[]>("http://localhost:8080/plants")
      .then((response) => {
        setPlants(response.data);
      })
      .catch((e) => console.log(e));
  };

  const fetchPlant = async (id: number): Promise<Plant> => {
    return axios
      .get<Plant>(`http://localhost:8080/plants/${id}`)
      .then((response) => {
        return response.data;
      });
  };

  const handleWater = async (id: number) => {
    const plant = await fetchPlant(id);
    const updatedPlant: Plant = {
      plantID: plant.plantID,
      customerID: plant.customerID,
      plantType: plant.plantType,
      height: plant.height,
      hydrated: 1,
      sunlightStatus: plant.hydrated,
    };
    updatePlant(id, updatedPlant);
  };

  const handleSun = async (id: number) => {
    const plant = await fetchPlant(id);
    const updatedPlant: Plant = {
      plantID: plant.plantID,
      customerID: plant.customerID,
      plantType: plant.plantType,
      height: plant.height,
      hydrated: plant.hydrated,
      sunlightStatus: 1,
    };
    updatePlant(id, updatedPlant);
  };

  const updatePlant = async (id: number, updatedPlant: Plant) => {
    try {
      await axios.put<Plant>(
        `http://localhost:8080/plants/${id}`,
        updatedPlant
      );

      setPlants((prevPlants) => {
        const updatedPlants = [...prevPlants];
        const index = updatedPlants.findIndex((plant) => plant.plantID === id);
        if (index !== -1) {
          updatedPlants[index] = { ...updatedPlant };
        }
        return updatedPlants;
      });
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div className="relative overflow-x-auto shadow-md sm:rounded-lg m-10">
      <table className="w-full text-sm text-left text-gray-500 dark:text-gray-400">
        <thead className="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
          <tr>
            {labels.map((label) => (
              <th key={label} scope="col" className="px-6 py-3">
                {label}
              </th>
            ))}
          </tr>
        </thead>
        <tbody>
          {plants.map((p) => (
            <tr
              key={p.plantID}
              className="bg-white border-b dark:bg-gray-900 dark:border-gray-700"
            >
              <td className="px-6 py-4">
                <Image src={getImage(p.plantType)} alt="Image of plant" className="w-16 h-16 bg-transparent"/>
              </td>
              <td className="px-6 py-4">{p.plantID}</td>
              <td className="px-6 py-4">{p.customerID}</td>
              <td className="px-6 py-4">{p.plantType}</td>
              <td className="px-6 py-4">{p.height}</td>
              <td className="px-6 py-4">
                {p.hydrated ? (
                  <GiWaterDrop color="blue" size={20} />
                ) : (
                  <FiXCircle color="red" size={20} />
                )}
              </td>
              <td className="px-6 py-4">
                {p.sunlightStatus ? (
                  <RiSunLine color="yellow" size={20} />
                ) : (
                  <RiCloudFill color="grey" size={20} />
                )}
              </td>
              <td className="px-6 py-4 grid grid-cols-2 gap-10">
                <button
                  className="font-medium text-blue-600 dark:text-blue-500 hover:underline"
                  onClick={() => handleWater(p.plantID)}
                >
                  Water
                </button>
                <button
                  className="font-medium text-yellow-600 dark:text-yellow-500 hover:underline"
                  onClick={() => handleSun(p.plantID)}
                >
                  Sun
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Plants;
