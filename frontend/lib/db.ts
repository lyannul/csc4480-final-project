const oracledb = require("oracledb");
oracledb.initOracleClient({ libDir: "/path/to/instant_client_directory" });

async function createConnection() {
  const conn = await oracledb.getConnection({
    user: process.env.DB_USER,
    password: process.env.DB_PASSWORD,
    connectString: process.env.DB_CONNECTION_STRING,
  });

  return conn;
}

module.exports = { executeQuery };
