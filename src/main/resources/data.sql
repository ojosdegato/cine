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
('Vengadores: Endgame', 'Acción', 181, 12, 'Los héroes más poderosos del mundo luchan para salvar al universo', 'https://youtube.com/ver_trailer10');

-- fin tablas Peliculas.