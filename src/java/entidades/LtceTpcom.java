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
@Table(name = "LTCE_TPCOM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LtceTpcom.findAll", query = "SELECT l FROM LtceTpcom l"),
    @NamedQuery(name = "LtceTpcom.findByTceCodigo", query = "SELECT l FROM LtceTpcom l WHERE l.tceCodigo = :tceCodigo"),
    @NamedQuery(name = "LtceTpcom.findByTceDescrip", query = "SELECT l FROM LtceTpcom l WHERE l.tceDescrip = :tceDescrip")})
public class LtceTpcom implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TCE_CODIGO")
    private BigDecimal tceCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TCE_DESCRIP")
    private String tceDescrip;
    @OneToMany(mappedBy = "tceCodigo")
    private List<LartArtic> lartArticList;

    public LtceTpcom() {
    }

    public LtceTpcom(BigDecimal tceCodigo) {
        this.tceCodigo = tceCodigo;
    }

    public LtceTpcom(BigDecimal tceCodigo, String tceDescrip) {
        this.tceCodigo = tceCodigo;
        this.tceDescrip = tceDescrip;
    }

    public BigDecimal getTceCodigo() {
        return tceCodigo;
    }

    public void setTceCodigo(BigDecimal tceCodigo) {
        this.tceCodigo = tceCodigo;
    }

    public String getTceDescrip() {
        return tceDescrip;
    }

    public void setTceDescrip(String tceDescrip) {
        this.tceDescrip = tceDescrip;
    }

    @XmlTransient
    public List<LartArtic> getLartArticList() {
        return lartArticList;
    }

    public void setLartArticList(List<LartArtic> lartArticList) {
        this.lartArticList = lartArticList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tceCodigo != null ? tceCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LtceTpcom)) {
            return false;
        }
        LtceTpcom other = (LtceTpcom) object;
        if ((this.tceCodigo == null && other.tceCodigo != null) || (this.tceCodigo != null && !this.tceCodigo.equals(other.tceCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.LtceTpcom[ tceCodigo=" + tceCodigo + " ]";
    }
    
}
