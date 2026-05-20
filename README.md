# Integración de Base de Datos y TableView (Ejercicio 23)

Este proyecto representa la culminación del aprendizaje al integrar una base de datos relacional Oracle con una interfaz gráfica avanzada, permitiendo la visualización de registros en tiempo real mediante un control `TableView`.

## 🚀 Funcionalidades
* **Visualización de Datos Complejos:** Utiliza `TableView` para mostrar información estructurada en columnas y filas.
* **Mapeo de Datos (ORM Básico):** Implementa una clase interna `Artista` para transformar los registros de la base de datos en objetos Java procesables por la interfaz.
* **Conexión JDBC en Tiempo Real:** Realiza una consulta `SELECT` al arrancar la aplicación para poblar la tabla automáticamente desde Oracle.
* **Vinculación de Propiedades:** Emplea `PropertyValueFactory` para conectar automáticamente los atributos del objeto `Artista` con las columnas visuales de la tabla.

## 🛠️ Estructura técnica
El código demuestra el flujo completo de una aplicación orientada a datos:
* **`TableView<Artista>`**: Control genérico que gestiona la presentación de colecciones de objetos.
* **`CellValueFactory`**: Mecanismo que indica a JavaFX qué método "getter" debe llamar para rellenar cada celda de la columna.
* **Arquitectura de Carga**: El método `cargarDatos()` separa la lógica de negocio (acceso a DB) de la lógica de presentación, siguiendo principios de diseño limpio.
* **Gestión de Recursos JDBC**: Utiliza la estructura *try-with-resources* para asegurar el cierre de conexiones, sentencias y conjuntos de resultados, incluso si ocurren errores de red.



## 📋 Requisitos del Modelo
Para que el `TableView` funcione correctamente, la clase de datos (`Artista`) debe cumplir con:
1. Atributos privados.
2. Constructor para inicialización.
3. Métodos **Getter** que sigan la convención de nombres de Java (ej. `getNombre` para la propiedad `nombre`).