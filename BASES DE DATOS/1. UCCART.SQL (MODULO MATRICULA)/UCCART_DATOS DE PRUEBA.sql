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

INSERT INTO cobro (cobro_id, cobro_codestudiante, cobro_monto, corbo_letra, cobro_fechapago, cobro_vencimiento, cobro_status, cobro_interes, cobro_detalle) VALUES
(1,'114100510', 20000, 10000, '2014-02-03', '2014-02-04', false, 1000, 'matricula');

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
('1', '1234', 'daniel', 1);


INSERT INTO curso (curso_id, curso_aula, curso_sede, curso_codmateria, curso_codprofesor, curso_cantmax, curso_cantmin, curso_cantactual, curso_periodo, curso_inicio, curso_final, curso_dia1, curso_dia1inicio, curso_dia1final, curso_dia2, curso_dia2inicio, curso_dia2final) VALUES
('1', '1', 'San Jose', '1', '12345', 15, 10, 12, 'IC- 2014', '2014-02-03', '2014-03-03' , 1, '08:00', '10:00', 1, '08:00', '10:00');

INSERT INTO nota (nota_codestudiante, nota_codcurso, nota_promedio, nota_condicion) VALUES
('114100510', '1', 100, 0);



















