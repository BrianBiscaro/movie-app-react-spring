import { MovieGrid } from "../components/MovieGrid";
import { useMovieContext } from "../hooks/useMovieContext";
import Footer from "../layouts/Footer";
import Header from "../layouts/Header";

const Home = () => {
    const { movies, error, loading } = useMovieContext();
    return (
        <>
            <Header />
            <div className="home">
                {(error) && <div className="error-message">{error}</div>}
                {(loading) ? <div> Loading... </div> : <MovieGrid movies={movies} />}
            </div>
            <Footer />
        </>
    )
}

export default Home;