import { useMovieContext } from "../features/movies/hooks/useMovieContext";

const SearchForm = () => {
    const { searchQuery, setSearchQuery, handleSearch, loading } = useMovieContext();

    const handleSubmit = (e) => {
        e.preventDefault();
        handleSearch(searchQuery);
    };

    return (
        <form onSubmit={handleSubmit} className="search-form">
            <input
                type="text"
                className="search-input"
                placeholder="Search for movies..."
                onChange={(e) => setSearchQuery(e.target.value)}
                value={searchQuery}
            />
            <button className="search-button" disabled={loading}>
                {loading ? "Searching..." : "Search"}
            </button>
        </form>
    );
};

export default SearchForm;