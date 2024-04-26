export class User {
    constructor(username, password, nombre, edad, role){
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.edad = edad;
        this.role = role;
        this.likes = [];
    }

    getUsername(){
        return this.username;
    }

    getPassword(){
        return this.password;
    }

    getNombre(){
        return this.nombre;
    }

    getEdad(){
        return this.edad;
    }

    setUsername(username){
        this.username = username;
    }

    setPassword(password){
        this.password = password;
    }

    setNombre(nombre){
        this.nombre = nombre;
    }

    setEdad(edad){
        this.edad = edad;
    }

}