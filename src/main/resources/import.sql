INSERT INTO marcas ( nombre)  VALUES ('Epson'),('HP (Hewlett-Packard)'),('Canon'), ('Brother'),('Samsung'),('Xerox'),('Lexmark'),('Dell'),('Ricoh'),('Kyocera'),('Panasonic');

INSERT INTO roles (descripcion) VALUES ('ADMINSITRADOR'),('COMPUTO'),('JEFE DE AREA'),('PERSONAL');


INSERT INTO servicios (nombre) VALUES ('ADMINISTRADOR'),('COMPUTOS'),('CONTABLE'),('NEUROLOGIA Y NEUROCIRUGIA'),('DEPOSITO'),('QUIROFANO CENTRAL'),('GUARDIA CENTRAL'),('FACTURACION'),('NUTRICION'),('LABORATORIO CENTRAL'),('TELEMEDICINA'),('ESTADISTICA'),('CIRUGIA GENERAL'),('KINESIOLOGIA Y FISIOTERAPIA'),('ANATOMIA PATOLOGICA'),('TECNICA Y OPERATIVA'),('DIRECCION ADMINISTRATIVA'),('LIQUIDACION DE HABERES'),('DIRECCION MEDICA'),('JEFA DE DPTO DE ENFERMERIA'),('FARMACIA Y ESTERILIZACION'),('SERVICIO SOCIAL');

INSERT INTO tipo_carga (descripcion) VALUES ('ORIGINAL'),('RECARGA'),('ALTERNATIVO');

INSERT INTO tipo_cartuchos (descripcion) VALUES ('ESTANDAR'),('TONER'),('TINTA');

INSERT INTO colores (nombre) VALUES ('NEGRO (BLACK)'),('COLOR(C,M,Y)'),('CIAN (CYAN)'),('MAGENTA'),('AMARILLO (YELLOW)');

INSERT INTO tipo_impresoras (descripcion) VALUES ('INYECCION DE TINTA'),('LASER'),('MULTIFUNCION'),('TONER');

INSERT INTO estados (descripcion) VALUES ('SOLICITADA'),('APROBADA'),('OBSERVADA'),('CANCELADA');


INSERT INTO cartuchos (color_id, marca_id,tipo_cartucho_id ,capacidad, descripcion, modelo) VALUES (1,2, 1,'80 ml','Para impresoras DesignJet T120 / T130 / T520.','Hp 711xl');

INSERT INTO cartuchos (color_id, marca_id,tipo_cartucho_id ,capacidad, descripcion, modelo) VALUES (2,2, 1,'50 ml','Para impresoras DesignJet T120 / T130 / T520.','Hp 711');

INSERT INTO cartuchos (color_id, marca_id,tipo_cartucho_id ,capacidad, descripcion, modelo) VALUES (1,2, 1,'50 ml','HP 1115 2135 2675 3635 3775 4535 4536 4538 4675 4676 4678','Hp 664');

INSERT INTO cartuchos (color_id, marca_id,tipo_cartucho_id ,capacidad, descripcion, modelo) VALUES (2,2, 1,'50 ml','HP 2135 3635 4535','Hp 664');


INSERT INTO cartuchos (color_id, marca_id,tipo_cartucho_id ,capacidad, descripcion, modelo) VALUES (1,1, 1,'40 ml','Para impresoras  Xp231 431 241 X4 ','E 296');

INSERT INTO cartuchos (color_id, marca_id,tipo_cartucho_id ,capacidad, descripcion, modelo) VALUES (3,1, 1,'40 ml','Para impresoras  Xp231 431 241 X4 ','E 296');
INSERT INTO cartuchos (color_id, marca_id,tipo_cartucho_id ,capacidad, descripcion, modelo) VALUES (4,1, 1,'40 ml','Para impresoras  Xp231 431 241 X4 ','E 296');
INSERT INTO cartuchos (color_id, marca_id,tipo_cartucho_id ,capacidad, descripcion, modelo) VALUES (5,1, 1,'40 ml','Para impresoras  Xp231 431 241 X4 ','E 296');


INSERT INTO impresoras (marca_id,tipo_impresora_id,descripcion,modelo) VALUES (2,1,'Impresora a color multifunción ','Deskjet Ink Advantage 2775');

INSERT INTO impresoras (marca_id,tipo_impresora_id,descripcion,modelo) VALUES (1,1,'Impresora a color multifunción Epson Expression XP-2101 con wifi ','Deskjet Ink Advantage 2775');

INSERT INTO impresoras_cartuchos (cartuchos_id,impresora_id) VALUES (1,1);
INSERT INTO impresoras_cartuchos (cartuchos_id,impresora_id) VALUES (2,1);

INSERT INTO impresoras_cartuchos (cartuchos_id,impresora_id) VALUES (5,2);
INSERT INTO impresoras_cartuchos (cartuchos_id,impresora_id) VALUES (6,2);


INSERT INTO `personas` (`create_at`, `dni`, `servicio_id`, `apellido`, `nombre`) VALUES (NOW(), 999, 1,'ADMIN','ADMIN');
INSERT INTO `personas` (`create_at`, `dni`, `servicio_id`, `apellido`, `nombre`) VALUES (NOW(), 111, 2,'COMPUTO','COMPUTO');

INSERT INTO `personas` (`create_at`, `dni`, `servicio_id`, `apellido`, `nombre`) VALUES (NOW(),38746133, 5,'GUZMAN','DANTE ISMAEL');

INSERT INTO `personas` (`create_at`, `dni`, `servicio_id`, `apellido`, `nombre`) VALUES (NOW(),24612995, 5,'POCLAVA','SILVIA FERNANDA');


INSERT INTO `user` (`create_at`, `enabled`, `persona_id`, `username`, `email`, `password`) VALUES (NOW(), true, 1, 'admin', 'admin@gmail.com','$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS');
INSERT INTO `user` (`create_at`, `enabled`, `persona_id`, `username`, `email`, `password`) VALUES (NOW(), true, 2, 'computo', 'computo@gmail.com','$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS');
INSERT INTO `user` (`create_at`, `enabled`, `persona_id`, `username`, `email`, `password`) VALUES (NOW(), true, 3, 'guzman', 'guszman@gmail.com','$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS');
INSERT INTO `user` (`create_at`, `enabled`, `persona_id`, `username`, `email`, `password`) VALUES (NOW(), true, 4, 'silvia', 'silvia@gmail.com','$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS');


INSERT INTO `users_roles` (`rol_id`, `user_id`) VALUES (1, 1);
INSERT INTO `users_roles` (`rol_id`, `user_id`) VALUES (2, 2);
INSERT INTO `users_roles` (`rol_id`, `user_id`) VALUES (3, 3);
INSERT INTO `users_roles` (`rol_id`, `user_id`) VALUES (4, 4);




