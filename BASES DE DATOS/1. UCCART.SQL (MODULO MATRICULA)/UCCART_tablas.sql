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

CREATE TABLE IF NOT EXISTS estudiante (
    est_id character varying(30) NOT NULL,
    est_nombre character varying(30) NOT NULL,
    est_apellido1 character varying(30) NOT NULL,
    est_apellido2 character varying(30) NOT NULL,
    est_celular integer,
    est_telefono integer,
    est_correo character varying(255),
    est_status smallint NOT NULL,
    est_becado boolean DEFAULT false,
    est_direccion character varying NOT NULL,
    est_nacionalidad character varying(20) NOT NULL,
    est_genero boolean DEFAULT true,
    est_nacimiento date NOT NULL,
    est_codtitulo integer,
    est_trabajo character varying(255),
    PRIMARY KEY (est_id),
    FOREIGN KEY (est_codtitulo) REFERENCES titulo(tit_codigo)
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

CREATE TABLE IF NOT EXISTS profesor (
    prof_id character varying(30) NOT NULL,
    prof_nombre character varying(30) NOT NULL,
    prof_apellido1 character varying(30) NOT NULL,
    prof_apellido2 character varying(30) NOT NULL,
    prof_gradoacademico character varying(255),
    prof_telefono integer,
    prof_correo character varying(255),
    PRIMARY KEY (prof_id)
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
