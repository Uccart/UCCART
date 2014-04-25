package beans;

import java.util.Date;

import javax.ejb.Local;

import model.Beca;

@Local
public interface B_BecaLocal {
	public void setBeca(int cod, Date inicio, Date venc, int pTipo,int pPorc);
	public Beca getBeca();

}
