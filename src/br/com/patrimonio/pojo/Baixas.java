package br.com.patrimonio.pojo;

import java.sql.Date;

public class Baixas {

	private Integer id;
	private Integer patrimonio_id;
	private Integer usuario_registro_id;
	private TipoBaixa tipo_baixa;
	private String motivo;
	private Double valor_recuperado;
	private String documento_comprobatorio;
	private Date data_baixa;

	public Baixas() {
	}

	public Baixas(
			Integer id,
			Integer patrimonio_id,
			Integer usuario_registro_id,
			TipoBaixa tipo_baixa,
			String motivo,
			Double valor_recuperado,
			String documento_comprobatorio,
			Date data_baixa) {

		this.id = id;
		this.patrimonio_id = patrimonio_id;
		this.usuario_registro_id = usuario_registro_id;
		this.tipo_baixa = tipo_baixa;
		this.motivo = motivo;
		this.valor_recuperado = valor_recuperado;
		this.documento_comprobatorio = documento_comprobatorio;
		this.data_baixa = data_baixa;
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

	public TipoBaixa getTipo_baixa() {
		return tipo_baixa;
	}

	public void setTipo_baixa(TipoBaixa tipo_baixa) {
		this.tipo_baixa = tipo_baixa;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Double getValor_recuperado() {
		return valor_recuperado;
	}

	public void setValor_recuperado(Double valor_recuperado) {
		this.valor_recuperado = valor_recuperado;
	}

	public String getDocumento_comprobatorio() {
		return documento_comprobatorio;
	}

	public void setDocumento_comprobatorio(String documento_comprobatorio) {
		this.documento_comprobatorio = documento_comprobatorio;
	}

	public Date getData_baixa() {
		return data_baixa;
	}

	public void setData_baixa(Date data_baixa) {
		this.data_baixa = data_baixa;
	}
}
