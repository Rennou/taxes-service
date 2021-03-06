
CREATE DATABASE IF NOT EXISTS bdd_taxes;
USE bdd_taxes ;
DROP TABLE IF EXISTS USERS ;
DROP TABLE IF EXISTS PROVINCE  ;
DROP TABLE IF EXISTS TAXES ;


CREATE TABLE USERS (
 CODE VARCHAR(8)  NOT NULL  ,
 PASSWORD VARCHAR(8)  NOT NULL,
 DESCRIPTION  VARCHAR(200) NOT NULL,
 PRIMARY KEY ( code )
);



CREATE TABLE PROVINCE (
  CODE  VARCHAR(2)  NOT NULL UNIQUE,
  NOM  VARCHAR(200) NOT NULL,
  PRIMARY KEY ( CODE )
);

CREATE TABLE TAXES (
   ID INT NOT NULL AUTO_INCREMENT,
   TAX_PROV  DECIMAL(7,2)  NOT NULl,
   TAX_FED  DECIMAL(7,2)  NOT NULl,
   CODE  VARCHAR(2) NOT NULL,
   DATE_TX  DATE NOT NULL,
   PRIMARY KEY (ID),
   FOREIGN KEY PROV_TAX_FK (CODE)
   REFERENCES PROVINCE(CODE),
   UNIQUE(TAX_PROV, TAX_FED, CODE, DATE_TX)
)




--Insertion ds la tables des provinces 
INSERT INTO PROVINCE VALUES('ON','Ontario');
INSERT INTO PROVINCE VALUES('QC','Quebec');
INSERT INTO PROVINCE VALUES('NS','Nouvelle-Écosse');
INSERT INTO PROVINCE VALUES('NB','Nouveau-Brunswick');
INSERT INTO PROVINCE VALUES('MB','Manitoba');
INSERT INTO PROVINCE VALUES('BC','Colombie-Britannique');
INSERT INTO PROVINCE VALUES('PE','ile-du-Prince-Édouard');
INSERT INTO PROVINCE VALUES('SK','Saskatchewan');
INSERT INTO PROVINCE VALUES('AB','Alberta');
INSERT INTO PROVINCE VALUES('NL','Terre-Neuve-et-Labrador');
INSERT INTO PROVINCE VALUES('NU','Nunavut');
INSERT INTO PROVINCE VALUES('NT','Territoires du Nord-Ouest');
INSERT INTO PROVINCE VALUES('YT','Yukon');

--Insertion ds la tables des taxes
INSERT INTO TAXES(CODE ,TAX_PROV , TAX_FED ,DATE_TX) VALUES('ON',4,7 ,'2018-01-01');
INSERT INTO TAXES(CODE ,TAX_PROV , TAX_FED ,DATE_TX)  VALUES('QC',5,9.9,'2018-01-01');
INSERT INTO TAXES(CODE ,TAX_PROV , TAX_FED ,DATE_TX)  VALUES('NS',5,9,'2018-01-01');
INSERT INTO TAXES(CODE ,TAX_PROV , TAX_FED ,DATE_TX)  VALUES('NB',5,9,'2018-01-01');

INSERT INTO TAXES(CODE ,TAX_PROV , TAX_FED ,DATE_TX) VALUES('ON',5,8 ,now());
INSERT INTO TAXES(CODE ,TAX_PROV , TAX_FED ,DATE_TX)  VALUES('QC',5,9.975 ,now());
INSERT INTO TAXES(CODE ,TAX_PROV , TAX_FED ,DATE_TX)  VALUES('NS',5,10 ,now());
INSERT INTO TAXES(CODE ,TAX_PROV , TAX_FED ,DATE_TX)  VALUES('NB',5,10 ,now());



