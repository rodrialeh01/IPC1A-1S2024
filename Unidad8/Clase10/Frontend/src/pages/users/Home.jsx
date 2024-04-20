import { useState } from "react";
import { useNavigate } from "react-router-dom";
import Post from "../../components/Post";
import SideBar from "../../components/Sidebar";
import { useUser } from "../../context/User";
const Home = () => {
    const { user, actualizarUsuario } = useUser();
    const [arregloposts, setArregloPosts] = useState([null, null]);
    const navigate = useNavigate();
    const hoy = new Date();
    const cerrarSesion = () => {
        actualizarUsuario(null);
        navigate('/');
    }
    return (
        <div className="flex justify-center">
            <div className="hidden lg:block w-64">
                <SideBar/>
            </div>
            <div className="flex justify-center w-full">
                <div className="mx-2 ">
                    <h1 className="text-3xl font-bold">Home</h1>
                    {/*<Tiempo fecha={hoy} />*/}
                    {arregloposts.map((post) => (
                        <Post post={post} />
                    ))}
                </div>
            </div>
        </div>
    );
}

export default Home;