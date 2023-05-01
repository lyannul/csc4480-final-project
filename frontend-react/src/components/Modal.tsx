import { Fragment, useRef, useState, useEffect, ReactNode } from "react";
import { Dialog, Transition } from "@headlessui/react";
import { BiHelpCircle } from "react-icons/bi";

type ModalProps = {
  children: ReactNode;
  title: string;
  open: boolean;
  setOpen: (x: boolean) => void;
  icon?: ReactNode;
};

const Modal = ({ children, title, open, setOpen }: ModalProps) => {
  const cancelButtonRef = useRef(null);

  useEffect(() => {
    const keyHandler = ({ key }: KeyboardEvent) => {
      if (!open || key !== "Escape") return;
      setOpen(false);
    };
    document.addEventListener("keydown", keyHandler);
    return () => document.removeEventListener("keydown", keyHandler);
  });

  return (
    <Transition.Root show={open} as={Fragment}>
      <Dialog
        as="div"
        className="relative z-30"
        initialFocus={cancelButtonRef}
        onClose={setOpen}
      >
        <Transition.Child
          as={Fragment}
          enter="ease-out duration-300"
          enterFrom="opacity-0"
          enterTo="opacity-100"
          leave="ease-in duration-200"
          leaveFrom="opacity-100"
          leaveTo="opacity-0"
        >
          <div className="fixed inset-0 bg-gray-500 bg-opacity-75 transition-opacity" />
        </Transition.Child>

        <div className="fixed inset-0 z-20 overflow-y-auto">
          <div className="flex min-h-full justify-center p-4 text-center items-center sm:p-0">
            <Transition.Child
              as={Fragment}
              enter="ease-out duration-300"
              enterFrom="opacity-0 translate-y-4 sm:translate-y-0 sm:scale-95"
              enterTo="opacity-100 translate-y-0 sm:scale-100"
              leave="ease-in duration-200"
              leaveFrom="opacity-100 translate-y-0 sm:scale-100"
              leaveTo="opacity-0 translate-y-4 sm:translate-y-0 sm:scale-95"
            >
              <Dialog.Panel className="relative transform overflow-hidden rounded-lg bg-dark text-left shadow-xl transition-all sm:my-8 sm:w-full sm:max-w-lg">
                <div className="bg-black px-4 pb-4 pt-5 sm:p-6 sm:pb-4">
                  <div className="sm:flex sm:items-start">
                    <div className="mt-3 text-center sm:ml-4 sm:mt-0 sm:text-left">
                      <Dialog.Title
                        as="h3"
                        className="text-base font-semibold leading-6 text-gray-900 dark:text-gray-200"
                      >
                        {title}
                      </Dialog.Title>
                      <div className="mt-2">{children}</div>
                    </div>
                  </div>
                </div>
                <div className="bg-black dark:outline px-4 py-3 sm:flex sm:flex-row-reverse sm:px-6">
                  <button
                    className="mt-3 inline-flex w-full justify-center rounded-md px-3 py-2 text-sm font-semibold shadow-sm sm:mt-0 sm:w-auto"
                    onClick={() => setOpen(false)}
                  >
                    Close
                  </button>
                </div>
              </Dialog.Panel>
            </Transition.Child>
          </div>
        </div>
      </Dialog>
    </Transition.Root>
  );
};

export default Modal;
