import MovieCard from "./MovieCard";
import styles from './MovieGrid.module.css'

export function MovieGrid({ movies }) {
    return (
        <div className={styles.moviesGrid}>
            {movies.map(
                movie => <MovieCard
                    movie={movie}
                    key={movie.id} />
            )}
        </div>
    )
}
