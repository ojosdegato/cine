-- Crear la tabla de películas de la entidad Pelicula por Javier Cachón.
CREATE TABLE IF NOT EXISTS peliculas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    genero VARCHAR(255) NOT NULL,
    duracion INT NOT NULL,
    clasificacion_edad INT NOT NULL,
    sinopsis TEXT,
    trailer VARCHAR(255)
);

-- Insertar las películas de la entidad Pelicula por Javier Cachón.
INSERT INTO peliculas (titulo, genero, duracion, clasificacion_edad, sinopsis, trailer) VALUES
('El señor de los anillos', 'Aventura', 120, 12, 'Aventura y ficción', 'https://youtube.com/ver_trailer1'),
('Troya', 'Historia', 130, 16, 'Aventura histórica con batallas épicas', 'https://youtube.com/ver_trailer2'),
('Gladiador', 'Acción', 150, 18, 'Un general romano busca venganza', 'https://youtube.com/ver_trailer3'),
('Piratas del Caribe', 'Aventura', 145, 12, 'Un pirata busca el tesoro perdido', 'https://youtube.com/ver_trailer4'),
('El origen', 'Ciencia Ficción', 148, 16, 'Un ladrón experto en robar secretos viaja en el sueño', 'https://youtube.com/ver_trailer5'),
('The Matrix', 'Ciencia Ficción', 136, 18, 'Un hacker descubre la verdad detrás de la realidad virtual', 'https://youtube.com/ver_trailer6'),
('El caballero oscuro', 'Acción', 152, 16, 'Batman enfrenta al Joker, el villano más peligroso', 'https://youtube.com/ver_trailer7'),
('Forrest Gump', 'Drama', 142, 12, 'La vida de un hombre con una inteligencia limitada, pero una gran suerte', 'https://youtube.com/ver_trailer8'),
('El rey león', 'Animación', 88, 0, 'Un joven león aprende a enfrentar su destino', 'https://youtube.com/ver_trailer9'),
('Vengadores: Endgame', 'Acción', 181, 12, 'Los héroes más poderosos del mundo luchan para salvar al universo', 'https://youtube.com/ver_trailer10'),
('Grease', 'Romance', 110, 12, 'Historia de amor entre Danny y Sandy en los años 50', 'https://youtube.com/ver_grease'),
('El Padrino', 'Crimen', 175, 18, 'El ascenso de la familia Corleone en el mundo del crimen', 'https://youtube.com/ver_el_padrino'),
('Titanic', 'Romance', 195, 12, 'Amor entre Jack y Rose a bordo del Titanic', 'https://youtube.com/ver_titanic'),
('Toy Story', 'Animación', 81, 0, 'Los juguetes cobran vida cuando los humanos no están', 'https://youtube.com/ver_toystory'),
('La lista de Schindler', 'Historia', 195, 16, 'Un empresario salva a judíos durante el Holocausto', 'https://youtube.com/ver_schindler'),
('El exorcista', 'Terror', 122, 18, 'Una niña es poseída por una entidad demoníaca', 'https://youtube.com/ver_exorcista'),
('La La Land', 'Musical', 128, 12, 'Una historia de amor y sueños en Los Ángeles', 'https://youtube.com/ver_lalaland'),
('Salvar al soldado Ryan', 'Bélica', 169, 16, 'Una misión de rescate en plena Segunda Guerra Mundial', 'https://youtube.com/ver_ryan'),
('Joker', 'Drama', 122, 18, 'La transformación de Arthur Fleck en el Joker', 'https://youtube.com/ver_joker'),
('Amélie', 'Comedia romántica', 122, 7, 'Una joven parisina decide cambiar la vida de los demás', 'https://youtube.com/ver_amelie');
-- fin tablas Peliculas.

CREATE TABLE IF NOT EXISTS salas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    aforo_maximo INT NOT NULL,
    asientos_disponibles INT NOT NULL,
    tipo_sala VARCHAR(50) NOT NULL
);

