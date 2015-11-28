package Excessões;

@SuppressWarnings("serial")
public class ObjetoJaExistenteEcepitions extends Exception {

	public ObjetoJaExistenteEcepitions(String nome){
		
		super(nome+ "Ja existe no sistema");
	}
}
