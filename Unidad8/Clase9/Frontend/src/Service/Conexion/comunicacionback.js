import axios from 'axios';

const instance = axios.create({
    baseURL: 'http://localhost:3000'
})


export const crearUsuario = async (user_data) => {
    const response = await instance.post(
        '/user/crear',
        user_data,
        {
            headers: {
                'Content-Type':'application/json'
            }
        }
    );

    return response.data;
}

export const login = async (user_data) => {
    const response = await instance.post(
        '/user/login',
        user_data,
        {
            headers: {
                'Content-Type':'application/json'
            }
        }
    );

    return response.data;
}