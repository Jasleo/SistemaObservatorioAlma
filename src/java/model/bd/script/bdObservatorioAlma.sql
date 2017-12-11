CREATE DATABASE bdAlmaAstrologia;

USE bdAlmaAstrologia;

/*    ON DELETE CASCADE
*/

CREATE TABLE sistemaPlanetario( 
    id INT AUTO_INCREMENT,
    nombre VARCHAR (20),
    PRIMARY KEY (id)
);

CREATE TABLE estrella(
     id INT AUTO_INCREMENT,
    nombre VARCHAR (20),
    idSistemaPlanetarioFK INT,
    PRIMARY KEY (id),
    FOREIGN KEY (idSistemaPlanetarioFK) REFERENCES sistemaPlanetario(id)
);

CREATE TABLE tipoDeCuerpoMenor(
    id INT AUTO_INCREMENT,
    nombre VARCHAR (20),
    PRIMARY KEY (id)
);

CREATE TABLE cuerpoCeleste(
    id INT AUTO_INCREMENT,
    nombre VARCHAR (20),
    masa FLOAT,
    tamano FLOAT,
    idEstrellaFK INT,
    idTipoDeCuerpoMenorFK INT,
    PRIMARY KEY (id),
    FOREIGN KEY (idEstrellaFK) REFERENCES estrella(id),
    FOREIGN KEY (idTipoDeCuerpoMenorFK) REFERENCES tipoDeCuerpoMenor(id)
);

CREATE TABLE tipoDePlaneta(
    id INT AUTO_INCREMENT,
    nombre VARCHAR (20),
    PRIMARY KEY (id)
);

CREATE TABLE planeta(
    id INT AUTO_INCREMENT,
    nombre VARCHAR (20),
    simbologia VARCHAR (20),
    diametroEcuatorial FLOAT,
    masa FLOAT,
    radioOrbital FLOAT,
    periodoOrbital FLOAT,
    periodoDeRotacion FLOAT ,
    composicionAtmosfera VARCHAR(20) ,
    idEstrellaFK INT,
    idTipoDePLanetaFK INT,
    PRIMARY KEY (id),
    FOREIGN KEY (idEstrellaFK) REFERENCES estrella(id),
    FOREIGN KEY (idTipoDePLanetaFK) REFERENCES tipoDePlaneta(id)
);

CREATE TABLE satelite(
    id INT AUTO_INCREMENT,
    nombre VARCHAR (20),
    diametro FLOAT,
    peridoOrbitalDia FLOAT,
    peridoOrbitalHora FLOAT ,
    peridoOrbitalMInuto FLOAT,
    idPlanetaFK INT,
    PRIMARY KEY (id),
    FOREIGN KEY (idPlanetaFK) REFERENCES planeta(id)
);

CREATE TABLE usuario(
    id INT AUTO_INCREMENT,
    nombre VARCHAR (20),
    contraseña VARCHAR (10),
    PRIMARY KEY (id)
);




--DROP DATABASE bdAlmaAstrologia