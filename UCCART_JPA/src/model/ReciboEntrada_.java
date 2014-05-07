package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-05-06T01:04:10.058-0600")
@StaticMetamodel(ReciboEntrada.class)
public class ReciboEntrada_ {
	public static volatile SingularAttribute<ReciboEntrada, String> idReciboEntrada;
	public static volatile SingularAttribute<ReciboEntrada, String> idFacturaEntrada;
	public static volatile SingularAttribute<ReciboEntrada, String> idEmpleado;
	public static volatile SingularAttribute<ReciboEntrada, Date> fecha;
	public static volatile SingularAttribute<ReciboEntrada, String> descripcion;
	public static volatile SingularAttribute<ReciboEntrada, Float> saldoAnterior;
	public static volatile SingularAttribute<ReciboEntrada, Float> recargoPorMora;
	public static volatile SingularAttribute<ReciboEntrada, Float> esteAbono;
	public static volatile SingularAttribute<ReciboEntrada, Float> saldoActual;
	public static volatile SingularAttribute<ReciboEntrada, FacturaEntrada> facturaEntrada;
}
