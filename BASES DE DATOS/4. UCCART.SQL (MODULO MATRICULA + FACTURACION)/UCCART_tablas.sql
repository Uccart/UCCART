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


------ EMPIEZA NUEVA PARTE DE LA BASE------
---------------FACTURACION-----------------
-- -----------------------------------------------------
-- Table `personas`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS personas (
  personas_id VARCHAR(45) NOT NULL,
  personas_nombre VARCHAR(45) NOT NULL,
  personas_apellido1 VARCHAR(45) NOT NULL,
  personas_apellido2 VARCHAR(45) NOT NULL,
  personas_fecha_de_nacimiento DATE NOT NULL,
  personas_telefonocasa VARCHAR(45),
  personas_telefonocel VARCHAR(45),
  personas_direccion VARCHAR(130),
  personas_correo VARCHAR(45),
  PRIMARY KEY (personas_id)
  );


-- -----------------------------------------------------
-- Table `empleados`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS empleados (
  empleados_salario_bruto VARCHAR(45) NOT NULL,
  empleados_puesto VARCHAR (45) NOT NULL,
  PRIMARY KEY (personas_id)
)INHERITS (personas);


-- -----------------------------------------------------
-- Table `clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS clientes ( 
  clientes_tipo VARCHAR(45) NOT NULL,
  PRIMARY KEY (personas_id)
) INHERITS (personas);


-- -----------------------------------------------------
-- Table `facturas_entrada`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS facturas_entrada (
  facturas_entrada_id VARCHAR(45) NOT NULL,
  facturas_entrada_id_empleado VARCHAR(45) NOT NULL,
  facturas_entrada_id_cliente VARCHAR(45) NOT NULL,
  facturas_entrada_nombre VARCHAR(45) NOT NULL,
  facturas_entrada_direccion VARCHAR(45) NOT NULL,
  facturas_entrada_telefono VARCHAR(45),
  facturas_entrada_metodo_de_pago VARCHAR(45) NOT NULL, 
  facturas_entrada_total integer,
  PRIMARY KEY (facturas_entrada_id),
  FOREIGN KEY (facturas_entrada_id_empleado) REFERENCES empleados(personas_id),
  FOREIGN KEY (facturas_entrada_id_cliente) REFERENCES clientes (personas_id)
);

-- -----------------------------------------------------
-- Table `aranceles`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS aranceles (
  aranceles_id VARCHAR(45) NOT NULL,
  aranceles_descripcion VARCHAR(45) NOT NULL,
  aranceles_precio decimal(20,3) NOT NULL,
  aranceles_tipo VARCHAR(45) NOT NULL,
  PRIMARY KEY (aranceles_id)
);


-- -----------------------------------------------------
-- Table `detalles_De_Factura_entrada`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS detalles_de_factura_entrada (
  detfac_entrada_id_detalle_factura VARCHAR(45) NOT NULL,
  detfac_entrada_id_factura VARCHAR(45) NOT NULL,
  detfac_entrada_id_arancel VARCHAR(45) NOT NULL,
  detfac_entrada_descripcion VARCHAR(45) NOT NULL,
  detfac_entrada_numero_linea integer NOT NULL,
  detfac_entrada_precio_unitario decimal(20,3) NOT NULL,
  detfac_entrada_descuento decimal(20,3),
  detfac_entrada_descripcion_descuento VARCHAR(45),
  detfac_entrada_total_bruto decimal(20,3) NOT NULL,
  detfac_entrada_subtotal decimal(20,3) NOT NULL,
  detfac_entrada_cantidad integer NOT NULL,
  PRIMARY KEY (detfac_entrada_id_detalle_factura),
  FOREIGN KEY (detfac_entrada_id_factura) REFERENCES facturas_entrada (facturas_entrada_id),
  FOREIGN KEY (detfac_entrada_id_arancel) REFERENCES aranceles (aranceles_id)
);



-- -----------------------------------------------------
-- Table `Recibos_Entrada`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS recibo_entrada (
  reciboEntrada_id VARCHAR(45) NOT NULL,
  reciboEntrada_id_factura_entrada VARCHAR(45) NOT NULL,
  reciboEntrada_id_empleado VARCHAR(45) NOT NULL,
  reciboEntrada_fecha date NOT NULL,
  reciboEntrada_descripcion VARCHAR(45) NOT NULL,
  reciboEntrada_saldo_anterior decimal (20,3) NOT NULL,
  reciboEntrada_recargo_por_mora decimal (20,3) NOT NULL,
  reciboEntrada_este_abono decimal (20,3) NOT NULL,
  reciboEntrada_saldo_actual decimal (20,3) NOT NULL,
  PRIMARY KEY (reciboEntrada_id),
  FOREIGN KEY (reciboEntrada_id_factura_entrada) REFERENCES facturas_entrada(facturas_entrada_id)
);
-- -----------------------------------------------------
-- Table `facturas_salida`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS facturas_salida (
  facturas_salida_id VARCHAR(45) NOT NULL,
  facturas_salida_id_empleado VARCHAR(45) NOT NULL,
  facturas_salida_id_cliente VARCHAR(45) NOT NULL,
  facturas_salida_nombre VARCHAR(45) NOT NULL,
  facturas_salida_direccion VARCHAR(45) NOT NULL,
  facturas_salida_telefono VARCHAR(45),
  facturas_salida_metodo_de_pago VARCHAR(45) NOT NULL, 
  facturas_salida_total integer,
  PRIMARY KEY (facturas_salida_id),
  FOREIGN KEY (facturas_salida_id_empleado) REFERENCES empleados(personas_id),
  FOREIGN KEY (facturas_salida_id_cliente) REFERENCES clientes (personas_id)
);

-- -----------------------------------------------------
-- Table `detalles_De_factura_salida`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS detalles_de_factura_salida (
  detfac_salida_id_detalle_factura VARCHAR(45) NOT NULL,
  detfac_salida_id_factura VARCHAR(45) NOT NULL,
  detfac_salida_id_arancel VARCHAR(45) NOT NULL,
  detfac_salida_descripcion VARCHAR(45) NOT NULL,
  detfac_salida_numero_linea integer NOT NULL,
  detfac_salida_precio_unitario decimal(20,3) NOT NULL,
  detfac_salida_descuento decimal(20,3),
  detfac_salida_descripcion_descuento VARCHAR(45),
  detfac_salida_total_bruto decimal(20,3) NOT NULL,
  detfac_salida_subtotal decimal(20,3) NOT NULL,
  detfac_salida_cantidad integer NOT NULL,
  PRIMARY KEY (detfac_salida_id_detalle_factura),
  FOREIGN KEY (detfac_salida_id_factura) REFERENCES facturas_salida (facturas_salida_id),
  FOREIGN KEY (detfac_salida_id_arancel) REFERENCES aranceles (aranceles_id)
);


-- -----------------------------------------------------
-- Table `Recibo_Salida`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS recibo_Salida (
  recibosalida_id VARCHAR(45) NOT NULL,
  recibosalida_id_empleado VARCHAR(45) NOT NULL,
  recibosalida_id_aranceles VARCHAR(45) NOT NULL,
  recibosalida_fecha date NOT NULL,
  recibosalida_descripcion VARCHAR(45) NOT NULL,
  recibosalida_monto decimal (20,3) NOT NULL,
  PRIMARY KEY (recibosalida_id),
  FOREIGN KEY (recibosalida_id_empleado) REFERENCES empleados(personas_id),
  FOREIGN KEY (recibosalida_id_aranceles) REFERENCES aranceles (aranceles_id)
);


-- -----------------------------------------------------
-- Table `Cuentas_Por_Cobrar`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS cuentas_por_cobrar (
  cuentascobrar_id VARCHAR(45) NOT NULL,
  cuentascobrar_id_factura_entrada VARCHAR(45) NOT NULL,
  cuentascobrar_saldo decimal (20,3) NULL,
  PRIMARY KEY (cuentascobrar_id),
  FOREIGN KEY (cuentascobrar_id_factura_entrada) REFERENCES facturas_entrada (facturas_entrada_id)
);

-- -----------------------------------------------------
-- Table `Cuentas_Por_Pagar`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS cuentas_por_pagar (
  cuentaspagar_id VARCHAR(45) NOT NULL,
  cuentaspagar_id_factura_salida VARCHAR(45) NOT NULL,
  cuentaspagar_saldo decimal (20,3) NULL,
  PRIMARY KEY (cuentaspagar_id),
  FOREIGN KEY (cuentaspagar_id_factura_salida) REFERENCES facturas_salida (facturas_salida_id)
);


-- -----------------------------------------------------
-- Table `inventario`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS inventario (
  inventario_id VARCHAR(45) NOT NULL,
  inventario_nombre VARCHAR(45) NOT NULL,
  inventario_marca VARCHAR(45),
  inventario_modelo VARCHAR(45),
  inventario_valor decimal(20,3),
  inventario_cantidad integer,
  inventario_proveedor VARCHAR(45),
  PRIMARY KEY (inventario_id)
);


