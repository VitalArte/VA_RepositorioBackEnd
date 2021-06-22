create database db_VitalArte;

use db_VitalArte;

CREATE TABLE `tb_tema` (
	`id_tema` bigint NOT NULL AUTO_INCREMENT,
	`tema` varchar(100) NOT NULL,
	`descricao` varchar(255) NOT NULL,
	`palavra_chave` varchar(100) NOT NULL,
	PRIMARY KEY (`id_tema`)
);

CREATE TABLE `tb_postagem` (
	`id_postagem` bigint NOT NULL AUTO_INCREMENT,
	`titulo` varchar(100) NOT NULL,
	`corpo` varchar(1000) NOT NULL,
	`hashtags` varchar(255) NOT NULL,
	`curtir` int NOT NULL,
	`data_hora` TIMESTAMP NOT NULL,
	`multimidia` varchar(255) NOT NULL,
	`autor_id` bigint NOT NULL,
	`tema_id` bigint NOT NULL,
	PRIMARY KEY (`id_postagem`)
);

CREATE TABLE `tb_usuario` (
	`id_usuario` bigint NOT NULL AUTO_INCREMENT,
	`nome` varchar(100) NOT NULL,
	`email` varchar(100) NOT NULL,
	`senha` varchar(100) NOT NULL,
	`tipo_conta` varchar(100) NOT NULL,
	`foto` varchar(255) NOT NULL,
	`biografia` varchar(255) NOT NULL,
	PRIMARY KEY (`id_usuario`)
);

ALTER TABLE `tb_postagem` ADD CONSTRAINT `tb_postagem_fk0` FOREIGN KEY (`autor_id`) REFERENCES `tb_usuario`(`id_usuario`);

ALTER TABLE `tb_postagem` ADD CONSTRAINT `tb_postagem_fk1` FOREIGN KEY (`tema_id`) REFERENCES `tb_tema`(`id_tema`);

