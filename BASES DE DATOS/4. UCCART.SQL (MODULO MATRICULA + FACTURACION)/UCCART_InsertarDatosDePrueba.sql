INSERT INTO carrera (carr_cod, carr_nombre, carr_credmax) VALUES
('BBA','Bachillerato en Bellas Artes',12),
('BDP','Bachillerato en Diseño Publicitario',12),
('BMU','Bachillerato en Música',12),
('EAP','Bachillerato en Enseñanza de las Artes Plasticas',16),
('EMU','Bachillerato en Enseñanza de la Música',16),
('MDU','Maestría en Docencia Universitaria',12);

INSERT INTO titulo (tit_tomo, tit_folio, tit_asiento,tit_codigo) VALUES
(12,12,12,12);


INSERT INTO estudiante (est_id, est_nombre, est_apellido1, est_apellido2, est_celular, est_telefono, est_correo, est_status, est_becado, est_direccion, est_nacionalidad, est_genero, est_nacimiento, est_codtitulo, est_trabajo) VALUES
('114100510','Daniel Herrera Villegas','Herrera','Villegas', 88892122,22408089,'danielhv89@gmail.com',1,true,'Tibas','Costa Rica',true,'1989-11-20',12,'informatica');



INSERT INTO beca (beca_idestudiante, beca_inicio, beca_vencimiento, beca_tipo, beca_porcentaje) VALUES
('114100510','2014-04-03', '2016-04-03', 1, 20);

INSERT INTO materia (materia_id, materia_nombre, materia_lab, materia_creditos, materia_area) VALUES
('1','Instrumento 1', 0, 4, 'Musica');


INSERT INTO padron (pad_serial, pad_idestudiante, pad_codcarr) VALUES
(1,'114100510','BBA');

INSERT INTO periodo (per_periodo, per_web, per_local) VALUES
('IC- 2014','2014-02-03','2014-02-04');

INSERT INTO plan (plan_cod, plan_carrera, plan_materia, plan_ciclo) VALUES
(1,'BBA','1', 1);


INSERT INTO profesor (prof_id, prof_nombre, prof_apellido1, prof_apellido2, prof_gradoacademico, prof_telefono, prof_correo) VALUES
('12345','Armando', 'Madrigal', 'Gomez', 'Maestria', 88891234, 'armando@gmail.com');

INSERT INTO requisito (req_cod, req_requisito, req_materia, req_carrera, req_tipo) VALUES
(1, '1', '1', 'BBA', false);

INSERT INTO usuario (us_id, us_pw, us_nombre, us_tipo) VALUES
('1', '1234', 'daniel', 1),
('1234', '1234', 'rector', 8),
('12', '12', 'Ronald Melendez', 4);



INSERT INTO curso (curso_id, curso_aula, curso_sede, curso_codmateria, curso_codprofesor, curso_cantmax, curso_cantmin, curso_cantactual, curso_periodo, curso_inicio, curso_final, curso_dia1, curso_dia1inicio, curso_dia1final, curso_dia2, curso_dia2inicio, curso_dia2final) VALUES
('1', '1', 'San Jose', '1', '12345', 15, 10, 12, 'IC- 2014', '2014-02-03', '2014-03-03' , 1, '08:00', '10:00', 1, '08:00', '10:00');

INSERT INTO nota (nota_codestudiante, nota_codcurso, nota_promedio, nota_condicion) VALUES
('114100510', '1', 100, 0);



-------------------------------------------
------ EMPIEZA NUEVA PARTE DE LA BASE------
-------------------------------------------

INSERT INTO empleados (personas_id, personas_nombre, personas_apellido1, personas_apellido2,  personas_fecha_de_nacimiento, personas_telefonocasa, personas_telefonocel, personas_direccion, personas_genero, personas_nacionalidad, personas_correo, empleados_salario_bruto, empleados_puesto) VALUES
(114100510, 'Daniel', 'Herrera', 'Villegas', '1989-11-20', '22408089', '88892122', 'Tibas','masculino','Costa Rica', 'daniel@correo.com', 30000, 'computin' );