-- Datos de ejemplo
INSERT INTO salas (nombre, aforo_maximo, asientos_disponibles, tipo_sala) VALUES
('Sala 1', 120, 120, '3D'),
('Sala 2', 100, 98, 'NORMAL'),
('Sala 3', 80, 75, 'IMAX'),
('Sala 4', 60, 60, 'VIP'),
('Sala 5', 90, 85, 'NORMAL');

CREATE TABLE IF NOT EXISTS proyecciones (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha_hora DATETIME NOT NULL,
    sala_id BIGINT,
    pelicula_id BIGINT,
    FOREIGN KEY (sala_id) REFERENCES salas(id),
    FOREIGN KEY (pelicula_id) REFERENCES peliculas(id)
);

-- Datos de ejemplo
INSERT INTO proyecciones (fecha_hora, sala_id, pelicula_id) VALUES
('2025-06-20 18:00:00', 1, 1),  -- El señor de los anillos
('2025-06-21 20:00:00', 2, 2),  -- Troya
('2025-06-22 16:30:00', 3, 3),  -- Gladiador
('2025-06-23 19:15:00', 1, 4),  -- Piratas del Caribe
('2025-06-24 21:00:00', 4, 5),  -- El origen
('2025-06-25 22:00:00', 5, 6),  -- The Matrix
('2025-06-26 18:45:00', 2, 7),  -- El caballero oscuro
('2025-06-27 20:30:00', 3, 8),  -- Forrest Gump
('2025-06-28 17:00:00', 4, 9),  -- El rey león
('2025-06-29 19:45:00', 5, 10); -- Vengadores: Endgame

-- Crear la tabla de usuarios de la entidad Usuario por David Jiménez.
CREATE TABLE IF NOT EXISTS usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellidos VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    rol ENUM('ADMIN', 'USUARIO') DEFAULT 'USUARIO',
    activo BOOLEAN DEFAULT true
);

-- Insertar los usuarios de la entidad Usuario por David Jiménez.
INSERT INTO usuarios (nombre, apellidos, email, password, rol, activo) VALUES
('Admin', 'Sistema', 'admin@cine.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'ADMIN', true),
('María', 'García López', 'maria@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', true),
('Juan', 'Pérez Martínez', 'juan@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', true),
('Ana', 'Rodríguez Sánchez', 'ana@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', true),
('Carlos', 'Martín Ruiz', 'carlos@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', false),
('Mario', 'Fernández Gómez', 'fernandez@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', false),
('Lucía', 'Santos Díaz', 'lucia@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', true),
('Pedro', 'López Torres', 'pedro@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', false),
('Sofía', 'Ramírez Gil', 'sofia@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', true),
('Miguel', 'Navarro Peña', 'miguel@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', true),
('Elena', 'Vega Romero', 'elena@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', false),
('Patricia', 'Moreno Díaz', 'patricia@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', true),
('Alberto', 'Serrano López', 'alberto@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', false),
('Raquel', 'Castro Jiménez', 'raquel@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', true),
('Laura', 'Gómez Ruiz', 'laura@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', true),
('Javier', 'Sánchez León', 'javier@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', false),
('Marta', 'Ortega Pérez', 'marta@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', true),
('David', 'Cabrera Soto', 'david@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', false),
('Cristina', 'Luna Ramos', 'cristina@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', true),
('Rubén', 'Molina Vera', 'ruben@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', false),
('Isabel', 'Pérez Fernández', 'isabel@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', false);
-- fin tablas Usuarios.

-- Crear la tabla de reservas de la entidad Reserva por David Jiménez.
CREATE TABLE IF NOT EXISTS reservas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario_id BIGINT NOT NULL,
    proyeccion_id BIGINT NOT NULL,
    numero_asiento VARCHAR(10) NOT NULL,
    metodo_pago ENUM('TARJETA', 'EFECTIVO') NOT NULL,
    estado_reserva ENUM('PENDIENTE', 'CONFIRMADA', 'CANCELADA') NOT NULL,
    tipo_entrada ENUM('NORMAL', 'DIA_ESPECTADOR') NOT NULL,
    fecha_reserva DATETIME NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (proyeccion_id) REFERENCES proyecciones(id)
);

