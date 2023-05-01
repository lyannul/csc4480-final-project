import Employees from "@/components/Employees";
import Layout from "@/components/Layout";
import React from "react";

const EmployeesPage = () => {
  return (
    <Layout>
      <main>
        <section className="min-h-main flex flex-col justify-center items-center">
          <h2 className="text-4xl md:text-6xl mt-16 mb-5">Employees</h2>

          <Employees />
        </section>
      </main>
    </Layout>
  );
};

export default EmployeesPage;
