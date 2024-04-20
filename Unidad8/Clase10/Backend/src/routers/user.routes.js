import { Router } from "express";
import { actualizarUsuario, crearUsuario, eliminarUsuario, getUsuario, login, verUsuarios } from '../controllers/user.controller.js';

const router = Router();

router.post('/crear',crearUsuario);
router.get('/ver', verUsuarios);
router.put('/editar', actualizarUsuario);
router.delete('/eliminar/:username', eliminarUsuario)
router.post('/login', login)
router.get('/getUsuario/:username', getUsuario)

export default router;