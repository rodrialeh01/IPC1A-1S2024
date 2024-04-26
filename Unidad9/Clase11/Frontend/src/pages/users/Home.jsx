import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import Post from "../../components/Post";
import SideBar from "../../components/Sidebar";
import { useUser } from "../../context/User";
import Service from "../../Service/Service";
const Home = () => {
    const { user, actualizarUsuario } = useUser();
    const [listaPublicaciones, setListaPublicaciones] = useState([]);
    const navigate = useNavigate();
    const hoy = new Date();
    const cerrarSesion = () => {
        actualizarUsuario(null);
        navigate('/');
    }
    useEffect(() => {
        Service.getPublicaciones()
        .then((response) => {
            setListaPublicaciones(response.publicaciones);
        })
        .catch((error) => {
            console.log(error);
        });
    }, []);
    return (
        <div className="flex justify-center">
            <div className="hidden lg:block w-64">
                <SideBar/>
            </div>
            <div className="flex justify-center w-full">
                <div className="mx-2 ">
                    <h1 className="text-3xl font-bold">Home</h1>
                    {/*<Tiempo fecha={hoy} />*/}
                    {listaPublicaciones.map((post) => (
                        <Post post={post} />
                    ))}
                </div>
            </div>
        </div>
    );
}

export default Home;