CREATE DATABASE  IF NOT EXISTS `vivero` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `vivero`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: vivero
-- ------------------------------------------------------
-- Server version	5.6.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `arboles`
--

DROP TABLE IF EXISTS `arboles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arboles` (
  `nombre` varchar(45) NOT NULL,
  `cantidad` varchar(45) DEFAULT NULL,
  `precio` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `fotos` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arboles`
--

LOCK TABLES `arboles` WRITE;
/*!40000 ALTER TABLE `arboles` DISABLE KEYS */;
INSERT INTO `arboles` VALUES ('Abedul','6','12','arboles','web/img/arboles.jpg'),('Castanio','9','15','arboles','web/img/arboles1.jpg'),('Ficus Benjamina','14','10.5','arboles','web/img/arboles2.jpg');
/*!40000 ALTER TABLE `arboles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `arbustos`
--

DROP TABLE IF EXISTS `arbustos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arbustos` (
  `nombre` varchar(45) NOT NULL,
  `cantidad` varchar(45) DEFAULT NULL,
  `precio` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `fotos` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arbustos`
--

LOCK TABLES `arbustos` WRITE;
/*!40000 ALTER TABLE `arbustos` DISABLE KEYS */;
INSERT INTO `arbustos` VALUES ('algo chungo ahi','6','15','arbustos','web/img/arbustos.jpg'),('ceto','5','25','arbustos','web/img/arbustos1.jpg'),('cosa verde','3','50','arbustos','web/img/arbustos2.jpg');
/*!40000 ALTER TABLE `arbustos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) NOT NULL,
  `contrasena` varchar(45) NOT NULL,
  `localidad` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `cPostal` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`,`usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'admin','root','arinaga','mi casa','35118'),(2,'pene','paco','aqui','tu casa','456445');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flores`
--

DROP TABLE IF EXISTS `flores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flores` (
  `fotos` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) NOT NULL,
  `precio` varchar(45) DEFAULT NULL,
  `cantidad` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flores`
--

LOCK TABLES `flores` WRITE;
/*!40000 ALTER TABLE `flores` DISABLE KEYS */;
INSERT INTO `flores` VALUES ('web/img/flores.jpg','amapola','12','3','flores'),('web/img/flores.png','claveles','20','5','flores'),('web/img/flores2.jpg','flor de Poronga','80','1','flores'),('web/img/flores3.jpg','rosas','5','10','flores');
/*!40000 ALTER TABLE `flores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fotos`
--

DROP TABLE IF EXISTS `fotos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fotos` (
  `foto` varchar(45) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`foto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fotos`
--

LOCK TABLES `fotos` WRITE;
/*!40000 ALTER TABLE `fotos` DISABLE KEYS */;
INSERT INTO `fotos` VALUES ('web/img/agregar.png','agregar'),('web/img/arboles.png','arbolespng'),('web/img/arbustos.png','arbustospng'),('web/img/buscar.png','buscar'),('web/img/cesta.png','cesta'),('web/img/eliminar.png','eliminar'),('web/img/flores.png','florespng'),('web/img/icono.png','icono'),('web/img/jardinero.png','jardinero'),('web/img/logo.png','logo'),('web/img/mobiliario.png','mobiliariopng'),('web/img/perfil.png','perfil'),('web/img/semillas.png','semillaspng'),('web/img/utiles.png','utilespng');
/*!40000 ALTER TABLE `fotos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mobiliario`
--

DROP TABLE IF EXISTS `mobiliario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mobiliario` (
  `nombre` varchar(45) NOT NULL,
  `cantidad` varchar(45) DEFAULT NULL,
  `precio` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `fotos` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mobiliario`
--

LOCK TABLES `mobiliario` WRITE;
/*!40000 ALTER TABLE `mobiliario` DISABLE KEYS */;
INSERT INTO `mobiliario` VALUES ('mesa','3','25','mobiliario','web/img/mobiliario.jpg'),('pergola','4','80','mobiliario','web/img/mobiliario1.jpg'),('silla','4','40','mobiliario','web/img/mobiliario2.jpg');
/*!40000 ALTER TABLE `mobiliario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedidos` (
  `nombre` varchar(45) NOT NULL,
  `cantidadPedido` varchar(45) DEFAULT NULL,
  `precio` varchar(45) DEFAULT NULL,
  `usuario` varchar(45) DEFAULT NULL,
  `fotos` varchar(45) DEFAULT NULL,
  `cantidad` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES ('flor de Poronga','1','80','admin','web/img/flores2.jpg','1',NULL);
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `semillas`
--

DROP TABLE IF EXISTS `semillas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `semillas` (
  `nombre` varchar(45) NOT NULL,
  `cantidad` varchar(45) DEFAULT NULL,
  `precio` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `fotos` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `semillas`
--

LOCK TABLES `semillas` WRITE;
/*!40000 ALTER TABLE `semillas` DISABLE KEYS */;
INSERT INTO `semillas` VALUES ('calabacin','200','3','semillas','web/img/semillas.jpg'),('calabaza','150','2.5','semillas','web/img/semillas1.jpg'),('sandia','400','3.5','semillas','web/img/semillas2.jpg');
/*!40000 ALTER TABLE `semillas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicios`
--

DROP TABLE IF EXISTS `servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servicios` (
  `nombre` varchar(45) NOT NULL,
  `cantidad` varchar(45) DEFAULT NULL,
  `precio` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `fotos` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicios`
--

LOCK TABLES `servicios` WRITE;
/*!40000 ALTER TABLE `servicios` DISABLE KEYS */;
INSERT INTO `servicios` VALUES ('jardineria','','50','servicios','web/img/jardinero.jpg'),('reparto','','15','servicios','web/img/reparto.jpg');
/*!40000 ALTER TABLE `servicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utiles`
--

DROP TABLE IF EXISTS `utiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utiles` (
  `nombre` varchar(45) NOT NULL,
  `cantidad` varchar(45) DEFAULT NULL,
  `precio` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `fotos` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utiles`
--

LOCK TABLES `utiles` WRITE;
/*!40000 ALTER TABLE `utiles` DISABLE KEYS */;
INSERT INTO `utiles` VALUES ('carretilla','5','25','utiles','web/img/utiles.jpg'),('corta cesped','6','59.99','utiles','web/img/utiles1.jpg'),('macetas','10','4','utiles','web/img/utiles2.jpg');
/*!40000 ALTER TABLE `utiles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-06-14 15:07:21
