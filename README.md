Añadiendo el README.md al repositorio https://github.com/ojosdegato/cine.git
Creación rama ojosdegato

TAREAS DEL PROYECTO CARTELERA DE CINE

Tareas que vamos a implementar en el proyecto:

   •	Película (Javier Cachón)
*   Long id
*   String título
*   String género
*   int duración
*   int clasificación por edad
*   String Sinopsis
*   String tráiler de cada película

    •	Proyección (Marcos)
*    Long id
*    LocaDateTime día_hora
*    Sala sala (OnetoMany) 
*    Boolean asignada

   •	Actor (Iñigo)
*   Long id
*   String nombre
*   String apellido
*   LocalDateTime fecha_nac
*   String nacionalidad

      •	 PeliculaActor (Iñigo)
*    Long idPelicula
*    Long idActor
*    UserRole rol

   •	Ticket (David)
*   Long id
*   Int aforo de la sala
*   Int asientos ocupados
*	Double Precio de la entrada

Hacer entidades y repositorio, controladores, servicios y HTMLs.

Utilizamos la base de datos H2

Implementar inicio.html con logo para enlazar todos los html del proyecto y pagina error.html (Javier Cachón)

Tareas que tenemos dudas en implementar:

•	Métodos de pago (tarjeta, PayPal, efectivo).
•	Posibilidad de ver la película en el cine o ver la película en tu casa.
Tareas por si queda tiempo.
•	Actores y director de la película.
•	Confirmación de compra (correo electrónico con código QR).
•	Sistema de reseñas y valoraciones de películas



Tareas que no pensamos implementar:
•	Control de ingresos (ventas diarias, estadísticas de ocupación).
•	Selección de asientos (mapa interactivo de la sala)
•	Gestión de empleados (turnos, funciones, permisos).
•	Historial de compras para usuarios registrados.
•	Gestión de salas (capacidad, tipo de proyección: 2D, 3D, IMAX).


Como preguntar a IA
•	Contexto: Se precisa una aplicación de reservas que necesita generar códigos QR para que los usuarios puedan acceder a sus tickets digitales.
•	Rol: Desarrollador web.
•	Tarea: obtener información sobre librerías de Java para la creación de códigos QR.
•	Resultado: Generador de codigo QR, ejemplos y recomendaciones de implementación

HERRAMIENTAS

•	Chat GPT
•	Gemini: https://gemini.google.com/
•	Claude: https://claude.ai/new

Para programar código con IA
•	Cursor: https://www.cursor.com/downloads

Crea aplicaciones
•	Lobable:  https://lovable.dev/
•	Bold.new:  https://bolt.new/

https://www.blackbox.ai/  (Facilita la programación mediante comandos de voz.)
