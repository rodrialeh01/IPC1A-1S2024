import React, { useRef, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import SideBar from '../../components/Sidebar';
const CrearPublicacion = () => {

    const [isDragging, setIsDragging] = useState(false);
    const [infoImage, setInfoImage] = useState('Arrastra aquí');
    const [previewImage, setPreviewImage] = useState(null);
    const [image, setImage] = useState(null);
    const [name, setName] = useState('');
    const [description, setDescription] = useState('');
    const navigate = useNavigate();
    const squareRef = useRef();

    const handleDragStart = (e) => {
        e.preventDefault();
        setIsDragging(true);
    };

    const handleDragEnd = () => {
        setIsDragging(false);
    };

    const handleFileUpload = (e) => {
        const files = e.target.files;
        const reader = new FileReader();
        reader.onload = () => {
            setInfoImage(files[0].name);
            setPreviewImage(image);
            console.log(reader.result);
            setImage(reader.result);
        }

        if(files){
            reader.readAsDataURL(files[0]);
        }
    };
    const handleDrop = (e) => {
        e.preventDefault();
        setIsDragging(false);

        const files = e.dataTransfer.files;
        const reader = new FileReader();

        reader.onload = () => {
            setInfoImage(files[0].name);
            setPreviewImage(image);
            console.log(reader.result);
            setImage(reader.result);
        }

        if(files){
            reader.readAsDataURL(files[0]);
        }
    };

    const handleDescription = (e) => {
        setDescription(e.target.value);
        console.log(description)
    };

    const handleSubmit = (e) =>{
		e.preventDefault();
	}

    return (
        <div className="flex justify-center bg-gray-300">
            <div className="hidden lg:block w-64">
                <SideBar/>
            </div>
            <div className="flex-grow h-screen overflow-y-scroll scrollbar-hide ">
                <div className=" mb-24">
                    <div className="relative w-full flex flex-col">
                        <div className="w-full h-40 bg-gradient-to-1 from-transparent sm:h-48"></div>
                        <div className="absolute inset-0 flex items-center">
                            <div className="ml-7 mt-20">
                                <h1 className="font-bold sm:text-4xl text-2xl text-black">
                                    Crea tu Publicación
                                </h1>
                            </div>
                        </div>
                    </div>
                    <form className="w-full max-w-lg ml-20 mt-12" onSubmit={handleSubmit}>
                        <div className="flex flex-wrap -mx-3 mb-6">
                            <div className="w-full px-3">
                                <label className="block uppercase tracking-wide text-black text-xs font-bold mb-2" >
                                    Describe lo que publicarás
                                </label>
                                <textarea className="resize-none rounded-md h-20 w-full bg-gray-200 text-gray-700 border border-lightPurple py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white focus:border-lightPurple" id="grid-password" placeholder="Descripción de tu plublicación" onChange={handleDescription} value={description}></textarea>
                            </div>
                        </div>
                        <div className="flex flex-wrap -mx-3 mb-6">
                            <div className="w-full px-3">
                                <label className="block uppercase tracking-wide text-black text-xs font-bold mb-2" htmlFor="grid-image">
                                    Cargar Imagen
                                </label>
                                <input type="file" accept="image/*" className="hidden" id="grid-image" onChange={handleFileUpload} />
                                <label htmlFor="grid-image" className={`cursor-pointer w-40 h-40 bg-lightPurple border-white border-2 block relative ${isDragging ? "opacity-50" : ""}`} onDragOver={handleDragStart} onDragLeave={handleDragEnd} onDrop={handleDrop} ref={squareRef}>
                                    <span className="absolute inset-0 flex items-center justify-center text-black text-sm">{infoImage}</span>
                                </label>
                                <label className="block uppercase tracking-wide text-black text-xs font-bold mb-2 mt-3" htmlFor="grid-image">
                                    {previewImage && "Vista Previa"}
                                </label>
                                {previewImage && <img src={previewImage} alt="Vista previa de la imagen" className="mt-4" style={{ width: "100px", height: "100px" }} />}
                            </div>
                        </div>
                        <button className="bg-red-500 text-black hover:bg-black hover:text-white font-bold py-2 px-4 rounded" onClick={null}>
                            Crear Publicación
                        </button>
                    </form>
                </div>
            </div>
        </div>
    )
}

export default CrearPublicacion;