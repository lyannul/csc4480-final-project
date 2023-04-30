import oracledb from "oracledb";

const dbConfig: oracledb.ConnectionAttributes = {
  user: process.env.DB_USER || "",
  password: process.env.DB_PASSWORD || "",
  connectString: process.env.DB_CONNECT_STRING || "",
};

export async function executeQuery(query: string, bindParams?: any[]) {
  let connection: oracledb.Connection;
  let result: oracledb.Result<any>;

  try {
    connection = await oracledb.getConnection(dbConfig);
    result = await connection.execute(query, bindParams);
  } catch (err) {
    console.error(err);
  } finally {
    if (connection) {
      try {
        await connection.close();
      } catch (err) {
        console.error(err);
      }
    }
  }

  return result;
}
