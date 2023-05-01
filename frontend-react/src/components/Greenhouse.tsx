import React, { useState, useEffect } from "react";
import Card from "./Card";
import { PlantType } from "@/interfaces";
import axios from "axios";
import Modal from "./Modal";
import PlantForm from "./PlantForm";

const Greenhouse = () => {
  const [plantTypes, setPlantTypes] = useState<PlantType[]>([]);
  const [open, setOpen] = useState(false);

  useEffect(() => {
    fetchPlantTypes();
  }, []);
  
  useEffect(() => {
    fetchPlantTypes();
  }, [open]);

  const fetchPlantTypes = async () => {
    axios
      .get<PlantType[]>("http://localhost:8080/plant_types")
      .then((response) => {
        setPlantTypes(response.data);
      })
      .catch((e) => console.log(e));
  };

  return (
    <>
      <button
        className="bg-green-400 rounded h-9 w-20 self-center m-4"
        onClick={() => setOpen(true)}
      >
        Add Plant
      </button>
      <div className="grid grid-cols-3 grid-rows-2 gap-5">
        {plantTypes.map((pType: PlantType) => (
          <Card key={pType.typeName} {...pType} />
        ))}
      </div>
      <Modal
        title="Add Plant Type"
        open={open}
        setOpen={setOpen}
        children={<PlantForm setOpen={setOpen}/>}
      />
    </>
  );
};

export default Greenhouse;
