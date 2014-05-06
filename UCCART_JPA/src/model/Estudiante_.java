package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-05-05T23:41:53.576-0600")
@StaticMetamodel(Estudiante.class)
public class Estudiante_ {
	public static volatile SingularAttribute<Estudiante, String> estId;
	public static volatile SingularAttribute<Estudiante, String> estApellido1;
	public static volatile SingularAttribute<Estudiante, String> estApellido2;
	public static volatile SingularAttribute<Estudiante, Boolean> estBecado;
	public static volatile SingularAttribute<Estudiante, String> estCelular;
	public static volatile SingularAttribute<Estudiante, String> estCorreo;
	public static volatile SingularAttribute<Estudiante, String> estDireccion;
	public static volatile SingularAttribute<Estudiante, String> estGenero;
	public static volatile SingularAttribute<Estudiante, Date> estNacimiento;
	public static volatile SingularAttribute<Estudiante, String> estNacionalidad;
	public static volatile SingularAttribute<Estudiante, String> estNombre;
	public static volatile SingularAttribute<Estudiante, Integer> estStatus;
	public static volatile SingularAttribute<Estudiante, String> estTelefono;
	public static volatile SingularAttribute<Estudiante, String> estTrabajo;
	public static volatile SingularAttribute<Estudiante, Beca> beca;
	public static volatile SingularAttribute<Estudiante, Titulo> titulo;
	public static volatile ListAttribute<Estudiante, Nota> notas;
	public static volatile SingularAttribute<Estudiante, Contrasena> contrasena;
	public static volatile ListAttribute<Estudiante, Padron> padrons;
	public static volatile ListAttribute<Estudiante, FacturaEntrada> facturaEntrada;
}
