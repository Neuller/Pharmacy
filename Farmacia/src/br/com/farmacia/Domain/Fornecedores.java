package br.com.farmacia.Domain;

public class Fornecedores {

	private int idFornecedores;
	private String Descricao;

	public int getIdFornecedores() {
		return idFornecedores;
	}

	public void setIdFornecedores(int idFornecedores) {
		this.idFornecedores = idFornecedores;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	// Tratando Busca por Código
	@Override
	public String toString() {
		String saida = idFornecedores + " - " + Descricao;
		return saida;
	}

}
