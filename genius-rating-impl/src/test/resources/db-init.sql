-- DROP TABLE boat_data;
-- DROP TABLE boat;
-- DROP TABLE user;

CREATE SCHEMA geniusrating DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;

-- USER

CREATE TABLE `user` (
	user_id						INTEGER NOT NULL,
	mail						VARCHAR(254) NOT NULL,
	nick						VARCHAR(254) NOT NULL,
	pass						VARCHAR(254) NOT NULL,
	ip							VARCHAR(39),
	login_fails					INTEGER DEFAULT 0 NOT NULL, 
	recover_code				VARCHAR(10),
	recover_code_expire_data	DATE,
	created_by					INTEGER NOT NULL,
	created_date				DATETIME NOT NULL,
	modified_by					INTEGER NOT NULL,
	modified_date				DATETIME NOT NULL,
	PRIMARY KEY (user_id)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE UNIQUE INDEX idxu_user_mail ON user(mail);

CREATE UNIQUE INDEX idxu_user_nick ON user(nick);

-- BOAT

CREATE TABLE boat (
	boat_id 			INTEGER NOT NULL,
	owner_id			INTEGER NOT NULL,
	boat_name 			VARCHAR(100) NOT NULL,
	design_year 		INTEGER NOT NULL,
	built_year 			INTEGER NOT NULL,
	shipyard 			VARCHAR(100) DEFAULT NULL,
	model 				VARCHAR(100) DEFAULT NULL,
	number_masts 		INTEGER NOT NULL,
	created_by			INTEGER NOT NULL,
	created_date		DATETIME NOT NULL,
	modified_by			INTEGER NOT NULL,
	modified_date		DATETIME NOT null,
	PRIMARY KEY (boat_id),
	CONSTRAINT fk_boat_owner FOREIGN KEY (owner_id) REFERENCES `user`(user_id)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE INDEX idxu_boat_name ON boat(boat_name);

CREATE TABLE boat_data (
	boat_data_id	INTEGER NOT NULL,
	edition			INTEGER NOT NULL,
	boat_id			INTEGER NOT NULL,
	`key`			VARCHAR(80) NOT NULL,
	value			VARCHAR(50) NOT NULL,
	`type`			VARCHAR(255) NOT NULL,
	created_by		INTEGER NOT NULL,
	created_date	DATETIME NOT NULL,
	modified_by		INTEGER NOT NULL,
	modified_date	DATETIME NOT null,
  PRIMARY KEY (boat_data_id),
  UNIQUE KEY idxu_boat_data_edition_boat_id_key (edition,boat_id,`key`),
  CONSTRAINT fkBarcoGenius_barco FOREIGN KEY (boat_id) REFERENCES boat (boat_id)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

