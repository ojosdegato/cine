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
('Carlos', 'Martín Ruiz', 'carlos@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', false);
('Mario', 'Fernández Gómez', 'fernandez@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', false);
('Lucía', 'Santos Díaz', 'lucia@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', true),
('Pedro', 'López Torres', 'pedro@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', false),
('Sofía', 'Ramírez Gil', 'sofia@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', true),
('Miguel', 'Navarro Peña', 'miguel@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', true),
('Elena', 'Vega Romero', 'elena@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', false);
('Patricia', 'Moreno Díaz', 'patricia@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', true),
('Alberto', 'Serrano López', 'alberto@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', false),
('Raquel', 'Castro Jiménez', 'raquel@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', true);
('Laura', 'Gómez Ruiz', 'laura@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', true),
('Javier', 'Sánchez León', 'javier@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', false),
('Marta', 'Ortega Pérez', 'marta@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', true),
('David', 'Cabrera Soto', 'david@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', false),
('Cristina', 'Luna Ramos', 'cristina@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', true),
('Rubén', 'Molina Vera', 'ruben@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', false);
('Isabel', 'Pérez Fernández', 'isabel@email.com', '$2a$10$xvvxPrwq9xR3qV7kyHUBm.PzzYTJRbVr1yj8HXtjW8j3GKQxLzrr.', 'USUARIO', false),
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
(2, 5, 'F7', 'TARJETA', 'PENDIENTE', 'DIA_ESPECTADOR', '2025-06-25 18:30:00');
(1, 6, 'G6', 'TARJETA', 'CONFIRMADA', 'DIA_ESPECTADOR', '2025-06-25 15:00:00'),
(2, 6, 'G8', 'TARJETA', 'CONFIRMADA', 'NORMAL', '2025-06-21 20:00:00'),
(4, 7, 'H9', 'EFECTIVO', 'CANCELADA', 'NORMAL', '2025-06-22 19:30:00'),
(5, 8, 'I10', 'TARJETA', 'PENDIENTE', 'DIA_ESPECTADOR', '2025-07-02 21:15:00'),
(1, 9, 'J11', 'TARJETA', 'CONFIRMADA', 'NORMAL', '2025-07-05 22:00:00');
(4, 10, 'K12', 'TARJETA', 'CONFIRMADA', 'NORMAL', '2025-07-06 12:00:00'),
(6, 11, 'L13', 'EFECTIVO', 'PENDIENTE', 'DIA_ESPECTADOR', '2025-07-09 13:30:00'),
(7, 12, 'M14', 'TARJETA', 'CONFIRMADA', 'NORMAL', '2025-07-08 15:45:00'),
(8, 13, 'N15', 'TARJETA', 'CANCELADA', 'NORMAL', '2025-07-08 17:20:00'),
(9, 14, 'O16', 'EFECTIVO', 'CONFIRMADA', 'DIA_ESPECTADOR', '2025-07-10 19:00:00'),
(10, 15, 'P17', 'TARJETA', 'PENDIENTE', 'NORMAL', '2025-07-11 20:30:00'),
(11, 16, 'Q18', 'TARJETA', 'CONFIRMADA', 'DIA_ESPECTADOR', '2025-07-16 21:45:00');
(12, 17, 'R19', 'EFECTIVO', 'CANCELADA', 'NORMAL', '2025-07-17 22:15:00'),
(13, 18, 'S20', 'TARJETA', 'CONFIRMADA', 'DIA_ESPECTADOR', '2025-07-18 23:00:00'),
(14, 19, 'T21', 'TARJETA', 'PENDIENTE', 'NORMAL', '2025-07-20 10:30:00'),
-- fin tablas Reservas.

