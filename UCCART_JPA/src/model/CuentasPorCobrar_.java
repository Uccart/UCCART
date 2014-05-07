package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-05-06T01:50:49.810-0600")
@StaticMetamodel(CuentasPorCobrar.class)
public class CuentasPorCobrar_ {
	public static volatile SingularAttribute<CuentasPorCobrar, String> cuentascobrar_id;
	public static volatile SingularAttribute<CuentasPorCobrar, String> cuentascobrar_id_factura_entrada;
	public static volatile SingularAttribute<CuentasPorCobrar, Float> cuentascobrar_saldo;
	public static volatile SingularAttribute<CuentasPorCobrar, FacturaEntrada> facturaEntrada;
}
