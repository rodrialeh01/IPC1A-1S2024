import { listaPublicaciones } from "../db/bd.js";
import { Post } from "../models/Post.js";

export const crearPublicacion = (req, res) => {
    const { usuario, descripcion, imagen, fecha } = req.body;
    const nuevaPublicacion = new Post(usuario, descripcion, imagen, fecha);
    listaPublicaciones.push(nuevaPublicacion);
    res.send({
        status: true,
        mensaje: "Publicación creada con éxito"
    })
}

export const getPublicaciones = (req, res) => {
    res.send({
        status: true,
        publicaciones: listaPublicaciones
    })
}