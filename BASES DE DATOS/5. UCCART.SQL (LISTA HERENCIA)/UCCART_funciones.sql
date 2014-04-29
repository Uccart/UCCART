CREATE FUNCTION cant_actual() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
DECLARE
    CANT INTEGER;
BEGIN 
    IF (TG_OP = 'INSERT') THEN
    SELECT  curso_cantactual INTO CANT FROM Curso WHERE curso_id = new.nota_codcurso; 
    CANT := CANT + 1;
    UPDATE Curso SET curso_cantactual = CANT WHERE curso_id = NEW.nota_codcurso;    
    RETURN NEW;
    ELSIF (TG_OP = 'DELETE') THEN
    SELECT  curso_cantactual INTO CANT FROM Curso WHERE curso_id = OLD.nota_codcurso; 
    CANT := CANT - 1;
    UPDATE Curso SET curso_cantactual = CANT WHERE curso_id = OLD.nota_codcurso;    
    RETURN OLD; 
    end if;

END; 
$$;

CREATE FUNCTION crear_constrasena() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
    BEGIN
        INSERT INTO CONTRASENAS 
        VALUES(TO_CHAR(NEW.PERSONAS_FECHA_DE_NACIMIENTO,'DDMMYY'), NEW.personas_id);
        RETURN NEW;
    END;
$$;

CREATE FUNCTION crear_usuario_profesor() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
    BEGIN
        INSERT INTO USUARIO VALUES(NEW.personas_id, substring(NEW.personas_id,char_length(new.personas_id)-3,char_length(new.personas_id)-1),NEW.personas_nombre || ' ' || NEW.personas_apellido1|| ' '||NEW.personas_apellido2,10);
        
        RETURN NEW;
    END;
$$;

CREATE FUNCTION f001plan() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
    BEGIN
        IF NEW.PLAN_COD IS NULL THEN
        SELECT NEXTVAL('PLAN_PLAN_COD_SEQ')INTO NEW.PLAN_COD;
        END IF;
        RETURN NEW;
    END;
$$;

CREATE FUNCTION f001titulo() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
    BEGIN
        IF NEW.TIT_CODIGO IS NULL THEN
        SELECT NEXTVAL('TITULO_TIT_COD_SEQ')INTO NEW.TIT_CODIGO;
        END IF;
        RETURN NEW;
    END;
$$;

CREATE FUNCTION fecha_sistema() RETURNS date
    LANGUAGE plpgsql
    AS $$
    BEGIN
        RETURN (SELECT current_timestamp);
    END;
$$;
