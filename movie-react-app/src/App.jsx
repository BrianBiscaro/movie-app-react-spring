import './App.css'
import Home from "./pages/Home"
import Favorites from './pages/Favorites'
import { Route, Routes } from 'react-router-dom'
import { MovieProvider } from './context/MovieProvider'

function App() {
  return (
    <MovieProvider>
      <main className='main-content'>

        <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/favorites' element={<Favorites />} />
        </Routes>

      </main>
    </MovieProvider>
  )

}

export default App
