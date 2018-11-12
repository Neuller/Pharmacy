package br.com.farmacia.Bean;

import java.sql.SQLException;
import java.util.ArrayList;	
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.farmacia.DAO.FornecedoresDAO;
import br.com.farmacia.Domain.Fornecedores;
import br.com.farmacia.Util.JSFUtil;

// Comunicação JAVA
@ManagedBean(name = "MBFornecedores")
@ViewScoped
public class FornecedoresBEAN {

	private Fornecedores fornecedores;
	private ArrayList<Fornecedores> itens;
	private ArrayList<Fornecedores> itensFiltrados;

	public Fornecedores getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedores = fornecedores;
	}
	
	public ArrayList<Fornecedores> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<Fornecedores> itens) {
		this.itens = itens;
	}
	
	public ArrayList<Fornecedores> getItensFiltrados() {
		return itensFiltrados;
	}
	
	public void setItensFiltrados(ArrayList<Fornecedores> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	// Construir quando a Página for iniciada
	@PostConstruct
	public void prepararPesquisa() {

		try {
			FornecedoresDAO FDAO = new FornecedoresDAO();
			itens = FDAO.listar();
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}

	}

	public void prepararNovo() {
		fornecedores = new Fornecedores();
	}

	public void novo() {

		try {
			FornecedoresDAO FDAO = new FornecedoresDAO();
			FDAO.salvar(fornecedores);

			itens = FDAO.listar();

			JSFUtil.adicionarMensagemSucesso("Salvo com Sucesso");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}

	public void excluir() {
		try {
			FornecedoresDAO FDAO = new FornecedoresDAO();
			FDAO.excluir(fornecedores);

			itens = FDAO.listar();

			JSFUtil.adicionarMensagemSucesso("Excluído com Sucesso");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("Não é possível excluir o Fornecedor");
			e.printStackTrace();
		}
	}

		public void editar() {
			try {
				FornecedoresDAO FDAO = new FornecedoresDAO();
				FDAO.editar(fornecedores);

				itens = FDAO.listar();

				JSFUtil.adicionarMensagemSucesso("Editado com Sucesso");
			} catch (SQLException e) {
				JSFUtil.adicionarMensagemErro("ex.getMessage()");
				e.printStackTrace();
			}
	}
}
