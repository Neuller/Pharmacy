package br.com.farmacia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.farmacia.Domain.Fornecedores;
import br.com.farmacia.Factory.ConexaoFactory;

public class FornecedoresDAO {

	public void salvar(Fornecedores F) throws SQLException {

		StringBuilder sql = new StringBuilder();

		sql.append("INSERT INTO Fornecedores ");
		sql.append("(Descricao)");
		sql.append("VALUES (?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, F.getDescricao());
		comando.executeUpdate();

	}

	public void excluir(Fornecedores F) throws SQLException {

		StringBuilder sql = new StringBuilder();

		sql.append("DELETE FROM Fornecedores ");
		sql.append("WHERE idFornecedores = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setInt(1, F.getIdFornecedores());
		comando.executeUpdate();

	}

	public void editar(Fornecedores F) throws SQLException {

		StringBuilder sql = new StringBuilder();

		sql.append("UPDATE Fornecedores ");
		sql.append("SET Descricao = ? ");
		sql.append("WHERE idFornecedores = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, F.getDescricao());
		comando.setInt(2, F.getIdFornecedores());
		comando.executeUpdate();

	}

	public Fornecedores buscaPorCodigo(Fornecedores F) throws SQLException {

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT idFornecedores, Descricao ");
		sql.append("FROM Fornecedores ");
		sql.append("WHERE idFornecedores = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setInt(1, F.getIdFornecedores());
		ResultSet resultado = comando.executeQuery();
		Fornecedores retorno = null;

		if (resultado.next()) {
			retorno = new Fornecedores();
			retorno.setIdFornecedores(resultado.getInt("idFornecedores"));
			retorno.setDescricao(resultado.getString("Descricao"));
		}

		return retorno;

	}

	public ArrayList<Fornecedores> listar() throws SQLException {

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT idFornecedores, Descricao ");
		sql.append("FROM Fornecedores ");
		sql.append("ORDER BY Descricao ASC ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		ResultSet resultado = comando.executeQuery();

		ArrayList<Fornecedores> lista = new ArrayList<Fornecedores>();

		while (resultado.next()) {
			Fornecedores f = new Fornecedores();
			f.setIdFornecedores(resultado.getInt("idFornecedores"));
			f.setDescricao(resultado.getString("Descricao"));

			lista.add(f);
		}

		return lista;
	}

	// Testes Unitários
	public static void main(String[] args) {

		/*
		 * // Teste Inserção Fornecedores f1 = new Fornecedores();
		 * f1.setDescricao("PHMINAS");
		 * 
		 * Fornecedores f2 = new Fornecedores(); f2.setDescricao("Print");
		 * 
		 * FornecedoresDAO FDAO = new FornecedoresDAO();
		 * 
		 * try { FDAO.salvar(f1); FDAO.salvar(f2); System.out.println(
		 * "Salvo com Sucesso!"); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); System.out.println(
		 * "Erro ao Salvar!"); }
		 * 
		 * // Teste Deleção Fornecedores f1 = new Fornecedores();
		 * f1.setIdFornecedores(2);
		 * 
		 * FornecedoresDAO FDAO = new FornecedoresDAO();
		 * 
		 * try { FDAO.excluir(f1);
		 * 
		 * System.out.println("Excluido com Sucesso!"); } catch (SQLException e)
		 * { // TODO Auto-generated catch block e.printStackTrace();
		 * System.out.println("Erro ao Excluir!"); }
		 * 
		 * // Teste Edição Fornecedores f1 = new Fornecedores();
		 * f1.setIdFornecedores(1); f1.setDescricao("Nserv");
		 * 
		 * FornecedoresDAO FDAO = new FornecedoresDAO();
		 * 
		 * try { FDAO.editar(f1);
		 * 
		 * System.out.println("Editado com Sucesso!"); } catch (SQLException e)
		 * { // TODO Auto-generated catch block e.printStackTrace();
		 * System.out.println("Erro ao Editar!"); }
		 * 
		 * 
		 * Fornecedores f1 = new Fornecedores(); f1.setIdFornecedores(1);
		 * f1.setDescricao("Nserv");
		 * 
		 * FornecedoresDAO FDAO = new FornecedoresDAO();
		 * 
		 * try { FDAO.buscaPorCodigo(f1); System.out.println("Resultado: " +
		 * f1); } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); System.out.println("Erro ao Buscar!"); }
		 * 
		 * 
		 * FornecedoresDAO FDAO = new FornecedoresDAO();
		 * 
		 * try {
		 * 
		 * ArrayList<Fornecedores>lista = FDAO.listar();
		 * 
		 * for(Fornecedores f : lista){ System.out.println("Resultado: " + f); }
		 * 
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); System.out.println("Erro ao Listar Registros!");
		 * }
		 */
	}

}
