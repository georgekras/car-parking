-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema carparking
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema carparking
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `carparking` DEFAULT CHARACTER SET utf8 ;
USE `carparking` ;

-- -----------------------------------------------------
-- Table `carparking`.`Car`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carparking`.`Car` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `model` VARCHAR(45) NOT NULL,
  `brand` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
