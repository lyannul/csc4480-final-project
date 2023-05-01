import * as React from "react";
import Navbar from "../components/Navbar";

const Layout = ({ children }: { children: React.ReactNode }) => {
  // Put Header or Footer Here
  return (
    <>
      <Navbar />
      <div className="flex items-center justify-center bg-dark transition-opacity">
        {children}
      </div>
    </>
  );
};

export default Layout;
