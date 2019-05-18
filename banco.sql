CREATE DATABASE  IF NOT EXISTS `teste` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `teste`;
-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: teste
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `estado` (
  `sigla_Estado` varchar(2) NOT NULL,
  `nome_Estado` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`sigla_Estado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado`
--

LOCK TABLES `estado` WRITE;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` VALUES ('AC','Acre'),('BA','Bahia'),('MG','Minas Gerais'),('RJ','Rio de Janeiro'),('SP','São Paulo');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loja`
--

DROP TABLE IF EXISTS `loja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `loja` (
  `nome_Loja` varchar(20) NOT NULL,
  `sigla_estado` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`nome_Loja`),
  KEY `sigla_estado` (`sigla_estado`),
  CONSTRAINT `loja_ibfk_1` FOREIGN KEY (`sigla_estado`) REFERENCES `estado` (`sigla_Estado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loja`
--

LOCK TABLES `loja` WRITE;
/*!40000 ALTER TABLE `loja` DISABLE KEYS */;
INSERT INTO `loja` VALUES ('FastCar','AC'),('HotCar','BA'),('Car++','MG'),('Seminovos','RJ'),('DeluxCar','SP');
/*!40000 ALTER TABLE `loja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marca_e_modelo`
--

DROP TABLE IF EXISTS `marca_e_modelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `marca_e_modelo` (
  `nome_Marca` varchar(20) NOT NULL,
  `nome_Modelo` varchar(20) NOT NULL,
  PRIMARY KEY (`nome_Modelo`,`nome_Marca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca_e_modelo`
--

LOCK TABLES `marca_e_modelo` WRITE;
/*!40000 ALTER TABLE `marca_e_modelo` DISABLE KEYS */;
INSERT INTO `marca_e_modelo` VALUES ('Mercedes Benz','AMG GT'),('Ford','Fiesta'),('Ford','Mustang GT'),('Cherry','Tiggo 5x'),('Fiat','Uno');
/*!40000 ALTER TABLE `marca_e_modelo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuario` (
  `login` varchar(20) NOT NULL,
  `senha` decimal(11,0) DEFAULT NULL,
  `nome_usuario` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('admin',123,'Admin'),('g',123,'gabriel'),('l',123,'Luan'),('m',123,'Marco'),('t',123,'Thays');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `veiculo`
--

DROP TABLE IF EXISTS `veiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `veiculo` (
  `id_Veiculo` int(11) NOT NULL AUTO_INCREMENT,
  `placa` varchar(8) DEFAULT NULL,
  `ano` int(4) DEFAULT NULL,
  `preco` decimal(10,0) DEFAULT NULL,
  `sigla_Estado` varchar(2) DEFAULT NULL,
  `nome_loja` varchar(20) DEFAULT NULL,
  `nome_Modelo` varchar(20) DEFAULT NULL,
  `nome_Marca` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_Veiculo`),
  KEY `nome_loja` (`nome_loja`),
  KEY `nome_Modelo` (`nome_Modelo`,`nome_Marca`),
  KEY `sigla_Estado` (`sigla_Estado`),
  CONSTRAINT `veiculo_ibfk_1` FOREIGN KEY (`nome_loja`) REFERENCES `loja` (`nome_Loja`),
  CONSTRAINT `veiculo_ibfk_2` FOREIGN KEY (`nome_Modelo`, `nome_Marca`) REFERENCES `marca_e_modelo` (`nome_Modelo`, `nome_Marca`),
  CONSTRAINT `veiculo_ibfk_3` FOREIGN KEY (`sigla_Estado`) REFERENCES `estado` (`sigla_Estado`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veiculo`
--

LOCK TABLES `veiculo` WRITE;
/*!40000 ALTER TABLE `veiculo` DISABLE KEYS */;
INSERT INTO `veiculo` VALUES (9,'ABCD-123',2014,14000,'AC','FastCar','AMG GT','Mercedes Benz'),(10,'ABCD-223',2015,15000,'BA','HotCar','Fiesta','Ford'),(11,'ABCD-323',2016,16000,'MG','Car++','Mustang GT','Ford'),(12,'ABCD-423',2017,17000,'RJ','Seminovos','Tiggo 5x','Cherry'),(13,'ABCD-523',2018,18000,'SP','DeluxCar','Uno','Fiat');
/*!40000 ALTER TABLE `veiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'teste'
--

--
-- Dumping routines for database 'teste'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-13 21:00:17
