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
@Table(name = "LSER_SERVI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LserServi.findAll", query = "SELECT l FROM LserServi l"),
    @NamedQuery(name = "LserServi.findBySerCodigo", query = "SELECT l FROM LserServi l WHERE l.serCodigo = :serCodigo"),
    @NamedQuery(name = "LserServi.findBySerDescrip", query = "SELECT l FROM LserServi l WHERE l.serDescrip = :serDescrip")})
public class LserServi implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SER_CODIGO")
    private BigDecimal serCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "SER_DESCRIP")
    private String serDescrip;
    @OneToMany(mappedBy = "serCodigo")
    private List<LtarTpoart> ltarTpoartList;
    @OneToMany(mappedBy = "serCodigo")
    private List<LartArtic> lartArticList;
    @OneToMany(mappedBy = "serCodigo")
    private List<LtcoTipcon> ltcoTipconList;
    @OneToMany(mappedBy = "serCodigo")
    private List<LcnjConju> lcnjConjuList;
    @OneToMany(mappedBy = "serCodigo")
    private List<LeatEstad> leatEstadList;

    public LserServi() {
    }

    public LserServi(BigDecimal serCodigo) {
        this.serCodigo = serCodigo;
    }

    public LserServi(BigDecimal serCodigo, String serDescrip) {
        this.serCodigo = serCodigo;
        this.serDescrip = serDescrip;
    }

    public BigDecimal getSerCodigo() {
        return serCodigo;
    }

    public void setSerCodigo(BigDecimal serCodigo) {
        this.serCodigo = serCodigo;
    }

    public String getSerDescrip() {
        return serDescrip;
    }

    public void setSerDescrip(String serDescrip) {
        this.serDescrip = serDescrip;
    }

    @XmlTransient
    public List<LtarTpoart> getLtarTpoartList() {
        return ltarTpoartList;
    }

    public void setLtarTpoartList(List<LtarTpoart> ltarTpoartList) {
        this.ltarTpoartList = ltarTpoartList;
    }

    @XmlTransient
    public List<LartArtic> getLartArticList() {
        return lartArticList;
    }

    public void setLartArticList(List<LartArtic> lartArticList) {
        this.lartArticList = lartArticList;
    }

    @XmlTransient
    public List<LtcoTipcon> getLtcoTipconList() {
        return ltcoTipconList;
    }

    public void setLtcoTipconList(List<LtcoTipcon> ltcoTipconList) {
        this.ltcoTipconList = ltcoTipconList;
    }

    @XmlTransient
    public List<LcnjConju> getLcnjConjuList() {
        return lcnjConjuList;
    }

    public void setLcnjConjuList(List<LcnjConju> lcnjConjuList) {
        this.lcnjConjuList = lcnjConjuList;
    }

    @XmlTransient
    public List<LeatEstad> getLeatEstadList() {
        return leatEstadList;
    }

    public void setLeatEstadList(List<LeatEstad> leatEstadList) {
        this.leatEstadList = leatEstadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serCodigo != null ? serCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LserServi)) {
            return false;
        }
        LserServi other = (LserServi) object;
        if ((this.serCodigo == null && other.serCodigo != null) || (this.serCodigo != null && !this.serCodigo.equals(other.serCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.LserServi[ serCodigo=" + serCodigo + " ]";
    }
    
}
