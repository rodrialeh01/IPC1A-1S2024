class Post{
    constructor(id, usuario, descripcion, imagen, fecha){
        this.id = id;
        this.usuario = usuario;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.fecha = fecha;
        this.comentarios = [];
        this.likes = 0;
    }

    getId(){
        return this.id;
    }

    setId(id){
        this.id = id;
    }

    getUsuario(){
        return this.usuario;
    }

    setUsuario(usuario){
        this.usuario = usuario;
    }

    getDescripcion(){
        return this.descripcion;
    }

    setDescripcion(descripcion){
        this.descripcion = descripcion;
    }

    getImagen(){
        return this.imagen;
    }

    setImagen(imagen){
        this.imagen = imagen;
    }

    getFecha(){
        return this.fecha;
    }

    setFecha(fecha){
        this.fecha = fecha;
    }

    getComentarios(){
        return this.comentarios;
    }

    setComentarios(comentarios){
        this.comentarios = comentarios;
    }

    agregarComentario(comentario){
        this.comentarios.push(comentario);
    }

    getLikes(){
        return this.likes;
    }

    setLikes(likes){
        this.likes = likes;
    }
    
}