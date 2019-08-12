package com.taxes.taxesservice.model;

import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFilter;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the taxes database table.
 * 
 */
@Entity
@Table(name="taxes")
@NamedQuery(name="Taxe.findAll", query="SELECT t FROM Taxe t")
@JsonFilter("infoTaxe")
public class Taxe implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private Date dateTx;
	private BigDecimal taxFed;
	private BigDecimal taxProv;
	private Province province;

	public Taxe() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="DATE_TX", nullable=false)
	public Date getDateTx() {
		return this.dateTx;
	}

	public void setDateTx(Date dateTx) {
		this.dateTx = dateTx;
	}


	@Column(name="TAX_FED", nullable=false, precision=10, scale=2)
	public BigDecimal getTaxFed() {
		return this.taxFed;
	}

	public void setTaxFed(BigDecimal taxFed) {
		this.taxFed = taxFed;
	}


	@Column(name="TAX_PROV", nullable=false, precision=10, scale=2)
	public BigDecimal getTaxProv() {
		return this.taxProv;
	}

	public void setTaxProv(BigDecimal taxProv) {
		this.taxProv = taxProv;
	}


	//bi-directional many-to-one association to Province
	@ManyToOne
	@JoinColumn(name="CODE" ,nullable=false)

	public Province getProvince() {
		return this.province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

}