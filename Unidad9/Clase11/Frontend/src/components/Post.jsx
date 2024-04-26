import { useState } from "react";
import { AiFillLike, AiOutlineLike, AiOutlineMessage } from "react-icons/ai";
import Tiempo from "../components/Tiempo";
import { useUser } from '../context/User';
const Post = ({ post }) => {
    const [imagen, setImagen] = useState(post.imagen);
    const { user, actualizarUsuario } = useUser();
    const [like, setLike] = useState(false);

    const darLike = () => {
        if(like === true){
            //llamo a mi endpoint de dislike
        }else{
            //llamo a mi endpoint de like
        }
        setLike(!like);
    }

    return (
        <div className="mx-auto lg:mx-4 w-full">
            <div className="p-5 bg-gray-200 mt-5 rounded-t-2xl shadow-xl">
                <div className="flex items-center space-x-2">
                    <div>
                        <p>{post.usuario}</p>
                        <p className="text-xs text-gray-400">
                            <Tiempo fecha={post.fecha} />
                        </p>
                    </div>
                </div>

                <p className="pt-4">{post.descripcion}</p>
            </div>

            {imagen && (
                <div className="relative bg-gray-200">
                    <img src={imagen} alt="Imagen" className="object-contain w-full h-auto lg:h-64 xl:h-80" />
                </div>
            )}

            {/*Footer*/}
            <div className="flex justify-between items-center rounded-b-2xl bg-white shadow-md text-gray-400 border-t">
                <div 
                className="flex items-center justify-center space-x-2 p-3 hover:bg-gray-300 hover:cursor-pointer flex-grow"
                onClick={darLike}
                >
                    {like? <AiFillLike className="h-4 rounded-none" /> : <AiOutlineLike className="h-4 rounded-none" />}
                    <p className="text-xs sm:text-base">Me gusta</p>
                </div>
                <div className="h-full border-l border-gray-300"></div> {/* Línea divisoria */}
                <div className="flex items-center justify-center space-x-2 p-3 hover:bg-gray-300 hover:cursor-pointer flex-grow">
                    <AiOutlineMessage className="h-4 rounded-none" />
                    <p className="text-xs sm:text-base">Comentarios</p>
                </div>
            </div>
        </div>
    );
}

export default Post;