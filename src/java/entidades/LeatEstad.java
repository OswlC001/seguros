/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Oswaldo
 */
@Entity
@Table(name = "LEAT_ESTAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LeatEstad.findAll", query = "SELECT l FROM LeatEstad l"),
    @NamedQuery(name = "LeatEstad.findByCnaCodigo", query = "SELECT l FROM LeatEstad l WHERE l.leatEstadPK.cnaCodigo = :cnaCodigo"),
    @NamedQuery(name = "LeatEstad.findByEatCodigo", query = "SELECT l FROM LeatEstad l WHERE l.leatEstadPK.eatCodigo = :eatCodigo"),
    @NamedQuery(name = "LeatEstad.findByEatDescrip", query = "SELECT l FROM LeatEstad l WHERE l.eatDescrip = :eatDescrip")})
public class LeatEstad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LeatEstadPK leatEstadPK;
    @Size(max = 20)
    @Column(name = "EAT_DESCRIP")
    private String eatDescrip;
    @JoinColumn(name = "CNA_CODIGO", referencedColumnName = "CNA_CODIGO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private LcnaCndar lcnaCndar;
    @JoinColumn(name = "SER_CODIGO", referencedColumnName = "SER_CODIGO")
    @ManyToOne
    private LserServi serCodigo;
    @OneToMany(mappedBy = "leatEstad")
    private List<LvehVehic> lvehVehicList;

    public LeatEstad() {
    }

    public LeatEstad(LeatEstadPK leatEstadPK) {
        this.leatEstadPK = leatEstadPK;
    }

    public LeatEstad(BigInteger cnaCodigo, BigInteger eatCodigo) {
        this.leatEstadPK = new LeatEstadPK(cnaCodigo, eatCodigo);
    }

    public LeatEstadPK getLeatEstadPK() {
        return leatEstadPK;
    }

    public void setLeatEstadPK(LeatEstadPK leatEstadPK) {
        this.leatEstadPK = leatEstadPK;
    }

    public String getEatDescrip() {
        return eatDescrip;
    }

    public void setEatDescrip(String eatDescrip) {
        this.eatDescrip = eatDescrip;
    }

    public LcnaCndar getLcnaCndar() {
        return lcnaCndar;
    }

    public void setLcnaCndar(LcnaCndar lcnaCndar) {
        this.lcnaCndar = lcnaCndar;
    }

    public LserServi getSerCodigo() {
        return serCodigo;
    }

    public void setSerCodigo(LserServi serCodigo) {
        this.serCodigo = serCodigo;
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
        hash += (leatEstadPK != null ? leatEstadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LeatEstad)) {
            return false;
        }
        LeatEstad other = (LeatEstad) object;
        if ((this.leatEstadPK == null && other.leatEstadPK != null) || (this.leatEstadPK != null && !this.leatEstadPK.equals(other.leatEstadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.LeatEstad[ leatEstadPK=" + leatEstadPK + " ]";
    }
    
}
