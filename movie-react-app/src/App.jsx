import './App.css'
import Home from "./pages/Home"
import Favorites from './pages/Favorites'
import Login from './pages/Login'
import Register from './pages/Register'
import { Route, Routes } from 'react-router-dom'
import { MovieProvider } from './context/MovieProvider'
import ProtectedRoute from './components/auth/ProtectedRoute'
import { AuthProvider } from './context/AuthProvider'
import { UserProvider } from './context/UserProvider'
import { MainLayout } from './layouts/MainLayout/MainLayout'

function App() {
  return (
    <AuthProvider>
      <MovieProvider>
        <UserProvider>
          <main className='main-content'>

            <Routes>
              <Route path='/' element={<Login />} />
              <Route path='/login' element={<Login />} />
              <Route path='/register' element={<Register />} />


              <Route element={<MainLayout />} />
              <Route path='/' element={<Home />} />


              <Route element={<ProtectedRoute />}>
                <Route path='/' element={<Home />} /> 
                <Route path='/home' element={<Home />} />
                <Route path='/favorites' element={<Favorites />} />
              </Route>
            </Routes>

          </main>
        </UserProvider>
      </MovieProvider>
    </AuthProvider>
  )

}

export default App
