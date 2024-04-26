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

export const getUsuarios = async () => {
    const response = await instance.get(
        '/user/ver'
    );

    return response.data;
}

export const editarUsuario = async (user_data) => {
    const response = await instance.put(
        '/user/editar',
        user_data,
        {
            headers: {
                'Content-Type':'application/json'
            }
        }
    );

    return response.data;
}

export const eliminarUsuario = async(username) => {
    const response = await instance.delete(
        `/user/eliminar/${username}`
    );

    return response.data;
}

export const getUsuario = async(username) => {
    const response = await instance.get(
        `/user/getUsuario/${username}`
    );

    return response.data;
}

export const crearPublicacion = async (post_data) => {
    const response = await instance.post(
        '/post/crear',
        post_data,
        {
            headers: {
                'Content-Type':'application/json'
            }
        }
    );

    return response.data;
}

export const getPublicaciones = async () => {
    const response = await instance.get(
        '/post/ver'
    );

    return response.data;
}
