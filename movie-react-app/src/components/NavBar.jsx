import { Link } from 'react-router-dom'
import styles from './NavBar.module.css'
import SearchForm from './SearchForm';

const NavBar = () => {

    return (
        <nav className={styles.navbar}>
            <div className={styles.navbarBrand}>
                <Link to="/">Movie App</Link>
            </div>
            <SearchForm />
            <div className={styles.navbarLinks}>
                <Link to="/">Home</Link>
                <Link to="/favorites">Favorites</Link>
            </div>
        </nav>
    )
}

export default NavBar;