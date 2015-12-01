package com.ufrpe.ava.gui.telas;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 * Created by paulomenezes on 22/11/15.
 */
public class TelaCadastro extends Tela {
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
   
     
    
    public void desabilitar(){
    	
    	graduacaoCheck.setDisable(true);
    	posGradCheck.setDisable(true);
    }
    
    
    
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
        
    	
    	ArrayList<String>listaValidacao = new ArrayList<String>();
    	listaValidacao.add(campoCPF.getText());
    	listaValidacao.add(campoEmail.getText());
    	listaValidacao.add(campoNome.getText());
    	listaValidacao.add(campoSenha.getText());
    	listaValidacao.add(campoReSenha.getText());
    	
    	if(this.validarCampos(listaValidacao) && validarCheckBox()){
    	     
    		
    		if(this.validarSenha(campoSenha.getText(), campoReSenha.getText()) &&  this.validarEmail(campoEmail.getText()) && 
    				this.validarCpf(campoCPF.getText()) ){
    			
    			
    			if(professorCheck.isSelected()){
    				
    				this.avaFachada.cadastarProfessor(campoNome.getText(), campoCPF.getText(), campoEmail.getText(),
    						campoSenha.getText(), Integer.parseInt(codDpto.getText()),'p');
    				
    			}else{
    				
    				String tipoAluno;
    				
    				if(graduacaoCheck.isSelected()){
    					
    					tipoAluno = graduacaoCheck.getText();
    				}else{
    					
    					tipoAluno = posGradCheck.getText();
    				}
    				
    				this.avaFachada.cadastrarAluno(campoNome.getText(), campoCPF.getText(), campoEmail.getText(),
    						campoSenha.getText(), Integer.parseInt(codCurso.getText()), tipoAluno,'a');
    				
    			}
    			
    			
    		}else{
    			
    			Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login inválido");
                alert.setHeaderText("CPF, senha ou Email inválido");
                alert.showAndWait();
    		}
    		
    		
    	}else{
    		
    		 Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Campos obrigatórios");
             alert.setHeaderText("Por favor preencher os campos corretamente !!");
             alert.showAndWait();
        }
    	
    	
    		
      }
    	

	private Boolean validarCheckBox(){
		
		if(!professorCheck.isSelected() && !alunoCheck.isSelected()){
			
			return false;
		
		}else if(alunoCheck.isSelected() && !codCurso.getText().isEmpty()){
			
			if( !graduacaoCheck.isSelected() && !posGradCheck.isSelected()){
				return false;
			}else{
				return true;
			}
		}else if (professorCheck.isSelected() && !alunoCheck.isSelected() && !codDpto.getText().isEmpty()){

				return true;			
		}else{
			
			return false;
		}
	}
    
    
}