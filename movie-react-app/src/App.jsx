import './App.css'
import Home from "./pages/Home"
import Favorites from './pages/Favorites'
import { Route, Routes } from 'react-router-dom'
import { MovieProvider } from './context/MovieProvider'
import ProtectedRoute from './components/auth/ProtectedRoute'

function App() {
  return (
    <AuthProvider>
      <MovieProvider>
        <main className='main-content'>

          <Routes>
            <Route path='/login' element={<Login />} />
            <Route path='/register' element={<Register />} />


            <Route element={<ProtectedRoute />}>
              <Route path='/' element={<Home />} />
              <Route path='/favorites' element={<Favorites />} />
            </Route>
          </Routes>

        </main>
      </MovieProvider>
    </AuthProvider>
  )

}

export default App
