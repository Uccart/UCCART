create table inventario(
 nombre varchar(50),
 codigo int,
 marca varchar(50),
 modelo varchar(50),
 valor int,
 cant int,
 comprado_en varchar(50),
 primary key (codigo)
);

insert into inventario(nombre,codigo,marca,modelo,valor,cant,comprado_en)values
('computadora',1234,'hp','i2500',500000,2,'universal'),
('computadora',555,'hp','i2700',300000,1,'universal'),
('escritorio',123,'moderna','estandar',50000,1,'universal');


create table arancel(
nombre varchar(50),
codigo_arancel int,
monto int,
tipo varchar(6),
entidad varchar(50),
primary key (codigo_arancel)
);

insert into arancel(nombre,codigo_arancel,monto,tipo,entidad)values
('pago caja',1,500000,'pagar','carlos gomez'),
('cobro banco',5,30000,'cobrar','bancredito');


create table presupuesto(
	nombre varchar(50),
	codigo_presupuesto int,
	monto int,
	primary key (codigo_presupuesto)
);

insert into presupuesto(nombre,codigo_presupuesto,monto)values
('monto para edificio',1234,5000000),
('monto para carro',112,1000000);

