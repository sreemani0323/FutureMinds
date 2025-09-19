
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
DROP TABLE IF EXISTS `colleges`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `colleges` (
  `sno` int NOT NULL,
  `name_of_the_institution` varchar(255) DEFAULT NULL,
  `region` varchar(100) DEFAULT NULL,
  `place` varchar(100) DEFAULT NULL,
  `affl` varchar(100) DEFAULT NULL,
  `branch_code` varchar(20) DEFAULT NULL,
  `oc_boys` int DEFAULT NULL,
  `oc_girls` int DEFAULT NULL,
  `sc_boys` int DEFAULT NULL,
  `sc_girls` int DEFAULT NULL,
  `st_boys` int DEFAULT NULL,
  `st_girls` int DEFAULT NULL,
  `bca_boys` int DEFAULT NULL,
  `bca_girls` int DEFAULT NULL,
  `bcb_boys` int DEFAULT NULL,
  `bcb_girls` int DEFAULT NULL,
  `bcc_boys` int DEFAULT NULL,
  `bcc_girls` int DEFAULT NULL,
  `bcd_boys` int DEFAULT NULL,
  `bcd_girls` int DEFAULT NULL,
  `bce_boys` int DEFAULT NULL,
  `bce_girls` int DEFAULT NULL,
  `oc_ews_boys` int DEFAULT NULL,
  `oc_ews_girls` int DEFAULT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
DROP TABLE IF EXISTS `new_colleges`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `new_colleges` (
  `sno` int NOT NULL,
  `name_of_the_institution` varchar(255) DEFAULT NULL,
  `region` varchar(100) DEFAULT NULL,
  `place` varchar(100) DEFAULT NULL,
  `affl` varchar(100) DEFAULT NULL,
  `branch_code` varchar(20) DEFAULT NULL,
  `oc_boys` int DEFAULT NULL,
  `oc_girls` int DEFAULT NULL,
  `sc_boys` int DEFAULT NULL,
  `sc_girls` int DEFAULT NULL,
  `st_boys` int DEFAULT NULL,
  `st_girls` int DEFAULT NULL,
  `bca_boys` int DEFAULT NULL,
  `bca_girls` int DEFAULT NULL,
  `bcb_boys` int DEFAULT NULL,
  `bcb_girls` int DEFAULT NULL,
  `bcc_boys` int DEFAULT NULL,
  `bcc_girls` int DEFAULT NULL,
  `bcd_boys` int DEFAULT NULL,
  `bcd_girls` int DEFAULT NULL,
  `bce_boys` int DEFAULT NULL,
  `bce_girls` int DEFAULT NULL,
  `oc_ews_boys` int DEFAULT NULL,
  `oc_ews_girls` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

