import { Router } from "express";
import { crearPublicacion, getPublicaciones } from '../controllers/post.controller.js';

const router = Router();

router.post('/crear',crearPublicacion);
router.get('/ver', getPublicaciones);

export default router;