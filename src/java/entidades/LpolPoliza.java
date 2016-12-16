/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Oswaldo
 */
@Entity
@Table(name = "LPOL_POLIZA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LpolPoliza.findAll", query = "SELECT l FROM LpolPoliza l"),
    @NamedQuery(name = "LpolPoliza.findByPolCodigo", query = "SELECT l FROM LpolPoliza l WHERE l.polCodigo = :polCodigo"),
    @NamedQuery(name = "LpolPoliza.findByPolNumpol", query = "SELECT l FROM LpolPoliza l WHERE l.polNumpol = :polNumpol"),
    @NamedQuery(name = "LpolPoliza.findByPolFecini", query = "SELECT l FROM LpolPoliza l WHERE l.polFecini = :polFecini"),
    @NamedQuery(name = "LpolPoliza.findByPolVigencia", query = "SELECT l FROM LpolPoliza l WHERE l.polVigencia = :polVigencia"),
    @NamedQuery(name = "LpolPoliza.findByPolIva", query = "SELECT l FROM LpolPoliza l WHERE l.polIva = :polIva"),
    @NamedQuery(name = "LpolPoliza.findByPolSegcamp", query = "SELECT l FROM LpolPoliza l WHERE l.polSegcamp = :polSegcamp"),
    @NamedQuery(name = "LpolPoliza.findByPolSupbanc", query = "SELECT l FROM LpolPoliza l WHERE l.polSupbanc = :polSupbanc"),
    @NamedQuery(name = "LpolPoliza.findByPolDeremis", query = "SELECT l FROM LpolPoliza l WHERE l.polDeremis = :polDeremis"),
    @NamedQuery(name = "LpolPoliza.findByPolPrimatotal", query = "SELECT l FROM LpolPoliza l WHERE l.polPrimatotal = :polPrimatotal")})
public class LpolPoliza implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "POL_CODIGO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_POLIZA_")
    @SequenceGenerator(name = "SEQ_POLIZA_", sequenceName = "SEQ_POLIZA", initialValue = 1, allocationSize = 1)
    private BigDecimal polCodigo;
    @Size(max = 20)
    @Column(name = "POL_NUMPOL")
    private String polNumpol;
    @Column(name = "POL_FECINI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date polFecini;
    @Column(name = "POL_VIGENCIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date polVigencia;
    @Column(name = "POL_IVA")
    private Short polIva;
    @Column(name = "POL_SEGCAMP")
    private Short polSegcamp;
    @Column(name = "POL_SUPBANC")
    private Short polSupbanc;
    @Column(name = "POL_DEREMIS")
    private BigInteger polDeremis;
    @Column(name = "POL_PRIMATOTAL")
    private BigInteger polPrimatotal;
    @JoinColumn(name = "ASE_CODIGO", referencedColumnName = "ASE_CODIGO")
    @ManyToOne
    private LaseAseguradora aseCodigo;
    @OneToMany(mappedBy = "polCodigo")
    private List<LasgAsegurados> lasgAseguradosList;

    public LpolPoliza() {
    }

    public LpolPoliza(BigDecimal polCodigo) {
        this.polCodigo = polCodigo;
    }

    public BigDecimal getPolCodigo() {
        return polCodigo;
    }

    public void setPolCodigo(BigDecimal polCodigo) {
        this.polCodigo = polCodigo;
    }

    public String getPolNumpol() {
        return polNumpol;
    }

    public void setPolNumpol(String polNumpol) {
        this.polNumpol = polNumpol;
    }

    public Date getPolFecini() {
        return polFecini;
    }

    public void setPolFecini(Date polFecini) {
        this.polFecini = polFecini;
    }

    public Date getPolVigencia() {
        return polVigencia;
    }

    public void setPolVigencia(Date polVigencia) {
        this.polVigencia = polVigencia;
    }

    public Short getPolIva() {
        return polIva;
    }

    public void setPolIva(Short polIva) {
        this.polIva = polIva;
    }

    public Short getPolSegcamp() {
        return polSegcamp;
    }

    public void setPolSegcamp(Short polSegcamp) {
        this.polSegcamp = polSegcamp;
    }

    public Short getPolSupbanc() {
        return polSupbanc;
    }

    public void setPolSupbanc(Short polSupbanc) {
        this.polSupbanc = polSupbanc;
    }

    public BigInteger getPolDeremis() {
        return polDeremis;
    }

    public void setPolDeremis(BigInteger polDeremis) {
        this.polDeremis = polDeremis;
    }

    public BigInteger getPolPrimatotal() {
        return polPrimatotal;
    }

    public void setPolPrimatotal(BigInteger polPrimatotal) {
        this.polPrimatotal = polPrimatotal;
    }

    public LaseAseguradora getAseCodigo() {
        return aseCodigo;
    }

    public void setAseCodigo(LaseAseguradora aseCodigo) {
        this.aseCodigo = aseCodigo;
    }

    @XmlTransient
    public List<LasgAsegurados> getLasgAseguradosList() {
        return lasgAseguradosList;
    }

    public void setLasgAseguradosList(List<LasgAsegurados> lasgAseguradosList) {
        this.lasgAseguradosList = lasgAseguradosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (polCodigo != null ? polCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LpolPoliza)) {
            return false;
        }
        LpolPoliza other = (LpolPoliza) object;
        if ((this.polCodigo == null && other.polCodigo != null) || (this.polCodigo != null && !this.polCodigo.equals(other.polCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.LpolPoliza[ polCodigo=" + polCodigo + " ]";
    }

}
