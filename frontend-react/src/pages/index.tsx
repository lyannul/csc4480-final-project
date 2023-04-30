import Image from 'next/image'
import { Inter } from 'next/font/google'
import Employees from '@/components/Employees'
import Plants from '@/components/Plants'

const inter = Inter({ subsets: ['latin'] })

export default function Home() {
  return (
    <main
      className={`flex min-h-screen flex-col items-center justify-between p-24 ${inter.className}`}
    >
      <Employees />
      <Plants />
    </main>
  )
}
