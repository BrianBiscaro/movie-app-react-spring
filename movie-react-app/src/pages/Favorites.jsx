import Header from "../layouts/Header";
import Footer from "../layouts/Footer";
import { MovieGrid } from "../components/MovieGrid";
import { useMovieContext } from "../hooks/useMovieContext";

const Favorites = () => {
    const { error, loading, favorites } = useMovieContext();

    return (
        <>
            <Header />
            <div className="favorites">
                {(error) && <div className="error-message">{error}</div>}
                {(loading) && <div> Loading... </div>}
                {(favorites) ? <MovieGrid movies={favorites} /> : <p>No movies yet...</p>}
            </div>
            <Footer />
        </>
    )

}

export default Favorites;