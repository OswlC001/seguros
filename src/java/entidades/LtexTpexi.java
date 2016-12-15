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
@Table(name = "LTEX_TPEXI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LtexTpexi.findAll", query = "SELECT l FROM LtexTpexi l"),
    @NamedQuery(name = "LtexTpexi.findByTexCodigo", query = "SELECT l FROM LtexTpexi l WHERE l.texCodigo = :texCodigo"),
    @NamedQuery(name = "LtexTpexi.findByTexDescrip", query = "SELECT l FROM LtexTpexi l WHERE l.texDescrip = :texDescrip")})
public class LtexTpexi implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TEX_CODIGO")
    private BigDecimal texCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "TEX_DESCRIP")
    private String texDescrip;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "texCodigo")
    private List<LtmoTpmov> ltmoTpmovList;
    @OneToMany(mappedBy = "texCodigo")
    private List<LvehVehic> lvehVehicList;

    public LtexTpexi() {
    }

    public LtexTpexi(BigDecimal texCodigo) {
        this.texCodigo = texCodigo;
    }

    public LtexTpexi(BigDecimal texCodigo, String texDescrip) {
        this.texCodigo = texCodigo;
        this.texDescrip = texDescrip;
    }

    public BigDecimal getTexCodigo() {
        return texCodigo;
    }

    public void setTexCodigo(BigDecimal texCodigo) {
        this.texCodigo = texCodigo;
    }

    public String getTexDescrip() {
        return texDescrip;
    }

    public void setTexDescrip(String texDescrip) {
        this.texDescrip = texDescrip;
    }

    @XmlTransient
    public List<LtmoTpmov> getLtmoTpmovList() {
        return ltmoTpmovList;
    }

    public void setLtmoTpmovList(List<LtmoTpmov> ltmoTpmovList) {
        this.ltmoTpmovList = ltmoTpmovList;
    }

    @XmlTransient
    public List<LvehVehic> getLvehVehicList() {
        return lvehVehicList;
    }

    public void setLvehVehicList(List<LvehVehic> lvehVehicList) {
        this.lvehVehicList = lvehVehicList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (texCodigo != null ? texCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LtexTpexi)) {
            return false;
        }
        LtexTpexi other = (LtexTpexi) object;
        if ((this.texCodigo == null && other.texCodigo != null) || (this.texCodigo != null && !this.texCodigo.equals(other.texCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.LtexTpexi[ texCodigo=" + texCodigo + " ]";
    }
    
}
