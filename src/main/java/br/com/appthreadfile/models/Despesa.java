package br.com.appthreadfile.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Despesa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public Despesa() {
	}

	public Despesa(Integer id, Date dataDespesa, String descricao, Double valor) {
		super();
		this.id = id;
		this.dataDespesa = dataDespesa;
		this.descricao = descricao;
		this.valor = valor;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date dataDespesa;
	private String descricao;
	private Double valor;

	public Integer getId() {
		return id;
	}

	public Date getDataDespesa() {
		return dataDespesa;
	}

	public String getDescricao() {
		return descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setDataDespesa(Date dataDespesa) {
		this.dataDespesa = dataDespesa;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
