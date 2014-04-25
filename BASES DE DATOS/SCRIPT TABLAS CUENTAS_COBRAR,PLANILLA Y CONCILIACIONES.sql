CREATE TABLE PLANILLA(
 ID_EMPLEADO INT,
 NOMBRE VARCHAR(50),
 APELLIDO VARCHAR(50),
 CORREO VARCHAR(50),
 NUMERO_TEL VARCHAR(20),
 DIA_CONTRATACION VARCHAR(20),
 SALARIO INT,
 PRIMARY KEY (ID_EMPLEADO)
);

INSERT INTO PLANILLA(
ID_EMPLEADO,NOMBRE,APELLIDO,CORREO,NUMERO_TEL,DIA_CONTRATACION,SALARIO)
VALUES
(001,'RONNY','LIZANO','RONNYLIZNO@HOTMAIL.COM','8877-6839','2014/3/14',100000),
(002,'JASON','QUESADA','JASONQUESADA@HOTMAIL.COM','8340-4753','2013/7/18',200000),
(003,'DANIEL','VILLEGAS','DANIELVILLEGAS@HOTMAIL.COM','8889-2122','2008/9/27',300000);

CREATE TABLE CUENTASPAGAR(
FECHA VARCHAR(20),
NUMERO_CUENTA INT,
MONTO FLOAT,
NOMBRE VARCHAR(50),
FECHA_PAGO VARCHAR(20),
POR_CONCEPTO VARCHAR(200),
PRIMARY KEY (NUMERO_CUENTA)
);

INSERT INTO CUENTAS_PAGAR(
FECHA,NUMERO_CUENTA,MONTO,NOMBRE,FECHA_PAGO,POR_CONCEPTO)
VALUES
('14/8/9',22,20000,'Mantenimiento edificio','8-5-3','Pintar edificio'),
('14/7/5',33,40000,'Mantenimiento edificio','8-5-3','Cambiar ventanas');

CREATE TABLE CONCILIACIONBANCARIA(
NOMBRE_EST VARCHAR(25),
IDENTIFICACION INT,
CARRERA VARCHAR(20),
MONTO_PAGADO INT,
NUMERO_TRANSACCION VARCHAR(25),
NUMERO_CUENTA VARCHAR(40),
PRIMARY KEY (IDENTIFICACION)
);

INSERT INTO CONCILIACIONBANCARIA(
NOMBRE_EST,IDENTIFICACION,CARRERA,MONTO_PAGADO,NUMERO_TRANSACCION,NUMERO_CUENTA)
VALUES
('juan',11,'ciencias',20000,'845','1221-45-4');






















ALTER TABLE nombretabla RENAME TO nombretablanueva;
