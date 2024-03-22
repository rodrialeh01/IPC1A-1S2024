import { listaUsuarios } from "../constants/constantes.js"
import { Usuario } from "../models/Usuario.js"

export const getHome = (req, res) => {
    res.send({
        mensaje: "Bienvenido a mi primer API usando NodeJS con Express en IPC1"
    })
}

// CREAR USUARIO
export const crearUsuario = (req, res) => {
    const { username, password, nombre, edad } = req.body;
    const nuevoUsuario = new Usuario(username, password, nombre, edad);
    listaUsuarios.push(nuevoUsuario);
    res.send({
        status: true,
        mensaje: "Usuario creado con éxito"
    })
}

//VER TODOS LOS USUARIOS
export const verUsuarios = (req, res) => {
    res.send({
        status: true,
        usuarios: listaUsuarios
    })
}

//ACTUALIZAR USUARIO
export const actualizarUsuario = (req, res) => {
    const { username, password, nombre, edad } = req.body;
    for (let i = 0; i < listaUsuarios.length; i++) {
        if(listaUsuarios[i].username === username){
            listaUsuarios[i].password = password;
            listaUsuarios[i].nombre = nombre;
            listaUsuarios[i].edad = edad;
            res.send({
                status: true,
                mensaje: "Usuario actualizado con éxito"
            })
        }
    }
    res.send({
        status: false,
        mensaje: "Error: Usuario no encontrado"
    })
}

export const eliminarUsuario = (req, res) => {
    const { username } = req.params;
    for(let i = 0; i < listaUsuarios.length; i++) {
        if(listaUsuarios[i].username === username){
            listaUsuarios.splice(i,1);
            res.send({
                status: true,
                mensaje: "Usuario eliminado con éxito"
            })
        }
    }
    res.send({
        status: false,
        mensaje: "Error: Usuario no encontrado"
    })
}