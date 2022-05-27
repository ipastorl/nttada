-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-05-2022 a las 20:38:20
-- Versión del servidor: 5.7.30
-- Versión de PHP: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `playfield`
--
CREATE DATABASE IF NOT EXISTS `playfield` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `playfield`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `combos`
--

CREATE TABLE `combos` (
  `id` varchar(30) NOT NULL,
  `points` int(9) NOT NULL,
  `until` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `combos`
--

INSERT INTO `combos` (`id`, `points`, `until`) VALUES
('shuttle', 50, 6),
('space', 100, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `max_score`
--

CREATE TABLE `max_score` (
  `name` varchar(60) NOT NULL,
  `score` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `max_score`
--

INSERT INTO `max_score` (`name`, `score`) VALUES
('IPL', 500),
('ipL', 7012);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `skinhole`
--

CREATE TABLE `skinhole` (
  `id` varchar(30) NOT NULL,
  `points` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `skinhole`
--

INSERT INTO `skinhole` (`id`, `points`) VALUES
('outOfGalaxy', 500);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `slingshot`
--

CREATE TABLE `slingshot` (
  `id` varchar(30) NOT NULL,
  `points` int(9) NOT NULL,
  `strength` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `slingshot`
--

INSERT INTO `slingshot` (`id`, `points`, `strength`) VALUES
('slingshot01', 25, 5),
('slingshot02', 25, 5),
('slingshot03', 25, 5),
('slingshot04', 50, 3),
('slingshot05right', 15, 6),
('slingshot06left', 15, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `targets`
--

CREATE TABLE `targets` (
  `id` varchar(30) NOT NULL,
  `points` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `targets`
--

INSERT INTO `targets` (`id`, `points`) VALUES
('target01east', 75),
('target01north', 50),
('target01west', 100),
('target02east', 75),
('target02north', 50),
('target02west', 100),
('target03east', 75),
('target03north', 50),
('target03west', 100);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `combos`
--
ALTER TABLE `combos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `skinhole`
--
ALTER TABLE `skinhole`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `slingshot`
--
ALTER TABLE `slingshot`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `targets`
--
ALTER TABLE `targets`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
