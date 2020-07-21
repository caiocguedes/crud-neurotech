CREATE TABLE `USERS`(
	nome varchar(100) NOT NULL,
	id smallint NOT NULL AUTO_INCREMENT,
	dataNascimento varchar(10) NOT NULL,
	sexo varchar(1) NOT NULL,
        PRIMARY KEY (id)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;