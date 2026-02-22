import { useState } from 'react';
import { AuthContext } from './AuthContext';
import { loginService } from '../services/authService';

export const AuthProvider = ({ children }) => {

    const [user, setUser] = useState(() => {
        const stored = localStorage.getItem('user_data');
        return stored ? JSON.parse(stored) : null;
    });


    const [loading, setLoading] = useState(false);


    const login = async (credentials) => {
        setLoading(true);
        try {
            const data = await loginService(credentials);
            localStorage.setItem('jwt_token', data.token);
            localStorage.setItem('user_data', JSON.stringify(data.user));
            setUser(data.user);
            return true;
        } catch (error) {
            console.error("Error en Login: ", error);
            return false;
        } finally {
            setLoading(false);
        }
    }
    const logout = () => {
        localStorage.removeItem('jwt_token');
        localStorage.removeItem('user_data');
        setUser(null);
    };

    return (
        <AuthContext.Provider value={{ user, login, logout, loading }}>
            {children}
        </AuthContext.Provider>
    );

}