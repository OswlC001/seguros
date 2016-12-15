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
@Table(name = "LPST_PRESE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LpstPrese.findAll", query = "SELECT l FROM LpstPrese l"),
    @NamedQuery(name = "LpstPrese.findByPstCodigo", query = "SELECT l FROM LpstPrese l WHERE l.pstCodigo = :pstCodigo"),
    @NamedQuery(name = "LpstPrese.findByPstDescrip", query = "SELECT l FROM LpstPrese l WHERE l.pstDescrip = :pstDescrip"),
    @NamedQuery(name = "LpstPrese.findByPstAbreviatura", query = "SELECT l FROM LpstPrese l WHERE l.pstAbreviatura = :pstAbreviatura")})
public class LpstPrese implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PST_CODIGO")
    private BigDecimal pstCodigo;
    @Size(max = 20)
    @Column(name = "PST_DESCRIP")
    private String pstDescrip;
    @Size(max = 10)
    @Column(name = "PST_ABREVIATURA")
    private String pstAbreviatura;
    @OneToMany(mappedBy = "pstCodigo")
    private List<LartArtic> lartArticList;

    public LpstPrese() {
    }

    public LpstPrese(BigDecimal pstCodigo) {
        this.pstCodigo = pstCodigo;
    }

    public BigDecimal getPstCodigo() {
        return pstCodigo;
    }

    public void setPstCodigo(BigDecimal pstCodigo) {
        this.pstCodigo = pstCodigo;
    }

    public String getPstDescrip() {
        return pstDescrip;
    }

    public void setPstDescrip(String pstDescrip) {
        this.pstDescrip = pstDescrip;
    }

    public String getPstAbreviatura() {
        return pstAbreviatura;
    }

    public void setPstAbreviatura(String pstAbreviatura) {
        this.pstAbreviatura = pstAbreviatura;
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
        hash += (pstCodigo != null ? pstCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LpstPrese)) {
            return false;
        }
        LpstPrese other = (LpstPrese) object;
        if ((this.pstCodigo == null && other.pstCodigo != null) || (this.pstCodigo != null && !this.pstCodigo.equals(other.pstCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.LpstPrese[ pstCodigo=" + pstCodigo + " ]";
    }
    
}
