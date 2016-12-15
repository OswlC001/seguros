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
@Table(name = "LCLA_CLASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LclaClase.findAll", query = "SELECT l FROM LclaClase l"),
    @NamedQuery(name = "LclaClase.findByClaCodigo", query = "SELECT l FROM LclaClase l WHERE l.claCodigo = :claCodigo"),
    @NamedQuery(name = "LclaClase.findByClaDescrip", query = "SELECT l FROM LclaClase l WHERE l.claDescrip = :claDescrip"),
    @NamedQuery(name = "LclaClase.findByClaTipo", query = "SELECT l FROM LclaClase l WHERE l.claTipo = :claTipo")})
public class LclaClase implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLA_CODIGO")
    private BigDecimal claCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "CLA_DESCRIP")
    private String claDescrip;
    @Size(max = 30)
    @Column(name = "CLA_TIPO")
    private String claTipo;
    @OneToMany(mappedBy = "claCodigo")
    private List<LartArtic> lartArticList;

    public LclaClase() {
    }

    public LclaClase(BigDecimal claCodigo) {
        this.claCodigo = claCodigo;
    }

    public LclaClase(BigDecimal claCodigo, String claDescrip) {
        this.claCodigo = claCodigo;
        this.claDescrip = claDescrip;
    }

    public BigDecimal getClaCodigo() {
        return claCodigo;
    }

    public void setClaCodigo(BigDecimal claCodigo) {
        this.claCodigo = claCodigo;
    }

    public String getClaDescrip() {
        return claDescrip;
    }

    public void setClaDescrip(String claDescrip) {
        this.claDescrip = claDescrip;
    }

    public String getClaTipo() {
        return claTipo;
    }

    public void setClaTipo(String claTipo) {
        this.claTipo = claTipo;
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
        hash += (claCodigo != null ? claCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LclaClase)) {
            return false;
        }
        LclaClase other = (LclaClase) object;
        if ((this.claCodigo == null && other.claCodigo != null) || (this.claCodigo != null && !this.claCodigo.equals(other.claCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.LclaClase[ claCodigo=" + claCodigo + " ]";
    }
    
}
