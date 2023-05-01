import Employees from "@/components/Employees";
import Layout from "@/components/Layout";
import Plants from "@/components/Plants";
import React from "react";

const PlantsPage = () => {
  return (
    <Layout>
      <main>
        <section className="min-h-main flex flex-col justify-center items-center">
          <h2 className="text-4xl md:text-6xl mt-16 mb-5">Plants</h2>

          <Plants />
        </section>
      </main>
    </Layout>
  );
};

export default PlantsPage;
