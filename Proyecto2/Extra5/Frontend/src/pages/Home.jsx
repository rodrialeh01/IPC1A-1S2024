import { useNavigate } from "react-router-dom";
import { useUser } from "../context/User";
const Home = () => {
    const { user, actualizarUsuario } = useUser();
    const navigate = useNavigate();
    const cerrarSesion = () => {
        actualizarUsuario(null);
        navigate('/');
    }
    return (
        <div>
            <h1>Home</h1>
            <button className="bg-green-500 p-3 rounded-lg text-white font-bold" onClick={cerrarSesion}>Cerrar Sesión</button>
        </div>
    );
}

export default Home;