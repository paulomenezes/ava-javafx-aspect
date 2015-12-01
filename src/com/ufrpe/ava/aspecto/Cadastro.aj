package com.ufrpe.ava.aspecto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ufrpe.ava.excecoes.ObjetoJaExistenteExcepitions;
import com.ufrpe.ava.excecoes.ObjetoNaoExistenteExcepitions;
import com.ufrpe.ava.negocio.entidades.Aluno;
import com.ufrpe.ava.negocio.entidades.Professor;
import com.ufrpe.ava.negocio.entidades.Usuario;
import com.ufrpe.ava.negocio.controladores.ControladorUsuario;

public aspect Cadastro extends ConnectMySQL {

	pointcut inserirUsuario(Usuario usuario): call(* ControladorUsuario.cadastrarUsuario(..)) && args(usuario)  ;

	pointcut selecionarTudo(): execution(* ControladorUsuario.selecionarTudo());


    ArrayList<Usuario> around(): selecionarTudo() {

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuario");
            ResultSet resultSet = statement.executeQuery();

            ArrayList<Usuario> lista = new ArrayList<>();
            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                //usuario.setId(resultSet.getInt("id"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setCPF(resultSet.getString("cpf"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setFoto(resultSet.getString("foto"));

                lista.add(usuario);
            }

            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

     void around(Usuario usuario) throws Exception, ObjetoJaExistenteExcepitions, ObjetoNaoExistenteExcepitions: inserirUsuario(usuario) {

		 try {
			 PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuario WHERE cpf = ? ");
			 statement.setString(1, usuario.getCPF());
			 ResultSet resultSet = statement.executeQuery();

			 if (resultSet == null) {
				 connection.setAutoCommit(false);
				 statement = connection.prepareStatement("INSERT INTO usuario (cpf, nome, foto, email, senha, grad)VALUES(?,?,?,?,?,?)");
				 statement.setString(1, usuario.getCPF());
				 statement.setString(2, usuario.getNome());
				 statement.setString(3, usuario.getFoto());
				 statement.setString(4, usuario.getEmail());
				 statement.setString(5, usuario.getSenha());
				 statement.setInt(6, usuario.getGrad());
				 statement.execute();
			 } else {
				 throw new ObjetoJaExistenteExcepitions(usuario.getNome(), usuario.getEmail());
			 }

			 if (usuario instanceof Aluno) {
				 statement = connection.prepareStatement("SELECT * FROM curso WHERE idCurso = ?");
				 statement.setInt(1, ((Aluno) usuario).getCurso());
				 resultSet = statement.executeQuery();

				 if (resultSet != null) {
					 statement = connection.prepareStatement("INSERT INTO aluno(idAluno,idCurso,tipo)VALUES(select LAST_INSERT_ID(),?,?)");
					 statement.setInt(1, ((Aluno) usuario).getCurso());
					 statement.setString(2, ((Aluno) usuario).getTipoAluno());
					 statement.execute();
					 connection.commit();
				 } else {
					 throw new ObjetoNaoExistenteExcepitions("Curso", "");
				 }
			 } else if (usuario instanceof Professor) {
				 statement.close();
				 statement = connection.prepareStatement("SELECT * FROM departamento WHERE idDepartamento = ?");
				 statement.setInt(1, ((Professor) usuario).getIdDpto());
				 resultSet = statement.executeQuery();

				 if (resultSet != null) {
					 statement = connection.prepareStatement("INSERT INTO professor(idProfessor, idDepartamento)VALUES(select LAST_INSERT_ID(),?)");
					 statement.setInt(1, ((Professor) usuario).getIdDpto());
					 statement.execute();
					 connection.commit();
				 } else {
					 throw new ObjetoNaoExistenteExcepitions("Departamento", "");
				 }
			 }
		 } catch (Exception e) {

		 }
	}
}