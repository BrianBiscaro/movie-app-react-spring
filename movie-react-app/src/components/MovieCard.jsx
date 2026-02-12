import styles from './MovieCard.module.css'
import { useMovieContext } from '../hooks/useMovieContext'

const MovieCard = ({ movie }) => {
    const { addToFavorites, removeFromFavorites, isFavorite } = useMovieContext()
    const favorite = isFavorite(movie.id)

    const onFavoriteClick = (e) => {
        e.preventDefault()
        if (favorite) {
            removeFromFavorites(movie.id)
            console.log("Se quito de favoritos la pelicula: " + movie.title)
        } else {
            addToFavorites(movie)
            console.log("Se agrego a favoritos la pelicula " + movie.title)
        }
    }

    return (
        <div className={styles.movieCard}>
            <div className={styles.moviePoster}>
                <img src={`https://image.tmdb.org/t/p/w500${movie.poster_path}`} alt={movie.title} />
                <div className={styles.movieOverlay}>
                    <button
                        className={`${styles.favoriteBtn} ${favorite ? styles.favoriteBtnActive : styles.favoriteBtnInactive}`}
                        onClick={onFavoriteClick}
                    >
                        {favorite ? <p>Unfavorite</p> : <p>Favorite</p>}
                    </button>
                </div>
            </div>
            <div className={styles.movieInfo}>
                <h3>{movie.title}</h3>
                <p>{movie.release_date?.split("-")[0]}</p>
            </div>
        </div>
    )
}

export default MovieCard;