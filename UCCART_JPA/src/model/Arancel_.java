package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-05-06T11:55:42.544-0600")
@StaticMetamodel(Arancel.class)
public class Arancel_ {
	public static volatile SingularAttribute<Arancel, String> arancelId;
	public static volatile SingularAttribute<Arancel, String> arancelDescripcion;
	public static volatile SingularAttribute<Arancel, Float> arancelPrecio;
	public static volatile SingularAttribute<Arancel, String> arancelTipo;
	public static volatile SingularAttribute<Arancel, DetalleFacturaEntrada> DetalleFacturaEntrada;
}