-- Insertar las reservas de la entidad Reserva por David Jiménez.
INSERT INTO reservas (usuario_id, proyeccion_id, numero_asiento, metodo_pago, estado_reserva, tipo_entrada, fecha_reserva) VALUES
(2, 1, 'A1', 'TARJETA', 'CONFIRMADA', 'NORMAL', '2025-06-17 10:00:00'),
(2, 2, 'B3', 'EFECTIVO', 'PENDIENTE', 'NORMAL', '2025-06-17 11:30:00'),
(3, 1, 'C4', 'TARJETA', 'CONFIRMADA', 'DIA_ESPECTADOR', '2025-06-18 09:15:00'),
(4, 3, 'D5', 'TARJETA', 'CANCELADA', 'NORMAL', '2025-06-19 14:20:00'),
(3, 4, 'E2', 'EFECTIVO', 'CONFIRMADA', 'NORMAL', '2025-06-20 16:45:00'),
(2, 5, 'F7', 'TARJETA', 'PENDIENTE', 'DIA_ESPECTADOR', '2025-06-25 18:30:00'),
(1, 6, 'G6', 'TARJETA', 'CONFIRMADA', 'DIA_ESPECTADOR', '2025-06-25 15:00:00'),
(2, 6, 'G8', 'TARJETA', 'CONFIRMADA', 'NORMAL', '2025-06-21 20:00:00'),
(4, 7, 'H9', 'EFECTIVO', 'CANCELADA', 'NORMAL', '2025-06-22 19:30:00'),
(5, 8, 'I10', 'TARJETA', 'PENDIENTE', 'DIA_ESPECTADOR', '2025-07-02 21:15:00'),
(1, 9, 'J11', 'TARJETA', 'CONFIRMADA', 'NORMAL', '2025-07-05 22:00:00'),
(4, 10, 'K12', 'TARJETA', 'CONFIRMADA', 'NORMAL', '2025-07-06 12:00:00'),
(6, 11, 'L13', 'EFECTIVO', 'PENDIENTE', 'DIA_ESPECTADOR', '2025-07-09 13:30:00'),
(7, 12, 'M14', 'TARJETA', 'CONFIRMADA', 'NORMAL', '2025-07-08 15:45:00'),
(8, 13, 'N15', 'TARJETA', 'CANCELADA', 'NORMAL', '2025-07-08 17:20:00'),
(9, 14, 'O16', 'EFECTIVO', 'CONFIRMADA', 'DIA_ESPECTADOR', '2025-07-10 19:00:00'),
(10, 15, 'P17', 'TARJETA', 'PENDIENTE', 'NORMAL', '2025-07-11 20:30:00'),
(11, 16, 'Q18', 'TARJETA', 'CONFIRMADA', 'DIA_ESPECTADOR', '2025-07-16 21:45:00')
(12, 17, 'R19', 'EFECTIVO', 'CANCELADA', 'NORMAL', '2025-07-17 22:15:00'),
(13, 18, 'S20', 'TARJETA', 'CONFIRMADA', 'DIA_ESPECTADOR', '2025-07-18 23:00:00'),
(14, 19, 'T21', 'TARJETA', 'PENDIENTE', 'NORMAL', '2025-07-20 10:30:00');
-- fin tablas Reservas.


-- TABLA Actor
-- Crear la tabla de actores de la entidad Actor por Javier Iñigo.
CREATE TABLE IF NOT EXISTS actores (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    fecha_nac DATETIME NOT NULL, -- Se usa DATETIME para LocalDateTime en SQL
    nacionalidad VARCHAR(255) NOT NULL
);

