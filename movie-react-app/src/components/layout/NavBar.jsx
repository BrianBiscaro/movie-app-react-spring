import { Link, useNavigate } from 'react-router-dom'
import styles from './NavBar.module.css'
import SearchForm from '../SearchForm';
import { useAuth } from '../../hooks/useAuth';

const NavBar = () => {

    const [logout] = useAuth();
    const navigate = useNavigate();

    const handleLogout = () => {
        logout();
        navigate("/login");
    }

    return (
        <nav className={styles.navbar}>
            <div className={styles.navbarBrand}>
                <Link to="/">Movie App</Link>
            </div>
            <SearchForm />
            <div className={styles.navbarLinks}>
                <Link to="/">Home</Link>
                <Link to="/favorites">Favorites</Link>
                <button onClick={handleLogout}>
                    <Link to="/login"> Cerrar Sesión </Link>
                </button>
            </div>
        </nav>
    )
}

export default NavBar;