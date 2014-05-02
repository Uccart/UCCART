package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-05-01T19:31:26.931-0600")
@StaticMetamodel(Periodo.class)
public class Periodo_ {
	public static volatile SingularAttribute<Periodo, String> perPeriodo;
	public static volatile SingularAttribute<Periodo, Date> perLocal;
	public static volatile SingularAttribute<Periodo, Date> perWeb;
	public static volatile ListAttribute<Periodo, Curso> cursos;
}
