import api from "./axiosConfig";

const BASE_URL = api.BASE_URL

export const popularMoviesService = async () => {

    const response = await api.get(`${BASE_URL}/catalog`)
    const data = await response.json();

    return data.results;
}

export const searchMoviesService = async (query) => {

    const response = await fetch(`${BASE_URL}/search/movie?api_key=${API_KEY}&query=${encodeURIComponent(query)}`)
    const data = await response.json();

    return data.results;
}