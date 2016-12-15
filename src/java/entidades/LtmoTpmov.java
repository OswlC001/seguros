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
@Table(name = "LTMO_TPMOV")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LtmoTpmov.findAll", query = "SELECT l FROM LtmoTpmov l"),
    @NamedQuery(name = "LtmoTpmov.findByTmoCodigo", query = "SELECT l FROM LtmoTpmov l WHERE l.tmoCodigo = :tmoCodigo"),
    @NamedQuery(name = "LtmoTpmov.findByTmoDescmov", query = "SELECT l FROM LtmoTpmov l WHERE l.tmoDescmov = :tmoDescmov")})
public class LtmoTpmov implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TMO_CODIGO")
    private BigDecimal tmoCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "TMO_DESCMOV")
    private String tmoDescmov;
    @JoinColumn(name = "TEX_CODIGO", referencedColumnName = "TEX_CODIGO")
    @ManyToOne(optional = false)
    private LtexTpexi texCodigo;
    @OneToMany(mappedBy = "tmoCodigo")
    private List<LvehVehic> lvehVehicList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tmoCodigo")
    private List<LmtvMotiv> lmtvMotivList;

    public LtmoTpmov() {
    }

    public LtmoTpmov(BigDecimal tmoCodigo) {
        this.tmoCodigo = tmoCodigo;
    }

    public LtmoTpmov(BigDecimal tmoCodigo, String tmoDescmov) {
        this.tmoCodigo = tmoCodigo;
        this.tmoDescmov = tmoDescmov;
    }

    public BigDecimal getTmoCodigo() {
        return tmoCodigo;
    }

    public void setTmoCodigo(BigDecimal tmoCodigo) {
        this.tmoCodigo = tmoCodigo;
    }

    public String getTmoDescmov() {
        return tmoDescmov;
    }

    public void setTmoDescmov(String tmoDescmov) {
        this.tmoDescmov = tmoDescmov;
    }

    public LtexTpexi getTexCodigo() {
        return texCodigo;
    }

    public void setTexCodigo(LtexTpexi texCodigo) {
        this.texCodigo = texCodigo;
    }

    @XmlTransient
    public List<LvehVehic> getLvehVehicList() {
        return lvehVehicList;
    }

    public void setLvehVehicList(List<LvehVehic> lvehVehicList) {
        this.lvehVehicList = lvehVehicList;
    }

    @XmlTransient
    public List<LmtvMotiv> getLmtvMotivList() {
        return lmtvMotivList;
    }

    public void setLmtvMotivList(List<LmtvMotiv> lmtvMotivList) {
        this.lmtvMotivList = lmtvMotivList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tmoCodigo != null ? tmoCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LtmoTpmov)) {
            return false;
        }
        LtmoTpmov other = (LtmoTpmov) object;
        if ((this.tmoCodigo == null && other.tmoCodigo != null) || (this.tmoCodigo != null && !this.tmoCodigo.equals(other.tmoCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.LtmoTpmov[ tmoCodigo=" + tmoCodigo + " ]";
    }
    
}
