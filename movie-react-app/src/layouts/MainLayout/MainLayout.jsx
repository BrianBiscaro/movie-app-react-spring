
import { Outlet } from 'react-router-dom';
import { Header } from './Header';
import { NavBar } from './NavBar/NavBar';
import { Footer } from './Footer';
import styles from './MainLayout.module.css';

export const MainLayout = () => {
    return (
        <div className={styles.layout}>
            <Header />
            <NavBar />
            <main className={styles.content}>
                {/* (Home, Favorites, etc.) */}
                <Outlet />
            </main>
            <Footer />
        </div>
    );
};