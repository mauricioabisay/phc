-- MySQL dump 10.13  Distrib 5.5.40, for Win32 (x86)
--
-- Host: localhost    Database: phc
-- ------------------------------------------------------
-- Server version	5.5.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES UTF8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alergia`
--

DROP TABLE IF EXISTS `alergia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alergia` (
  `id_alergia` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `alergia` varchar(50) DEFAULT NULL,
  `paciente_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_alergia`),
  KEY `paciente_fk` (`paciente_fk`),
  CONSTRAINT `alergia_ibfk_1` FOREIGN KEY (`paciente_fk`) REFERENCES `paciente` (`id_paciente`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alergia`
--

LOCK TABLES `alergia` WRITE;
/*!40000 ALTER TABLE `alergia` DISABLE KEYS */;
/*!40000 ALTER TABLE `alergia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `antecedente_heredofamiliar`
--

DROP TABLE IF EXISTS `antecedente_heredofamiliar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `antecedente_heredofamiliar` (
  `id_antecedente_familiar` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `enfermedad` varchar(50) DEFAULT NULL,
  `parentesco` varchar(50) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL,
  `fecha_captura` date DEFAULT NULL,
  `paciente_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_antecedente_familiar`),
  KEY `paciente_fk` (`paciente_fk`),
  CONSTRAINT `antecedente_heredofamiliar_ibfk_1` FOREIGN KEY (`paciente_fk`) REFERENCES `paciente` (`id_paciente`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `antecedente_heredofamiliar`
--

LOCK TABLES `antecedente_heredofamiliar` WRITE;
/*!40000 ALTER TABLE `antecedente_heredofamiliar` DISABLE KEYS */;
INSERT INTO `antecedente_heredofamiliar` VALUES (1,'Diabetes','Abuelo Materno','Activo','2014-11-18',1),(2,'Hipertensión','Abuela Materno','Activo','2014-11-18',1),(3,'Cáncer','Abuela Paterna','Activo','2014-11-18',1),(6,'Hipertensión','Abuela Materna','Activo','2014-11-18',2);
/*!40000 ALTER TABLE `antecedente_heredofamiliar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `antecedente_personal`
--

DROP TABLE IF EXISTS `antecedente_personal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `antecedente_personal` (
  `id_antecedente_personal` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `alcohol` enum('si','no') DEFAULT NULL,
  `alcohol_frec_valor` int(10) unsigned DEFAULT NULL,
  `alcohol_frec_tipo` enum('diario','semanal','mensual','anual') DEFAULT NULL,
  `alcohol_frec_cantidad` int(10) unsigned DEFAULT NULL,
  `tabaco` enum('si','no') DEFAULT NULL,
  `tabaco_frec_cantidad` int(10) unsigned DEFAULT NULL,
  `tabaco_frec_tipo` enum('diario','semanal','mensual','anual') DEFAULT NULL,
  `embarazo` enum('si','no') DEFAULT NULL,
  `semana` int(10) unsigned DEFAULT NULL,
  `gesta` int(10) unsigned DEFAULT NULL,
  `peso_pregestacional` decimal(5,2) unsigned DEFAULT NULL,
  `lactancia` enum('si','no') DEFAULT NULL,
  `ejercicio` enum('si','no') DEFAULT NULL,
  `paciente_fk` bigint(20) unsigned DEFAULT NULL,
  `fecha_actualizacion` date DEFAULT NULL,
  PRIMARY KEY (`id_antecedente_personal`),
  KEY `paciente_fk` (`paciente_fk`),
  CONSTRAINT `antecedente_personal_ibfk_1` FOREIGN KEY (`paciente_fk`) REFERENCES `paciente` (`id_paciente`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `antecedente_personal`
--

LOCK TABLES `antecedente_personal` WRITE;
/*!40000 ALTER TABLE `antecedente_personal` DISABLE KEYS */;
INSERT INTO `antecedente_personal` VALUES (1,'no',0,'diario',0,'no',0,'diario','no',0,0,0.00,'no','si',1,'2014-11-22'),(2,'si',5,'semanal',1,'si',1,'diario','no',0,0,0.00,'no','si',2,'2014-11-24'),(3,'no',0,'diario',0,'si',1,'diario','no',0,0,0.00,'no','si',1,'2014-11-25'),(4,'no',0,'diario',0,'no',1,'diario','no',0,0,0.00,'no','si',1,'2014-11-25'),(5,'no',0,'diario',0,'no',1,'diario','no',0,0,0.00,'no','si',1,'2014-12-06'),(6,'si',1,'semanal',2,'si',1,'diario','no',0,0,0.00,'no','si',1,'2014-12-08');
/*!40000 ALTER TABLE `antecedente_personal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ejercicio`
--

DROP TABLE IF EXISTS `ejercicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ejercicio` (
  `id_ejercicio` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `ejercicio` varchar(100) DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  `frec_valor` int(10) unsigned DEFAULT NULL,
  `frec_tipo` enum('diario','semanal','mensual','anual') DEFAULT NULL,
  `paciente_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_ejercicio`),
  KEY `paciente_fk` (`paciente_fk`),
  CONSTRAINT `ejercicio_ibfk_1` FOREIGN KEY (`paciente_fk`) REFERENCES `paciente` (`id_paciente`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ejercicio`
--

LOCK TABLES `ejercicio` WRITE;
/*!40000 ALTER TABLE `ejercicio` DISABLE KEYS */;
INSERT INTO `ejercicio` VALUES (2,'Correr','aerobico',3,'diario',1),(3,'Correr','aerobico',3,'semanal',2);
/*!40000 ALTER TABLE `ejercicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exploracion_fisica`
--

DROP TABLE IF EXISTS `exploracion_fisica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exploracion_fisica` (
  `id_exploracion_fisica` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `temperatura` decimal(5,2) unsigned DEFAULT NULL,
  `presion_sistolica` int(10) unsigned DEFAULT NULL,
  `presion_diastolica` int(10) unsigned DEFAULT NULL,
  `frec_cardiaca` int(10) unsigned DEFAULT NULL,
  `frec_respiratoria` int(10) unsigned DEFAULT NULL,
  `peso` decimal(6,3) unsigned DEFAULT NULL,
  `estatura` decimal(5,2) unsigned DEFAULT NULL,
  `habitus` text,
  `cabeza` text,
  `ojos` text,
  `garganta` text,
  `nariz` text,
  `oido` text,
  `torax` text,
  `abdomen` text,
  `genitales` text,
  `miembros` text,
  `observaciones` text,
  `fecha` date DEFAULT NULL,
  `paciente_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_exploracion_fisica`),
  KEY `paciente_fk` (`paciente_fk`),
  CONSTRAINT `exploracion_fisica_ibfk_1` FOREIGN KEY (`paciente_fk`) REFERENCES `paciente` (`id_paciente`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exploracion_fisica`
--

LOCK TABLES `exploracion_fisica` WRITE;
/*!40000 ALTER TABLE `exploracion_fisica` DISABLE KEYS */;
INSERT INTO `exploracion_fisica` VALUES (17,0.00,0,0,0,0,0.000,0.00,'','','','','','','','','','','','2014-12-06',1);
/*!40000 ALTER TABLE `exploracion_fisica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interrogatorio`
--

DROP TABLE IF EXISTS `interrogatorio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `interrogatorio` (
  `id_interrogatorio` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `gastro_intestinal` text,
  `respiratorio` text,
  `cardiovascular` text,
  `genito_urinario` text,
  `esfera_mental` text,
  `psicosomatico` text,
  `otorrino_laringologico` text,
  `musculo_esqueletico` text,
  `endocrino` text,
  `observaciones` text,
  `fecha` date DEFAULT NULL,
  `paciente_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_interrogatorio`),
  KEY `paciente_fk` (`paciente_fk`),
  CONSTRAINT `interrogatorio_ibfk_1` FOREIGN KEY (`paciente_fk`) REFERENCES `paciente` (`id_paciente`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interrogatorio`
--

LOCK TABLES `interrogatorio` WRITE;
/*!40000 ALTER TABLE `interrogatorio` DISABLE KEYS */;
INSERT INTO `interrogatorio` VALUES (9,'n','n','n','n','n','n','n','n','n','NORMALx1','2014-11-26',1),(10,'','','','','','','','','','mis observaciones','2014-12-02',1);
/*!40000 ALTER TABLE `interrogatorio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `laboratorio`
--

DROP TABLE IF EXISTS `laboratorio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `laboratorio` (
  `id_laboratorio` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `laboratorio` varchar(100) DEFAULT NULL,
  `tipo` enum('Laboratorio','Gabinete') DEFAULT NULL,
  `estado` enum('Solicitud','Normal','Alterado') DEFAULT NULL,
  `fecha_captura` date DEFAULT NULL,
  `observaciones` text,
  `paciente_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_laboratorio`),
  KEY `paciente_fk` (`paciente_fk`),
  CONSTRAINT `laboratorio_ibfk_1` FOREIGN KEY (`paciente_fk`) REFERENCES `paciente` (`id_paciente`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `laboratorio`
--

LOCK TABLES `laboratorio` WRITE;
/*!40000 ALTER TABLE `laboratorio` DISABLE KEYS */;
INSERT INTO `laboratorio` VALUES (1,'Estudio Solicitado 1','Laboratorio','Solicitud','2014-12-04','RESULTADOS PENDIENTES',1),(3,'Lab1','Laboratorio','Solicitud','2014-12-06','RESULTADOS PENDIENTES',1),(4,'Estudio Solicitado 1','Laboratorio','Normal','2014-12-06','RESULTADOS NORMALES',1),(5,'Lab1','Laboratorio','Alterado','2014-12-06','RESULTADOS DENTRO DE LO NORMAL, PERO CON ALGUNAS VARIACIONES SIGNIFICATIVAS',1);
/*!40000 ALTER TABLE `laboratorio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paciente` (
  `id_paciente` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `ap` varchar(50) DEFAULT NULL,
  `am` varchar(50) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `sexo` set('M','F') DEFAULT NULL,
  `edo_civil` enum('Soltero','Casado','Divorciado','Viudo','ULibre') DEFAULT NULL,
  `ocupacion` varchar(60) DEFAULT NULL,
  `calle` varchar(60) DEFAULT NULL,
  `num_ext` varchar(10) DEFAULT NULL,
  `num_int` varchar(10) DEFAULT NULL,
  `colonia` varchar(60) DEFAULT NULL,
  `ciudad` varchar(60) DEFAULT NULL,
  `estado` char(3) DEFAULT NULL,
  `cp` varchar(20) DEFAULT NULL,
  `pais` varchar(60) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `celular` varchar(10) DEFAULT NULL,
  `rfc` char(30) DEFAULT NULL,
  `curp` char(18) DEFAULT NULL,
  `recomendado_por` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_paciente`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente`
--

LOCK TABLES `paciente` WRITE;
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
INSERT INTO `paciente` VALUES (1,'MAURICIO ABISAY','LÓPEZ','VELÁZQUEZ','1988-01-11','M','Soltero','ESTUDIANTE','VICENTE GUERRERO','6139','','EL PATRIMONIO','PUEBLA','PUE','72450',NULL,NULL,NULL,NULL,NULL,NULL),(2,'JUAN RAFAEL','PEREZ','RAMIREZ','1950-02-01','M','Soltero','JUBILADO','CALLE','123','','COLONIA','CIUDAD','PUE','72400',NULL,'222','22',NULL,NULL,'REFERENCIA'),(4,'JOSE LUIS','PERALES','PERALES','1950-02-11','M','Soltero','CANTANTE','CALLE','456','','COLONIA COLONIA','ESPAÑA','PUE','123456',NULL,'222','22',NULL,NULL,NULL),(5,'MUJER','MAYOR','EDAD','1994-01-11','F','Soltero','ESTUDIANTE','CALLE','123','','COLONIA','CIUDAD','PUE','74500',NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `padecimiento`
--

DROP TABLE IF EXISTS `padecimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `padecimiento` (
  `id_padecimiento` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `padecimiento` varchar(50) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL,
  `descripcion` text,
  `tratamiento` enum('si','no') DEFAULT NULL,
  `anterior` enum('si','no') DEFAULT NULL,
  `paciente_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_padecimiento`),
  KEY `paciente_fk` (`paciente_fk`),
  CONSTRAINT `padecimiento_ibfk_1` FOREIGN KEY (`paciente_fk`) REFERENCES `paciente` (`id_paciente`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `padecimiento`
--

LOCK TABLES `padecimiento` WRITE;
/*!40000 ALTER TABLE `padecimiento` DISABLE KEYS */;
INSERT INTO `padecimiento` VALUES (5,'DOLOR DE CABEZA AGUDO','Activo','DOLOR AGUADO EN LA PARTE DE LA NUCA','no','si',1),(6,'Migraña','Activo','LINEA 1\r\nLINEA 2\r\nLINEA 3\r\nLINEA 4','no','si',1);
/*!40000 ALTER TABLE `padecimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tratamiento`
--

DROP TABLE IF EXISTS `tratamiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tratamiento` (
  `id_tratamiento` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `tratamiento` varchar(50) DEFAULT NULL,
  `descripcion` text,
  `tipo` enum('Convencional','Alternativo','Tradicional') DEFAULT NULL,
  `padecimiento_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_tratamiento`),
  KEY `padecimiento_fk` (`padecimiento_fk`),
  CONSTRAINT `tratamiento_ibfk_1` FOREIGN KEY (`padecimiento_fk`) REFERENCES `padecimiento` (`id_padecimiento`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tratamiento`
--

LOCK TABLES `tratamiento` WRITE;
/*!40000 ALTER TABLE `tratamiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `tratamiento` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-03-24 13:07:30
