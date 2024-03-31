CREATE DATABASE  IF NOT EXISTS `fastdevelopment`;
USE `fastdevelopment`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: fastdevelopment
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.31-MariaDB

--
-- Table structure for table `personas`
--
DROP TABLE IF EXISTS `personas`;
CREATE TABLE `personas` (
  `id_persona_rut` int(11) NOT NULL,
  `dv_persona` varchar(1) NOT NULL,
  `tipo_persona` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apaterno` varchar(20) NOT NULL,
  `amaterno` varchar(20) NOT NULL,
  `direccion` int(11) NOT NULL,
  `telefono` int(11) NOT NULL,
  `email` int(11) NOT NULL,
  `dia_contrato` int(11) DEFAULT NULL,
  `mes_contrato` int(11) DEFAULT NULL,
  `year_contrato` int(11) DEFAULT NULL,
  `dia_incorporacion` int(11) DEFAULT NULL,
  `mes_incorporacion` int(11) DEFAULT NULL,
  `year_incorporacion` int(11) DEFAULT NULL,
  `estado` int(11) NOT NULL,
  PRIMARY KEY (`id_persona_rut`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
--
-- Table structure for table `telefono`
--
DROP TABLE IF EXISTS `telefono`;
CREATE TABLE `telefono` (
  `id_telefono` int(11) NOT NULL AUTO_INCREMENT,
  `telefono` varchar(15) NOT NULL,
  PRIMARY KEY (`id_telefono`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
--
-- Table structure for table `editorial`
--
DROP TABLE IF EXISTS `editorial`;
CREATE TABLE `editorial` (
  `id_editorial` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `estado` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_editorial`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
--
-- Table structure for table `email`
--
DROP TABLE IF EXISTS `email`;
CREATE TABLE `email` (
  `id_email` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`id_email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
--
-- Table structure for table `estado`
--
DROP TABLE IF EXISTS `estado`;
CREATE TABLE `estado` (
  `id_estado` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`id_estado`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
--
-- Table structure for table `forma_pago`
--
DROP TABLE IF EXISTS `forma_pago`;
CREATE TABLE `forma_pago` (
  `id_tipo` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`id_tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
--
-- Table structure for table `idioma`
--
DROP TABLE IF EXISTS `idioma`;
CREATE TABLE `idioma` (
  `id_idioma` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `estado` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_idioma`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
--
-- Table structure for table `distribuidores`
--
DROP TABLE IF EXISTS `distribuidores`;
CREATE TABLE `distribuidores` (
  `id_distribuidor_rut` int(11) NOT NULL,
  `dv_distribuidor` varchar(1) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `estado` int(11) NOT NULL,
  `year_incorporacion` int(11) NOT NULL,
  PRIMARY KEY (`id_distribuidor_rut`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
--
-- Table structure for table `direccion`
--
DROP TABLE IF EXISTS `direccion`;
CREATE TABLE `direccion` (
  `id_direccion` int(11) NOT NULL AUTO_INCREMENT,
  `direccion` varchar(45) NOT NULL,
  PRIMARY KEY (`id_direccion`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
--
-- Table structure for table `categoria`
--
DROP TABLE IF EXISTS `categoria`;
CREATE TABLE `categoria` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `estado` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
--
-- Table structure for table `autores`
--
DROP TABLE IF EXISTS `autores`;
CREATE TABLE `autores` (
  `id_autor` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `estado` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_autor`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
--
-- Table structure for table `libros`
--
DROP TABLE IF EXISTS `libros`;
CREATE TABLE `libros` (
  `id_libro_serie` varchar(20) NOT NULL,
  `isbn` varchar(20) NOT NULL,
  `titulo` varchar(45) NOT NULL,
  `npaginas` int(11) NOT NULL,
  `precio_referencias` int(11) NOT NULL,
  `yearr` int(11) NOT NULL,
  `id_idioma` int(11) NOT NULL,
  `autor` int(11) NOT NULL,
  `categoria` int(11) NOT NULL,
  `id_editorial` int(11) NOT NULL,
  `estado` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `en_arriendo` int(11) NOT NULL,
  `valor_venta` int(11) NOT NULL,
  `valor_arriendo` int(11) NOT NULL,
  PRIMARY KEY (`id_libro_serie`),
  KEY `fk_l_idioma_idx` (`id_idioma`),
  KEY `fk_l_editorial_idx` (`id_editorial`),
  CONSTRAINT `fk_l_editorial` FOREIGN KEY (`id_editorial`) REFERENCES `editorial` (`id_editorial`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_l_idioma` FOREIGN KEY (`id_idioma`) REFERENCES `idioma` (`id_idioma`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
--
-- Table structure for table `parametros`
--
DROP TABLE IF EXISTS `parametros`;
CREATE TABLE `parametros` (
  `id_parametros` int(11) NOT NULL,
  `impuesto_iva` int(11) NOT NULL,
  `multa_atraso_diario` int(11) NOT NULL,
  `descuento_especial` int(11) NOT NULL,
  `monto_minimo_descuento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
--
-- Table structure for table `arriendos_de_libros`
--
DROP TABLE IF EXISTS `arriendos_de_libros`;
CREATE TABLE `arriendos_de_libros` (
  `id_folio_comprobante_arriendo` bigint(20) NOT NULL AUTO_INCREMENT,
  `costo_arriendo` int(11) NOT NULL,
  `dia_arriendo` int(11) NOT NULL,
  `mes_arriendo` int(11) NOT NULL,
  `year_arriendo` int(11) NOT NULL,
  `dia_devolucion_estimada` int(11) NOT NULL,
  `mes_devolucion_estimada` int(11) NOT NULL,
  `year_devolucion_estimada` int(11) NOT NULL,
  `dia_devolucion_real` int(11) NOT NULL,
  `mes_devolucion_real` int(11) NOT NULL,
  `year_devolucion_real` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_trabajador` int(11) NOT NULL,
  `id_fpago` int(11) NOT NULL,
  `cuotas` int(11) NOT NULL,
  `libros_arrendados` int(11) NOT NULL,
  `estado` int(11) NOT NULL,
  PRIMARY KEY (`id_folio_comprobante_arriendo`),
  KEY `fk_id_cliente_idx` (`id_cliente`),
  KEY `fk_id_trabajador_idx` (`id_trabajador`),
  KEY `fk_id_fpago_idx` (`id_fpago`),
  CONSTRAINT `fk_adl_id_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `personas` (`id_persona_rut`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_adl_id_fpago` FOREIGN KEY (`id_fpago`) REFERENCES `forma_pago` (`id_tipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_adl_id_trabajador` FOREIGN KEY (`id_trabajador`) REFERENCES `personas` (`id_persona_rut`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
--
-- Table structure for table `arriendos_detalle`
--
DROP TABLE IF EXISTS `arriendos_detalle`;
CREATE TABLE `arriendos_detalle` (
  `id_folio_comprobante_arriendo` bigint(20) NOT NULL,
  `serie` varchar(20) NOT NULL,
  `cantidad_libro` int(11) NOT NULL,
  `valor_arriendo` int(11) NOT NULL,
  `estado` int(11) NOT NULL,
  KEY `fk_serie_idx` (`serie`),
  KEY `fk_id_foliocomprobante_arriendo_idx` (`id_folio_comprobante_arriendo`),
  CONSTRAINT `fk_ad_id_folio_comprobante_arriendo` FOREIGN KEY (`id_folio_comprobante_arriendo`) REFERENCES `arriendos_de_libros` (`id_folio_comprobante_arriendo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ad_serie` FOREIGN KEY (`serie`) REFERENCES `libros` (`id_libro_serie`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='detalle de la boleta';
--
-- Table structure for table `compras_de_libros`
--
DROP TABLE IF EXISTS `compras_de_libros`;
CREATE TABLE `compras_de_libros` (
  `id_compras` int(11) NOT NULL AUTO_INCREMENT,
  `id_distribuidor` int(11) NOT NULL,
  `folio_factura` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `dia_compra` int(11) NOT NULL,
  `mes_compra` int(11) NOT NULL,
  `year_compra` int(11) NOT NULL,
  `hora_compra` int(11) NOT NULL,
  `minuto_compra` int(11) NOT NULL,
  `segundo_compra` int(11) NOT NULL,
  `id_fpago` int(11) NOT NULL,
  `cuotas` int(11) NOT NULL,
  `glosa` varchar(100) NOT NULL,
  `numero_libros` int(11) NOT NULL,
  PRIMARY KEY (`id_compras`),
  UNIQUE KEY `UC_Compra` (`id_distribuidor`,`folio_factura`),
  KEY `fk_id_fpago_idx` (`id_fpago`),
  KEY `fk_id_distribuidor_idx` (`id_distribuidor`),
  CONSTRAINT `fk_cl_id_distribuidor` FOREIGN KEY (`id_distribuidor`) REFERENCES `distribuidores` (`id_distribuidor_rut`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cl_id_fpago` FOREIGN KEY (`id_fpago`) REFERENCES `forma_pago` (`id_tipo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
--
-- Table structure for table `compras_detalle`
--
DROP TABLE IF EXISTS `compras_detalle`;
CREATE TABLE `compras_detalle` (
  `id_compras` int(11) NOT NULL,
  `id_libro` varchar(20) NOT NULL,
  `cantidad_libro` int(11) NOT NULL,
  `precio_referencia` int(11) NOT NULL,
  KEY `fk_id_libro_idx` (`id_libro`),
  KEY `fk_id_compras_idx` (`id_compras`),
  CONSTRAINT `fk_cd_id_compra` FOREIGN KEY (`id_compras`) REFERENCES `compras_de_libros` (`id_compras`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cd_id_libro` FOREIGN KEY (`id_libro`) REFERENCES `libros` (`id_libro_serie`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='detalle de la boleta';
--
-- Table structure for table `libroautores`
--
DROP TABLE IF EXISTS `libroautores`;
CREATE TABLE `libroautores` (
  `id_libro` varchar(20) NOT NULL,
  `id_autor` int(11) NOT NULL,
  KEY `fk_id_libro_idx` (`id_libro`),
  KEY `fk_id_autor_idx` (`id_autor`),
  CONSTRAINT `fk_da_id_autor` FOREIGN KEY (`id_autor`) REFERENCES `autores` (`id_autor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_da_id_libro` FOREIGN KEY (`id_libro`) REFERENCES `libros` (`id_libro_serie`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
--
-- Table structure for table `librocategoria`
--
DROP TABLE IF EXISTS `librocategoria`;
CREATE TABLE `librocategoria` (
  `id_libro` varchar(20) NOT NULL,
  `id_categoria` int(11) NOT NULL,
  KEY `fk_id_libros_idx` (`id_libro`),
  KEY `fk_id_categoria_idx` (`id_categoria`),
  CONSTRAINT `fk_dc_id_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_dc_id_libros` FOREIGN KEY (`id_libro`) REFERENCES `libros` (`id_libro_serie`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
--
-- Table structure for table `personadireccion`
--
DROP TABLE IF EXISTS `personadireccion`;
CREATE TABLE `personadireccion` (
  `id_persona` int(11) NOT NULL,
  `id_direccion` int(11) NOT NULL,
  `id_estado` int(11) NOT NULL,
  KEY `fk_id_persona_idx` (`id_persona`),
  KEY `fk_id_direccion_idx` (`id_direccion`),
  KEY `fk_dd_id_estado_idx` (`id_estado`),
  CONSTRAINT `fk_dd_id_direccion` FOREIGN KEY (`id_direccion`) REFERENCES `direccion` (`id_direccion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_dd_id_estado` FOREIGN KEY (`id_estado`) REFERENCES `estado` (`id_estado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_dd_id_persona` FOREIGN KEY (`id_persona`) REFERENCES `personas` (`id_persona_rut`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
--
-- Table structure for table `personaemail`
--
DROP TABLE IF EXISTS `personaemail`;
CREATE TABLE `personaemail` (
  `id_persona` int(11) NOT NULL,
  `id_email` int(11) NOT NULL,
  `id_estado` int(11) NOT NULL,
  KEY `fk_id_persona_idx` (`id_persona`),
  KEY `fk_id_email_idx` (`id_email`),
  KEY `fk_id_estado_idx` (`id_estado`),
  CONSTRAINT `fk_de_id_email` FOREIGN KEY (`id_email`) REFERENCES `email` (`id_email`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_de_id_estado` FOREIGN KEY (`id_estado`) REFERENCES `estado` (`id_estado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_de_id_persona` FOREIGN KEY (`id_persona`) REFERENCES `personas` (`id_persona_rut`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
--
-- Table structure for table `personatelefono`
--
DROP TABLE IF EXISTS `personatelefono`;
CREATE TABLE `personatelefono` (
  `id_persona` int(11) NOT NULL,
  `id_telefono` int(11) NOT NULL,
  `id_estado` int(11) NOT NULL,
  KEY `fk_id_persona_idx` (`id_persona`),
  KEY `fk_id_telefono_idx` (`id_telefono`),
  KEY `fk_id_estado_idx` (`id_estado`),
  CONSTRAINT `fk_dt_id_estado` FOREIGN KEY (`id_estado`) REFERENCES `estado` (`id_estado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_dt_id_persona` FOREIGN KEY (`id_persona`) REFERENCES `personas` (`id_persona_rut`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_dt_id_telefono` FOREIGN KEY (`id_telefono`) REFERENCES `telefono` (`id_telefono`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
--
-- Table structure for table `ventas_de_libros`
--
DROP TABLE IF EXISTS `ventas_de_libros`;
CREATE TABLE `ventas_de_libros` (
  `id_folio_boleta` bigint(20) NOT NULL AUTO_INCREMENT,
  `total` int(11) NOT NULL,
  `dia` int(11) NOT NULL,
  `mes` int(11) NOT NULL,
  `yearr` int(11) NOT NULL,
  `hora_venta` time NOT NULL,
  `id_fpago` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_trabajador` int(11) NOT NULL,
  `cuotas` int(11) NOT NULL,
  `glosa` varchar(100) NOT NULL,
  `librosvendidos` int(11) NOT NULL,
  PRIMARY KEY (`id_folio_boleta`),
  KEY `fk_id_cliente_idx` (`id_cliente`),
  KEY `fk_id_trabajador_idx` (`id_trabajador`),
  KEY `fk_id_fpago_idx` (`id_fpago`),
  CONSTRAINT `fk_vdl_id_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `personas` (`id_persona_rut`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_vdl_id_fpago` FOREIGN KEY (`id_fpago`) REFERENCES `forma_pago` (`id_tipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_vdl_id_trabajador` FOREIGN KEY (`id_trabajador`) REFERENCES `personas` (`id_persona_rut`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='registro de venta';
--
-- Table structure for table `ventas_detalle`
--
DROP TABLE IF EXISTS `ventas_detalle`;
CREATE TABLE `ventas_detalle` (
  `id_folio_boleta` bigint(20) NOT NULL,
  `serie` varchar(20) NOT NULL,
  `cantidad_libro` int(11) NOT NULL,
  `valor_venta` int(11) NOT NULL,
  KEY `fk_id_folio_boleta_idx` (`id_folio_boleta`),
  KEY `fk_serie_idx` (`serie`),
  CONSTRAINT `fk_vd_id_folio_boleta` FOREIGN KEY (`id_folio_boleta`) REFERENCES `ventas_de_libros` (`id_folio_boleta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_vd_serie` FOREIGN KEY (`serie`) REFERENCES `libros` (`id_libro_serie`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='detalle de la boleta';

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscarUltimoFolio`(IN folio BIGINT, OUT ultimoFolio BIGINT)
BEGIN
     SET ultimoFolio = (SELECT MAX(id_folio_boleta) AS id FROM ventas_de_libros);
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscarUltimoFolioComprobante`(IN folio BIGINT, OUT ultimoFolio BIGINT)
BEGIN
     SET ultimoFolio = (SELECT MAX(id_folio_comprobante_arriendo) AS id FROM arriendos_de_libros);
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_cambiaEstadoAutor`(
  IN Xid_autor INT,
  IN Xestado Boolean
)
BEGIN
UPDATE autores 
SET estado = Xestado 
WHERE id_autor=Xid_autor
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_cambiaEstadoCategoria`(
  IN Xid_categoria INT,
  IN Xestado Boolean
)
BEGIN
UPDATE categoria
SET estado = Xestado 
WHERE id_categoria=Xid_categoria
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_cambiaEstadoEditorial`(
  IN Xid_editorial INT,
  IN Xestado Boolean
)
BEGIN
UPDATE editorial
SET estado = Xestado 
WHERE id_editorial=Xid_editorial
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_cambiaEstadoIdioma`(
  IN Xid_idioma INT,
  IN Xestado Boolean
)
BEGIN
UPDATE idioma
SET estado = Xestado 
WHERE id_idioma=Xid_idioma
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_creaParametros`()
BEGIN
INSERT INTO `parametros` VALUES (1,19,1,5,100000);
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_deleteA`(
  IN Xid_autor INT
)
BEGIN
  UPDATE autores SET estado = false  
  WHERE id_autor = Xid_autor
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_deleteC`(
  IN Xid_categoria INT
)
BEGIN
  UPDATE categoria SET estado = false  
  WHERE id_categoria = Xid_categoria
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_deleteEd`(
  IN Xid_editorial INT
)
BEGIN
  UPDATE editorial SET estado = false  
  WHERE id_editorial = Xid_editorial
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_deleteI`(
  IN Xid_idioma INT
)
BEGIN
  UPDATE idioma SET estado = false  
  WHERE id_idioma = Xid_idioma
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_deleteLibroAutor`(
  IN Xid_libro VARCHAR(20)
)
BEGIN
  DELETE FROM libroautores  
  WHERE id_libro = Xid_libro
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_deleteLibroCategoria`(
  IN Xid_libro VARCHAR(20)
)
BEGIN
  DELETE FROM librocategoria  
  WHERE id_libro = Xid_libro
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertA`(
  IN p1 VARCHAR(45)
)
BEGIN
  INSERT INTO autores (
  nombre,
  estado) 
  VALUES (
  p1,
  true
  );
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertArriendo`(
  IN Xid_folio_comprobante_arriendo BIGINT,
  IN Xcosto_arriendo INT,
  IN Xdia_arriendo INT,
  IN Xmes_arriendo INT,
  IN Xyear_arriendo INT,
  IN Xdia_devolucion_estimada INT,
  IN Xmes_devolucion_estimada INT,
  IN Xyear_devolucion_estimada INT,
  IN Xdia_devolucion_real INT,
  IN Xmes_devolucion_real INT,
  IN Xyear_devolucion_real INT,
  IN Xid_cliente INT,
  IN Xid_trabajador INT,
  IN Xid_fpago INT,
  IN Xcuotas INT,
  IN Xlibros_arrendados INT,
  IN Xestado INT
)
BEGIN
  INSERT INTO arriendos_de_libros (
  id_folio_comprobante_arriendo,
  costo_arriendo,
  dia_arriendo,
  mes_arriendo,
  year_arriendo,
  dia_devolucion_estimada,
  mes_devolucion_estimada,
  year_devolucion_estimada,
  dia_devolucion_real,
  mes_devolucion_real,
  year_devolucion_real,
  id_cliente,
  id_trabajador,
  id_fpago,
  cuotas,
  libros_arrendados,
  estado
  ) 
  VALUES (
  Xid_folio_comprobante_arriendo,
  Xcosto_arriendo,
  Xdia_arriendo,
  Xmes_arriendo,
  Xyear_arriendo,
  Xdia_devolucion_estimada,
  Xmes_devolucion_estimada,
  Xyear_devolucion_estimada,
  Xdia_devolucion_real,
  Xmes_devolucion_real,
  Xyear_devolucion_real,
  Xid_cliente,
  Xid_trabajador,
  Xid_fpago,
  Xcuotas,
  Xlibros_arrendados,
  Xestado
  );
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertArriendosDetalle`(
  IN Xid_folio_comprobante_arriendo BIGINT,
  IN Xserie VARCHAR(20),
  IN Xcantidad_libro INT,
  IN Xvalor_arriendo INT,
  IN Xestado INT
)
BEGIN
  INSERT INTO arriendos_detalle (
  id_folio_comprobante_arriendo,
  serie,
  cantidad_libro,
  valor_arriendo,
  estado
  ) 
  VALUES (
  Xid_folio_comprobante_arriendo,
  Xserie,
  Xcantidad_libro,
  Xvalor_arriendo,
  Xestado
  );
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertC`(
  IN p1 VARCHAR(30)
)
BEGIN
  INSERT INTO categoria (
  nombre,
  estado) 
  VALUES (
  p1,
  true
  );
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertCD`(
  IN id_compras INT,
  IN id_libro  VARCHAR(20),
  IN cantidad_libro INT,
  IN precio_referencia INT
)
BEGIN
  INSERT INTO compras_detalle (
  id_compras,
  id_libro,
  cantidad_libro,
  precio_referencia) 
  VALUES (
  Xid_compras,
  Xid_libro,
  Xcantidad_libro,
  Xprecio_referencia
  );
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertCDL`(
  IN Xid_distribuidor INT,
  IN Xfolio_factura INT,
  IN Xtotal INT,
  IN Xdia_compra INT,
  IN Xmes_compra INT,
  IN Xyear_compra INT,
  IN Xhora_compra INT,
  IN Xminuto_compra INT,
  IN Xsegundo_compra INT,
  IN Xid_fpago INT,
  IN Xcuotas INT,
  IN Xglosa VARCHAR(100),
  IN Xnumero_libros INT
  )
BEGIN
  INSERT INTO compras_de_libros (
  id_distribuidor,
  folio_factura,
  total,
  dia_compra,
  mes_compra,
  year_compra,
  hora_compra,
  minuto_compra,
  segundo_compra,
  id_fpago,
  cuotas,
  glosa,
  numero_libros
  ) 
  VALUES (
  Xid_distribuidor,
  Xfolio_factura,
  Xtotal,
  Xdia_compra,
  Xmes_compra,
  Xyear_compra,
  Xhora_compra,
  Xminuto_compra,
  Xsegundo_compra,
  Xid_fpago,
  Xcuotas,
  Xglosa,
  Xnumero_libros
  );
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertComprasDetalle`(
  IN Xid_compras INT,
  IN Xid_libro VARCHAR(20),
  IN Xcantidad_libro INT,
  IN Xprecio_referencia INT
)
BEGIN
  INSERT INTO compras_detalle (
  id_compras,
  id_libro,
  cantidad_libro,
  precio_referencia
  ) 
  VALUES (
  Xid_compras,
  Xid_libro,
  Xcantidad_libro,
  Xprecio_referencia
  )
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertDireccion`(
 IN p1 VARCHAR(45)
)
BEGIN
  INSERT INTO direccion (
  direccion) 
  VALUES (
  p1
  );
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertDistribuidor`(
  IN Xid_distribuidor_rut INT,
  IN Xdv_distribuidor INT,
  IN Xnombre VARCHAR(30),
  IN Xdireccion VARCHAR(45),
  IN Xtelefono VARCHAR(15),
  IN Xestado INT,
  IN Xyear_incorporacion INT
)
BEGIN
  INSERT INTO distribuidores (
  id_distribuidor_rut,
  dv_distribuidor,
  nombre,
  direccion,
  telefono,
  estado,
  year_incorporacion
  )
  VALUES (
  Xid_distribuidor_rut,
  Xdv_distribuidor,
  Xnombre,
  Xdireccion,
  Xtelefono,
  Xestado,
  Xyear_incorporacion
  );
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertEditorial`(
  IN p1 VARCHAR(45)
)
BEGIN
  INSERT INTO editorial (
  nombre,
  estado) 
  VALUES (
  p1,
  true
  );
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertEmail`(
  IN p1 VARCHAR(45)
)
BEGIN
  INSERT INTO email (
  email) 
  VALUES (
  p1
  );
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertEstado`(
IN Xdescripcion VARCHAR(45) 
)
BEGIN
INSERT INTO estado (
descripcion
)
VALUES (
Xdescripcion
);
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertFP`(
  IN p1 VARCHAR(45)
)
BEGIN
  INSERT INTO forma_persona (
  descripcion) 
  VALUES (
  p1
  );
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertI`(
  IN p1 VARCHAR(45)
)
BEGIN
  INSERT INTO idioma (
  nombre,
  estado) 
  VALUES (
  p1,
  true
  );
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertL`(
  IN Xid_libro_serie VARCHAR(20),
  IN Xisbn VARCHAR(20),
  IN Xtitulo VARCHAR(45),
  IN Xnpaginas INT,
  IN Xprecio_referencias INT,
  IN Xyearr INT,
  IN Xid_idioma INT,
  IN Xautor INT,
  IN Xcategoria INT,
  IN Xid_editorial INT,
  IN Xestado INT,
  IN Xstock INT,
  IN Xen_arriendo INT,
  IN Xvalor_venta INT,
  IN Xvalor_arriendo INT
)
BEGIN
  INSERT INTO libros (
  id_libro_serie,
  isbn,
  titulo,
  npaginas,
  precio_referencias,
  yearr,
  id_idioma,
  autor,
  categoria,
  id_editorial,
  estado,
  stock,
  en_arriendo,
  valor_venta,
  valor_arriendo
)
  VALUES (
  Xid_libro_serie,
  Xisbn,
  Xtitulo,
  Xnpaginas,
  Xprecio_referencias,
  Xyearr,
  Xid_idioma,
  Xautor,
  Xcategoria,
  Xid_editorial,
  Xestado,
  Xstock,
  Xen_arriendo,
  Xvalor_venta,
  Xvalor_arriendo
  );
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertLibroAutores`(
  IN Xid_libro VARCHAR(20),
  IN Xid_autor INT
)
BEGIN
  INSERT INTO libroautores (
  id_libro,
  id_autor
  ) 
  VALUES (
  Xid_libro,
  Xid_autor
  );
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertLibroCategoria`(
  IN Xid_libro VARCHAR(20),
  IN Xid_categoria INT
)
BEGIN
  INSERT INTO librocategoria (
  id_libro,
  id_categoria
  ) 
  VALUES (
  Xid_libro,
  Xid_categoria
  );
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertPersonaDireccion`(
  IN Xid_persona INT,
  IN Xid_direccion INT,
  IN Xid_estado INT
)
BEGIN
  INSERT INTO personadireccion (
  id_persona,
  id_direccion,
  id_estado) 
  VALUES (
  Xid_persona,
  Xid_direccion,
  Xid_estado
  );
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertPersonaEmail`(
  IN Xid_persona INT,
  IN Xid_email INT,
  IN Xid_estado INT
)
BEGIN
  INSERT INTO personaemail (
  id_persona,
  id_email,
  id_estado) 
  VALUES (
  Xid_persona,
  Xid_email,
  Xid_estado
  );
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertPersonas`(
  IN Xid_persona_rut INT,
  IN Xdv_persona INT,
  IN Xtipo_persona INT,
  IN Xnombre VARCHAR(30),
  IN Xapaterno VARCHAR(20),
  IN Xamaterno VARCHAR(20),
  IN Xdireccion INT,
  IN Xtelefono INT,
  IN Xemail INT,
  IN Xdia_contrato INT,
  IN Xmes_contrato INT,
  IN Xyear_contrato INT,
  IN Xdia_incorporacion INT,
  IN Xmes_incorporacion INT,
  IN Xyear_incorporacion INT,
  IN Xestado INT
)
BEGIN
INSERT INTO personas (
  id_persona_rut,
  dv_persona,
  tipo_persona,
  nombre,
  apaterno,
  amaterno,
  direccion,
  telefono,
  email,
  dia_contrato,
  mes_contrato,
  year_contrato,
  dia_incorporacion,
  mes_incorporacion,
  year_incorporacion,
  estado)
VALUES(
  Xid_persona_rut,
  Xdv_persona,
  Xtipo_persona,
  Xnombre,
  Xapaterno,
  Xamaterno,
  Xdireccion,
  Xtelefono,
  Xemail,
  Xdia_contrato,
  Xmes_contrato,
  Xyear_contrato,
  Xdia_incorporacion,
  Xmes_incorporacion,
  Xyear_incorporacion,
  Xestado);
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertPersonaTelefono`(
  IN Xid_persona INT,
  IN Xid_telefono INT,
  IN Xid_estado INT
)
BEGIN
  INSERT INTO personatelefono (
  id_persona,
  id_telefono,
  id_estado) 
  VALUES (
  Xid_persona,
  Xid_telefono,
  Xid_estado
  );
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertTelefono`(
  IN p1 VARCHAR(15)
)
BEGIN
  INSERT INTO telefono (
  telefono) 
  VALUES (
  p1
  );
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertVenta`(
  IN Xid_folio_boleta BIGINT,
  IN Xtotal INT,
  IN Xdia INT,
  IN Xmes INT,
  IN Xyearr INT,
  IN Xhora_venta TIME,
  IN Xid_fpago INT,
  IN Xid_cliente INT,
  IN Xid_trabajador INT,
  IN Xcuotas INT,
  IN Xglosa VARCHAR(100),
  IN Xlibrosvendidos INT
)
BEGIN
  INSERT INTO ventas_de_libros (
  id_folio_boleta,
  total,
  dia,
  mes,
  yearr,
  hora_venta,
  id_fpago,
  id_cliente,
  id_trabajador,
  cuotas,
  glosa,
  librosvendidos
  ) 
  VALUES (
  Xid_folio_boleta,
  Xtotal,
  Xdia,
  Xmes,
  Xyearr,
  Xhora_venta,
  Xid_fpago,
  Xid_cliente,
  Xid_trabajador,
  Xcuotas,
  Xglosa,
  Xlibrosvendidos
  );
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertVentasDetalle`(
  IN Xid_folio_boleta BIGINT,
  IN Xserie VARCHAR(20),
  IN Xcantidad_libro INT,
  IN Xvalor_venta INT
)
BEGIN
  INSERT INTO ventas_detalle (
  id_folio_boleta,
  serie,
  cantidad_libro,
  valor_venta
  ) 
  VALUES (
  Xid_folio_boleta,
  Xserie,
  Xcantidad_libro,
  Xvalor_venta  );
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectA`(
  IN Xnombre VARCHAR(30)
)
BEGIN
  SELECT * FROM autores 
  WHERE nombre = Xnombre
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectAenLibros`(
  IN Xid_autor INT
)
BEGIN
  SELECT * FROM libros 
  WHERE autor = Xid_autor
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectAll`(
  IN Xid_parametros INT
)
BEGIN
SELECT * FROM parametros WHERE id_parametros = Xid_parametros 
;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectAllArriendos`()
BEGIN
  SELECT * FROM arriendos_de_libros
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectAllArriendosXcliente`(
  IN Xid_cliente INT
)
BEGIN
  SELECT * FROM arriendos_de_libros
  WHERE id_cliente = Xid_cliente
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectAllAutores`()
BEGIN
  SELECT * FROM autores 
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectAllCategorias`()
BEGIN
  SELECT * FROM categoria
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectAllCompras`()
BEGIN
  SELECT * FROM compras_de_libros 
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectAllDistribuidores`()
BEGIN
  SELECT * FROM distribuidores
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectAllEditoriales`()
BEGIN
  SELECT * FROM editorial
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectAllIdiomas`()
BEGIN
  SELECT * FROM idioma
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectAllLibroAutor`(
  IN Xid_libro VARCHAR(20)
)
BEGIN
  SELECT * FROM libroautores  
  WHERE id_libro = Xid_libro
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectAllLibroCategoria`(
  IN Xid_libro VARCHAR(20)
)
BEGIN
  SELECT * FROM librocategoria
  WHERE id_libro = Xid_libro
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectAllLibros`()
BEGIN
  SELECT * FROM libros 
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectAllLibrosParametro`(
  IN Xbuscar VARCHAR(45)
)
BEGIN
  SELECT * FROM libros 
  WHERE titulo LIKE concat("%",Xbuscar,"%")
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectAllLibrosParametroSerie`(
  IN Xbuscar VARCHAR(20)
)
BEGIN
  SELECT * FROM libros 
  WHERE id_libro_serie LIKE concat("%",Xbuscar,"%")
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectAllPersonaDireccion`(
  IN Xid_persona INT
)
BEGIN
  SELECT * FROM personadireccion
  WHERE id_persona = Xid_persona
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectAllPersonaEmail`(
  IN Xid_persona INT
)
BEGIN
  SELECT * FROM personaemail
  WHERE id_persona = Xid_persona
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectAllPersonas`()
BEGIN
  SELECT * FROM personas                                                                  
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectAllPersonaTelefono`(
  IN Xid_persona INT
)
BEGIN
  SELECT * FROM personatelefono
  WHERE id_persona = Xid_persona
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectArriendos`(
  IN Xid_folio_comprobante_arriendo BIGINT
)
BEGIN
  SELECT * FROM arriendos_de_libros
  WHERE id_folio_comprobante_arriendo = Xid_folio_comprobante_arriendo
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectArriendosXfolio`(
  IN Xid_folio_comprobante_arriendo BIGINT
)
BEGIN
  SELECT * FROM arriendos_detalle
  WHERE id_folio_comprobante_arriendo = Xid_folio_comprobante_arriendo
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectAxId`(
  IN Xid_autor INT
)
BEGIN
  SELECT * FROM autores 
  WHERE id_autor = Xid_autor
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectC`(
  IN Xnombre VARCHAR(30)
)
BEGIN
  SELECT * FROM categoria 
  WHERE nombre = Xnombre
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectCenLibros`(
  IN Xid_categoria INT
)
BEGIN
  SELECT * FROM libros 
  WHERE categoria = Xid_categoria
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectCompras`(
  IN Xid_distribuidor INT,
  IN Xfolio_factura INT  
)
BEGIN
  SELECT * FROM compras_de_libros 
  WHERE id_distribuidor=Xid_distribuidor
  AND folio_factura=Xfolio_factura
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectCxId`(
  IN Xid_categoria INT
)
BEGIN
  SELECT * FROM categoria 
  WHERE id_categoria = Xid_categoria
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectDireccion`(
 IN Xid_direccion INT
)
BEGIN
  SELECT * FROM direccion
  WHERE id_direccion=Xid_direccion
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectDistribuidorEnCompras`(
  IN Xid_distribuidor INT
)
BEGIN
  SELECT * FROM compras_de_libros 
  WHERE id_distribuidor=Xid_distribuidor
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectDistribuidorXrut`(
  IN Xid_distribuidor_rut INT
)
BEGIN
  SELECT * FROM distribuidores 
  WHERE id_distribuidor_rut = Xid_distribuidor_rut
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectE`(
  IN Xnombre VARCHAR(30)
)
BEGIN
  SELECT * FROM editorial 
  WHERE nombre = Xnombre
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectEenLibros`(
  IN Xid_editorial INT
)
BEGIN
  SELECT * FROM libros 
  WHERE id_editorial = Xid_editorial
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectEmail`(
 IN Xid_email INT
)
BEGIN
  SELECT * FROM email
  WHERE id_email=Xid_email
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectExId`(
  IN Xid_editorial INT
)
BEGIN
  SELECT * FROM editorial
  WHERE id_editorial = Xid_editorial
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectI`(
  IN Xnombre VARCHAR(30)
)
BEGIN
  SELECT * FROM idioma 
  WHERE nombre = Xnombre
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectIenLibros`(
  IN Xid_idioma INT
)
BEGIN
  SELECT * FROM libros 
  WHERE id_idioma = Xid_idioma
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectIxId`(
  IN Xid_idioma INT
)
BEGIN
  SELECT * FROM idioma 
  WHERE id_idioma = Xid_idioma
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectL`(
  IN Xserie VARCHAR(20)
)
BEGIN
  SELECT * FROM libros 
  WHERE id_libro_serie = Xserie
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectLibroAutor`(
  IN Xid_libro VARCHAR(20)
)
BEGIN
  SELECT * FROM libroautores 
  WHERE id_libro = Xid_libro
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectLibroCategoria`(
  IN Xid_libro VARCHAR(20)
)
BEGIN
  SELECT * FROM librocategoria
  WHERE id_libro = Xid_libro
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectLibroEnCompras`(
  IN Xid_libro VARCHAR(20)
)
BEGIN
  SELECT * FROM compras_detalle 
  WHERE id_libro=Xid_libro
  ;
END ;;
DELIMITER ;
;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectPersonaXrut`(
  IN Xid_persona_rut INT
)
BEGIN
  SELECT * FROM personas 
  WHERE id_persona_rut = Xid_persona_rut
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectTelefono`(
 IN Xid_telefono INT
)
BEGIN
  SELECT * FROM telefono
  WHERE id_telefono=Xid_telefono
  ;
END ;;
DELIMITER ;
;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectVentas`(
  IN Xid_folio_boleta BIGINT
)
BEGIN
  SELECT * FROM ventas_de_libros
  WHERE id_folio_boleta = Xid_folio_boleta
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectXdireccion`(
  IN Xdireccion VARCHAR(45)
)
BEGIN
  SELECT * FROM direccion
  WHERE direccion = Xdireccion
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectXemail`(
  IN Xemail VARCHAR(45)
)
BEGIN
  SELECT * FROM email
  WHERE email = Xemail
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectXtelefono`(
  IN Xtelefono VARCHAR(15)
)
BEGIN
  SELECT * FROM telefono
  WHERE telefono = Xtelefono
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_updateA`(
  IN Xid_autor INT,
  IN Xnombre VARCHAR(30)
)
BEGIN
  UPDATE autores 
  SET nombre = Xnombre 
  WHERE id_autor = Xid_autor
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_updateArriendosDetalle`(
  IN Xid_folio_comprobante_arriendo BIGINT,
  IN Xserie VARCHAR(20)
)
BEGIN
  UPDATE arriendos_detalle
  SET estado = 0
  WHERE id_folio_comprobante_arriendo = Xid_folio_comprobante_arriendo 
        AND serie = Xserie
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_updateC`(
  IN Xid_categoria INT,
  IN Xnombre VARCHAR(30)
)
BEGIN
  UPDATE categoria 
  SET nombre = Xnombre 
  WHERE id_categoria = Xid_categoria
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_updateCDL`(
  IN Xid_compras INT,
  IN Xid_distribuidor INT,
  IN Xfolio_factura INT,
  IN Xtotal INT,
  IN Xdia_compra INT,
  IN Xmes_compra INT,
  IN Xyear_compra INT,
  IN Xhora_compra INT,
  IN Xminuto_compra INT,
  IN Xsegundo_compra INT,
  IN Xid_fpago INT,
  IN Xcuotas INT,
  IN Xglosa VARCHAR(100),
  IN Xnumero_libros INT
  )
BEGIN
  UPDATE compras_de_libros SET
  id_distribuidor=Xid_distribuidor,
  folio_factura=Xfolio_factura,
  total=Xtotal,
  dia_compra=Xdia_compra,
  mes_compra=Xmes_compra,
  year_compra=Xyear_compra,
  hora_compra=Xhora_compra,
  minuto_compra=Xminuto_compra,
  segundo_compra=Xsegundo_compra,
  id_fpago=Xid_fpago,
  cuotas=Xcuotas,
  glosa=Xglosa,
  numero_libros=Xnumero_libros
  WHERE
  id_compras=Xid_compras
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_updateDistribuidor`(
  IN Xid_distribuidor_rut INT,
  IN Xdv_distribuidor VARCHAR(1),
  IN Xnombre VARCHAR(30),
  IN Xdireccion VARCHAR(45),
  IN Xtelefono VARCHAR(15),
  IN Xestado INT,
  IN Xyear_incorporacion INT,
  IN Xglosa VARCHAR(100)
)
BEGIN
UPDATE distribuidores
SET dv_distribuidor=Xdv_distribuidor,
	nombre=Xnombre,
    direccion=Xdireccion,
    telefono=Xtelefono,
    estado=Xestado,
    year_incorporacion=Xyear_incorporacion,
    glosa=Xglosa
WHERE id_distribuidor_rut = Xid_distribuidor_rut
  ;

END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_updateE`(
  IN Xid_editorial INT,
  IN Xnombre VARCHAR(30)
)
BEGIN
  UPDATE editorial 
  SET nombre = Xnombre 
  WHERE id_editorial = Xid_editorial
  ;
END ;;
DELIMITER ;
 ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_updateI`(
  IN Xid_idioma INT,
  IN Xnombre VARCHAR(30)
)
BEGIN
  UPDATE idioma 
  SET nombre = Xnombre 
  WHERE id_iioma = Xid_autor
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_updateL`(
  IN Xid_libro_serie VARCHAR(20),
  IN Xisbn VARCHAR(20),
  IN Xtitulo VARCHAR(45),
  IN Xnpaginas INT,
  IN Xprecio_referencias INT,
  IN Xyearr INT,
  IN Xid_idioma INT,
  IN Xautor INT,
  IN Xcategoria INT,
  IN Xid_editorial INT,
  IN Xestado INT,
  IN Xstock INT,
  IN Xen_arriendo INT,
  IN Xvalor_venta INT,
  IN Xvalor_arriendo INT
)
BEGIN

UPDATE libros SET 
  isbn=Xisbn,
  titulo=Xtitulo,
  npaginas=Xnpaginas,
  precio_referencias=Xprecio_referencias,
  yearr=Xyearr,
  id_idioma=Xid_idioma,
  autor=Xautor,
  categoria=Xcategoria,
  id_editorial=Xid_editorial,
  estado=Xestado,
  stock=Xstock,
  en_arriendo=Xen_arriendo,
  valor_venta=Xvalor_venta,
  valor_arriendo=Xvalor_arriendo
  WHERE id_libro_serie=Xid_libro_serie;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_updateParametros`(
  IN Xid_parametros INT,
  IN Ximpuesto_iva INT,
  IN Xmulta_atraso_diario INT,
  IN Xdescuento_especial INT,
  IN Xmonto_minimo_descuento INT
  )
BEGIN
  UPDATE parametros SET
  impuesto_iva=Ximpuesto_iva,
  multa_atraso_diario=Xmulta_atraso_diario,
  descuento_especial=Xdescuento_especial,
  monto_minimo_descuento=Xmonto_minimo_descuento
  WHERE id_parametros=Xid_parametros
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_updatePersonas`(
  IN Xid_persona_rut INT,
  IN Xdv_persona INT,
  IN Xtipo_persona INT,
  IN Xnombre VARCHAR(30),
  IN Xapaterno VARCHAR(20),
  IN Xamaterno VARCHAR(20),
  IN Xdireccion INT,
  IN Xtelefono INT,
  IN Xemail INT,
  IN Xdia_contrato INT,
  IN Xmes_contrato INT,
  IN Xyear_contrato INT,
  IN Xdia_incorporacion INT,
  IN Xmes_incorporacion INT,
  IN Xyear_incorporacion INT,
  IN Xestado INT
)
BEGIN
UPDATE personas 
SET 
  dv_persona=Xdv_persona,
  tipo_persona=Xtipo_persona,
  nombre=Xnombre,
  apaterno=Xapaterno,
  amaterno=Xamaterno,
  direccion=Xdireccion,
  telefono=Xtelefono,
  email=Xemail,
  dia_contrato=Xdia_contrato,
  mes_contrato=Xmes_contrato,
  year_contrato=Xyear_contrato,
  dia_incorporacion=Xdia_incorporacion,
  mes_incorporacion=Xmes_incorporacion,
  year_incorporacion=Xyear_incorporacion,
  estado=Xestado
  WHERE id_persona_rut = Xid_persona_rut
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_updateStockArriendos`(
  IN Xid_libro_serie VARCHAR(20),
  IN Xen_arriendo INT
  )
BEGIN
  UPDATE libros SET
  en_arriendo=Xen_arriendo
  WHERE
  id_libro_serie=Xid_libro_serie
  ;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_updateStockYprecioLibro`(
  IN Xid_libro_serie VARCHAR(20),
  IN Xstock INT,
  IN Xprecio_referencias INT
  )
BEGIN
  UPDATE libros SET
  stock=Xstock,
  precio_referencias=Xprecio_referencias
  WHERE
  id_libro_serie=Xid_libro_serie
  ;
END ;;
DELIMITER ;


-- Dump completed on 2018-06-20  2:51:10
-- ------------------------------------------------------------  cambia estado de arriendo

DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_updateEstadoArriendo`(
  IN Xid_folio_comprobante_arriendo BIGINT,
  IN Xdia INT,
  IN Xmes INT,
  IN Xyear INT
)
BEGIN
  UPDATE arriendos_de_libros
  SET 
  estado = 0,
  dia_devolucion_real = Xdia,
  mes_devolucion_real = Xmes,
  year_devolucion_real = Xyear  
  WHERE id_folio_comprobante_arriendo = Xid_folio_comprobante_arriendo
  ;
END ;;
DELIMITER ;
-- ------------------------------------------------------------  cambia estado a bloqueado de arriendo
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_updateEstadoAbloqueado`(
  IN Xid_folio_comprobante_arriendo BIGINT
)
BEGIN
  UPDATE arriendos_de_libros
  SET estado = 2
  WHERE id_folio_comprobante_arriendo = Xid_folio_comprobante_arriendo
  ;
END ;;
DELIMITER ;
-- ----------------------------------------------------------------- busca todas las ventas
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectAllVentas`()
BEGIN
  SELECT * FROM ventas_de_libros 
  ;
END ;;
DELIMITER ;
-- ------------------------------------------------------------  cambia estado a bloqueado de arriendo
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_bloqueaPersonaXmora`(
  IN Xid_persona_rut INT
)
BEGIN
  UPDATE personas
  SET estado = 3
  WHERE id_persona_rut = Xid_persona_rut
  ;
END ;;
DELIMITER ;
-- -------------------------------------------------------- busca persona en ventas
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectPersonaEnVentas`(
  IN Xid_persona INT
)
BEGIN
  SELECT * FROM ventas_de_libros 
  WHERE id_cliente=Xid_persona OR
	    id_trabajador=Xid_persona
  ;
END ;;
DELIMITER ;
-- -------------------------------------------------------- busca persona en arriendos
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_selectPersonaEnArriendos`(
  IN Xid_persona INT
)
BEGIN
  SELECT * FROM arriendos_de_libros 
  WHERE id_cliente=Xid_persona OR
	    id_trabajador=Xid_persona
  ;
END ;;
DELIMITER ;
-- datos en duro para trabajar con las bases de datos
-- forma de pago
LOCK TABLES `forma_pago` WRITE;
INSERT INTO `forma_pago` VALUES (1,'Efectivo'),(2,'Cheque'),(3,'Cuotas');
UNLOCK TABLES;
-- estados de los registros
LOCK TABLES `estado` WRITE;
INSERT INTO `estado` VALUES (1,'VIGENTE'),(2,'ELIMINADO'),(3,'PENDIENTE');
UNLOCK TABLES;



