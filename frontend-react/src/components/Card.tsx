import React, { useState, useEffect } from "react";
import Image from "next/image";
import { PlantType } from "@/interfaces";
import Modal from "./Modal";
import PurchaseForm from "./PurchaseForm";
import { getImage } from "@/utils/getImage";

const Card = ({
  typeName,
  description,
  color,
  price,
  locationID,
  waterNeeds,
  soilType,
}: PlantType) => {
  const [open, setOpen] = useState(false);

  return (
    <>
      <div className="w-full max-w-sm bg-white border border-gray-200 rounded-lg shadow dark:bg-gray-800 dark:border-gray-700">
        <div className="flex items-center justify-center">
          <Image
            className="p-8 rounded-t-lg w-56 h-56"
            src={getImage(typeName)}
            alt="Plant Image"
          />
        </div>
        <div className="px-5 pb-5">
          <a href="#">
            <h5 className="text-xl font-semibold tracking-tight text-gray-900 dark:text-white">
              {typeName}
            </h5>
          </a>
          <div className="flex items-center mt-2.5 mb-5">
            <span className="bg-blue-100 text-blue-800 text-xs font-semibold mr-2 px-2.5 py-0.5 rounded dark:bg-blue-200 dark:text-blue-800 ml-3">
              {description}
            </span>
          </div>
          <div className="flex items-center justify-between">
            <span className="text-3xl font-bold text-gray-900 dark:text-white">
              ${price}
            </span>
            <button
              className="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
              onClick={() => setOpen(true)}
            >
              Purchase
            </button>
          </div>
        </div>
      </div>
      <Modal
        title="Purchase"
        open={open}
        setOpen={setOpen}
        children={<PurchaseForm plantType={typeName} setOpen={setOpen} />}
      />
    </>
  );
};

export default Card;
