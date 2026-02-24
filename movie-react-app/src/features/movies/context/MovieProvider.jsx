import { useEffect, useState } from 'react'
import { MovieContext } from './MovieContext'
import { getPopularMovies, searchMovies } from '../services/externalApiMovieService'

export const MovieProvider = ({ children }) => {

    const [favorites, setFavorites] = useState(() => {
        const storedFavs = localStorage.getItem("favorites")
        return storedFavs ? JSON.parse(storedFavs) : []
    })

    const [movies, setMovies] = useState([])
    const [searchQuery, setSearchQuery] = useState("")
    const [error, setError] = useState(null)
    const [loading, setLoading] = useState(true)

    useEffect(() => {
        localStorage.setItem('favorites', JSON.stringify(favorites))
    }, [favorites])

    useEffect(() => {
        const loadPopularMovies = async () => {
            try {
                const popularMovies = await getPopularMovies()
                setMovies(popularMovies)
            } catch (err) {
                console.log(err)
                setError("Failed to load movies...")
            } finally {
                setLoading(false)
            }
        }

        loadPopularMovies()
    }, [])

    const addToFavorites = (movie) => {
        setFavorites(prev => [...prev, movie])
    }

    const removeFromFavorites = (movieId) => {
        setFavorites(prev => prev.filter(movie => movie.id !== movieId))
    }

    const isFavorite = (movieId) => {
        return favorites.some(movie => movie.id === movieId)
    }

    const handleSearch = async (query) => {
        if (!query.trim()) return
        if (loading) return

        setLoading(true)
        try {
            const searchResult = await searchMovies(query)
            setMovies(searchResult)
            setError(null)
        } catch (err) {
            console.log(err)
            setError("Error searching movies")
        } finally {
            setLoading(false)
        }
    }

    const value = {
        favorites,
        isFavorite,
        addToFavorites,
        removeFromFavorites,
        movies,
        setMovies,
        searchQuery,
        setSearchQuery,
        error,
        setError,
        loading,
        setLoading,
        handleSearch
    }

    return <MovieContext.Provider value={value}>
        {children}
    </MovieContext.Provider>
}
