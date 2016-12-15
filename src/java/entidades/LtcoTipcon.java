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
@Table(name = "LTCO_TIPCON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LtcoTipcon.findAll", query = "SELECT l FROM LtcoTipcon l"),
    @NamedQuery(name = "LtcoTipcon.findByTcoCodigo", query = "SELECT l FROM LtcoTipcon l WHERE l.tcoCodigo = :tcoCodigo"),
    @NamedQuery(name = "LtcoTipcon.findByTcoDescripcion", query = "SELECT l FROM LtcoTipcon l WHERE l.tcoDescripcion = :tcoDescripcion"),
    @NamedQuery(name = "LtcoTipcon.findByTcoEstado", query = "SELECT l FROM LtcoTipcon l WHERE l.tcoEstado = :tcoEstado")})
public class LtcoTipcon implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TCO_CODIGO")
    private BigDecimal tcoCodigo;
    @Size(max = 100)
    @Column(name = "TCO_DESCRIPCION")
    private String tcoDescripcion;
    @Column(name = "TCO_ESTADO")
    private Character tcoEstado;
    @OneToMany(mappedBy = "tcoCodigo")
    private List<LartArtic> lartArticList;
    @JoinColumn(name = "SER_CODIGO", referencedColumnName = "SER_CODIGO")
    @ManyToOne
    private LserServi serCodigo;
    @OneToMany(mappedBy = "tcoCodigo")
    private List<LdcoDetcon> ldcoDetconList;

    public LtcoTipcon() {
    }

    public LtcoTipcon(BigDecimal tcoCodigo) {
        this.tcoCodigo = tcoCodigo;
    }

    public BigDecimal getTcoCodigo() {
        return tcoCodigo;
    }

    public void setTcoCodigo(BigDecimal tcoCodigo) {
        this.tcoCodigo = tcoCodigo;
    }

    public String getTcoDescripcion() {
        return tcoDescripcion;
    }

    public void setTcoDescripcion(String tcoDescripcion) {
        this.tcoDescripcion = tcoDescripcion;
    }

    public Character getTcoEstado() {
        return tcoEstado;
    }

    public void setTcoEstado(Character tcoEstado) {
        this.tcoEstado = tcoEstado;
    }

    @XmlTransient
    public List<LartArtic> getLartArticList() {
        return lartArticList;
    }

    public void setLartArticList(List<LartArtic> lartArticList) {
        this.lartArticList = lartArticList;
    }

    public LserServi getSerCodigo() {
        return serCodigo;
    }

    public void setSerCodigo(LserServi serCodigo) {
        this.serCodigo = serCodigo;
    }

    @XmlTransient
    public List<LdcoDetcon> getLdcoDetconList() {
        return ldcoDetconList;
    }

    public void setLdcoDetconList(List<LdcoDetcon> ldcoDetconList) {
        this.ldcoDetconList = ldcoDetconList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tcoCodigo != null ? tcoCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LtcoTipcon)) {
            return false;
        }
        LtcoTipcon other = (LtcoTipcon) object;
        if ((this.tcoCodigo == null && other.tcoCodigo != null) || (this.tcoCodigo != null && !this.tcoCodigo.equals(other.tcoCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.LtcoTipcon[ tcoCodigo=" + tcoCodigo + " ]";
    }
    
}
