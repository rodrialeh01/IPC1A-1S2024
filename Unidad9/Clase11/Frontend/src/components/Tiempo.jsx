import { format, formatDistanceToNow } from 'date-fns';
import { es } from 'date-fns/locale';
import { useState } from 'react';

const Tiempo = ({ fecha }) => {
    const [mostrarTiempo, setMostrarTiempo] = useState(false);

    const fechaFormateada = format(new Date(fecha), 'dd/MM/yyyy HH:mm:ss', { locale: es });

    const tiempoTranscurrido = formatDistanceToNow(new Date(fecha), { addSuffix: true, locale: es, includeSeconds: true });
    const textoFormateado = tiempoTranscurrido.replace('en alrededor de', 'hace');

    return (
        <span
            onMouseEnter={() => setMostrarTiempo(true)}
            onMouseLeave={() => setMostrarTiempo(false)}
        >
            {mostrarTiempo ? fechaFormateada : textoFormateado}
        </span>
    );
};

export default Tiempo;