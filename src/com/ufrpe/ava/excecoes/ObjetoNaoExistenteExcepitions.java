package Excess�es;

@SuppressWarnings("serial")
public class ObjetoNaoExistenteExcepitions extends Exception{

	
	public ObjetoNaoExistenteExcepitions(String nome){
		
		super(nome + "N�o existente no sistema");
		
	}
	

	
}
