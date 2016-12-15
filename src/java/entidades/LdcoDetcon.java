/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Oswaldo
 */
@Entity
@Table(name = "LDCO_DETCON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LdcoDetcon.findAll", query = "SELECT l FROM LdcoDetcon l"),
    @NamedQuery(name = "LdcoDetcon.findByDcoCodigo", query = "SELECT l FROM LdcoDetcon l WHERE l.dcoCodigo = :dcoCodigo"),
    @NamedQuery(name = "LdcoDetcon.findByDcoDescripcion", query = "SELECT l FROM LdcoDetcon l WHERE l.dcoDescripcion = :dcoDescripcion"),
    @NamedQuery(name = "LdcoDetcon.findByDcoEstado", query = "SELECT l FROM LdcoDetcon l WHERE l.dcoEstado = :dcoEstado")})
public class LdcoDetcon implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DCO_CODIGO")
    private BigDecimal dcoCodigo;
    @Size(max = 100)
    @Column(name = "DCO_DESCRIPCION")
    private String dcoDescripcion;
    @Column(name = "DCO_ESTADO")
    private Character dcoEstado;
    @OneToMany(mappedBy = "dcoCodigo")
    private List<LdsuDetsub> ldsuDetsubList;
    @OneToMany(mappedBy = "dcoCodigo")
    private List<LartArtic> lartArticList;
    @JoinColumn(name = "TCO_CODIGO", referencedColumnName = "TCO_CODIGO")
    @ManyToOne
    private LtcoTipcon tcoCodigo;

    public LdcoDetcon() {
    }

    public LdcoDetcon(BigDecimal dcoCodigo) {
        this.dcoCodigo = dcoCodigo;
    }

    public BigDecimal getDcoCodigo() {
        return dcoCodigo;
    }

    public void setDcoCodigo(BigDecimal dcoCodigo) {
        this.dcoCodigo = dcoCodigo;
    }

    public String getDcoDescripcion() {
        return dcoDescripcion;
    }

    public void setDcoDescripcion(String dcoDescripcion) {
        this.dcoDescripcion = dcoDescripcion;
    }

    public Character getDcoEstado() {
        return dcoEstado;
    }

    public void setDcoEstado(Character dcoEstado) {
        this.dcoEstado = dcoEstado;
    }

    @XmlTransient
    public List<LdsuDetsub> getLdsuDetsubList() {
        return ldsuDetsubList;
    }

    public void setLdsuDetsubList(List<LdsuDetsub> ldsuDetsubList) {
        this.ldsuDetsubList = ldsuDetsubList;
    }

    @XmlTransient
    public List<LartArtic> getLartArticList() {
        return lartArticList;
    }

    public void setLartArticList(List<LartArtic> lartArticList) {
        this.lartArticList = lartArticList;
    }

    public LtcoTipcon getTcoCodigo() {
        return tcoCodigo;
    }

    public void setTcoCodigo(LtcoTipcon tcoCodigo) {
        this.tcoCodigo = tcoCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dcoCodigo != null ? dcoCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LdcoDetcon)) {
            return false;
        }
        LdcoDetcon other = (LdcoDetcon) object;
        if ((this.dcoCodigo == null && other.dcoCodigo != null) || (this.dcoCodigo != null && !this.dcoCodigo.equals(other.dcoCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.LdcoDetcon[ dcoCodigo=" + dcoCodigo + " ]";
    }
    
}
