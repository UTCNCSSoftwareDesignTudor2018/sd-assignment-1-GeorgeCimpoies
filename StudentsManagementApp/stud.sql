-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema studentsmanagement
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema studentsmanagement
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `studentsmanagement` DEFAULT CHARACTER SET utf8 ;
USE `studentsmanagement` ;

-- -----------------------------------------------------
-- Table `studentsmanagement`.`students`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `studentsmanagement`.`students` (
  `studentId` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `card_nr` VARCHAR(45) NULL,
  `personal_numerical_code` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `group` VARCHAR(45) NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`studentId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `studentsmanagement`.`teachers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `studentsmanagement`.`teachers` (
  `idteacher` INT NOT NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`idteacher`))
ENGINE = InnoDB
COMMENT = '	';


-- -----------------------------------------------------
-- Table `studentsmanagement`.`courses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `studentsmanagement`.`courses` (
  `idcourse` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `teachers_id` INT NOT NULL,
  PRIMARY KEY (`idcourse`, `teachers_id`),
  INDEX `fk_courses_teachers1_idx` (`teachers_id` ASC),
  CONSTRAINT `fk_courses_teachers1`
    FOREIGN KEY (`teachers_id`)
    REFERENCES `studentsmanagement`.`teachers` (`idteacher`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `studentsmanagement`.`exams`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `studentsmanagement`.`exams` (
  `idexam` INT NOT NULL,
  `grade` INT NULL,
  PRIMARY KEY (`idexam`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `studentsmanagement`.`enrollments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `studentsmanagement`.`enrollments` (
  `idenrollment` VARCHAR(45) NOT NULL,
  `students_id` INT NOT NULL,
  `courses_id` INT NOT NULL,
  `exams_id` INT NOT NULL,
  PRIMARY KEY (`idenrollment`, `students_id`, `courses_id`, `exams_id`),
  INDEX `fk_students_has_courses_courses1_idx` (`courses_id` ASC),
  INDEX `fk_students_has_courses_students_idx` (`students_id` ASC),
  INDEX `fk_enrollments_exams1_idx` (`exams_id` ASC),
  CONSTRAINT `fk_students_has_courses_students`
    FOREIGN KEY (`students_id`)
    REFERENCES `studentsmanagement`.`students` (`studentId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_students_has_courses_courses1`
    FOREIGN KEY (`courses_id`)
    REFERENCES `studentsmanagement`.`courses` (`idcourse`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_enrollments_exams1`
    FOREIGN KEY (`exams_id`)
    REFERENCES `studentsmanagement`.`exams` (`idexam`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
