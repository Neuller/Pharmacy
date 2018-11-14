package br.com.farmacia.Bean;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.farmacia.DAO.ProdutosDAO;
import br.com.farmacia.Domain.Produtos;
import br.com.farmacia.Util.JSFUtil;

// Comunicação JAVA
@ManagedBean(name = "MBProdutos")
@ViewScoped
public class ProdutosBEAN {

	private Produtos produtos;
	private ArrayList<Produtos> itens;
	private ArrayList<Produtos> itensFiltrados;

	public Produtos getProdutos() {
		return produtos;
	}

	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}

	public ArrayList<Produtos> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Produtos> itens) {
		this.itens = itens;
	}

	public ArrayList<Produtos> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Produtos> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	// Construir quando a Página for iniciada
	@PostConstruct
	public void prepararPesquisa() {

		try {
			ProdutosDAO PDAO = new ProdutosDAO();
			itens = PDAO.listar();
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}

	}
}