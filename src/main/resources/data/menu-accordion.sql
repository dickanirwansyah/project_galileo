create database springAccordion;

use springAccordion;

CREATE TABLE menu_accordion(


    idmenu INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    link VARCHAR(255) NOT NULL,
    parentid INT,


    CONSTRAINT pk_idmenu PRIMARY KEY (idmenu),
    CONSTRAINT fk_idmenu_parentid  FOREIGN KEY (parentid) REFERENCES menu_accordion(idmenu)

);

CREATE TABLE kategori(

    idkategori INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    deskripsi VARCHAR(255),
    active boolean,

    CONSTRAINT pk_idkategori PRIMARY KEY (idkategori)

);

CREATE TABLE mobil(


    idmobil INT NOT NULL AUTO_INCREMENT,
    images VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    tahun DATE NOT NULL,
    idkategori INT NOT NULL,
    active boolean,

    CONSTRAINT pk_idmobi PRIMARY KEY (idmobil),
    CONSTRAINT fk_mobil_idkategori FOREIGN KEY (idkategori) REFERENCES kategori(idkategori)
);

CREATE TABLE menu(

    idmenus INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    link VARCHAR(255) NOT NULL,

    CONSTRAINT pk_menu_idmenus PRIMARY KEY (idmenus)

);

CREATE TABLE user(

    iduser INT NOT NULL AUTO_INCREMENT,
    email VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    active INT,

    CONSTRAINT pk_user_iduser PRIMARY KEY(iduser)
    
);


CREATE TABLE role(

    idrole INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),

    CONSTRAINT pk_role_idrole PRIMARY KEY (idrole)
);


CREATE TABLE user_role(

    iduser INT NOT NULL,
    idrole INT NOT NULL,
    
    CONSTRAINT pk_user_role_iduser_idrole PRIMARY KEY (iduser, idrole),
    CONSTRAINT fk_user_role_iduser FOREIGN KEY (iduser) REFERENCES user(iduser),
    CONSTRAINT fk_user_role_idrole FOREIGN KEY (idrole) REFERENCES role(idrole) 
    
);