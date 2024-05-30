-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-05-2024 a las 08:41:26
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `noticias`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `anunciante`
--

CREATE TABLE `anunciante` (
  `id_anunciante` int(10) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `pais` varchar(100) DEFAULT NULL,
  `fecha_registro` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `anunciante`
--

INSERT INTO `anunciante` (`id_anunciante`, `nombre`, `correo`, `telefono`, `direccion`, `pais`, `fecha_registro`) VALUES
(1, 'Renault', 'renault@example.com', '+330246434042', '122-122 bis Avenue du Général Leclerc, Boulogne-Billancourt', 'Francia', '2024-05-01'),
(2, 'Mercadona', 'mercadona@example.com', '+34783381679', 'Calle Valencia 5, Tavernes Blanques', 'España', '2024-05-01');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `anuncio`
--

CREATE TABLE `anuncio` (
  `id_anuncio` int(10) NOT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `contenido` text DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  `fecha_creacion` date DEFAULT NULL,
  `id_anunciante` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `anuncio`
--

INSERT INTO `anuncio` (`id_anuncio`, `titulo`, `imagen`, `contenido`, `tipo`, `fecha_creacion`, `id_anunciante`) VALUES
(1, 'Oferta Especial: Nuevo Renault Clio', 'clio.jpg', '¡Descubre el emocionante nuevo Renault Clio! Con un diseño moderno y características innovadoras, el Clio te ofrece una experiencia de conducción excepcional. Visita nuestro concesionario hoy mismo.', 'Oferta', '2024-05-03', 1),
(2, '¡Nuevas ofertas semanales en Mercadona!', 'ofertas.jpg', '¡Descubre nuestras nuevas ofertas semanales en Mercadona! Desde productos frescos hasta artículos de limpieza, tenemos todo lo que necesitas al mejor precio. ¡Visítanos hoy mismo!', 'Oferta', '2024-05-03', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autoria`
--

CREATE TABLE `autoria` (
  `idUsuario` int(11) NOT NULL,
  `idComentario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id_categoria` int(10) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id_categoria`, `nombre`, `descripcion`) VALUES
(1, 'Actualidad', 'Noticias variadas sobre eventos actuales y relevantes.'),
(2, 'Política', 'Noticias relacionadas con el gobierno, legislación, partidos políticos y elecciones.'),
(3, 'Deportes', 'Cobertura de eventos deportivos, resultados de partidos, entrevistas con atletas y análisis deportivos.'),
(4, 'Tecnología', 'Últimas novedades en el mundo de la tecnología, gadgets, innovaciones y avances científicos.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentario`
--

CREATE TABLE `comentario` (
  `id_comentario` int(10) NOT NULL,
  `contenido` text DEFAULT NULL,
  `fecha_creacion` date DEFAULT NULL,
  `id_usuario` int(10) NOT NULL,
  `id_noticia` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `comentario`
--

INSERT INTO `comentario` (`id_comentario`, `contenido`, `fecha_creacion`, `id_usuario`, `id_noticia`) VALUES
(1, '¡Qué emocionante partido! Ambos equipos jugaron realmente bien.', '2024-05-01', 4, 1),
(2, 'Fue un juego realmente emocionante. ¡Espero que el próximo partido sea igual de bueno!', '2024-05-01', 2, 1),
(3, 'Interesante plan económico. Estoy deseando ver cómo se desarrollan estas propuestas.', '2024-05-02', 5, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `etiqueta`
--

CREATE TABLE `etiqueta` (
  `id_etiqueta` int(10) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `etiqueta`
--

INSERT INTO `etiqueta` (`id_etiqueta`, `nombre`, `descripcion`) VALUES
(1, 'LALIGA EA Sports', 'Eventos específicos de la liga de fútbol en España.'),
(2, 'Fútbol', 'Noticias y eventos relacionados con el fútbol en general.'),
(3, 'Protestas', 'Noticias que abordan eventos de protesta social y política.'),
(4, 'Elecciones', 'Noticias sobre procesos electorales y resultados de elecciones.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `noticia`
--

CREATE TABLE `noticia` (
  `id_noticia` int(10) NOT NULL,
  `autor` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `contenido` text DEFAULT NULL,
  `fecha_creacion` date DEFAULT NULL,
  `id_usuario` int(10) NOT NULL,
  `id_anuncio` int(10) NOT NULL,
  `id_categoria` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `noticia`
--

INSERT INTO `noticia` (`id_noticia`, `autor`, `titulo`, `imagen`, `contenido`, `fecha_creacion`, `id_usuario`, `id_anuncio`, `id_categoria`) VALUES
(1, 'John Doe', 'Partido de fútbol termina en empate', 'futbol.jpg', 'El emocionante partido de fútbol entre los equipos locales terminó en un empate 2-2. Ambos equipos demostraron un gran desempeño en el campo.', '2024-05-01', 1, 1, 3),
(2, 'Jane Smith', 'Candidato presidencial presenta su plan económico', 'politica.jpg', 'El candidato presidencial dio a conocer su plan económico durante un evento en la capital. El plan incluye medidas para mejorar el empleo y estimular el crecimiento económico.', '2024-05-02', 1, 2, 2),
(3, 'Jane Smith', 'Protestas en todo el país exigen cambios en la política', 'protestas.jpg', 'Miles de personas salieron a las calles en protesta por la situación política actual. Exigen reformas y cambios significativos en el gobierno para abordar diversas problemáticas sociales.', '2024-05-03', 1, 2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `noticia_etiqueta`
--

CREATE TABLE `noticia_etiqueta` (
  `id_noticia` int(10) NOT NULL,
  `id_etiqueta` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `noticia_etiqueta`
--

INSERT INTO `noticia_etiqueta` (`id_noticia`, `id_etiqueta`) VALUES
(1, 1),
(1, 2),
(2, 4),
(3, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(10) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `contrasenya` varchar(255) DEFAULT NULL,
  `rol` varchar(50) DEFAULT NULL,
  `fecha_registro` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombre`, `correo`, `contrasenya`, `rol`, `fecha_registro`) VALUES
(1, 'admin', 'admin@example.com', 'admin123', 'AD', '2024-05-01'),
(2, 'vballeo', 'vballeo@example.com', 'vballeo123', 'US', '2024-05-01'),
(3, 'lacavec', 'lacavec@example.com', 'lacavec123', 'US', '2024-05-01'),
(4, 'darabe', 'darabe@example.com', 'darabe123', 'US', '2024-05-01'),
(5, 'jmvegriv', 'jmvegriv@example.com', 'jmvegriv123', 'US', '2024-05-01');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `valoracion`
--

CREATE TABLE `valoracion` (
  `id_valoracion` int(10) NOT NULL,
  `puntuacion` int(11) DEFAULT NULL,
  `fecha_creacion` date DEFAULT NULL,
  `id_usuario` int(10) NOT NULL,
  `id_comentario` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `valoracion`
--

INSERT INTO `valoracion` (`id_valoracion`, `puntuacion`, `fecha_creacion`, `id_usuario`, `id_comentario`) VALUES
(1, 5, '2024-05-01', 1, 1),
(2, 4, '2024-05-01', 2, 1),
(3, 3, '2024-05-02', 3, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `valorado`
--

CREATE TABLE `valorado` (
  `idUsuario` int(11) NOT NULL,
  `idValoracion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `anunciante`
--
ALTER TABLE `anunciante`
  ADD PRIMARY KEY (`id_anunciante`);

--
-- Indices de la tabla `anuncio`
--
ALTER TABLE `anuncio`
  ADD PRIMARY KEY (`id_anuncio`),
  ADD KEY `id_anunciante` (`id_anunciante`);

--
-- Indices de la tabla `autoria`
--
ALTER TABLE `autoria`
  ADD PRIMARY KEY (`idUsuario`,`idComentario`),
  ADD KEY `idComentario` (`idComentario`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indices de la tabla `comentario`
--
ALTER TABLE `comentario`
  ADD PRIMARY KEY (`id_comentario`),
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `id_noticia` (`id_noticia`);

--
-- Indices de la tabla `etiqueta`
--
ALTER TABLE `etiqueta`
  ADD PRIMARY KEY (`id_etiqueta`);

--
-- Indices de la tabla `noticia`
--
ALTER TABLE `noticia`
  ADD PRIMARY KEY (`id_noticia`),
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `id_anuncio` (`id_anuncio`),
  ADD KEY `id_categoria` (`id_categoria`);

--
-- Indices de la tabla `noticia_etiqueta`
--
ALTER TABLE `noticia_etiqueta`
  ADD PRIMARY KEY (`id_noticia`,`id_etiqueta`),
  ADD KEY `id_etiqueta` (`id_etiqueta`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- Indices de la tabla `valoracion`
--
ALTER TABLE `valoracion`
  ADD PRIMARY KEY (`id_valoracion`),
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `id_comentario` (`id_comentario`);

--
-- Indices de la tabla `valorado`
--
ALTER TABLE `valorado`
  ADD PRIMARY KEY (`idUsuario`,`idValoracion`),
  ADD KEY `idValoracion` (`idValoracion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `anunciante`
--
ALTER TABLE `anunciante`
  MODIFY `id_anunciante` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `anuncio`
--
ALTER TABLE `anuncio`
  MODIFY `id_anuncio` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id_categoria` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `comentario`
--
ALTER TABLE `comentario`
  MODIFY `id_comentario` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `etiqueta`
--
ALTER TABLE `etiqueta`
  MODIFY `id_etiqueta` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `noticia`
--
ALTER TABLE `noticia`
  MODIFY `id_noticia` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `valoracion`
--
ALTER TABLE `valoracion`
  MODIFY `id_valoracion` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `anuncio`
--
ALTER TABLE `anuncio`
  ADD CONSTRAINT `fk_anuncio_anunciante` FOREIGN KEY (`id_anunciante`) REFERENCES `anunciante` (`id_anunciante`);

--
-- Filtros para la tabla `autoria`
--
ALTER TABLE `autoria`
  ADD CONSTRAINT `autoria_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`id_usuario`),
  ADD CONSTRAINT `autoria_ibfk_2` FOREIGN KEY (`idComentario`) REFERENCES `comentario` (`id_comentario`);

--
-- Filtros para la tabla `comentario`
--
ALTER TABLE `comentario`
  ADD CONSTRAINT `fk_comentario_noticia` FOREIGN KEY (`id_noticia`) REFERENCES `noticia` (`id_noticia`),
  ADD CONSTRAINT `fk_comentario_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `noticia`
--
ALTER TABLE `noticia`
  ADD CONSTRAINT `fk_noticia_anuncio` FOREIGN KEY (`id_anuncio`) REFERENCES `anuncio` (`id_anuncio`),
  ADD CONSTRAINT `fk_noticia_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`),
  ADD CONSTRAINT `fk_noticia_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `noticia_etiqueta`
--
ALTER TABLE `noticia_etiqueta`
  ADD CONSTRAINT `noticia_etiqueta_ibfk_1` FOREIGN KEY (`id_noticia`) REFERENCES `noticia` (`id_noticia`),
  ADD CONSTRAINT `noticia_etiqueta_ibfk_2` FOREIGN KEY (`id_etiqueta`) REFERENCES `etiqueta` (`id_etiqueta`);

--
-- Filtros para la tabla `valoracion`
--
ALTER TABLE `valoracion`
  ADD CONSTRAINT `fk_valoracion_comentario` FOREIGN KEY (`id_comentario`) REFERENCES `comentario` (`id_comentario`),
  ADD CONSTRAINT `fk_valoracion_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `valorado`
--
ALTER TABLE `valorado`
  ADD CONSTRAINT `valorado_ibfk_1` FOREIGN KEY (`idValoracion`) REFERENCES `valoracion` (`id_valoracion`),
  ADD CONSTRAINT `valorado_ibfk_2` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`id_usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
