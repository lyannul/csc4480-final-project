import type { NextApiRequest, NextApiResponse } from "next";
import type { User } from "../../interfaces";

// Fake users data
const users: User[] = [
  { name: "Lucas", id: 1 },
  { name: "Josephine", id: 2 },
  { name: "Ximena", id: 3 },
  { name: "Amou", id: 4 },
];

export default function handler(
  _req: NextApiRequest,
  res: NextApiResponse<User[]>
) {
  // Get data from your database
  res.status(200).json(users);
}
