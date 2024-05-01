SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

CREATE DATABASE IF NOT EXISTS `noticias` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `noticias`;

CREATE TABLE `categoria` (
 `id_categoria` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` text,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `usuario` (
  `id_usuario` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `contrasenya` varchar(255) DEFAULT NULL,
  `rol` varchar(50) DEFAULT NULL,
  `fecha_registro` date DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `anunciante` (
  `id_anunciante` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `pais` varchar(100) DEFAULT NULL,
  `fecha_registro` date DEFAULT NULL,
  PRIMARY KEY (`id_anunciante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `anuncio` (
  `id_anuncio` int(10) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `contenido` text,
  `tipo` varchar(50) DEFAULT NULL,
  `fecha_creacion` date DEFAULT NULL,
  `id_anunciante` int(10) NOT NULL,
  PRIMARY KEY (`id_anuncio`),
  KEY `id_anunciante` (`id_anunciante`),
  CONSTRAINT `fk_anuncio_anunciante` FOREIGN KEY (`id_anunciante`) REFERENCES `anunciante` (`id_anunciante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `noticia` (
  `id_noticia` int(10) NOT NULL AUTO_INCREMENT,
  `autor` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `contenido` text,
  `fecha_creacion` date DEFAULT NULL,
  `id_usuario` int(10) NOT NULL,
  `id_anuncio` int(10) NOT NULL,
  `id_categoria` int(10) NOT NULL,
  PRIMARY KEY (`id_noticia`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_anuncio` (`id_anuncio`),
  KEY `id_categoria` (`id_categoria`),
  CONSTRAINT `fk_noticia_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `fk_noticia_anuncio` FOREIGN KEY (`id_anuncio`) REFERENCES `anuncio` (`id_anuncio`),
  CONSTRAINT `fk_noticia_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `comentario` (
  `id_comentario` int(10) NOT NULL AUTO_INCREMENT,
  `contenido` text,
  `fecha_creacion` date DEFAULT NULL,
  `id_usuario` int(10) NOT NULL,
  `id_noticia` int(10) NOT NULL,
  PRIMARY KEY (`id_comentario`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_noticia` (`id_noticia`),
  CONSTRAINT `fk_comentario_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `fk_comentario_noticia` FOREIGN KEY (`id_noticia`) REFERENCES `noticia` (`id_noticia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `valoracion` (
  `id_valoracion` int(10) NOT NULL AUTO_INCREMENT,
  `puntuacion` int(11) DEFAULT NULL,
  `fecha_creacion` date DEFAULT NULL,
  `id_usuario` int(10) NOT NULL,
  `id_comentario` int(10) NOT NULL,
  PRIMARY KEY (`id_valoracion`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_comentario` (`id_comentario`),
  CONSTRAINT `fk_valoracion_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `fk_valoracion_comentario` FOREIGN KEY (`id_comentario`) REFERENCES `comentario` (`id_comentario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `etiqueta` (
  `id_etiqueta` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` text,
  PRIMARY KEY (`id_etiqueta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE noticia_etiqueta (
  `id_noticia` int(10) NOT NULL,
  `id_etiqueta` int(10) NOT NULL,
  PRIMARY KEY (`id_noticia`, `id_etiqueta`),
  FOREIGN KEY (`id_noticia`) REFERENCES `noticia` (`id_noticia`),
  FOREIGN KEY (`id_etiqueta`) REFERENCES `etiqueta` (`id_etiqueta`)
);

COMMIT;

INSERT INTO `categoria` (`nombre`, `descripcion`) VALUES
('Actualidad', 'Noticias variadas sobre eventos actuales y relevantes.'),
('Política', 'Noticias relacionadas con el gobierno, legislación, partidos políticos y elecciones.'),
('Deportes', 'Cobertura de eventos deportivos, resultados de partidos, entrevistas con atletas y análisis deportivos.'),
('Tecnología', 'Últimas novedades en el mundo de la tecnología, gadgets, innovaciones y avances científicos.');

INSERT INTO `usuario` (`nombre`, `correo`, `contrasenya`, `rol`, `fecha_registro`) VALUES
('admin', 'admin@example.com', 'admin123', 'AD', '2024-05-01'),
('vballeo', 'vballeo@example.com', 'vballeo123', 'US', '2024-05-01'),
('lacavec', 'lacavec@example.com', 'lacavec123', 'US', '2024-05-01'),
('darabe', 'darabe@example.com', 'darabe123', 'US', '2024-05-01'),
('jmvegriv', 'jmvegriv@example.com', 'jmvegriv123', 'US', '2024-05-01');

INSERT INTO `anunciante` (`nombre`, `correo`, `telefono`, `direccion`, `pais`, `fecha_registro`) VALUES
('Renault', 'renault@example.com', '+330246434042', '122-122 bis Avenue du Général Leclerc, Boulogne-Billancourt', 'Francia', '2024-05-01'),
('Mercadona', 'mercadona@example.com', '+34783381679', 'Calle Valencia 5, Tavernes Blanques', 'España', '2024-05-01');

INSERT INTO `anuncio` (`titulo`, `imagen`, `contenido`, `tipo`, `fecha_creacion`, `id_anunciante`) VALUES
('Oferta Especial: Nuevo Renault Clio', 'clio.jpg', '¡Descubre el emocionante nuevo Renault Clio! Con un diseño moderno y características innovadoras, el Clio te ofrece una experiencia de conducción excepcional. Visita nuestro concesionario hoy mismo.', 'Oferta', '2024-05-03', 1),
('¡Nuevas ofertas semanales en Mercadona!', 'ofertas.jpg', '¡Descubre nuestras nuevas ofertas semanales en Mercadona! Desde productos frescos hasta artículos de limpieza, tenemos todo lo que necesitas al mejor precio. ¡Visítanos hoy mismo!', 'Oferta', '2024-05-03', 2);

INSERT INTO `noticia` (`autor`, `titulo`, `imagen`, `contenido`, `fecha_creacion`, `id_usuario`, `id_anuncio`, `id_categoria`) VALUES
('John Doe', 'Partido de fútbol termina en empate', 'futbol.jpg', 'El emocionante partido de fútbol entre los equipos locales terminó en un empate 2-2. Ambos equipos demostraron un gran desempeño en el campo.', '2024-05-01', 1, 1, 3),
('Jane Smith', 'Candidato presidencial presenta su plan económico', 'politica.jpg', 'El candidato presidencial dio a conocer su plan económico durante un evento en la capital. El plan incluye medidas para mejorar el empleo y estimular el crecimiento económico.', '2024-05-02', 1, 2, 2),
('Jane Smith', 'Protestas en todo el país exigen cambios en la política', 'protestas.jpg', 'Miles de personas salieron a las calles en protesta por la situación política actual. Exigen reformas y cambios significativos en el gobierno para abordar diversas problemáticas sociales.', '2024-05-03', 1, 2, 2);

INSERT INTO `comentario` (`contenido`, `fecha_creacion`, `id_usuario`, `id_noticia`) VALUES
('¡Qué emocionante partido! Ambos equipos jugaron realmente bien.', '2024-05-01', 4, 1),
('Fue un juego realmente emocionante. ¡Espero que el próximo partido sea igual de bueno!', '2024-05-01', 2, 1),
('Interesante plan económico. Estoy deseando ver cómo se desarrollan estas propuestas.', '2024-05-02', 5, 2);

INSERT INTO `valoracion` (`puntuacion`, `fecha_creacion`, `id_usuario`, `id_comentario`) VALUES
(5, '2024-05-01', 1, 1),
(4, '2024-05-01', 2, 1),
(3, '2024-05-02', 3, 3);

INSERT INTO `etiqueta` (`nombre`, `descripcion`) VALUES
('LALIGA EA Sports', 'Eventos específicos de la liga de fútbol en España.'),
('Fútbol', 'Noticias y eventos relacionados con el fútbol en general.'),
('Protestas', 'Noticias que abordan eventos de protesta social y política.'),
('Elecciones', 'Noticias sobre procesos electorales y resultados de elecciones.');

INSERT INTO `noticia_etiqueta` (`id_noticia`, `id_etiqueta`) VALUES
(1, 1),
(1, 2),
(3, 3),
(2, 4);
