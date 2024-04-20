import {
    ArcElement,
    BarElement,
    CategoryScale,
    Chart as ChartJS,
    Legend,
    LinearScale,
    Title,
    Tooltip
} from 'chart.js';
import { saveAs } from 'file-saver';
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import Tabla from "../../components/Tabla";
import { useUser } from "../../context/User";
import Service from "../../Service/Service";

import { Bar, Pie } from 'react-chartjs-2';

const Usuarios = () => {

    // Registra la gráfica de Pastel
    ChartJS.register(ArcElement, Tooltip, Legend);
    // Registra la gráfica de Barras
    ChartJS.register(CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend);

    const { user, actualizarUsuario } = useUser();
    const navigate = useNavigate();
    const [listaUsuarios, setListaUsuarios] = useState([]);
    const [usuariosTemp, setUsuariosTemp] = useState([]);
    const [edad20, setEdad20] = useState(2);
    const [edad22, setEdad22] = useState(3);
    const [labelsE, setLabelsE] = useState([]);

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
            setLabelsE(['Edad 20', 'Edad 22']);
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
            {/* GRAFICAS DE EJEMPLO */}
            <div className='columns-2 max-h-full'>
                {/* GRAFICA BARRAS */}
                <div className='col-span-1'>
                    <h1 className='flex justify-center items-center pt-3 mt-4 text-xl font-bold'>Gráfica de Barras</h1>
                    <br />
                    <Bar
                        data = {{
                            labels: labelsE,
                            datasets: [
                                {
                                    data: [edad20, edad22],
                                    backgroundColor: 'rgba(11, 156, 164,0.2)',
                                    borderColor: 'rgba(11, 156, 164,1)',
                                    borderWidth: 1
                                }
                            ]
                        }}

                        options={{
                            responsive: true,
                            plugins: {
                                legend: {
                                    display: false
                                }
                            },
                            scales: {
                                y: {
                                    beginAtZero: true,
                                    grid: {
                                        color: 'rgba(255, 255, 255, 0.1)'
                                    }
                                }
                            }
                        }}
                    />
                </div>
                {/* GRAFICA PASTEL */}
                <div className='col-span-1'>
                    <h1 className='flex justify-center items-center pt-3 mt-4 text-xl font-bold'>Gráfica de Pie</h1>
                    <br />
                    <Pie
                        className='w-20 h-20'
                        data ={{
                            labels: labelsE,
                            datasets: [
                                {
                                    data: [edad20, edad22],
                                    backgroundColor: ['rgba(11, 156, 164,0.2)', 'rgba(255, 99, 132, 0.2)'],
                                    borderColor: ['rgba(11, 156, 164,1)', 'rgba(255, 99, 132, 1)'],
                                    borderWidth: 1
                                }
                            ],
                            hoverOffset: 2
                        }}
                        options={{
                            responsive: true,
                            plugins: {
                                legend: {
                                    position: 'top'
                                }
                            }
                        }}
                    />
                </div>
            </div>
        </div>
    );
}

export default Usuarios;