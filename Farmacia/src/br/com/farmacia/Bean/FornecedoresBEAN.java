package br.com.farmacia.Bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.farmacia.DAO.FornecedoresDAO;
import br.com.farmacia.Domain.Fornecedores;
import br.com.farmacia.Util.JSFUtil;

// Comunicação JAVA
@ManagedBean(name = "MBFornecedores")
@ViewScoped
public class FornecedoresBEAN {
	
	private Fornecedores fornecedores;
	private ListDataModel<Fornecedores>itens;

	public ListDataModel<Fornecedores> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<Fornecedores> itens) {
		this.itens = itens;
	}
	
	public Fornecedores getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedores = fornecedores;
	}

	// Construir quando a Página for iniciada
	@PostConstruct
	public void prepararPesquisa(){
		
		try {
			FornecedoresDAO FDAO = new FornecedoresDAO();
			ArrayList<Fornecedores>lista = FDAO.listar();
			//Converter em DataModel
			itens = new ListDataModel<Fornecedores>(lista);
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
		
	}
	
	public void prepararNovo(){
		fornecedores = new Fornecedores();
	}
	
	public void novo(){
		
		try {
			FornecedoresDAO FDAO = new FornecedoresDAO();
			FDAO.salvar(fornecedores);
			
			ArrayList<Fornecedores>lista = FDAO.listar();
			itens = new ListDataModel<Fornecedores>(lista);
			JSFUtil.adicionarMensagemSucesso("Salvo com Sucesso");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	
}
