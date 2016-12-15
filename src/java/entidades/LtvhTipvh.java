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
@Table(name = "LTVH_TIPVH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LtvhTipvh.findAll", query = "SELECT l FROM LtvhTipvh l"),
    @NamedQuery(name = "LtvhTipvh.findByTvhCodigo", query = "SELECT l FROM LtvhTipvh l WHERE l.tvhCodigo = :tvhCodigo"),
    @NamedQuery(name = "LtvhTipvh.findByTvhDescrip", query = "SELECT l FROM LtvhTipvh l WHERE l.tvhDescrip = :tvhDescrip"),
    @NamedQuery(name = "LtvhTipvh.findByTvhNumRegistro", query = "SELECT l FROM LtvhTipvh l WHERE l.tvhNumRegistro = :tvhNumRegistro"),
    @NamedQuery(name = "LtvhTipvh.findByTvhRegistroSigla", query = "SELECT l FROM LtvhTipvh l WHERE l.tvhRegistroSigla = :tvhRegistroSigla")})
public class LtvhTipvh implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TVH_CODIGO")
    private BigDecimal tvhCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TVH_DESCRIP")
    private String tvhDescrip;
    @Column(name = "TVH_NUM_REGISTRO")
    private Integer tvhNumRegistro;
    @Size(max = 3)
    @Column(name = "TVH_REGISTRO_SIGLA")
    private String tvhRegistroSigla;
    @OneToMany(mappedBy = "tvhCodigo")
    private List<LvehVehic> lvehVehicList;

    public LtvhTipvh() {
    }

    public LtvhTipvh(BigDecimal tvhCodigo) {
        this.tvhCodigo = tvhCodigo;
    }

    public LtvhTipvh(BigDecimal tvhCodigo, String tvhDescrip) {
        this.tvhCodigo = tvhCodigo;
        this.tvhDescrip = tvhDescrip;
    }

    public BigDecimal getTvhCodigo() {
        return tvhCodigo;
    }

    public void setTvhCodigo(BigDecimal tvhCodigo) {
        this.tvhCodigo = tvhCodigo;
    }

    public String getTvhDescrip() {
        return tvhDescrip;
    }

    public void setTvhDescrip(String tvhDescrip) {
        this.tvhDescrip = tvhDescrip;
    }

    public Integer getTvhNumRegistro() {
        return tvhNumRegistro;
    }

    public void setTvhNumRegistro(Integer tvhNumRegistro) {
        this.tvhNumRegistro = tvhNumRegistro;
    }

    public String getTvhRegistroSigla() {
        return tvhRegistroSigla;
    }

    public void setTvhRegistroSigla(String tvhRegistroSigla) {
        this.tvhRegistroSigla = tvhRegistroSigla;
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
        hash += (tvhCodigo != null ? tvhCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LtvhTipvh)) {
            return false;
        }
        LtvhTipvh other = (LtvhTipvh) object;
        if ((this.tvhCodigo == null && other.tvhCodigo != null) || (this.tvhCodigo != null && !this.tvhCodigo.equals(other.tvhCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.LtvhTipvh[ tvhCodigo=" + tvhCodigo + " ]";
    }
    
}
