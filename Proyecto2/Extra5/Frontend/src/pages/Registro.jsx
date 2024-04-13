import { useState } from 'react';
import { Link } from 'react-router-dom';
import Service from '../Service/Service';
import './Registro.css';
const Registro = () => {

    const [username, setUsername] = useState('');
    const [name, setName] = useState('');
    const [age, setAge] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
    }

    const onChangeUsername = (e) => {
        setUsername(e.target.value);
    }

    const onChangeName = (e) => {
        setName(e.target.value);
    }

    const onChangeAge = (e) => {
        setAge(e.target.value);
    }

    const onChangePassword = (e) => {
        setPassword(e.target.value);
    }

    const CrearUser = () => {

        if(username === '' || name === '' || age === '' || password === ''){
            alert('Todos los campos son obligatorios');
            return;
        }

        const user_data = {
            username: username,
            password:password,
            nombre:name,
            edad:age
        }

        Service.crearUsuario(user_data)
        .then(response => {
            console.log(response);
            alert('Usuario creado correctamente');
        })
        .catch(error => {
            console.log(error);
        });
    }

    return (
        <div>
            <div className="h-screen md:flex font">
                <div
                className="fuente3 relative overflow-hidden md:flex w-1/2 bg-gradient-to-tr from-lightPurple to-purple-700 i justify-around items-center hidden"
                style={{
                    backgroundImage:
                    "url('https://i.postimg.cc/y8Jb088T/imagen-2023-12-08-114349361.png')",
                    backgroundColor: "rgba(127, 63, 191, 0.7)",
                    backgroundSize: "cover",
                    backgroundPosition: "center center",
                }}
                >
                <div style={{ width: "400px", height: "400px" }}>
                    <svg
                    xmlns="http://www.w3.org/2000/svg"
                    fill="none"
                    viewBox="0 0 24 24"
                    strokeWidth={1.5}
                    stroke="currentColor"
                    className="opacity-60 mx-auto text-black"
                    >
                    <path
                        strokeLinecap="round"
                        strokeLinejoin="round"
                        d="M12 6.042A8.967 8.967 0 006 3.75c-1.052 0-2.062.18-3 .512v14.25A8.987 8.987 0 016 18c2.305 0 4.408.867 6 2.292m0-14.25a8.966 8.966 0 016-2.292c1.052 0 2.062.18 3 .512v14.25A8.987 8.987 0 0018 18a8.967 8.967 0 00-6 2.292m0-14.25v14.25"
                    />
                    </svg>
                </div>
                </div>
                <div className="flex md:w-1/2 justify-center py-10 items-center bg-gris3">
                <form className="bg-gris3" onSubmit={handleSubmit}>
                    <h1 className="text-black font-bold text-4xl mb-1 ">
                    <span>Bienvenido</span>, Regístrate
                    </h1>
                    <p className="text-s font-normal text-black mb-7">
                    Un ejemplo de registro
                    </p>
                    <div className="flex items-center border-2 py-2 px-3 rounded-2xl mb-4">
                    <svg
                        xmlns="http://www.w3.org/2000/svg"
                        fill="none"
                        viewBox="0 0 24 24"
                        strokeWidth={1.5}
                        stroke="currentColor"
                        className="w-6 h-6 text-rojo1"
                    >
                        <path
                        strokeLinecap="round"
                        strokeLinejoin="round"
                        d="M15.75 6a3.75 3.75 0 11-7.5 0 3.75 3.75 0 017.5 0zM4.501 20.118a7.5 7.5 0 0114.998 0A17.933 17.933 0 0112 21.75c-2.676 0-5.216-.584-7.499-1.632z"
                        />
                    </svg>

                    <input
                        className="pl-2 outline-none border-none bg-gris3 text-black"
                        type="text"
                        name="name"
                        id="name"
                        placeholder="Username"
                        value={username}
                        onChange={onChangeUsername}
                        required
                        style={{ width: "100%" }}
                    />
                    </div>
                    <div className="flex items-center border-2 py-2 px-3 rounded-2xl mb-4">
                    <svg
                        xmlns="http://www.w3.org/2000/svg"
                        fill="none"
                        viewBox="0 0 24 24"
                        strokeWidth={1.5}
                        stroke="currentColor"
                        className="w-6 h-6 text-rojo1"
                    >
                        <path
                        strokeLinecap="round"
                        strokeLinejoin="round"
                        d="M15.75 6a3.75 3.75 0 11-7.5 0 3.75 3.75 0 017.5 0zM4.501 20.118a7.5 7.5 0 0114.998 0A17.933 17.933 0 0112 21.75c-2.676 0-5.216-.584-7.499-1.632z"
                        />
                    </svg>
                    <input
                        className="pl-2 outline-none border-none bg-gris3 text-black"
                        type="text"
                        name="lastName"
                        id="lastName"
                        placeholder="Nombre"
                        value={name}
                        onChange={onChangeName}
                        required
                    />
                    </div>
                    <div className="flex items-center border-2 py-2 px-3 rounded-2xl mb-4">
                    <svg
                        xmlns="http://www.w3.org/2000/svg"
                        fill="none"
                        viewBox="0 0 25 25"
                        strokeWidth={1.5}
                        stroke="currentColor"
                        className="w-6 h-6 text-rojo1"
                    >
                        <path
                        strokeLinecap="round"
                        strokeLinejoin="round"
                        d="M2.25 6.75c0 8.284 6.716 15 15 15h2.25a2.25 2.25 0 002.25-2.25v-1.372c0-.516-.351-.966-.852-1.091l-4.423-1.106c-.44-.11-.902.055-1.173.417l-.97 1.293c-.282.376-.769.542-1.21.38a12.035 12.035 0 01-7.143-7.143c-.162-.441.004-.928.38-1.21l1.293-.97c.363-.271.527-.734.417-1.173L6.963 3.102a1.125 1.125 0 00-1.091-.852H4.5A2.25 2.25 0 002.25 4.5v2.25z"
                        />
                    </svg>

                    <input
                        className="pl-2 outline-none border-none bg-gris3 text-black"
                        type="number"
                        name="phone"
                        id="phone"
                        placeholder="Edad"
                        value={age}
                        onChange={onChangeAge}
                        required
                    />
                    </div>
                    
                    <div className="flex items-center border-2 py-2 px-3 rounded-2xl mb-4">
                    <svg
                        xmlns="http://www.w3.org/2000/svg"
                        fill="none"
                        viewBox="0 0 24 24"
                        strokeWidth={1.5}
                        stroke="currentColor"
                        className="w-6 h-6 text-rojo1"
                    >
                        <path
                        strokeLinecap="round"
                        strokeLinejoin="round"
                        d="M16.5 10.5V6.75a4.5 4.5 0 10-9 0v3.75m-.75 11.25h10.5a2.25 2.25 0 002.25-2.25v-6.75a2.25 2.25 0 00-2.25-2.25H6.75a2.25 2.25 0 00-2.25 2.25v6.75a2.25 2.25 0 002.25 2.25z"
                        />
                    </svg>

                    <input
                        className="pl-2 outline-none border-none bg-gris3 text-black"
                        type="password"
                        name="password"
                        id="password"
                        placeholder="Contraseña"
                        value={password}
                        onChange={onChangePassword}
                        required
                    />
                    </div>
                    <button
                    type="submit"
                    className="block w-full bg-red-600 mt-4 py-2 rounded-2xl text-black font-semibold mb-2 hover:bg-red-900 transition duration-300 ease-in-out"
                    onClick={CrearUser}
                    >
                    Registrar
                    </button>
                    <p className="mt-6 text-xs text-black text-center">
                    También puedes{" "}
                    <Link
                        to="/"
                        className="border-b border-rojo1 border-dotted text-red-500 hover:text-red-800 transition-all duration-300 ease-in-out hover:cursor-pointer"
                    >
                        Iniciar Sesión
                    </Link>
                    </p>
                </form>
                </div>
            </div>
        </div>
    );
}

export default Registro;