CREATE TABLE carros (
    id INT(8) NOT null auto_increment,
    modelo VARCHAR(120) NOT NULL,
    ano INT(8) not null,    
    PRIMARY KEY (id)
  );


CREATE TABLE ipva (
    id INT(8) NOT null auto_increment,
    ano INT(8) not null,    
    PRIMARY KEY (id)
  );
 insert into ipva (id, ano) values (3,2019);
select  * from ipva;
select * from carros;

INSERT INTO ipva VALUES(2015);

show tables;
insert into carros (modelo, ano) values (fiat, 2010);
select * from ipva;