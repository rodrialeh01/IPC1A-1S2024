import { Router } from "express";
import { actualizarUsuario, crearUsuario, eliminarUsuario, getHome, verUsuarios } from '../controllers/data.controllers.js';

const router = Router();

router.get('/', getHome);
router.post('/crear',crearUsuario);
router.get('/ver', verUsuarios);
router.put('/editar', actualizarUsuario);
router.delete('/eliminar/:username', eliminarUsuario)

export default router;