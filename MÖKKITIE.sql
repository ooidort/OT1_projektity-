DROP DATABASE IF EXISTS mokki;
CREATE DATABASE mokki CHARACTER SET utf8mb4;
USE mokki;
 
CREATE TABLE `mokit`(
    `MokkiID` INT NOT NULL,
    `osoite` VARCHAR(255) NOT NULL,
    `varauksen_alku` DATETIME NOT NULL,
    `varauksen_loppu` DATETIME NOT NULL,
    `hinta` INT NOT NULL,
    `kayttoaste` INT NOT NULL
);
ALTER TABLE
    `mokit` ADD PRIMARY KEY(`MokkiID`);
    
CREATE TABLE `asiakas`(
    `AsiakasID` INT NOT NULL,
    `nimi` VARCHAR(255) NOT NULL,
    `sahkoposti` VARCHAR(255) NOT NULL,
    `osoite` VARCHAR(255) NOT NULL,
    `puhelinnumero` VARCHAR(255) NOT NULL
);
ALTER TABLE
    `asiakas` ADD PRIMARY KEY(`AsiakasID`);
    
CREATE TABLE `laskut`(
    `LaskuID` INT NOT NULL,
    `erapaiva_alku` DATETIME NOT NULL,
    `erapaiva_loppu` DATETIME NOT NULL,
    `summa` INT NOT NULL
);
ALTER TABLE
    `laskut` ADD PRIMARY KEY(`LaskuID`);
    
CREATE TABLE `huollot`(
    `HuoltoID` INT NOT NULL,
	`historia` VARCHAR(255) NOT NULL,
	`kohteet` VARCHAR(255) NOT NULL
);
ALTER TABLE
    `huollot` ADD PRIMARY KEY(`HuoltoID`);

CREATE TABLE `varaukset`(
    `VarausID` INT NOT NULL AUTO_INCREMENT,
    `MokkiID` INT NOT NULL,
    `AsiakasID` INT NOT NULL,
    `varauksen_alku` DATETIME NOT NULL,
    `varauksen_loppu` DATETIME NOT NULL,
    `lisatiedot` VARCHAR(255),
    FOREIGN KEY (`MokkiID`) REFERENCES `mokit` (`MokkiID`),
    FOREIGN KEY (`AsiakasID`) REFERENCES `asiakas` (`AsiakasID`)
);

ALTER TABLE
    `asiakas` ADD UNIQUE `kayttaja_sahkoposti_unique`(`sahkoposti`);
    
ALTER TABLE
    `mokit` ADD CONSTRAINT `mokit_AsiakasID_vieras` FOREIGN KEY(`MokkiID`) REFERENCES `asiakas`(`AsiakasID`);
    
ALTER TABLE
    `asiakas` ADD CONSTRAINT `asiakas_LaskuID_vieras` FOREIGN KEY(`AsiakasID`) REFERENCES `laskut`(`LaskuID`);
    
ALTER TABLE
    `huollot` ADD CONSTRAINT `huollot_MokkiID_vieras` FOREIGN KEY(`HuoltoID`) REFERENCES `mokit`(`MokkiID`);
