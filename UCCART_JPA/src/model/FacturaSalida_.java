package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-05-11T19:58:45.601-0600")
@StaticMetamodel(FacturaSalida.class)
public class FacturaSalida_ {
	public static volatile SingularAttribute<FacturaSalida, String> facturas_salida_id;
	public static volatile SingularAttribute<FacturaSalida, String> facturas_salida_id_empleado;
	public static volatile SingularAttribute<FacturaSalida, String> facturas_salida_id_profesor;
	public static volatile SingularAttribute<FacturaSalida, String> facturas_salida_nombre;
	public static volatile SingularAttribute<FacturaSalida, String> facturas_salida_direccion;
	public static volatile SingularAttribute<FacturaSalida, String> facturas_salida_telefono;
	public static volatile SingularAttribute<FacturaSalida, String> facturas_salida_metodo_de_pago;
	public static volatile SingularAttribute<FacturaSalida, Float> facturas_salida_total;
	public static volatile SingularAttribute<FacturaSalida, Estudiante> estudiante;
	public static volatile SingularAttribute<FacturaSalida, Empleado> empleados;
	public static volatile SingularAttribute<FacturaSalida, DetalleFacturaSalida> detalleFacturaSalida;
	public static volatile SingularAttribute<FacturaSalida, ReciboSalida> reciboSalida;
	public static volatile SingularAttribute<FacturaSalida, CuentasPorPagar> cuentasPorPagar;
}
