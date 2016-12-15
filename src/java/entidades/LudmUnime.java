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
@Table(name = "LUDM_UNIME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LudmUnime.findAll", query = "SELECT l FROM LudmUnime l"),
    @NamedQuery(name = "LudmUnime.findByUdmCodigo", query = "SELECT l FROM LudmUnime l WHERE l.udmCodigo = :udmCodigo"),
    @NamedQuery(name = "LudmUnime.findByUdmDescrip", query = "SELECT l FROM LudmUnime l WHERE l.udmDescrip = :udmDescrip"),
    @NamedQuery(name = "LudmUnime.findByUdmSimbo", query = "SELECT l FROM LudmUnime l WHERE l.udmSimbo = :udmSimbo")})
public class LudmUnime implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "UDM_CODIGO")
    private BigDecimal udmCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "UDM_DESCRIP")
    private String udmDescrip;
    @Size(max = 20)
    @Column(name = "UDM_SIMBO")
    private String udmSimbo;
    @OneToMany(mappedBy = "udmCodigo")
    private List<LartArtic> lartArticList;

    public LudmUnime() {
    }

    public LudmUnime(BigDecimal udmCodigo) {
        this.udmCodigo = udmCodigo;
    }

    public LudmUnime(BigDecimal udmCodigo, String udmDescrip) {
        this.udmCodigo = udmCodigo;
        this.udmDescrip = udmDescrip;
    }

    public BigDecimal getUdmCodigo() {
        return udmCodigo;
    }

    public void setUdmCodigo(BigDecimal udmCodigo) {
        this.udmCodigo = udmCodigo;
    }

    public String getUdmDescrip() {
        return udmDescrip;
    }

    public void setUdmDescrip(String udmDescrip) {
        this.udmDescrip = udmDescrip;
    }

    public String getUdmSimbo() {
        return udmSimbo;
    }

    public void setUdmSimbo(String udmSimbo) {
        this.udmSimbo = udmSimbo;
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
        hash += (udmCodigo != null ? udmCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LudmUnime)) {
            return false;
        }
        LudmUnime other = (LudmUnime) object;
        if ((this.udmCodigo == null && other.udmCodigo != null) || (this.udmCodigo != null && !this.udmCodigo.equals(other.udmCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.LudmUnime[ udmCodigo=" + udmCodigo + " ]";
    }
    
}
