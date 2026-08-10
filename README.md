## Instalación

El proyecto utiliza contenedores Docker para aislar el entorno del backend y Vite para el servidor de desarrollo del frontend. Para proteger las credenciales, el repositorio implementa plantillas `.env.example` que deben ser copiadas localmente.

### Requisitos Previos

- **Docker** y **Docker Compose** instalados.

### Pasos de Ejecución

**1. Configurar las variables de entorno**
El proyecto requiere tres archivos de configuración. Posicionado en la raíz, ejecuta los siguientes comandos para generar las versiones locales a partir de las plantillas:

```bash
# Entorno de infraestructura (Docker)
cp .env.example .env

```

**2. Crear el volumen persistente de la base de datos**
El sistema requiere la creación de un volumen externo para garantizar la persistencia de los datos del mercado y los usuarios:

```bash
docker volume create movie-app
```

**3. Iniciar la infraestructura**
Ejecuta el siguiente comando en la raíz del proyecto para construir las imágenes y levantar el stack completo (Frontend, API, Base de Datos y phpMyAdmin):

```Bash
docker compose up -d
```

Para detener la aplicación y apagar los contenedores, ejecuta `docker-compose down` desde la misma ubicación.
Para eliminar el volumen persistente de la base de datos, ejecuta `docker volume rm movie-app`.

🌐 Acceso a los Servicios
Una vez que los contenedores reporten estar en ejecución, los servicios estarán disponibles en los siguientes puertos locales:

Movie App (Frontend UI): http://localhost:5173

API REST (Backend): http://localhost:8000

Administrador de Base de Datos (phpMyAdmin): http://localhost:8080
