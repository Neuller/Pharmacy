package br.com.farmacia.test;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;
import br.com.farmacia.DAO.ProdutosDAO;
import br.com.farmacia.Domain.Fornecedores;
import br.com.farmacia.Domain.Produtos;

public class ProdutosDAOTESTE {

	@Test
	@Ignore
	public void salvar() throws SQLException {

		Produtos p1 = new Produtos();

		p1.setDescricao("ACETATO DE MEDROXIPROGESTERONA 150MG");
		p1.setQuantidade(50);
		p1.setPreco(10.2);

		Fornecedores f = new Fornecedores();

		f.setIdFornecedores(1);

		p1.setFornecedores(f);

		ProdutosDAO PDAO = new ProdutosDAO();

		PDAO.salvar(p1);

	}

	@Test
	@Ignore
	public void listar() throws SQLException {

		ProdutosDAO PDAO = new ProdutosDAO();

		ArrayList<Produtos> lista = PDAO.listar();
		
		for (Produtos p : lista){
			
			System.out.println("Código do Produto: " + p.getIdProdutos());
			System.out.println("Descrição do Produto: " + p.getDescricao());
			System.out.println("Quantidade: " + p.getQuantidade());
			System.out.println("Preço: " + p.getPreco());
			
			System.out.println("Código do Fornecedor: " + p.getFornecedores().getIdFornecedores());
			System.out.println("Descrição do Fornecedor: " + p.getFornecedores().getDescricao());
		}

	}
	
	@Test
	@Ignore
	public void excluir() throws SQLException{
		
		Produtos p = new Produtos();
		
		p.setIdProdutos(1);
		
		ProdutosDAO PDAO = new ProdutosDAO();
		
		PDAO.excluir(p);
		
	}
	
	@Test
	@Ignore
	public void editar() throws SQLException{
		
		Produtos p = new Produtos();
		
		p.setIdProdutos(3);
		p.setDescricao("CAPTOPRIL 25MG");
		p.setQuantidade(60);
		p.setPreco(16.80);
		
		Fornecedores f = new Fornecedores();
		f.setIdFornecedores(5);
		p.setFornecedores(f);
		
		ProdutosDAO PDAO = new ProdutosDAO();
		
		PDAO.editar(p);
		
	}

}
