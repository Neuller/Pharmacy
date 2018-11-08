package br.com.farmacia.Domain;

public class Produtos {
	
	private int idProdutos;
	private String Descricao;
	private int Quantidade;
	private double Preco;
	private Fornecedores fornecedores;
	
	public int getIdProdutos() {
		return idProdutos;
	}
	public void setIdProdutos(int idProdutos) {
		this.idProdutos = idProdutos;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public int getQuantidade() {
		return Quantidade;
	}
	public void setQuantidade(int quantidade) {
		Quantidade = quantidade;
	}
	public double getPreco() {
		return Preco;
	}
	public void setPreco(double preco) {
		Preco = preco;
	}
	public Fornecedores getFornecedores() {
		return fornecedores;
	}
	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedores = fornecedores;
	}
		
}
