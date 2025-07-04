# BiblioFinder 📚

BiblioFinder es una aplicación de línea de comandos desarrollada en Java con Spring Boot, orientada a la exploración y gestión de libros y autores utilizando la API pública de [Gutendex](https://gutendex.com/books/). Permite buscar libros, registrar autores, consultar historial de búsquedas y filtrar autores por año de nacimiento, todo desde una interfaz sencilla y poderosa.

---

## Características principales

- 🔍 **Búsqueda de libros por nombre:**  
  Ingresa el título de un libro y explora los resultados obtenidos desde la API de Gutendex. Selecciona el libro deseado para almacenarlo en tu base de datos local, junto con su información de autor.

- 🕑 **Historial de libros buscados:**  
  Accede rápidamente al listado de todos los libros que has consultado y guardado durante tu sesión.

- 👤 **Gestión de autores registrados:**  
  Consulta la lista completa de autores almacenados en tu base de datos, creada dinámicamente a partir de tus búsquedas.

- 🗓️ **Búsqueda de autores por año:**  
  Filtra y visualiza los autores registrados de acuerdo a su año de nacimiento.

- 🌐 **(Próximamente) Filtrado de libros por idioma:**  
  La interfaz ya contempla esta opción para futuras ampliaciones.

---

## Menú de opciones

Al iniciar la aplicación, tendrás acceso al siguiente menú interactivo:

1. **Buscar libro por su nombre**
2. **Historial de libros buscados**
3. **Autores registrados**
4. **Buscar autores registrados por un año determinado**
5. **Libros por idioma** *(en desarrollo)*
6. **Salir*

---

## Tecnologías utilizadas

- Java 17+
- Spring Boot
- JPA / Hibernate (persistencia de datos)
- API Gutendex (libros de dominio público)
- Maven

---

## Instalación y ejecución

1. **Clona el repositorio:**
    ```bash
    git clone https://github.com/YmidOrtega/LiterAlura.git
    cd LiterAlura
    ```

2. **Configuración de la base de datos:**  
    Modifica las propiedades de conexión en `src/main/resources/application.properties` según tu entorno.

3. **Compila y ejecuta el proyecto:**
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

4. **¡Listo!**  
    Interactúa con el menú desde la terminal.

---

## Estructura del proyecto

```
literatura/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/aluracursos/challenge/literatura/
│       │       ├── principal/   # Lógica de menú y flujo principal
│       │       ├── models/      # Modelos de dominio (Libro, Autor, etc.)
│       │       ├── repository/  # Interfaces de persistencia
│       │       └── services/    # Servicios de consumo API y conversión
└── README.md
```

---

## Créditos

Proyecto desarrollado para el Challenge de Alura Latam.

Autor: Ymid Ortega  
API utilizada: [Gutendex](https://gutendex.com/books/)

---

¡Explora, aprende y redescubre la literatura con **BiblioFinder**!
