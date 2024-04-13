import { listaUsuarios } from "../db/bd.js"
import { User } from "../models/User.js"

export const getHome = (req, res) => {
    res.send({
        mensaje: "Bienvenido a mi primer API usando NodeJS con Express en IPC1"
    })
}

// CREAR USUARIO
export const crearUsuario = (req, res) => {
    const { username, password, nombre, edad } = req.body;
    const nuevoUsuario = new User(username, password, nombre, edad, 2);
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
    let usuarioEncontrado = false;
    for (let i = 0; i < listaUsuarios.length; i++) {
        if(listaUsuarios[i].username === username){
            listaUsuarios[i].password = password;
            listaUsuarios[i].nombre = nombre;
            listaUsuarios[i].edad = edad;
            usuarioEncontrado = true;
            break;
        }
    }
    if (usuarioEncontrado) {
        res.send({
            status: true,
            mensaje: "Usuario actualizado con éxito"
        })
    } else {
        res.send({
            status: false,
            mensaje: "Error: Usuario no encontrado"
        })
    }
}

export const eliminarUsuario = (req, res) => {
    const { username } = req.params;
    let usuarioEncontrado = false;
    for(let i = 0; i < listaUsuarios.length; i++) {
        if(listaUsuarios[i].username === username && listaUsuarios[i].role !== 1){
            listaUsuarios.splice(i,1);
            usuarioEncontrado = true;
        }
    }
    if (usuarioEncontrado) {
        res.send({
            status: true,
            mensaje: "Usuario eliminado con éxito"
        })
    } else {
        res.send({
            status: false,
            mensaje: "Error: Usuario no encontrado"
        })
    }
}

export const login = (req, res) => {
    const { username, password } = req.body;
    let usuarioEncontrado = false;
    let datareturn = {};
    for(let i = 0; i < listaUsuarios.length; i++) {
        if(listaUsuarios[i].username === username && listaUsuarios[i].password === password){
            usuarioEncontrado = true;
            datareturn = {
                usuario: listaUsuarios[i].username,
                rol: listaUsuarios[i].role
            }
            break;
        }
    }
    if (usuarioEncontrado) {
        res.send({
            status: true,
            mensaje: "Usuario encontrado",
            data: datareturn
        })
    } else {
        res.send({
            status: false,
            mensaje: "Error: Usuario no encontrado"
        })
    }
}

export const getUsuario = (req, res) => {
    const { username } = req.params;
    let usuarioEncontrado = false;
    for(let i = 0; i < listaUsuarios.length; i++) {
        if(listaUsuarios[i].username === username){
            usuarioEncontrado = true;
            res.send({
                status: true,
                usuario: listaUsuarios[i]
            })
            break;
        }
    }
    if (!usuarioEncontrado) {
        res.send({
            status: false,
            mensaje: "Error: Usuario no encontrado"
        })
    }
}