package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-05-01T19:31:26.895-0600")
@StaticMetamodel(Empleado.class)
public class Empleado_ {
	public static volatile SingularAttribute<Empleado, String> empleadosId;
	public static volatile SingularAttribute<Empleado, String> empleadosNombre;
	public static volatile SingularAttribute<Empleado, String> empleadosApellido1;
	public static volatile SingularAttribute<Empleado, String> empleadosApellido2;
	public static volatile SingularAttribute<Empleado, Date> empleadosFechaN;
	public static volatile SingularAttribute<Empleado, String> empleadosTelefonoCasa;
	public static volatile SingularAttribute<Empleado, String> empleadosTelefonoCel;
	public static volatile SingularAttribute<Empleado, String> empleadosDireccion;
	public static volatile SingularAttribute<Empleado, String> empleadosGenero;
	public static volatile SingularAttribute<Empleado, String> empleadosNacionalidad;
	public static volatile SingularAttribute<Empleado, String> empleadosCorreo;
	public static volatile SingularAttribute<Empleado, Float> empleadosSalario;
	public static volatile SingularAttribute<Empleado, String> empleadosPuesto;
}
