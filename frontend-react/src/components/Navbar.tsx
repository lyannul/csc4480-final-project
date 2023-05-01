import React, { useState, useRef, useEffect } from "react";
import { useRouter } from "next/router";
import styles from "./Navbar.module.css";
import Logo from "../../../public/favicon/android-chrome-192x192.png";
import Image from "next/image";
import Link from "next/link";

const links = [
  { href: "/", label: "Greenhouse" },
  { href: "/employees", label: "Employees" },
  { href: "/plants", label: "Plants" },
];

const Navbar = () => {
  const [mobileNavOpen, setMobileNavOpen] = useState(false);
  const trigger = useRef<any>(null);
  const mobileNav = useRef<any>(null);

  const router = useRouter();
  const arrOfRoute = router.route.split("/");
  const baseRoute = "/" + arrOfRoute[1];

  // close the mobile menu on click outside
  useEffect(() => {
    const clickHandler = ({ target }: any) => {
      if (!mobileNav.current || !trigger.current) return;
      if (
        !mobileNavOpen ||
        mobileNav.current.contains(target) ||
        trigger.current.contains(target)
      )
        return;
      setMobileNavOpen(false);
    };
    document.addEventListener("click", clickHandler);
    return () => document.removeEventListener("click", clickHandler);
  });

  // close the mobile menu if the esc key is pressed
  useEffect(() => {
    const keyHandler = ({ keyCode }: any) => {
      if (!mobileNavOpen || keyCode !== 27) return;
      setMobileNavOpen(false);
    };
    document.addEventListener("keydown", keyHandler);
    return () => document.removeEventListener("keydown", keyHandler);
  });

  return (
    <header className="sticky top-0 z-30 w-full bg-dark ">
      {/* Top Gradient*/}
      <div className="h-2 bg-gradient-to-tr from-primary-200 via-primary-300 to-primary-400" />

      <div className="bg-dark transition-colors text-white">
        <div className="mx-auto max-w-6xl px-4 sm:px-6">
          <div className="flex h-20 items-center justify-center">
            {/* Desktop navigation */}
            <nav className="flex items-center justify-center">
              {/* Desktop sign in links */}
              <ul className="flex grow flex-wrap items-center justify-center space-x-3 ">
                {links.map(({ href, label }) => (
                  <li key={`${href}${label}`}>
                    <Link
                      rel="noopener noreferrer"
                      href={href}
                      className={
                        "rounded-md p-2 transition-colors font-medium text-white group hover:text-primary-300 hover:border-primary-300 hover:bg-gray-700 hover:text-primary-300"
                      }
                    >
                      <span
                        className={
                          "transition-colors group-hover:bg-primary-300/0"
                        }
                      >
                        {label}
                      </span>
                    </Link>
                  </li>
                ))}
              </ul>
            </nav>
          </div>
        </div>
      </div>
    </header>
  );
};

export default Navbar;
