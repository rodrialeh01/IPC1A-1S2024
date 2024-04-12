# NodeJS

## Introducción

En esta unidad se abordarán los temas de programación web, en específico se verá el entorno de ejecución de JavaScript NodeJS. Este readme esta dedicado a mostrar un poco de NodeJS.

## Instalación

Para instalar NodeJS es necesario que vayas a la página oficial de NodeJS y descargues el instalador de acuerdo a tu sistema operativo. [NodeJS](https://nodejs.org/en/download/)

## Iniciar un proyecto

Para iniciar un proyecto en NodeJS es necesario que abras una terminal y te dirijas a la carpeta donde deseas crear tu proyecto y ejecutes el siguiente comando:

```bash
npm init
```

Este comando te hará una serie de preguntas para configurar tu proyecto, al final te creará un archivo llamado `package.json` que es donde se guardan las configuraciones de tu proyecto.

## Instalar dependencias

Para instalar dependencias en NodeJS es necesario que abras una terminal y te dirijas a la carpeta donde tienes tu proyecto y ejecutes el siguiente comando:

```bash
npm install nombreDependencia
```

Puedes encontrar dependencias en el siguiente [enlace](https://www.npmjs.com/)

## Ejecutar un archivo

Para ejecutar un archivo en NodeJS es necesario que abras una terminal y te dirijas a la carpeta donde tienes tu archivo y ejecutes el siguiente comando:

```bash
node nombreArchivo.js
```

## Scripts

Puedes agregar scripts en tu archivo `package.json` de la siguiente manera:

```json
{
    "scripts": {
        "nombreScript": "comando"
    }
}
```

Un ejemplo es:

```json
{
    "scripts": {
        "start": "node index.js"
    }
}
```

Para ejecutar el script es necesario que abras una terminal y te dirijas a la carpeta donde tienes tu archivo y ejecutes el siguiente comando:

```bash
npm run nombreScript
```