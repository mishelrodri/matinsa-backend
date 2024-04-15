
INSERT INTO "public"."categoria_producto" VALUES (2, 'Camisas');
INSERT INTO "public"."categoria_producto" VALUES (3, 'Pantalones');
INSERT INTO "public"."categoria_producto" VALUES (4, 'Uniformes Deportivos');

INSERT INTO "public"."rol" VALUES (1, 'ADMINISTRADOR');
INSERT INTO "public"."rol" VALUES (2, 'BODEGA');
INSERT INTO "public"."rol" VALUES (3, 'PRODUCCION');


INSERT INTO "public"."unidad" VALUES (1, 'Cajas');
INSERT INTO "public"."unidad" VALUES (2, 'Fardos');
INSERT INTO "public"."unidad" VALUES (3, 'Unidades');
INSERT INTO "public"."unidad" VALUES (4, 'Rollos');
INSERT INTO "public"."unidad" VALUES (5, 'Cubetas');


INSERT INTO "public"."cliente" VALUES (1, 'Calle Principal 123', 'Juan Pérez');
INSERT INTO "public"."cliente" VALUES (2, 'Avenida Libertad 456', 'María García');
INSERT INTO "public"."cliente" VALUES (3, 'Calle del Sol 789', 'Luis Martínez');
INSERT INTO "public"."cliente" VALUES (4, 'Paseo del Parque 210', 'Ana Rodríguez');
INSERT INTO "public"."cliente" VALUES (5, 'Carrera 7 #23-45', 'Pedro Sánchez');
INSERT INTO "public"."cliente" VALUES (6, 'Avenida Bolívar 567', 'Laura López');
INSERT INTO "public"."cliente" VALUES (7, 'Calle Mayor 890', 'Carlos Ruiz');
INSERT INTO "public"."cliente" VALUES (8, 'Calle de la Montaña 12', 'Sofía Hernández');
INSERT INTO "public"."cliente" VALUES (9, 'Calle Estrella 354', 'Diego González');
INSERT INTO "public"."cliente" VALUES (10, 'Avenida Central 678', 'Marta Díaz');


INSERT INTO "public"."producto" VALUES (15, 90, 'PT2', 'Falda de algodón', 't', 'Falda de algodón', 1, 2, 3);
INSERT INTO "public"."producto" VALUES (2, 200, 'MP1', 'Cuero genuino', 't', 'Cuero genuino', 2, NULL, 1);
INSERT INTO "public"."producto" VALUES (4, 250, 'MP3', 'Algodón orgánico', 't', 'Algodón orgánico', 2, NULL, 2);
INSERT INTO "public"."producto" VALUES (5, 180, 'MP4', 'Lana merino', 't', 'Lana merino', 2, NULL, 2);
INSERT INTO "public"."producto" VALUES (7, 400, 'MP6', 'Algodón reciclado', 't', 'Algodón reciclado', 2, NULL, 1);
INSERT INTO "public"."producto" VALUES (8, 220, 'MP7', 'Tela de seda artificial', 't', 'Tela de seda artificial', 2, NULL, 1);
INSERT INTO "public"."producto" VALUES (9, 270, 'MP8', 'Tela de nylon', 't', 'Tela de nylon', 2, NULL, 1);
INSERT INTO "public"."producto" VALUES (10, 320, 'MP9', 'Tela de rayón', 't', 'Tela de rayón', 2, NULL, 1);
INSERT INTO "public"."producto" VALUES (11, 400, 'MP10', 'Tela de lino orgánico', 't', 'Tela de lino orgánico', 2, NULL, 4);
INSERT INTO "public"."producto" VALUES (12, 180, 'MP11', 'Hilo de seda natural', 't', 'Hilo de seda natural', 2, NULL, 4);
INSERT INTO "public"."producto" VALUES (6, 120, 'MP5', 'Tela de lana', 't', 'Tela de lana', 2, NULL, 2);
INSERT INTO "public"."producto" VALUES (3, 200, 'MP2', 'Tela de poliéster', 't', 'Tela de poliéster', 2, NULL, 1);
INSERT INTO "public"."producto" VALUES (16, 150, 'PT3', 'Saco de lana', 't', 'Saco de lana', 1, 2, 3);
INSERT INTO "public"."producto" VALUES (17, 80, 'PT4', 'Chaleco de cuero', 't', 'Chaleco de cuero', 1, 2, 3);
INSERT INTO "public"."producto" VALUES (18, 200, 'PT5', 'Pantalon de lana', 't', 'Bufanda de lana', 1, 2, 3);
INSERT INTO "public"."producto" VALUES (14, 143, 'PT1', 'Blusa de seda', 't', 'Blusa de seda', 1, 2, 3);
INSERT INTO "public"."producto" VALUES (19, 25, 'PT6', 'Camisa Azul 1989', 't', 'Camisa Azul 1989', 1, 2, 1);
INSERT INTO "public"."producto" VALUES (43, 50, 'MP12', 'Camisa personalizada lover', 't', 'Camisa personalizada lover', 2, NULL, 1);

INSERT INTO "public"."usuario" VALUES (2, 'administrador@ues.edu.sv', 'ADMINISTRADOR', 'administrador', '$2a$10$nQ8eHiX.nnkPtj1JNFQODOdXjdT6X/rgd6MPyctFw4r9eQLnlKvbS', NULL, 1);
INSERT INTO "public"."usuario" VALUES (3, 'bodega@ues.edu.sv', 'BODEGA', 'bodega', '$2a$10$nQ8eHiX.nnkPtj1JNFQODOdXjdT6X/rgd6MPyctFw4r9eQLnlKvbS', NULL, 2);
INSERT INTO "public"."usuario" VALUES (4, 'produccion@ues.edu.sv', 'PRODUCCION', 'produccion', '$2a$10$nQ8eHiX.nnkPtj1JNFQODOdXjdT6X/rgd6MPyctFw4r9eQLnlKvbS', NULL, 3);
