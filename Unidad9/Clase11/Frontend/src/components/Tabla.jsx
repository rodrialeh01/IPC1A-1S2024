import Swal from 'sweetalert2';
import Service from "../Service/Service";
const Tabla = ({ usuarios }) => {

    const verUsuario = (username) => {
        Service.getUsuario(username)
        .then(response => {
            console.log(response);
            Swal.fire({
                title: response.usuario.username,
                text: `Nombre: ${response.usuario.nombre} Edad: ${response.usuario.edad}`,
                icon: "info"
            });
        })
        .catch(error => {
            console.log(error);
        });
    }

    const eliminarUsuario = (username) => {
        Service.eliminarUsuario(username)
        .then(response => {
            console.log(response);
            alert(response.mensaje);
            window.location.reload();
        })
        .catch(error => {
            console.log(error);
        });
    }
    return(
        <div>
            <table className="table min-w-full divide-y divide-gray-200">
                <thead>
                    <tr>
                        <th scope="col px-6 py-3 bg-gray-50 text-left text-xs leading-4 font-medium text-gray-500 uppercase tracking-wider">No.</th>
                        <th scope="col px-6 py-3 bg-gray-50 text-left text-xs leading-4 font-medium text-gray-500 uppercase tracking-wider">Nombre</th>
                        <th scope="col px-6 py-3 bg-gray-50 text-left text-xs leading-4 font-medium text-gray-500 uppercase tracking-wider">Edad</th>
                        <th scope="col px-6 py-3 bg-gray-50 text-left text-xs leading-4 font-medium text-gray-500 uppercase tracking-wider">Nombre de Usuario</th>
                        <th scope="col px-6 py-3 bg-gray-50 text-left text-xs leading-4 font-medium text-gray-500 uppercase tracking-wider">Acciones</th>
                    </tr>
                </thead>
                <tbody className="bg-white divide-y divide-gray-200">
                    {
                    usuarios.map((usuario, key) => (
                        <tr key={key}>
                            <td className="px-6 py-4 whitespace-no-wrap text-center">{key + 1}</td>
                            <td className="px-6 py-4 whitespace-no-wrap text-center">{usuario.nombre}</td>
                            <td className="px-6 py-4 whitespace-no-wrap text-center">{usuario.edad}</td>
                            <td className="px-6 py-4 whitespace-no-wrap text-center">{usuario.username}</td>
                            <td className="px-6 py-4 whitespace-no-wrap text-center">
                                <button className="bg-green-500 p-3 rounded-lg text-white font-bold m-2" onClick={() => verUsuario(usuario.username)}>Ver</button>
                                <button className="bg-red-500 p-3 rounded-lg text-white font-bold m-2" onClick={() => eliminarUsuario(usuario.username)}>Eliminar</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default Tabla;