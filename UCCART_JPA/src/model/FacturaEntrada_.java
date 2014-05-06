package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@Generated(value="Dali", date="2014-05-06T01:52:59.999-0600")

@StaticMetamodel(FacturaEntrada.class)
public class FacturaEntrada_ {
	public static volatile SingularAttribute<FacturaEntrada, String> facturas_entrada_id;
	public static volatile SingularAttribute<FacturaEntrada, String> facturas_entrada_id_empleado;
	public static volatile SingularAttribute<FacturaEntrada, String> facturas_entrada_id_estudiante;
	public static volatile SingularAttribute<FacturaEntrada, String> facturas_entrada_nombre;
	public static volatile SingularAttribute<FacturaEntrada, String> facturas_entrada_direccion;
	public static volatile SingularAttribute<FacturaEntrada, String> facturas_entrada_telefono;
	public static volatile SingularAttribute<FacturaEntrada, String> facturas_entrada_metodo_de_pago;
	public static volatile SingularAttribute<FacturaEntrada, Float> facturas_entrada_total;
	public static volatile SingularAttribute<FacturaEntrada, String> facturas_entrada_id_estudiante;
	public static volatile SingularAttribute<FacturaEntrada, Estudiante> estudiante;
	public static volatile SingularAttribute<FacturaEntrada, Empleado> empleados;
	public static volatile SingularAttribute<FacturaEntrada, DetalleFacturaEntrada> detalleFacturaEntrada;
	public static volatile SingularAttribute<FacturaEntrada, ReciboEntrada> reciboEntrada;
	public static volatile SingularAttribute<FacturaEntrada, CuentasPorCobrar> cuentasPorCobrar;
}
