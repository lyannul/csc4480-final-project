import type { NextApiRequest, NextApiResponse } from "next";
import { executeQuery } from "../../utils/db";

export default async function handler(
  req: NextApiRequest,
  res: NextApiResponse
) {
  try {
    const customers = await executeQuery("SELECT * FROM CUSTOMER");
    res.status(200).json(customers);
  } catch (error) {
    console.error(error);
    res.status(500).json({ message: "Something went wrong" });
  }
}