INSERT INTO clientes (personas_id, personas_nombre, personas_apellido1, personas_apellido2, personas_fecha_de_nacimiento, personas_telefonocasa, personas_telefonocel, personas_direccion, personas_genero, personas_nacionalidad, personas_correo, clientes_tipo) VALUES
(1, 'Pedro', 'Arias', 'Mendez', '1989-11-20', '22408089', '88892122', 'Tibas', 'masculino','Costa Rica', 'daniel@correo.com','estudiante' );

INSERT INTO aranceles (aranceles_id, aranceles_descripcion, aranceles_precio, aranceles_tipo) VALUES
(1, 'Examen de Reposición', 15000, 'entrada'),
(2, 'Titulo', 15000, 'entrada');

INSERT INTO facturas_entrada (facturas_entrada_id, facturas_entrada_id_empleado, facturas_entrada_id_cliente, facturas_entrada_nombre, facturas_entrada_direccion, facturas_entrada_telefono, facturas_entrada_metodo_de_pago, facturas_entrada_total) VALUES
(1, '114100510', '1', 'Daniel', 'Tibas', '88892122', 'contado', 1000000);

INSERT INTO detalles_de_factura_entrada (detfac_entrada_id_detalle_factura, detfac_entrada_id_factura, detfac_entrada_id_arancel, detfac_entrada_descripcion, detfac_entrada_numero_linea, detfac_entrada_precio_unitario, detfac_entrada_descuento, detfac_entrada_descripcion_descuento, detfac_entrada_total_bruto, detfac_entrada_subtotal, detfac_entrada_cantidad) VALUES
(1, 1, 1, 'Titulo', 1, 15000, 00, 'nada', 15000, 15000, 1);

INSERT INTO recibo_entrada (reciboEntrada_id, reciboEntrada_id_factura_entrada, reciboEntrada_id_empleado, reciboEntrada_fecha, reciboEntrada_descripcion, reciboEntrada_saldo_anterior, reciboEntrada_recargo_por_mora, reciboEntrada_este_abono, reciboEntrada_saldo_actual) VALUES
(1, 1, 1, '2014-01-20', 'titulo', 15000, 0, 15000, 0);

INSERT INTO recibo_Salida (recibosalida_id, recibosalida_id_empleado, recibosalida_id_aranceles, recibosalida_fecha, recibosalida_descripcion, recibosalida_monto) VALUES
(1, '114100510', '1','2014-11-20', 'Salario', 2000);

INSERT INTO facturas_salida (facturas_salida_id, facturas_salida_id_empleado, facturas_salida_id_cliente, facturas_salida_nombre, facturas_salida_direccion, facturas_salida_telefono, facturas_salida_metodo_de_pago, facturas_salida_total) VALUES
(1, '114100510', '1', 'Daniel', 'Tibas', '88892122', 'contado', 1000000);

INSERT INTO detalles_de_factura_salida (detfac_salida_id_detalle_factura, detfac_salida_id_factura, detfac_salida_id_arancel, detfac_salida_descripcion, detfac_salida_numero_linea, detfac_salida_precio_unitario, detfac_salida_descuento, detfac_salida_descripcion_descuento, detfac_salida_total_bruto, detfac_salida_subtotal, detfac_salida_cantidad) VALUES
(1, 1, 1, 'Titulo', 1, 15000, 00, 'nada', 15000, 15000, 1);

INSERT INTO cuentas_por_cobrar (cuentascobrar_id, cuentascobrar_id_factura_entrada, cuentascobrar_saldo) VALUES
(1, 1, 2000);

INSERT INTO cuentas_por_pagar (cuentaspagar_id, cuentaspagar_id_factura_salida, cuentaspagar_saldo) VALUES
(1, 1, 2000);

INSERT INTO inventario (inventario_id, inventario_nombre, inventario_marca, inventario_modelo, inventario_valor, inventario_cantidad, inventario_proveedor) VALUES
(1, 'Computadora', 'DEll', 'Inspiration', 20000, 1, 'COMPUFAX.SA');










