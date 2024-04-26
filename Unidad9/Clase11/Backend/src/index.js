import cors from 'cors';
import express from 'express';
import morgan from 'morgan';
import handlePost from './routers/post.routes.js';
import handleUser from './routers/user.routes.js';


const app = express();

app.use(express.json({limit: '50mb'}));
app.use(express.urlencoded({ limit: '50mb', extended:true}));
app.use(morgan('dev'));
app.use(cors());


app.use('/user',handleUser);
app.use('/post',handlePost);

app.listen(3000);

console.log('Servidor levantado en el lugar: http://localhost:3000');