-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-06-2019 a las 00:08:54
-- Versión del servidor: 10.1.36-MariaDB
-- Versión de PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyectosena`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulo`
--

CREATE TABLE `articulo` (
  `codigoArticulo` int(11) NOT NULL,
  `nombreArticulo` varchar(80) NOT NULL,
  `descripcion` varchar(250) DEFAULT NULL,
  `idProveedores` int(11) NOT NULL,
  `iva` decimal(5,2) DEFAULT NULL,
  `idSublinea` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `lote` varchar(50) DEFAULT NULL,
  `costo` decimal(12,2) NOT NULL,
  `precioVenta` decimal(12,2) DEFAULT NULL,
  `utilidad` decimal(12,2) DEFAULT NULL,
  `estado` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `articulo`
--

INSERT INTO `articulo` (`codigoArticulo`, `nombreArticulo`, `descripcion`, `idProveedores`, `iva`, `idSublinea`, `cantidad`, `lote`, `costo`, `precioVenta`, `utilidad`, `estado`) VALUES
(4, 'Boligrafo Kilometrico Azul', '', 3, '16.00', 1, 95, '', '1500.00', '2200.00', '700.00', 'Activo'),
(5, 'Lapiz Mirado 2', 'Lapiz para dibujo, de madera amarillo mirado 2', 3, '18.00', 2, 74, 'LT 1 Mayo 2 2019', '1100.00', '1700.00', '600.00', 'Activo'),
(6, 'Cartulina Amarilla', 'Cartulina amarilla x10 tamaño oficio', 1, '17.00', 12, 26, 'LT 1 Mayo 28 2019 ', '3500.00', '4800.00', '1300.00', 'Inactivo'),
(7, 'Tijeras negra pequeña', 'Tijera para cortar papel', 4, '19.00', 4, 198, 'LT 1 Junio 1 2019', '900.00', '1600.00', '700.00', 'Activo'),
(8, 'Cinta transparente', '', 3, '17.00', 7, 145, '', '2300.00', '3400.00', '1100.00', 'Activo'),
(9, 'Cinta de enmascarar', '', 4, '12.00', 7, 198, '', '2500.00', '4000.00', '1500.00', 'Activo'),
(10, 'Lampara clasica', 'Lampara que es clasica con iluminacion led del año 1600', 4, '16.00', 24, 90, 'LT 5002', '199500.00', '250000.00', '50500.00', 'Activo'),
(11, 'PACK  CD RW', 'CD REESCRIBIBLE', 5, '19.00', 25, 100, 'LT999999', '11000.00', '15000.00', '4000.00', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caja`
--

CREATE TABLE `caja` (
  `codigoCaja` int(11) NOT NULL,
  `ubicacion` varchar(80) NOT NULL,
  `descripcion` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `caja`
--

INSERT INTO `caja` (`codigoCaja`, `ubicacion`, `descripcion`) VALUES
(111, 'Entrada Principal', 'Caja 1'),
(222, 'Entrada Principal', 'Caja 2'),
(333, 'Entrada Posterior', 'Caja 3');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cargos`
--

CREATE TABLE `cargos` (
  `idCargo` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `descripcion` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cargos`
--

INSERT INTO `cargos` (`idCargo`, `nombre`, `descripcion`) VALUES
(1, 'Cajero', 'Encargado de registrar la compra de los productos vendidos a clientes'),
(2, 'Supervisor', 'Encargado de toda la supervision');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudad`
--

CREATE TABLE `ciudad` (
  `codigoCiudad` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `departamento` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `ciudad`
--

INSERT INTO `ciudad` (`codigoCiudad`, `nombre`, `departamento`) VALUES
(1, 'Cali', 'Valle del Cauca'),
(2, 'Bogota', 'Cundinamarca'),
(3, 'Armenia', 'Quindio'),
(4, 'Pereira', 'Risaralda'),
(5, 'Bucaramanga', 'Santander'),
(6, 'Barranquilla', 'Atlantico'),
(7, 'Cartagena', 'Bolivar'),
(8, 'Medellin', 'Antioquia'),
(9, 'Manizales', 'Caldas'),
(10, 'Pasto', 'Nariño');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `codigoCliente` int(11) NOT NULL,
  `idTipoIdentidad` int(11) NOT NULL,
  `numeroDocumento` varchar(20) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `apellido` varchar(60) NOT NULL,
  `genero` char(1) DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `direccion` varchar(60) NOT NULL,
  `telefono` varchar(12) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `codigoCiudad` int(11) NOT NULL,
  `estado` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`codigoCliente`, `idTipoIdentidad`, `numeroDocumento`, `nombre`, `apellido`, `genero`, `fechaNacimiento`, `direccion`, `telefono`, `email`, `codigoCiudad`, `estado`) VALUES
(1, 1, '1232131221', 'Carlos', 'Taquinas', 'M', '1991-06-06', 'Cra 23 tranv 2', '123123123', '', 1, 'Activo'),
(2, 1, '23123123', 'Guillermo', 'Lopez', 'M', '1988-08-03', 'Cra 23 # 2 n98', '', '', 1, 'Activo'),
(3, 1, '1144155177', 'Cecilia', 'Gimenez', 'M', '1990-11-26', 'Cra 45 23 34', '3242342', 'cecilia@hotmail.com', 2, 'Activo'),
(4, 3, '1126000815', 'Alejandro ', 'Toro Benitez', 'M', '2001-08-10', 'calle 77 4n 88', '3476347', 'alejo2001@gmail.com', 1, 'Activo'),
(5, 1, '123123123123', 'Diana Marcela', 'Rios Gimenez', 'F', '1993-08-05', 'Cra 8 calle 24', '2345677', '', 1, 'Activo'),
(6, 1, '10308341', 'Fabian Andres', 'Muñoz', 'M', '1985-12-06', 'Calle 15 N # 9 36', '3006715400', 'fabianmz@misena.edu.co', 1, 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleventa`
--

CREATE TABLE `detalleventa` (
  `numeroDocumento` int(11) NOT NULL,
  `codigoArticulo` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `iva` decimal(12,2) DEFAULT NULL,
  `total` decimal(12,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `detalleventa`
--

INSERT INTO `detalleventa` (`numeroDocumento`, `codigoArticulo`, `cantidad`, `iva`, `total`) VALUES
(1, 4, 3, '1056.00', '7656.00'),
(1, 5, 2, '612.00', '4012.00'),
(1, 6, 1, '816.00', '5616.00'),
(2, 4, 2, '704.00', '5104.00'),
(2, 5, 1, '306.00', '2006.00'),
(2, 6, 3, '2448.00', '16848.00'),
(3, 7, 2, '608.00', '3808.00'),
(3, 8, 5, '2890.00', '19890.00'),
(4, 5, 3, '918.00', '6018.00'),
(4, 9, 2, '480.00', '4480.00'),
(5, 10, 10, '400000.00', '2900000.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `numeroDocumento` int(11) NOT NULL,
  `codigoDocumento` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time DEFAULT NULL,
  `codigoCaja` int(11) NOT NULL,
  `codigoCliente` int(11) NOT NULL,
  `idResolucionFactura` int(11) DEFAULT NULL,
  `idUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`numeroDocumento`, `codigoDocumento`, `fecha`, `hora`, `codigoCaja`, `codigoCliente`, `idResolucionFactura`, `idUsuario`) VALUES
(1, 1, '2019-06-17', '21:56:41', 111, 1, 1, 3),
(2, 1, '2019-06-17', '23:42:52', 111, 2, 1, 1),
(3, 1, '2019-06-17', '23:46:31', 222, 3, 1, 4),
(4, 1, '2019-06-18', '15:56:05', 111, 6, 1, 1),
(5, 1, '2019-06-18', '16:14:46', 222, 6, 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horariolaboral`
--

CREATE TABLE `horariolaboral` (
  `idHorario` int(11) NOT NULL,
  `horaInicio` time NOT NULL,
  `horaFin` time NOT NULL,
  `horaDesc` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `horariolaboral`
--

INSERT INTO `horariolaboral` (`idHorario`, `horaInicio`, `horaFin`, `horaDesc`) VALUES
(1, '07:00:00', '16:00:00', 'Apertura'),
(2, '08:00:00', '17:00:00', 'Apertura'),
(3, '11:30:00', '20:30:00', 'Cierre'),
(4, '13:00:00', '22:00:00', 'Cierre');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lineaproducto`
--

CREATE TABLE `lineaproducto` (
  `idLinea` int(11) NOT NULL,
  `lineaDescripcion` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `lineaproducto`
--

INSERT INTO `lineaproducto` (`idLinea`, `lineaDescripcion`) VALUES
(1, 'Escritura'),
(2, 'Utiles de oficina'),
(3, 'Papeles y blocks'),
(4, 'Accesorios de oficina'),
(5, 'Escritorios y mesas'),
(6, 'Archivo y Clasificación'),
(9, 'Luminaria');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `idProveedores` int(11) NOT NULL,
  `numeroIdentidad` varchar(20) NOT NULL,
  `nombre` varchar(80) NOT NULL,
  `codigoCiudad` int(11) NOT NULL,
  `direccion` varchar(80) NOT NULL,
  `telefono` varchar(12) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `estado` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`idProveedores`, `numeroIdentidad`, `nombre`, `codigoCiudad`, `direccion`, `telefono`, `email`, `estado`) VALUES
(1, '87543278', 'Carvajal SAs', 1, 'calle 34 # 2N 50', '', 'admin@carvajal.com', 'Activo'),
(2, '67965656', 'Papel omega ltda', 1, 'Acopi Yumbo', '3234234', 'gerencia@pomega.com', 'Activo'),
(3, '45345345', 'Propal Sa', 1, 'Acopi Yumbo', '2342342', 'compras@propal.com', 'Activo'),
(4, '12332312323', 'Piñateria Don Roque', 1, 'Calle 41 # 2N 45', '4546332', '', 'Activo'),
(5, '12334556', 'Insumos del valle', 1, 'calle 77 4n 88 bis norte', '1356253', 'insumos@insumosSAS.com', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reportes`
--

CREATE TABLE `reportes` (
  `idreporte` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `moduloReportado` varchar(80) NOT NULL,
  `descripcion` varchar(90) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `resolucionfactura`
--

CREATE TABLE `resolucionfactura` (
  `idResolucionFactura` int(11) NOT NULL,
  `nroResolucionFactura` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFin` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `resolucionfactura`
--

INSERT INTO `resolucionfactura` (`idResolucionFactura`, `nroResolucionFactura`, `fecha`, `fechaInicio`, `fechaFin`) VALUES
(1, 234234323, '2008-01-12', '2019-04-02', '2021-04-02');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `idRol` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `descripcion` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`idRol`, `nombre`, `descripcion`) VALUES
(1, 'Administrador', ''),
(2, 'Empleado', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sublineaproducto`
--

CREATE TABLE `sublineaproducto` (
  `idSublinea` int(11) NOT NULL,
  `sublineaDescripcion` varchar(80) NOT NULL,
  `idLinea` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `sublineaproducto`
--

INSERT INTO `sublineaproducto` (`idSublinea`, `sublineaDescripcion`, `idLinea`) VALUES
(1, 'Boligrafos', 1),
(2, 'Lapices', 1),
(3, 'Marcadores', 1),
(4, 'Tijeras', 2),
(5, 'Clips', 2),
(6, 'Perforadoras', 2),
(7, 'Cintas Adhesivas', 2),
(8, 'Bandas de caucho', 2),
(9, 'Grapadoras', 2),
(10, 'Notas Adhesivas', 3),
(11, 'Resmas de papel', 3),
(12, 'Cartulinas,carton paja', 3),
(13, 'Sacaganchos', 4),
(14, 'Canecas', 4),
(15, 'Lamparas de escritorio', 4),
(16, 'Escritorios sencillos', 5),
(17, 'Mesas para portatiles', 5),
(18, 'Legajadores', 6),
(19, 'Carpetas', 6),
(20, 'Folderes', 6),
(21, 'Ganchos legajadora', 6),
(24, 'Lamparas', 9),
(25, 'CD Y DVD', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipodocumento`
--

CREATE TABLE `tipodocumento` (
  `codigoDocumento` int(11) NOT NULL,
  `descripcion` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipodocumento`
--

INSERT INTO `tipodocumento` (`codigoDocumento`, `descripcion`) VALUES
(1, 'Factura'),
(2, 'Cotizacion');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipoidentidad`
--

CREATE TABLE `tipoidentidad` (
  `idTipoIdentidad` int(11) NOT NULL,
  `nombreTipoIdentidad` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipoidentidad`
--

INSERT INTO `tipoidentidad` (`idTipoIdentidad`, `nombreTipoIdentidad`) VALUES
(1, 'Cedula'),
(2, 'Pasaporte'),
(3, 'T.I.'),
(4, 'C.E');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `turnocaja`
--

CREATE TABLE `turnocaja` (
  `idTurnoCaja` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `codCaja` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `horaInicial` time DEFAULT NULL,
  `horaFinal` time DEFAULT NULL,
  `observaciones` varchar(90) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `turnocaja`
--

INSERT INTO `turnocaja` (`idTurnoCaja`, `idUsuario`, `codCaja`, `fecha`, `horaInicial`, `horaFinal`, `observaciones`) VALUES
(1, 1, 111, '2019-06-18', '00:29:37', '00:29:55', ''),
(2, 4, 222, '2019-06-18', '00:30:14', '00:30:43', 'no ocurrio nada'),
(3, 4, 222, '2019-06-18', '00:32:05', '00:32:10', ''),
(4, 2, 111, '2019-06-18', '01:22:06', '01:22:50', ''),
(5, 2, 111, '2019-06-18', '01:24:24', '01:25:25', ''),
(6, 2, 111, '2019-06-18', '01:25:59', '01:27:07', ''),
(7, 2, 111, '2019-06-18', '01:27:37', '01:28:44', ''),
(8, 1, 111, '2019-06-18', '13:08:20', '13:09:33', ''),
(9, 1, 111, '2019-06-18', '13:39:33', '00:00:00', ''),
(10, 2, 111, '2019-06-18', '13:48:12', '00:00:00', ''),
(11, 1, 111, '2019-06-18', '14:04:02', '14:12:10', ''),
(12, 4, 222, '2019-06-18', '14:29:37', '14:31:35', ''),
(13, 2, 111, '2019-06-18', '14:31:43', '14:35:31', ''),
(14, 1, 111, '2019-06-18', '15:50:11', '16:01:34', ''),
(15, 1, 222, '2019-06-18', '16:48:22', '16:55:44', ''),
(16, 2, 333, '2019-06-18', '16:56:25', '17:08:22', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `primerNombre` varchar(30) NOT NULL,
  `segundoNombre` varchar(30) DEFAULT NULL,
  `primerApellido` varchar(30) NOT NULL,
  `segundoApellido` varchar(30) DEFAULT NULL,
  `login` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `sexo` char(1) NOT NULL,
  `idTipoIdentidad` int(11) NOT NULL,
  `numeroIdentidad` varchar(30) NOT NULL,
  `fechaNac` date DEFAULT NULL,
  `idCargo` int(11) NOT NULL,
  `direccion` varchar(60) DEFAULT NULL,
  `telefono` varchar(12) DEFAULT NULL,
  `idRol` int(11) NOT NULL,
  `idHorario` int(11) NOT NULL,
  `estado` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `primerNombre`, `segundoNombre`, `primerApellido`, `segundoApellido`, `login`, `password`, `sexo`, `idTipoIdentidad`, `numeroIdentidad`, `fechaNac`, `idCargo`, `direccion`, `telefono`, `idRol`, `idHorario`, `estado`) VALUES
(1, 'Rodrigo', '', 'Perez', '', 'rodrigo', 'rodrigo', 'M', 1, '88654123', '1968-05-01', 1, 'calle 43 # 23 12', '4678900', 2, 1, 'Activo'),
(2, 'Jefersson', 'Andres', 'Garcia', '', 'admin', 'admin', 'M', 1, '1144166128', '1993-01-31', 2, 'calle 51 # 23 12', '4467889', 1, 1, 'Activo'),
(3, 'Raul', '', 'Ruiz', 'Vera', 'raul', 'raul', 'M', 1, '23234234', '1990-06-06', 2, 'cra 22 # 2 n 12', '', 1, 4, 'Activo'),
(4, 'Lina', 'Maria', 'Mendoza', '', 'lina', 'lina', 'M', 1, '432432423', '1990-12-05', 1, 'Calle 23 # 2N14', '', 2, 3, 'Activo'),
(5, 'Felipe', '', 'Guerra', 'Sáenz', 'felipe', 'felipe', 'M', 1, '666000666', '2019-06-16', 2, '', '', 1, 1, 'Activo');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `articulo`
--
ALTER TABLE `articulo`
  ADD PRIMARY KEY (`codigoArticulo`),
  ADD KEY `fk_articulo_proveedores1_idx` (`idProveedores`),
  ADD KEY `fk_articulo_sublineaproducto1_idx` (`idSublinea`);

--
-- Indices de la tabla `caja`
--
ALTER TABLE `caja`
  ADD PRIMARY KEY (`codigoCaja`);

--
-- Indices de la tabla `cargos`
--
ALTER TABLE `cargos`
  ADD PRIMARY KEY (`idCargo`);

--
-- Indices de la tabla `ciudad`
--
ALTER TABLE `ciudad`
  ADD PRIMARY KEY (`codigoCiudad`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`codigoCliente`),
  ADD KEY `fk_cliente_tipoidentidad1_idx` (`idTipoIdentidad`),
  ADD KEY `fk_cliente_ciudad1_idx` (`codigoCiudad`);

--
-- Indices de la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  ADD PRIMARY KEY (`numeroDocumento`,`codigoArticulo`),
  ADD KEY `fk_detalleVenta_factura1_idx` (`numeroDocumento`),
  ADD KEY `fk_detalleVenta_articulo1_idx` (`codigoArticulo`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`numeroDocumento`),
  ADD KEY `fk_factura_tipodocumento1_idx` (`codigoDocumento`),
  ADD KEY `fk_factura_caja1_idx` (`codigoCaja`),
  ADD KEY `fk_factura_cliente1_idx` (`codigoCliente`),
  ADD KEY `fk_factura_resolucionfactura1_idx` (`idResolucionFactura`),
  ADD KEY `fk_factura_empleados1_idx` (`idUsuario`);

--
-- Indices de la tabla `horariolaboral`
--
ALTER TABLE `horariolaboral`
  ADD PRIMARY KEY (`idHorario`);

--
-- Indices de la tabla `lineaproducto`
--
ALTER TABLE `lineaproducto`
  ADD PRIMARY KEY (`idLinea`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`idProveedores`),
  ADD KEY `fk_proveedores_ciudad_idx` (`codigoCiudad`);

--
-- Indices de la tabla `reportes`
--
ALTER TABLE `reportes`
  ADD PRIMARY KEY (`idreporte`),
  ADD KEY `fk_reportes_empleados1_idx` (`idUsuario`);

--
-- Indices de la tabla `resolucionfactura`
--
ALTER TABLE `resolucionfactura`
  ADD PRIMARY KEY (`idResolucionFactura`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`idRol`);

--
-- Indices de la tabla `sublineaproducto`
--
ALTER TABLE `sublineaproducto`
  ADD PRIMARY KEY (`idSublinea`),
  ADD KEY `fk_sublineaproducto_lineaproducto1_idx` (`idLinea`);

--
-- Indices de la tabla `tipodocumento`
--
ALTER TABLE `tipodocumento`
  ADD PRIMARY KEY (`codigoDocumento`);

--
-- Indices de la tabla `tipoidentidad`
--
ALTER TABLE `tipoidentidad`
  ADD PRIMARY KEY (`idTipoIdentidad`);

--
-- Indices de la tabla `turnocaja`
--
ALTER TABLE `turnocaja`
  ADD PRIMARY KEY (`idTurnoCaja`),
  ADD KEY `fk_controlCaja_caja1_idx` (`codCaja`),
  ADD KEY `fk_controlCaja_usuario1_idx` (`idUsuario`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`),
  ADD KEY `fk_empleados_tipoidentidad1_idx` (`idTipoIdentidad`),
  ADD KEY `fk_empleados_cargos1_idx` (`idCargo`),
  ADD KEY `fk_usuario_rol1_idx` (`idRol`),
  ADD KEY `fk_usuario_horariolaboral1_idx` (`idHorario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `articulo`
--
ALTER TABLE `articulo`
  MODIFY `codigoArticulo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `caja`
--
ALTER TABLE `caja`
  MODIFY `codigoCaja` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=334;

--
-- AUTO_INCREMENT de la tabla `cargos`
--
ALTER TABLE `cargos`
  MODIFY `idCargo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `ciudad`
--
ALTER TABLE `ciudad`
  MODIFY `codigoCiudad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `codigoCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `horariolaboral`
--
ALTER TABLE `horariolaboral`
  MODIFY `idHorario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `lineaproducto`
--
ALTER TABLE `lineaproducto`
  MODIFY `idLinea` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  MODIFY `idProveedores` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `reportes`
--
ALTER TABLE `reportes`
  MODIFY `idreporte` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `resolucionfactura`
--
ALTER TABLE `resolucionfactura`
  MODIFY `idResolucionFactura` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `idRol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `sublineaproducto`
--
ALTER TABLE `sublineaproducto`
  MODIFY `idSublinea` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT de la tabla `tipodocumento`
--
ALTER TABLE `tipodocumento`
  MODIFY `codigoDocumento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tipoidentidad`
--
ALTER TABLE `tipoidentidad`
  MODIFY `idTipoIdentidad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `turnocaja`
--
ALTER TABLE `turnocaja`
  MODIFY `idTurnoCaja` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `articulo`
--
ALTER TABLE `articulo`
  ADD CONSTRAINT `fk_articulo_proveedores1` FOREIGN KEY (`idProveedores`) REFERENCES `proveedores` (`idProveedores`),
  ADD CONSTRAINT `fk_articulo_sublineaproducto1` FOREIGN KEY (`idSublinea`) REFERENCES `sublineaproducto` (`idSublinea`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `fk_cliente_ciudad1` FOREIGN KEY (`codigoCiudad`) REFERENCES `ciudad` (`codigoCiudad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_cliente_tipoidentidad1` FOREIGN KEY (`idTipoIdentidad`) REFERENCES `tipoidentidad` (`idTipoIdentidad`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  ADD CONSTRAINT `fk_detalleVenta_articulo1` FOREIGN KEY (`codigoArticulo`) REFERENCES `articulo` (`codigoArticulo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_detalleVenta_factura1` FOREIGN KEY (`numeroDocumento`) REFERENCES `factura` (`numeroDocumento`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `fk_factura_caja1` FOREIGN KEY (`codigoCaja`) REFERENCES `caja` (`codigoCaja`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_factura_cliente1` FOREIGN KEY (`codigoCliente`) REFERENCES `cliente` (`codigoCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_factura_empleados1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_factura_resolucionfactura1` FOREIGN KEY (`idResolucionFactura`) REFERENCES `resolucionfactura` (`idResolucionFactura`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_factura_tipodocumento1` FOREIGN KEY (`codigoDocumento`) REFERENCES `tipodocumento` (`codigoDocumento`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD CONSTRAINT `fk_proveedores_ciudad` FOREIGN KEY (`codigoCiudad`) REFERENCES `ciudad` (`codigoCiudad`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `reportes`
--
ALTER TABLE `reportes`
  ADD CONSTRAINT `fk_reportes_empleados1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `sublineaproducto`
--
ALTER TABLE `sublineaproducto`
  ADD CONSTRAINT `fk_sublineaproducto_lineaproducto1` FOREIGN KEY (`idLinea`) REFERENCES `lineaproducto` (`idLinea`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `turnocaja`
--
ALTER TABLE `turnocaja`
  ADD CONSTRAINT `fk_controlCaja_caja1` FOREIGN KEY (`codCaja`) REFERENCES `caja` (`codigoCaja`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_controlCaja_usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_empleados_cargos1` FOREIGN KEY (`idCargo`) REFERENCES `cargos` (`idCargo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_empleados_tipoidentidad1` FOREIGN KEY (`idTipoIdentidad`) REFERENCES `tipoidentidad` (`idTipoIdentidad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_usuario_horariolaboral1` FOREIGN KEY (`idHorario`) REFERENCES `horariolaboral` (`idHorario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_usuario_rol1` FOREIGN KEY (`idRol`) REFERENCES `rol` (`idRol`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
