-- Limpare base de dados caso já exista
DROP TABLE IF EXISTS `db_gs_processos`.`perfil`;
DROP TABLE IF EXISTS `db_gs_processos`.`parecer`;
DROP TABLE IF EXISTS `db_gs_processos`.`processos`;
DROP TABLE IF EXISTS  `db_gs_processos`.`usuarios`;

-- Usuários
CREATE TABLE `db_gs_processos`.`usuarios` (
  `id_usuarios` int NOT NULL AUTO_INCREMENT,
  `nome_usuarios` varchar(200) NOT NULL,
  `cpf_usuarios` varchar(11) NOT NULL,
  `email_usuarios` varchar(200) NOT NULL,
  `senha_usuarios` varchar(500) NOT NULL,
  `status_usuarios` varchar(1) NOT NULL,
  `data_cadastro` datetime NOT NULL,
  PRIMARY KEY (`id_usuarios`),
  UNIQUE KEY `email_usuarios_unique` (`email_usuarios`),
  UNIQUE KEY `cfp_usuarios_unique` (`cpf_usuarios`)
) ENGINE = innodb;

-- Perfil
CREATE TABLE `db_gs_processos`.`perfil` (
  `perfis` int DEFAULT NULL,
  `usuarios_id_usuarios` int NOT NULL,
  FOREIGN KEY ( `usuarios_id_usuarios`) REFERENCES `db_gs_processos`.`usuarios`(`id_usuarios`)
) ENGINE= innodb;

-- Processos
CREATE TABLE `db_gs_processos`.`processos` (
  `id_processos` int NOT NULL AUTO_INCREMENT,
  `numero_processos` varchar(200) NOT NULL,
  `titulo_processos` varchar(200) NOT NULL,
  `texto_processos` varchar(2000) NOT NULL,
  `dt_cadastro_processos` datetime NOT NULL,
  `status_processos` varchar(1) NOT NULL,
  PRIMARY KEY (`id_processos`),
  UNIQUE KEY `numero_processo_unique` (`numero_processos`)
) ENGINE = innodb;

-- Parecer
CREATE TABLE `db_gs_processos`.`parecer` (
  `id_parecer` int NOT NULL AUTO_INCREMENT,
  `texto_parecer` varchar(2000),
  `decisao_parecer` varchar(1),
  `id_usuario_parecer` int NOT NULL,
  `id_processo_parecer` int NOT NULL,
  `dt_cadastro_parecer` datetime NOT NULL,
  PRIMARY KEY (`id_parecer`),
  FOREIGN KEY (`id_usuario_parecer`) REFERENCES `db_gs_processos`.`usuarios`(`id_usuarios`),
  FOREIGN KEY (`id_processo_parecer`) REFERENCES `db_gs_processos`.`processos`(`id_processos`)
) ENGINE = innodb;

-- Inserts Iniciais
-- Usuários: Admin -- Senha de acesso: 4N1mY33iKR ---
INSERT INTO `db_gs_processos`.`usuarios` VALUES (1, 'Softplan Admin', '16945057070', 'admin@hotmail.com','$2a$10$xlJj6HLuAeOpfZAYFVuTqOnP7Vfn9L6JhOKTTQRs9//gkd82xrQuu','A','2020-11-14 22:04:04');
INSERT INTO `db_gs_processos`.`perfil` VALUES (1,1);

-- Usários: Triadores --- Senha de acesso: 4N1mY33iKR ---
INSERT INTO `db_gs_processos`.`usuarios` VALUES (2, 'Softplan Triador 1', '07676770050', 'triador_um@hotmail.com','$2a$10$xlJj6HLuAeOpfZAYFVuTqOnP7Vfn9L6JhOKTTQRs9//gkd82xrQuu','A','2020-11-14 22:05:04');
INSERT INTO `db_gs_processos`.`perfil` VALUES (2,2);

INSERT INTO `db_gs_processos`.`usuarios` VALUES (3, 'Softplan Triador 2', '22099347026', 'triador_dois@hotmail.com','$2a$10$xlJj6HLuAeOpfZAYFVuTqOnP7Vfn9L6JhOKTTQRs9//gkd82xrQuu','A','2020-11-14 22:06:04');
INSERT INTO `db_gs_processos`.`perfil` VALUES (2,3);

-- Usuários:Finalizadores --- Senha de acesso: 4N1mY33iKR ---
INSERT INTO `db_gs_processos`.`usuarios` VALUES (4, 'Softplan Finalizador 1', '06202937050', 'fin_um@hotmail.com','$2a$10$xlJj6HLuAeOpfZAYFVuTqOnP7Vfn9L6JhOKTTQRs9//gkd82xrQuu','A','2020-11-15 22:06:04');
INSERT INTO `db_gs_processos`.`perfil` VALUES (3,4);

INSERT INTO `db_gs_processos`.`usuarios` VALUES (5, 'Softplan Finalizador 2', '89768303000', 'fin_dois@hotmail.com','$2a$10$xlJj6HLuAeOpfZAYFVuTqOnP7Vfn9L6JhOKTTQRs9//gkd82xrQuu','A','2020-11-15 22:10:04');
INSERT INTO `db_gs_processos`.`perfil` VALUES (3,5);

INSERT INTO `db_gs_processos`.`usuarios` VALUES (6, 'Softplan Finalizador 3', '55214369018', 'fin_tres@hotmail.com','$2a$10$xlJj6HLuAeOpfZAYFVuTqOnP7Vfn9L6JhOKTTQRs9//gkd82xrQuu','A','2020-11-15 22:11:04');
INSERT INTO `db_gs_processos`.`perfil` VALUES (3,6);


-- Processos
INSERT INTO `db_gs_processos`.`processos` VALUES (1, '2020.12.01.54265-8', 'Procedimento Cautelar - Maria Silva', 'Procedimento cautelar promovido em favor de Maria da Silva',  '2020-11-14', 'A');
INSERT INTO `db_gs_processos`.`processos` VALUES (2, '2020.90.34.69854-6', 'Ação de Cobrança - Carlos Santos', 'Ação de cobrança promovido em favor de Carlos Santos',  '2020-11-12', 'A');
INSERT INTO `db_gs_processos`.`processos` VALUES (3, '2020.09.06.76541-5', 'Inventário - Aurélio Lima', 'Inventário promovido em favor de Aurélio Lima',  '2020-11-10', 'A');
INSERT INTO `db_gs_processos`.`processos` VALUES (4, '2020.04.09.54218-9', 'Ação de Cobrança - Marcio Leite', 'Ação de Cobranca promovido em favor de Marcio Leite',  '2020-11-13', 'A');
INSERT INTO `db_gs_processos`.`processos` VALUES (5, '2020.36.03.56478-2', 'Ação de Indenização - Carlos Luz', 'Ação de indenização promovido em favor de Carlos Luz',  '2020-11-12', 'A');

-- Parecer 
INSERT INTO `db_gs_processos`.`parecer` VALUES (1, null, null, '1', '1', '2020-11-14');
INSERT INTO `db_gs_processos`.`parecer` VALUES (2, null, null, '2', '2', '2020-11-14');
INSERT INTO `db_gs_processos`.`parecer` VALUES (3, null, null, '3', '3', '2020-11-14');
INSERT INTO `db_gs_processos`.`parecer` VALUES (4, null, null, '4', '4', '2020-11-14');
INSERT INTO `db_gs_processos`.`parecer` VALUES (5, null, null, '5', '5', '2020-11-14');
INSERT INTO `db_gs_processos`.`parecer` VALUES (6, null, null, '6', '1', '2020-11-14');