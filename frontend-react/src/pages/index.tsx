import Greenhouse from "@/components/Greenhouse";
import Layout from "@/components/Layout";

export default function Home() {
  return (
    <Layout>
      <main>
        <section className="min-h-main flex flex-col justify-center items-center">
          <Greenhouse />
        </section>
      </main>
    </Layout>
  );
}
