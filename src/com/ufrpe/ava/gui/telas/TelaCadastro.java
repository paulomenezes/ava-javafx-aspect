package com.ufrpe.ava.gui.telas;

import javax.swing.JOptionPane;

import com.ufrpe.ava.gui.telas.Tela;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 * Created by paulomenezes on 22/11/15.
 */
public class TelaCadastro extends Tela implements EventHandler<Event> {
    @FXML
    private TextField campoCPF;

    @FXML
    private TextField campoSenha;
    
    @FXML
    private TextField campoReSenha;
    
    @FXML
    private CheckBox professorCheck;
    
    @FXML
    private CheckBox alunoCheck;

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoEmail;

    @FXML
    private Button botaoVoltar;

    @FXML
    private Button botaoCriarConta;
    
    @FXML
    private TextField codDpto;
    
    @FXML
    private TextField codCurso;
    
    @FXML
    private CheckBox graduacaoCheck;
    
    @FXML
    private CheckBox posGradCheck; 
    
    
    public void clickGraduacaoCheck(){
    	
    	if(graduacaoCheck.isSelected()){
    		
    		posGradCheck.setDisable(true);
    		
    	}else{
    		posGradCheck.setDisable(false);
    	}
    }
    
    
    public void clickPosGradCheck(){
    	
    	if(posGradCheck.isSelected()){
    		
    		graduacaoCheck.setDisable(true);
    		
    	}else{
    		
    		graduacaoCheck.setDisable(false);
    	}
    	
    }
    
    public void clickProfessorCheck(){
    	
    	if(professorCheck.isSelected()){
    		
    		alunoCheck.setDisable(true);
    		codCurso.setDisable(true);
    		
    	}else{

    		alunoCheck.setDisable(false);
    		codCurso.setDisable(false);
    	}
    	
    }
    
    public void clickAlunoCheck(){
    	
    	if(alunoCheck.isSelected()){
    		
    		professorCheck.setDisable(true);
    		codDpto.setDisable(true);
    		graduacaoCheck.setDisable(false);
    		posGradCheck.setDisable(false);
    	}else{
    		professorCheck.setDisable(false);
    		codDpto.setDisable(false);
    		graduacaoCheck.setDisable(true);
    		posGradCheck.setDisable(true);
    	}
    }

    public void botaoVoltarAction() {
        trocarTela("login", botaoVoltar);
    }

    public void botaoCriarContaAction() {
        
    	
    	//Validação dos Checks
    	if(!alunoCheck.isSelected() && !professorCheck.isSelected() && !graduacaoCheck.isSelected() && !posGradCheck.isSelected()){
    		
    		JOptionPane.showMessageDialog(null,"Campos Aluno ou Professor não foram escolhidos corretamete!! /n Por favor escolha uma Opção");
    	
    	}else{
    		
    		//Validação das entradas
    		if(!campoCPF.getText().isEmpty() && !campoNome.getText().isEmpty() && 
    				!campoEmail.getText().isEmpty() && !campoSenha.getText().isEmpty() && 
    					!campoReSenha.getText().isEmpty() && !codCurso.getText().isEmpty() && !codDpto.getText().isEmpty()){
    			
    			//Se o usuario é um professor
    			if(professorCheck.isSelected()){
    				
    				this.avaFachada.cadastarProfessor(campoNome.getText(), campoCPF.getText(), campoEmail.getText(), 
    						campoSenha.getText(), Integer.parseInt(codDpto.getText()));
    			
    			//Se o usuario é um Aluno
    			}else{
    				
    				String tipo;
    				
    				if(graduacaoCheck.isSelected()){
    					
    					tipo = graduacaoCheck.getText();
    				
    				}else{
    					
    					tipo = posGradCheck.getText();
    				}
    				
    				this.avaFachada.cadastrarAluno(campoNome.getText(), campoCPF.getText(), campoEmail.getText(), 
    						campoSenha.getText(), Integer.parseInt(codCurso.getText()),tipo);
    			}
    			
    			
    		}else{
    			
    			JOptionPane.showMessageDialog(null,"Preencha todos os campos !!");
    		}
        	
        	
       }
    }


	@Override
	public void handle(Event event) {
		// TODO Auto-generated method stub
		
	}
    
    
}