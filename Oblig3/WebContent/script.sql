SET search_path = oblig3_2019;

DROP TABLE IF EXISTS deltager;

CREATE TABLE deltager 
(
   mobil    VARCHAR(12),
   passordhash  VARCHAR (40),
   passordsalt VARCHAR(40),
   fornavn VARCHAR(255),
   etternavn VARCHAR(255),
   kjonn CHAR(1),
   PRIMARY KEY (mobil)
);
