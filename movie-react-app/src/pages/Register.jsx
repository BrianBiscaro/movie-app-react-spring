import { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import { registerService } from "../services/authService";

const Register = () => {

    const [formData, setFormData] = useState({
        username: '',
        email: '',
        password: '',
        confirmpassword: ''
    });
    const [error, setError] = useState('');
    const [successMessage, setSuccessMessage] = useState('');

    const navigate = useNavigate();



    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        setError('');
        setSuccessMessage('');


        // Validación básica
        if (formData.password !== formData.confirmpassword) {
            setError('Las contraseñas no coinciden');
            return;
        }

        try {
            await registerService({
                username: formData.username,
                email: formData.email,
                password: formData.password
            });


            setSuccessMessage('Registro exitoso');

            setTimeout(() => {
                navigate('/login');
            }, 2000);
        } catch (err) {
            console.error('Error en el registro', err);
            setError('Hubo un problema al registrar el usuario. Intenta con otro nombre');
        }
    };

    return (
        <div className="register-page">
            <h2>Crear Cuenta</h2>
            <form onSubmit={handleSubmit}>

                <div>
                    <label>Usuario</label>
                    <input
                        type="text"
                        name="username"
                        value={formData.username}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label>Email</label>
                    <input
                        type="email"
                        name="email"
                        value={formData.email}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label>Contraseña</label>
                    <input
                        type="password"
                        name="password"
                        value={formData.password}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label>Confirmar Contraseña</label>
                    <input
                        type="password"
                        name="confirmPassword"
                        value={formData.confirmpassword}
                        onChange={handleChange}
                        required
                    />
                </div>

                {error && <p>{error}</p>}
                {successMessage && <p>{successMessage}</p>}

                <button type="submit">
                    Registrarse
                </button>
            </form>

            <p>¿Ya tienes cuenta?

                <Link to="/login"> Inicia sesión aquí</Link>
            </p>
        </div>
    )
}

export default Register;