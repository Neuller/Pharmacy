package br.com.farmacia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.farmacia.Domain.Fornecedores;
import br.com.farmacia.Domain.Produtos;
import br.com.farmacia.Factory.ConexaoFactory;

public class ProdutosDAO {
	
	public void salvar(Produtos P) throws SQLException {

		StringBuilder sql = new StringBuilder();

		sql.append("INSERT INTO Produtos ");
		sql.append("(Descricao, Quantidade, Preco, Fornecedores_idFornecedores)");
		sql.append("VALUES (?, ?, ?, ?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, P.getDescricao());
		comando.setInt(2, P.getQuantidade());
		comando.setDouble(3, P.getPreco());
		comando.setInt(4, P.getFornecedores().getIdFornecedores());
		comando.executeUpdate();

	}
	
	public void excluir(Produtos P) throws SQLException {

		StringBuilder sql = new StringBuilder();

		sql.append("DELETE FROM produtos ");
		sql.append("WHERE idProdutos = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setInt(1, P.getIdProdutos());
		comando.executeUpdate();

	}
	
	public ArrayList<Produtos> listar() throws SQLException {

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT p.idProdutos, p.Descricao, p.Quantidade, p.Preco, f.idFornecedores, f.Descricao ");
		sql.append("FROM produtos p ");
		sql.append("INNER JOIN fornecedores f ON f.idFornecedores = p.Fornecedores_idFornecedores ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		ResultSet resultado = comando.executeQuery();

		ArrayList<Produtos> lista = new ArrayList<Produtos>();

		while (resultado.next()) {
			
			Fornecedores f = new Fornecedores();
			f.setIdFornecedores(resultado.getInt("f.idFornecedores"));
			f.setDescricao(resultado.getString("f.Descricao"));
			
			Produtos p = new Produtos();
			
			p.setIdProdutos(resultado.getInt("p.idProdutos"));
			p.setDescricao(resultado.getString("p.Descricao"));
			p.setQuantidade(resultado.getInt("p.Quantidade"));
			p.setPreco(resultado.getDouble("p.Preco"));
			p.setFornecedores(f);
			

			lista.add(p);
		}

		return lista;
	}

}
