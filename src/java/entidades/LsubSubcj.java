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
@Table(name = "LSUB_SUBCJ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LsubSubcj.findAll", query = "SELECT l FROM LsubSubcj l"),
    @NamedQuery(name = "LsubSubcj.findBySubCodigo", query = "SELECT l FROM LsubSubcj l WHERE l.subCodigo = :subCodigo"),
    @NamedQuery(name = "LsubSubcj.findBySubDescripc", query = "SELECT l FROM LsubSubcj l WHERE l.subDescripc = :subDescripc"),
    @NamedQuery(name = "LsubSubcj.findByCodigoTotalConjunto", query = "SELECT l FROM LsubSubcj l WHERE l.codigoTotalConjunto = :codigoTotalConjunto"),
    @NamedQuery(name = "LsubSubcj.findByCodTotal", query = "SELECT l FROM LsubSubcj l WHERE l.codTotal = :codTotal"),
    @NamedQuery(name = "LsubSubcj.findBySubCindiv", query = "SELECT l FROM LsubSubcj l WHERE l.subCindiv = :subCindiv"),
    @NamedQuery(name = "LsubSubcj.findBySubFungible", query = "SELECT l FROM LsubSubcj l WHERE l.subFungible = :subFungible"),
    @NamedQuery(name = "LsubSubcj.findBySubSubconjuntoCodigo", query = "SELECT l FROM LsubSubcj l WHERE l.subSubconjuntoCodigo = :subSubconjuntoCodigo"),
    @NamedQuery(name = "LsubSubcj.findBySubRepuesto", query = "SELECT l FROM LsubSubcj l WHERE l.subRepuesto = :subRepuesto"),
    @NamedQuery(name = "LsubSubcj.findBySubCodalter", query = "SELECT l FROM LsubSubcj l WHERE l.subCodalter = :subCodalter")})
public class LsubSubcj implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUB_CODIGO")
    private BigDecimal subCodigo;
    @Size(max = 100)
    @Column(name = "SUB_DESCRIPC")
    private String subDescripc;
    @Size(max = 50)
    @Column(name = "CODIGO_TOTAL_CONJUNTO")
    private String codigoTotalConjunto;
    @Size(max = 50)
    @Column(name = "COD_TOTAL")
    private String codTotal;
    @Column(name = "SUB_CINDIV")
    private Character subCindiv;
    @Column(name = "SUB_FUNGIBLE")
    private Character subFungible;
    @Size(max = 2)
    @Column(name = "SUB_SUBCONJUNTO_CODIGO")
    private String subSubconjuntoCodigo;
    @Size(max = 50)
    @Column(name = "SUB_REPUESTO")
    private String subRepuesto;
    @Size(max = 10)
    @Column(name = "SUB_CODALTER")
    private String subCodalter;
    @OneToMany(mappedBy = "subCodigo")
    private List<LartArtic> lartArticList;
    @JoinColumn(name = "CNJ_CODIGO", referencedColumnName = "CNJ_CODIGO")
    @ManyToOne
    private LcnjConju cnjCodigo;

    public LsubSubcj() {
    }

    public LsubSubcj(BigDecimal subCodigo) {
        this.subCodigo = subCodigo;
    }

    public BigDecimal getSubCodigo() {
        return subCodigo;
    }

    public void setSubCodigo(BigDecimal subCodigo) {
        this.subCodigo = subCodigo;
    }

    public String getSubDescripc() {
        return subDescripc;
    }

    public void setSubDescripc(String subDescripc) {
        this.subDescripc = subDescripc;
    }

    public String getCodigoTotalConjunto() {
        return codigoTotalConjunto;
    }

    public void setCodigoTotalConjunto(String codigoTotalConjunto) {
        this.codigoTotalConjunto = codigoTotalConjunto;
    }

    public String getCodTotal() {
        return codTotal;
    }

    public void setCodTotal(String codTotal) {
        this.codTotal = codTotal;
    }

    public Character getSubCindiv() {
        return subCindiv;
    }

    public void setSubCindiv(Character subCindiv) {
        this.subCindiv = subCindiv;
    }

    public Character getSubFungible() {
        return subFungible;
    }

    public void setSubFungible(Character subFungible) {
        this.subFungible = subFungible;
    }

    public String getSubSubconjuntoCodigo() {
        return subSubconjuntoCodigo;
    }

    public void setSubSubconjuntoCodigo(String subSubconjuntoCodigo) {
        this.subSubconjuntoCodigo = subSubconjuntoCodigo;
    }

    public String getSubRepuesto() {
        return subRepuesto;
    }

    public void setSubRepuesto(String subRepuesto) {
        this.subRepuesto = subRepuesto;
    }

    public String getSubCodalter() {
        return subCodalter;
    }

    public void setSubCodalter(String subCodalter) {
        this.subCodalter = subCodalter;
    }

    @XmlTransient
    public List<LartArtic> getLartArticList() {
        return lartArticList;
    }

    public void setLartArticList(List<LartArtic> lartArticList) {
        this.lartArticList = lartArticList;
    }

    public LcnjConju getCnjCodigo() {
        return cnjCodigo;
    }

    public void setCnjCodigo(LcnjConju cnjCodigo) {
        this.cnjCodigo = cnjCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subCodigo != null ? subCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LsubSubcj)) {
            return false;
        }
        LsubSubcj other = (LsubSubcj) object;
        if ((this.subCodigo == null && other.subCodigo != null) || (this.subCodigo != null && !this.subCodigo.equals(other.subCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.LsubSubcj[ subCodigo=" + subCodigo + " ]";
    }
    
}