-- Insertar los actores de la entidad Actor por Javier Iñigo.
INSERT INTO actores (nombre, apellido, fecha_nac, nacionalidad) VALUES
('Tom', 'Hanks', '1956-07-09 00:00:00', 'Estadounidense'),
('Brad', 'Pitt', '1963-12-18 00:00:00', 'Estadounidense'),
('Angelina', 'Jolie', '1975-06-04 00:00:00', 'Estadounidense'),
('Leonardo', 'DiCaprio', '1974-11-11 00:00:00', 'Estadounidense'),
('Meryl', 'Streep', '1949-06-22 00:00:00', 'Estadounidense'),
('Javier', 'Bardem', '1969-03-01 00:00:00', 'Español'),
('Penélope', 'Cruz', '1974-04-28 00:00:00', 'Española'),
('Antonio', 'Banderas', '1960-08-10 00:00:00', 'Español'),
('Emma', 'Watson', '1990-04-15 00:00:00', 'Británica'),
('Dwayne', 'Johnson', '1972-05-02 00:00:00', 'Estadounidense');
-- fin tablas Actores.

-- TABLA PeliculaActor
-- Crear la tabla de relación Pelicula-Actor (peliculas_actores) por Javier Iñigo.
-- Esta tabla une películas con actores y especifica el rol del actor en esa película.
CREATE TABLE IF NOT EXISTS peliculas_actores (
    pelicula_id BIGINT NOT NULL,
    actor_id BIGINT NOT NULL,
    rol VARCHAR(255) NOT NULL, -- Rol del actor en la película (ej. "Protagonista", "Secundario")
    PRIMARY KEY (pelicula_id, actor_id), -- Clave primaria compuesta
    FOREIGN KEY (pelicula_id) REFERENCES peliculas(id) ON DELETE CASCADE,
    FOREIGN KEY (actor_id) REFERENCES actores(id) ON DELETE CASCADE
);

-- Insertar datos en la tabla de relación Pelicula-Actor por Javier Iñigo.
-- NOTA: Los IDs de pelicula_id y actor_id deben existir en las tablas 'peliculas' y 'actores' respectivamente.
--       Puedes consultar tus INSERTS previos para los IDs.

-- Ejemplos basados en tus películas y los actores que he insertado:
-- ID de Películas: 1 al 20 (según tu data.sql)
-- ID de Actores: 1 (Tom Hanks), 2 (Brad Pitt), 3 (Angelina Jolie), 4 (Leonardo DiCaprio), 5 (Meryl Streep),
--                6 (Javier Bardem), 7 (Penélope Cruz), 8 (Antonio Banderas), 9 (Emma Watson), 10 (Dwayne Johnson)

INSERT INTO peliculas_actores (pelicula_id, actor_id, rol) VALUES
-- 'Forrest Gump' (ID 8) -> Tom Hanks (ID 1)
(8, 1, 'Protagonista'),
-- 'Troya' (ID 2) -> Brad Pitt (ID 2)
(2, 2, 'Protagonista'),
-- 'Gladiador' (ID 3) -> Russell Crowe (No está en tu lista de actores que te di, asumiremos que es Brad Pitt por simplicidad, o podrías añadir a Russell Crowe)
(3, 2, 'Secundario'), -- Usando Brad Pitt como ejemplo
-- 'El origen' (ID 5) -> Leonardo DiCaprio (ID 4)
(5, 4, 'Protagonista'),
-- 'Titanic' (ID 12) -> Leonardo DiCaprio (ID 4)
(12, 4, 'Protagonista'),
-- 'Joker' (ID 18) -> Joaquin Phoenix (No está en tu lista de actores que te di, pondré un actor de ejemplo)
(18, 1, 'Secundario'), -- Usando Tom Hanks como ejemplo (o añade a Joaquin Phoenix en la tabla actores)
-- 'Piratas del Caribe' (ID 4) -> Johnny Depp (No está en tu lista de actores, pondré un actor de ejemplo)
(4, 10, 'Protagonista'), -- Usando Dwayne Johnson como ejemplo
-- 'Amélie' (ID 19) -> Audrey Tautou (No está en tu lista de actores, pondré un actor de ejemplo)
(19, 9, 'Protagonista'); -- Usando Emma Watson como ejemplo

-- Puedes añadir más inserciones aquí, combinando los IDs de tus películas y los IDs de los actores que has creado.
-- Asegúrate de que los pelicula_id y actor_id existan en sus respectivas tablas.
-- fin tablas PeliculaActor.


