package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-05-01T19:31:26.906-0600")
@StaticMetamodel(Inventario.class)
public class Inventario_ {
	public static volatile SingularAttribute<Inventario, String> inventarioId;
	public static volatile SingularAttribute<Inventario, String> inventarioNombre;
	public static volatile SingularAttribute<Inventario, String> inventarioMarca;
	public static volatile SingularAttribute<Inventario, String> inventarioModelo;
	public static volatile SingularAttribute<Inventario, Float> inventarioValor;
	public static volatile SingularAttribute<Inventario, Integer> inventarioCantidad;
	public static volatile SingularAttribute<Inventario, String> inventarioProveedor;
}
