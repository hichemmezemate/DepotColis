DROP DATABASE IF EXISTS depotcolis;
CREATE DATABASE depotcolis;
USE depotcolis;

CREATE TABLE depot(
   id_depot INT AUTO_INCREMENT NOT NULL,
   nom VARCHAR(70) NOT NULL,
   adresse VARCHAR(150) NOT NULL,
   capacite INT NOT NULL,
   PRIMARY KEY(id_depot)
);

CREATE TABLE colis(
   id_colis INT AUTO_INCREMENT NOT NULL,
   numero VARCHAR(50) NOT NULL,
   adresse_livraison VARCHAR(150) NOT NULL,
   nom_destinataire VARCHAR(100) NOT NULL,
   prenom_destinataire VARCHAR(100) NOT NULL,
   tel_destinataire VARCHAR(10) NOT NULL,
   id_depot INT NOT NULL,
   PRIMARY KEY(id_colis),
   FOREIGN KEY(id_depot) REFERENCES depot(id_depot)
);
