CREATE TABLE IF NOT EXISTS persona(
    persona_id serial NOT NULL,
    persona_nombre varchar(100) NOT NULL,
    persona_identificacion varchar(50) NOT NULL,
    persona_apellido1 character varying(30) NOT NULL,
    persona_apellido2 character varying(30),
    persona_telefono integer,
    persona_celular integer,
    persona_direccion varchar(200),
    persona_nacionalidad varchar(50) NOT NULL,
    persona_genero boolean DEFAULT true NOT NULL,
    persona_nacimineto date NOT NULL,
    persona_correo character varying(255),
    PRIMARY KEY (persona_id)
);

CREATE TABLE IF NOT EXISTS estudiante (
    est_id character varying(30) NOT NULL,
    est_persona_id integer NOT NULL,
    est_status smallint NOT NULL,
    est_becado boolean DEFAULT false,
    est_codtitulo integer,
    est_trabajo character varying(255),
    PRIMARY KEY (est_id),
    FOREIGN KEY (est_persona_id) REFERENCES persona(persona_id),
    FOREIGN KEY (est_codtitulo) REFERENCES titulo(tit_codigo)
);

CREATE TABLE IF NOT EXISTS profesor (
    prof_id character varying(30) NOT NULL,
    prof_persona_id integer NOT NULL,
    prof_gradoacademico character varying(255),
    PRIMARY KEY (prof_id),
    FOREIGN KEY (prof_persona_id) REFERENCES persona(persona_id)
);

CREATE TABLE IF NOT EXISTS empleado(
    empleado_id serial NOT NULL,
    empleado_persona_id integer NOT NULL,
    empleado_salario integer NOT NULL,
    empleado_puesto varchar (50),
    empleado_gradoAcademico varchar (50) NOT NULL,
    PRIMARY KEY (empleado_id)
);



CREATE VIEW IF NOT EXIST estudiantes_view(
SELECT persona_identificacion as est_id, 
persona_nombre as est_nombre, 
persona_apellido1 as est_apellido1, 
persona_apellido2 as est_apellido2,   
persona_celular as est_celular,
persona_telefono as est_telefono
persona_correo as est_correo,
est_status,
est_becado,
persona_direccion as est_direccion,
persona_nacionalidad as est_nacionalidad,
persona_genero as est_genero,
persona_nacimineto as est_nacimiento,
est_trabajo,
est_codtitulo
FROM persona JOIN estudiante ON personas.persona_id = estudiante.est_persona_id;
)

CREATE VIEW IF NOT EXIST profesor_view(
SELECT persona_identificacion as prof_id,
persona_nombre as prof_nombre, 
persona_apellido1 as prof_apellido1, 
persona_apellido2 as prof_apellido2,   
persona_celular as prof_celular,
persona_telefono as prof_telefono,
persona_correo as prof_correo,
prof_gradoacademico
FROM persona JOIN profesor ON personas.persona_id = profesor.prof_persona_id;
)

CREATE VIEW IF NOT EXIST empleado_view(
SELECT persona_identificacion as empleado_id,
persona_nombre as empleado_nombre, 
persona_apellido1 as empleado_apellido1, 
persona_apellido2 as empleado_apellido2,   
persona_celular as empleado_celular,
persona_telefono as empleado_telefono,
persona_correo as empleado_correo,
empleado_puesto,
empleado_gradoAcademico,
empleado_salario
FROM persona JOIN profesor ON personas.persona_id = empleado.prof_persona_id;
)




CREATE TABLE IF NOT EXISTS carrera (
    carr_cod character varying(30) NOT NULL,
    carr_nombre character varying(255) NOT NULL,
    carr_credmax integer NOT NULL,
    PRIMARY KEY (carr_cod)
);

CREATE TABLE IF NOT EXISTS titulo (
    tit_tomo integer NOT NULL,
    tit_folio integer NOT NULL,
    tit_asiento integer NOT NULL,
    tit_codigo integer NOT NULL,
    PRIMARY KEY (tit_codigo)
);


CREATE TABLE IF NOT EXISTS contrasenas (
    cont_pw character varying(30),
    cont_idestudiante character varying(30) NOT NULL,
    PRIMARY KEY (cont_idestudiante),
    FOREIGN KEY (cont_idestudiante) REFERENCES estudiante(est_id)
);

CREATE TABLE IF NOT EXISTS beca (
    beca_idestudiante character varying(30) NOT NULL,
    beca_inicio date,
    beca_vencimiento date NOT NULL,
    beca_tipo smallint,
    beca_porcentaje integer NOT NULL,
    PRIMARY KEY (beca_idestudiante),
    FOREIGN KEY (beca_idestudiante) REFERENCES estudiante(est_id)
);

CREATE TABLE IF NOT EXISTS materia (
    materia_id character varying(30) NOT NULL,
    materia_nombre character varying(255) NOT NULL,
    materia_lab smallint DEFAULT 0,
    materia_creditos smallint NOT NULL,
    materia_area character varying(50) NOT NULL,
    PRIMARY KEY (materia_id)
);

CREATE TABLE IF NOT EXISTS cobro (
    cobro_id integer NOT NULL,
    cobro_codestudiante character varying(30) NOT NULL,
    cobro_monto real NOT NULL,
    corbo_letra integer,
    cobro_fechapago date,
    cobro_vencimiento date,
    cobro_status boolean DEFAULT false,
    cobro_interes integer DEFAULT 1000,
    cobro_detalle character varying(500),
    PRIMARY KEY (cobro_id),
    FOREIGN KEY (cobro_codestudiante) REFERENCES estudiante(est_id)
);

