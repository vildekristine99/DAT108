SET search_path = oblig3_2019;

DROP TABLE IF EXISTS Deltager;

CREATE TABLE Deltager 
(
   mobil    VARCHAR(12),
   passordhash  VARCHAR (255),
   passordsalt VARCHAR(255),
   fornavn VARCHAR(255),
   etternavn VARCHAR(255),
   kjonn CHAR(1),
   CONSTRAINT deltager_pk PRIMARY KEY (mobil)
);