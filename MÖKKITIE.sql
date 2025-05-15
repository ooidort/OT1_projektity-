
-- Drop the database if it exists
DROP DATABASE IF EXISTS mokki;

-- Create the database
CREATE DATABASE mokki CHARACTER SET utf8mb4;
USE mokki;

-- Create the 'mokit' table
CREATE TABLE mokit (
    MokkiID INT PRIMARY KEY,
    osoite VARCHAR(255) NOT NULL,
    varauksen_alku DATETIME NOT NULL,
    varauksen_loppu DATETIME NOT NULL,
    hinta INT NOT NULL,
    kayttoaste INT NOT NULL
);

-- Create the 'asiakas' table
CREATE TABLE asiakas (
    AsiakasID INT PRIMARY KEY,
    nimi VARCHAR(255) NOT NULL,
    sahkoposti VARCHAR(255) NOT NULL UNIQUE,
    osoite VARCHAR(255) NOT NULL,
    puhelinnumero VARCHAR(255) NOT NULL
);

-- Create the 'laskut' table
CREATE TABLE laskut (
    LaskuID INT PRIMARY KEY,
    erapaiva_alku DATETIME NOT NULL,
    erapaiva_loppu DATETIME NOT NULL,
    summa INT NOT NULL
);

-- Create the 'huollot' table
CREATE TABLE huollot (
    HuoltoID INT PRIMARY KEY,
    historia VARCHAR(255) NOT NULL,
    kohteet VARCHAR(255) NOT NULL
);

-- Create the 'varaukset' table to link customers and cabins
CREATE TABLE varaukset (
    VarausID INT PRIMARY KEY,
    AsiakasID INT,
    MokkiID INT,
    varauksen_alku DATETIME,
    varauksen_loppu DATETIME,
    FOREIGN KEY (AsiakasID) REFERENCES asiakas(AsiakasID),
    FOREIGN KEY (MokkiID) REFERENCES mokit(MokkiID)
);

-- Example inserts for 'mokit' table
INSERT INTO mokit (MokkiID, osoite, varauksen_alku, varauksen_loppu, hinta, kayttoaste) VALUES
(1, 'Mökkitie 1', '1999-12-31 10:00:00', '1999-12-31 10:00:00', 80, 0),
(2, 'Mökkitie 2', '1999-12-31 10:00:00', '1999-12-31 10:00:00', 120, 0),
(3, 'Mökkitie 3', '1999-12-31 10:00:00', '1999-12-31 10:00:00', 140, 0),
(4, 'Mökkitie 4', '1999-12-31 10:00:00', '1999-12-31 10:00:00', 1150, 0);

-- Example inserts for 'asiakas' table
INSERT INTO asiakas (AsiakasID, nimi, sahkoposti, osoite, puhelinnumero) VALUES
(1, 'Asiakas 1', 'asiakas1@example.com', 'Asiakastie 1', '1234567890'),
(2, 'Asiakas 2', 'asiakas2@example.com', 'Asiakastie 2', '0987654321'),
(3, 'Asiakas 3', 'asiakas3@example.com', 'Asiakastie 3', '1122334455'),
(4, 'Asiakas 4', 'asiakas4@example.com', 'Asiakastie 4', '5566778899');

-- Example inserts for 'laskut' table
INSERT INTO laskut (LaskuID, erapaiva_alku, erapaiva_loppu, summa) VALUES
(1, '2023-01-01 00:00:00', '2023-01-31 23:59:59', 100),
(2, '2023-02-01 00:00:00', '2023-02-28 23:59:59', 200),
(3, '2023-03-01 00:00:00', '2023-03-31 23:59:59', 300),
(4, '2023-04-01 00:00:00', '2023-04-30 23:59:59', 400);

-- Example inserts for 'huollot' table
INSERT INTO huollot (HuoltoID, historia, kohteet) VALUES
(1, 'Huoltohistoria 1', 'Kohde 1'),
(2, 'Huoltohistoria 2', 'Kohde 2'),
(3, 'Huoltohistoria 3', 'Kohde 3'),
(4, 'Huoltohistoria 4', 'Kohde 4');

-- Example inserts for 'varaukset' table
INSERT INTO varaukset (VarausID, AsiakasID, MokkiID, varauksen_alku, varauksen_loppu) VALUES
(1, 1, 1, '2023-05-01 00:00:00', '2023-05-07 23:59:59'),
(2, 2, 2, '2023-06-01 00:00:00', '2023-06-07 23:59:59'),
(3, 3, 3, '2023-07-01 00:00:00', '2023-07-07 23:59:59'),
(4, 4, 4, '2023-08-01 00:00:00', '2023-08-07 23:59:59');
