package br.com.patrimonio.pojo;

import java.sql.Date;

public class Locais {

	private Integer id;
	private String local;
	private String descricao;
	private Integer criado_por;
	private Date criado_em;

	public Locais() {
	}

	public Locais(Integer id, String local, String descricao, Integer criado_por, Date criado_em) {
		this.id = id;
		this.local = local;
		this.descricao = descricao;
		this.criado_por = criado_por;
		this.criado_em = criado_em;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getCriado_por() {
		return criado_por;
	}

	public void setCriado_por(Integer criado_por) {
		this.criado_por = criado_por;
	}

	public Date getCriado_em() {
		return criado_em;
	}

	public void setCriado_em(Date criado_em) {
		this.criado_em = criado_em;
	}
}
