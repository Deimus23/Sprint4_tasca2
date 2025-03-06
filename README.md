# S04T02N01 - Gestión de Frutas con Spring Boot

Este proyecto es una aplicación desarrollada con **Spring Boot** que permite gestionar una colección de frutas mediante una API REST.

## 📌 Tecnologías utilizadas

- Java 23
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database (o cualquier otra base de datos que prefieras)
- Lombok (opcional, para reducir código boilerplate)

## 📂 Estructura del proyecto

```
├───src
│   ├───main
│   │   ├───java
│   │   │   └───cat.itacademy.s04.t02.n01
│   │   │       ├───controller       # Controladores REST
│   │   │       ├───exception         # Manejadores de excepciones
│   │   │       ├───model             # Clases de modelo (entidades)
│   │   │       ├───repository        # Interfaces de repositorio
│   │   │       ├───services          # Lógica de negocio
│   │   │       └───S04T02N01Application.java  # Clase principal
│   │   ├───resources
│   │   │   ├───application.properties  # Configuración
│   │   │   ├───static                  # Archivos estáticos
│   │   │   └───templates               # Plantillas Thymeleaf (si aplica)
```

## 🚀 Cómo ejecutar el proyecto

1. Clona el repositorio:
   ```sh
   git clone <URL_DEL_REPOSITORIO>
   ```
2. Accede al directorio del proyecto:
   ```sh
   cd S04T02N01
   ```
3. Compila y ejecuta la aplicación con Maven o Gradle:
   ```sh
   ./mvnw spring-boot:run   # Si usas Maven
   ./gradlew bootRun        # Si usas Gradle
   ```
4. La aplicación estará disponible en:
   ```
   http://localhost:8080
   ```

## 🛠 Endpoints principales

| Método | Endpoint         | Descripción |
|--------|----------------|-------------|
| GET    | `/fruits`      | Obtener todas las frutas |
| GET    | `/fruits/{id}` | Obtener una fruta por ID |
| POST   | `/fruits`      | Agregar una nueva fruta |
| PUT    | `/fruits/{id}` | Actualizar una fruta |
| DELETE | `/fruits/{id}` | Eliminar una fruta |

## 📌 Manejo de Excepciones

La aplicación maneja errores personalizados, como `FruitNotFoundException`, a través de la clase `GlobalExceptionHandler`.

## 📄 Licencia

Este proyecto está bajo la licencia MIT. Puedes usarlo y modificarlo libremente.

---

¡Si tienes preguntas o mejoras, no dudes en contribuir! 🚀

