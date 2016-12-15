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
@Table(name = "LCNJ_CONJU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LcnjConju.findAll", query = "SELECT l FROM LcnjConju l"),
    @NamedQuery(name = "LcnjConju.findByCnjCodigo", query = "SELECT l FROM LcnjConju l WHERE l.cnjCodigo = :cnjCodigo"),
    @NamedQuery(name = "LcnjConju.findByCnjDesconj", query = "SELECT l FROM LcnjConju l WHERE l.cnjDesconj = :cnjDesconj"),
    @NamedQuery(name = "LcnjConju.findByCnjCodigocontable", query = "SELECT l FROM LcnjConju l WHERE l.cnjCodigocontable = :cnjCodigocontable"),
    @NamedQuery(name = "LcnjConju.findByCnjCodconjunto", query = "SELECT l FROM LcnjConju l WHERE l.cnjCodconjunto = :cnjCodconjunto"),
    @NamedQuery(name = "LcnjConju.findByCnjFungible", query = "SELECT l FROM LcnjConju l WHERE l.cnjFungible = :cnjFungible"),
    @NamedQuery(name = "LcnjConju.findByCnjCindiv", query = "SELECT l FROM LcnjConju l WHERE l.cnjCindiv = :cnjCindiv"),
    @NamedQuery(name = "LcnjConju.findByCodTotal", query = "SELECT l FROM LcnjConju l WHERE l.codTotal = :codTotal"),
    @NamedQuery(name = "LcnjConju.findByCnjRepuesto", query = "SELECT l FROM LcnjConju l WHERE l.cnjRepuesto = :cnjRepuesto"),
    @NamedQuery(name = "LcnjConju.findByCnjCodalter", query = "SELECT l FROM LcnjConju l WHERE l.cnjCodalter = :cnjCodalter")})
public class LcnjConju implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CNJ_CODIGO")
    private BigDecimal cnjCodigo;
    @Size(max = 500)
    @Column(name = "CNJ_DESCONJ")
    private String cnjDesconj;
    @Size(max = 500)
    @Column(name = "CNJ_CODIGOCONTABLE")
    private String cnjCodigocontable;
    @Size(max = 500)
    @Column(name = "CNJ_CODCONJUNTO")
    private String cnjCodconjunto;
    @Column(name = "CNJ_FUNGIBLE")
    private Character cnjFungible;
    @Column(name = "CNJ_CINDIV")
    private Character cnjCindiv;
    @Size(max = 500)
    @Column(name = "COD_TOTAL")
    private String codTotal;
    @Size(max = 50)
    @Column(name = "CNJ_REPUESTO")
    private String cnjRepuesto;
    @Size(max = 10)
    @Column(name = "CNJ_CODALTER")
    private String cnjCodalter;
    @OneToMany(mappedBy = "cnjCodigo")
    private List<LartArtic> lartArticList;
    @OneToMany(mappedBy = "cnjCodigo")
    private List<LsubSubcj> lsubSubcjList;
    @JoinColumn(name = "SER_CODIGO", referencedColumnName = "SER_CODIGO")
    @ManyToOne
    private LserServi serCodigo;

    public LcnjConju() {
    }

    public LcnjConju(BigDecimal cnjCodigo) {
        this.cnjCodigo = cnjCodigo;
    }

    public BigDecimal getCnjCodigo() {
        return cnjCodigo;
    }

    public void setCnjCodigo(BigDecimal cnjCodigo) {
        this.cnjCodigo = cnjCodigo;
    }

    public String getCnjDesconj() {
        return cnjDesconj;
    }

    public void setCnjDesconj(String cnjDesconj) {
        this.cnjDesconj = cnjDesconj;
    }

    public String getCnjCodigocontable() {
        return cnjCodigocontable;
    }

    public void setCnjCodigocontable(String cnjCodigocontable) {
        this.cnjCodigocontable = cnjCodigocontable;
    }

    public String getCnjCodconjunto() {
        return cnjCodconjunto;
    }

    public void setCnjCodconjunto(String cnjCodconjunto) {
        this.cnjCodconjunto = cnjCodconjunto;
    }

    public Character getCnjFungible() {
        return cnjFungible;
    }

    public void setCnjFungible(Character cnjFungible) {
        this.cnjFungible = cnjFungible;
    }

    public Character getCnjCindiv() {
        return cnjCindiv;
    }

    public void setCnjCindiv(Character cnjCindiv) {
        this.cnjCindiv = cnjCindiv;
    }

    public String getCodTotal() {
        return codTotal;
    }

    public void setCodTotal(String codTotal) {
        this.codTotal = codTotal;
    }

    public String getCnjRepuesto() {
        return cnjRepuesto;
    }

    public void setCnjRepuesto(String cnjRepuesto) {
        this.cnjRepuesto = cnjRepuesto;
    }

    public String getCnjCodalter() {
        return cnjCodalter;
    }

    public void setCnjCodalter(String cnjCodalter) {
        this.cnjCodalter = cnjCodalter;
    }

    @XmlTransient
    public List<LartArtic> getLartArticList() {
        return lartArticList;
    }

    public void setLartArticList(List<LartArtic> lartArticList) {
        this.lartArticList = lartArticList;
    }

    @XmlTransient
    public List<LsubSubcj> getLsubSubcjList() {
        return lsubSubcjList;
    }

    public void setLsubSubcjList(List<LsubSubcj> lsubSubcjList) {
        this.lsubSubcjList = lsubSubcjList;
    }

    public LserServi getSerCodigo() {
        return serCodigo;
    }

    public void setSerCodigo(LserServi serCodigo) {
        this.serCodigo = serCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cnjCodigo != null ? cnjCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LcnjConju)) {
            return false;
        }
        LcnjConju other = (LcnjConju) object;
        if ((this.cnjCodigo == null && other.cnjCodigo != null) || (this.cnjCodigo != null && !this.cnjCodigo.equals(other.cnjCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.LcnjConju[ cnjCodigo=" + cnjCodigo + " ]";
    }
    
}
