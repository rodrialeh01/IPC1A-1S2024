import { useEffect } from "react";
import { createBrowserRouter } from "react-router-dom";
import { useUser } from "../context/User";
import LayoutAdmin from "../Layouts/LayoutAdmin";
import LayoutUser from "../Layouts/LayoutUser";
import Home from "../pages/Home";
import Login from "../pages/Login";
import Registro from "../pages/Registro";
import Usuarios from "../pages/Usuarios";

const PrivateRoute = () => {
    const { user } = useUser();

    useEffect(() => {
        if(user === null){
            window.location.href = '/';
        }
    }, [user]);
}

export const router = createBrowserRouter([
    {
        path: '/',
        element: <Login />
    },
    {
        path:'/registrar',
        element: <Registro />
    },
    {
        path:'/user',
        element: <LayoutUser/>,
        children:[
            {
                path:'home',
                element: <Home />
            }
        ]
    },
    {
        path: '/admin',
        element: <LayoutAdmin />,
        children:[
            {
                path: 'usuarios',
                element: <Usuarios/>
            }
        ]
    }
]);