CREATE TABLE IF NOT EXISTS padron (
    pad_serial integer NOT NULL,
    pad_idestudiante character varying(30) NOT NULL,
    pad_codcarr character varying(30) NOT NULL,
    PRIMARY KEY (pad_serial),
    FOREIGN KEY (pad_codcarr) REFERENCES carrera(carr_cod),
    FOREIGN KEY (pad_idestudiante) REFERENCES estudiante(est_id)
);

CREATE TABLE IF NOT EXISTS periodo (
    per_periodo character varying(50) NOT NULL,
    per_web date NOT NULL,
    per_local date NOT NULL,
    PRIMARY KEY (per_periodo)
);

CREATE TABLE IF NOT EXISTS plan (
    plan_cod integer NOT NULL,
    plan_carrera character varying(30),
    plan_materia character varying(30),
    plan_ciclo integer,
    PRIMARY KEY (plan_cod),
    FOREIGN KEY (plan_carrera) REFERENCES carrera(carr_cod),
    FOREIGN KEY (plan_materia) REFERENCES materia(materia_id)
);

CREATE TABLE IF NOT EXISTS requisito (
    req_cod integer NOT NULL,
    req_requisito character varying(30),
    req_materia character varying(30),
    req_carrera character varying(30),
    req_tipo boolean,
    PRIMARY KEY (req_cod),
    FOREIGN KEY (req_carrera) REFERENCES carrera(carr_cod),
    FOREIGN KEY (req_materia) REFERENCES materia(materia_id),
	FOREIGN KEY (req_requisito) REFERENCES materia(materia_id)
);

CREATE TABLE IF NOT EXISTS usuario (
    us_id character varying(30) NOT NULL,
    us_pw character varying(30),
    us_nombre character varying(50),
    us_tipo integer,
    PRIMARY KEY (us_id)
);

CREATE TABLE IF NOT EXISTS curso (
    curso_id character varying(30) NOT NULL,
    curso_aula character varying(30),
    curso_sede character varying(50),
    curso_codmateria character varying(30),
    curso_codprofesor character varying(30),
    curso_cantmax integer NOT NULL,
    curso_cantmin integer NOT NULL,
    curso_cantactual integer,
    curso_periodo character varying(30),
    curso_inicio date NOT NULL,
    curso_final date NOT NULL,
    curso_dia1 integer,
    curso_dia1inicio time without time zone,
    curso_dia1final time without time zone,
    curso_dia2 integer,
    curso_dia2inicio time without time zone,
    curso_dia2final time without time zone,
    PRIMARY KEY (curso_id),
    FOREIGN KEY (curso_codmateria) REFERENCES materia(materia_id),
    FOREIGN KEY (curso_codprofesor) REFERENCES profesor(prof_id),
    FOREIGN KEY (curso_periodo) REFERENCES periodo(per_periodo)
);  

CREATE TABLE IF NOT EXISTS nota (
    nota_codestudiante character varying(30) NOT NULL,
    nota_codcurso character varying(30) NOT NULL,
    nota_promedio integer,
    nota_condicion integer DEFAULT 0,
    PRIMARY KEY (nota_codestudiante, nota_codcurso),
    FOREIGN KEY (nota_codcurso) REFERENCES curso(curso_id),
    FOREIGN KEY (nota_codestudiante) REFERENCES estudiante(est_id)
);

CREATE TABLE IF NOT EXISTS tipos_de_documento (
    tipoDoc_id serial NOT NULL,
    tipoDoc varchar(50),

    PRIMARY KEY (tipoDoc_id)
)

INSERT INTO tipos_de_documento (tipoDoc_id, tipoDoc) VALUES
(1, 'Facturas de entrada de dinero'),
(2, 'Facturas de salida de dinero'),
(3, 'Recibo por dinero');

CREATE TABLE IF NOT EXISTS condiciones_de_venta (
    condicionVenta_id serial NOT NULL,
    condicionVenta varchar (50) NOT NULL,

    PRIMARY KEY (condicionVenta_id)
)

INSERT INTO condiciones_de_venta (condicionVenta_id, condicionVenta) VALUES
(1, 'Contado'),
(2, 'Crédito');

CREATE TABLE IF NOT EXISTS factura (
    factura_id serial NOT NULL,
    factura_idPersona integer NOT NULL,
    factura_tipoDoc integer NOT NULL,
    factura_fecha date NOT null,
    factura_condicionVenta integer not null,
    factura_subTotal integer NOT NULL,
    factura_descuentos integer NOT NULL,
    factura_total integer NOT NULL,
    factura_numeroReferencia integer,
    factura_razonReferencia varchar(200),

    PRIMARY KEY (factura_id),
    FOREIGN KEY (factura_idPersona) REFERENCES persona(persona_id),
    FOREIGN KEY (factura_tipoDoc) REFERENCES tipos_de_documento(tipoDoc_id),
    FOREIGN KEY (factura_condicionVenta) REFERENCES condiciones_de_venta(condicionVenta_id)
);

CREATE TABLE IF NOT EXISTS detalleFactura (
    detalleFactura_id serial NOT NULL,
    detalleFactura_facturaId integer (50),
    detalleFactura_codigo varchar(50) NOT NULL,
    detalleFactura_detalle varchar(200) NOT NULL,
    detalleFactura_precio integer NOT NULL,
    detalleFactura_cantidad integer NOT NULL,
    detalleFactura_subTotal integer NOT NULL,
    detalleFactura_descuento integer NOT NULL,
    detalleFactura_total integer NOT NULL,

    PRIMARY KEY (detalleFactura_id),
    FOREIGN KEY (detalleFactura_facturaId) REFERENCES factura(factura_id)
    );
































