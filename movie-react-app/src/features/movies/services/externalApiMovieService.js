import api from "../../../services/axiosConfig";

export const getPopularMovies = async () => {

    const response = await api.get('/catalog/popular')
    const data = await response.json();

    return data.results;
}

export const searchMovies = async (query) => {

    const response = await api.get(`/catalog/popular/${query}`)
    const data = await response.json();

    return data.results;
}