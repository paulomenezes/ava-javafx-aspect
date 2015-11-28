package Excessões;

@SuppressWarnings("serial")
public class ObjetoNaoExistenteExcepitions extends Exception{

	
	public ObjetoNaoExistenteExcepitions(String nome){
		
		super(nome + "Não existente no sistema");
		
	}
	

	
}
