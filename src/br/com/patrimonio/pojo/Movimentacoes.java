package br.com.patrimonio.pojo;

import java.sql.Date;

public class Movimentacoes {

	private Integer id;
	private Integer patrimonio_id;
	private Integer usuario_registro_id;
	private TipoMov tipo_movimentacao;
	private String responsavel_destino;
	private String documento_responsavel;
	private Date data_saida;
	private Date data_prevista_retorno;
	private Date data_retorno_efetivo;
	private String observacoes;

	public Movimentacoes() {
	}

	public Movimentacoes(Integer id, Integer patrimonio_id,
			Integer usuario_registro_id, TipoMov tipo_movimentacao,
			String responsavel_destino, String documento_responsavel,
			Date data_saida, Date data_prevista_retorno,
			Date data_retorno_efetivo, String observacoes) {

		this.id = id;
		this.patrimonio_id = patrimonio_id;
		this.usuario_registro_id = usuario_registro_id;
		this.tipo_movimentacao = tipo_movimentacao;
		this.responsavel_destino = responsavel_destino;
		this.documento_responsavel = documento_responsavel;
		this.data_saida = data_saida;
		this.data_prevista_retorno = data_prevista_retorno;
		this.data_retorno_efetivo = data_retorno_efetivo;
		this.observacoes = observacoes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPatrimonio_id() {
		return patrimonio_id;
	}

	public void setPatrimonio_id(Integer patrimonio_id) {
		this.patrimonio_id = patrimonio_id;
	}

	public Integer getUsuario_registro_id() {
		return usuario_registro_id;
	}

	public void setUsuario_registro_id(Integer usuario_registro_id) {
		this.usuario_registro_id = usuario_registro_id;
	}

	public TipoMov getTipo_movimentacao() {
		return tipo_movimentacao;
	}

	public void setTipo_movimentacao(TipoMov tipo_movimentacao) {
		this.tipo_movimentacao = tipo_movimentacao;
	}

	public String getResponsavel_destino() {
		return responsavel_destino;
	}

	public void setResponsavel_destino(String responsavel_destino) {
		this.responsavel_destino = responsavel_destino;
	}

	public String getDocumento_responsavel() {
		return documento_responsavel;
	}

	public void setDocumento_responsavel(String documento_responsavel) {
		this.documento_responsavel = documento_responsavel;
	}

	public Date getData_saida() {
		return data_saida;
	}

	public void setData_saida(Date data_saida) {
		this.data_saida = data_saida;
	}

	public Date getData_prevista_retorno() {
		return data_prevista_retorno;
	}

	public void setData_prevista_retorno(Date data_prevista_retorno) {
		this.data_prevista_retorno = data_prevista_retorno;
	}

	public Date getData_retorno_efetivo() {
		return data_retorno_efetivo;
	}

	public void setData_retorno_efetivo(Date data_retorno_efetivo) {
		this.data_retorno_efetivo = data_retorno_efetivo;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
}