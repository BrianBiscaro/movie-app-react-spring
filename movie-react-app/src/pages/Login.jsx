import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../hooks/useAuth";

const Login = () => {

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const { login } = useAuth();
    const navigate = useNavigate();


    const handleSubmit = async (e) => {
        e.preventDefault();
        setError('');

        const success = await login({ username, password });
        if (success) {
            navigate('/home');
        } else {
            setError('Credenciales inválidas');
        }
    };

    return (
        <div className="login-page">
            <h2>Iniciar Sesión</h2>

            <form onSubmit={handleSubmit}>

                <div>
                    <label>Usuario</label>
                    <input type="text"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label>Contraseña</label>
                    <input
                        type="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />
                </div>

                {error && <p style={{ color: 'red' }}>{error}</p>}

                <button type="submit">
                    Entrar
                </button>
            </form>
        </div>
    );
};

export default Login;
