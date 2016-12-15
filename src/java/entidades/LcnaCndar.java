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
import javax.persistence.CascadeType;
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
@Table(name = "LCNA_CNDAR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LcnaCndar.findAll", query = "SELECT l FROM LcnaCndar l"),
    @NamedQuery(name = "LcnaCndar.findByCnaCodigo", query = "SELECT l FROM LcnaCndar l WHERE l.cnaCodigo = :cnaCodigo"),
    @NamedQuery(name = "LcnaCndar.findByCnaDescrip", query = "SELECT l FROM LcnaCndar l WHERE l.cnaDescrip = :cnaDescrip")})
public class LcnaCndar implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CNA_CODIGO")
    private BigDecimal cnaCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CNA_DESCRIP")
    private String cnaDescrip;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lcnaCndar")
    private List<LeatEstad> leatEstadList;

    public LcnaCndar() {
    }

    public LcnaCndar(BigDecimal cnaCodigo) {
        this.cnaCodigo = cnaCodigo;
    }

    public LcnaCndar(BigDecimal cnaCodigo, String cnaDescrip) {
        this.cnaCodigo = cnaCodigo;
        this.cnaDescrip = cnaDescrip;
    }

    public BigDecimal getCnaCodigo() {
        return cnaCodigo;
    }

    public void setCnaCodigo(BigDecimal cnaCodigo) {
        this.cnaCodigo = cnaCodigo;
    }

    public String getCnaDescrip() {
        return cnaDescrip;
    }

    public void setCnaDescrip(String cnaDescrip) {
        this.cnaDescrip = cnaDescrip;
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
        hash += (cnaCodigo != null ? cnaCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LcnaCndar)) {
            return false;
        }
        LcnaCndar other = (LcnaCndar) object;
        if ((this.cnaCodigo == null && other.cnaCodigo != null) || (this.cnaCodigo != null && !this.cnaCodigo.equals(other.cnaCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.LcnaCndar[ cnaCodigo=" + cnaCodigo + " ]";
    }
    
}
