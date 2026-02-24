import api from "./axiosConfig";

export const popularMoviesService = async () => {

    const response = await api.get('/catalog')
    const data = await response.json();

    return data.results;
}

export const searchMoviesService = async (query) => {

    const response = await api.get(`/catalog/${query}`)
    const data = await response.json();

    return data.results;
}