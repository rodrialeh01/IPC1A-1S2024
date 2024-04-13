import { saveAs } from 'file-saver';
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import Tabla from "../components/Tabla";
import { useUser } from "../context/User";
import Service from "../Service/Service";
const Usuarios = () => {
    const { user, actualizarUsuario } = useUser();
    const navigate = useNavigate();
    const [listaUsuarios, setListaUsuarios] = useState([]);
    const [usuariosTemp, setUsuariosTemp] = useState([]);

    useEffect(() => {
        Service.getUsuarios()
        .then(response => {
            const listaU = []
            for(let i = 0; i < response.usuarios.length; i++){
                if(response.usuarios[i].role !== 1){
                    listaU.push(response.usuarios[i]);
                }
            }
            setListaUsuarios(listaU);
        })
        .catch(error => {
            console.log(error);
        })
    },[])


    const cerrarSesion = () => {
        actualizarUsuario(null);
        navigate('/');
    }

    const abrirArchivo = (e) => {
        const archivo = e.target.files[0];
        const fileReader = new FileReader();

        fileReader.readAsText(archivo, 'UTF-8');
        fileReader.onload = (e) => {
            const usuarios = JSON.parse(fileReader.result);
            console.log(usuarios);
            setUsuariosTemp(usuarios);
        }
        fileReader.onerror = (error) => {
            console.log(error);
        }
    }

    const cargarUsuarios = () => {
        for(let i = 0; i < usuariosTemp.length; i++){
            const data = {
                username: usuariosTemp[i].username,
                password: usuariosTemp[i].password,
                nombre: usuariosTemp[i].nombre,
                edad: usuariosTemp[i].edad
            }
            Service.crearUsuario(data)
            .then(response => {
                console.log(response);
            })
            .catch(error => {
                console.log(error);
            })
        }
        window.location.reload();
    }

    const crearArchivo = () => {
        let contenido = 'username,password,nombre,edad\n'
        for(let i = 0; i < listaUsuarios.length; i++){
            contenido += listaUsuarios[i].username+','+listaUsuarios[i].password+','+listaUsuarios[i].nombre+','+listaUsuarios[i].edad +'\n';
        }
        const archivo = new Blob([contenido], {type: 'text/plain; charset=utf-8'});
        saveAs(archivo, 'usuarios.csv')
    }
    return (
        <div>
            <h1>Usuarios</h1>
            <button className="bg-green-500 p-3 rounded-lg text-white font-bold m-2" onClick={cerrarSesion}>Cerrar Sesión</button>
            <button className="bg-blue-500 p-3 rounded-lg text-white font-bold m-2" onClick={cargarUsuarios}>Cargar Usuarios</button>
            <button className="bg-yellow-500 p-3 rounded-lg text-white font-bold m-2" onClick={crearArchivo}>Guardar Usuarios</button>
            <label htmlFor="inputff"><img src="https://img.icons8.com/fluency-systems-filled/50/000000/import-file.png"/></label>
            <input onChange={abrirArchivo} type="file" id='inputff' accept=".json" />
            <Tabla usuarios={listaUsuarios}/>
        </div>
    );
}

export default Usuarios;