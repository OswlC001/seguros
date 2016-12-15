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
@Table(name = "LMTV_MOTIV")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LmtvMotiv.findAll", query = "SELECT l FROM LmtvMotiv l"),
    @NamedQuery(name = "LmtvMotiv.findByMtvCodigo", query = "SELECT l FROM LmtvMotiv l WHERE l.mtvCodigo = :mtvCodigo"),
    @NamedQuery(name = "LmtvMotiv.findByMtvDestmoti", query = "SELECT l FROM LmtvMotiv l WHERE l.mtvDestmoti = :mtvDestmoti"),
    @NamedQuery(name = "LmtvMotiv.findByMtvTipo", query = "SELECT l FROM LmtvMotiv l WHERE l.mtvTipo = :mtvTipo"),
    @NamedQuery(name = "LmtvMotiv.findByMtvCodigoIe", query = "SELECT l FROM LmtvMotiv l WHERE l.mtvCodigoIe = :mtvCodigoIe"),
    @NamedQuery(name = "LmtvMotiv.findByMtvEspecial", query = "SELECT l FROM LmtvMotiv l WHERE l.mtvEspecial = :mtvEspecial"),
    @NamedQuery(name = "LmtvMotiv.findByMtvReplica", query = "SELECT l FROM LmtvMotiv l WHERE l.mtvReplica = :mtvReplica"),
    @NamedQuery(name = "LmtvMotiv.findByMtvPerfil", query = "SELECT l FROM LmtvMotiv l WHERE l.mtvPerfil = :mtvPerfil")})
public class LmtvMotiv implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MTV_CODIGO")
    private BigDecimal mtvCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "MTV_DESTMOTI")
    private String mtvDestmoti;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MTV_TIPO")
    private Character mtvTipo;
    @Column(name = "MTV_CODIGO_IE")
    private Double mtvCodigoIe;
    @Column(name = "MTV_ESPECIAL")
    private Character mtvEspecial;
    @Column(name = "MTV_REPLICA")
    private Character mtvReplica;
    @Column(name = "MTV_PERFIL")
    private Character mtvPerfil;
    @OneToMany(mappedBy = "mtvCodigo")
    private List<LvehVehic> lvehVehicList;
    @JoinColumn(name = "TMO_CODIGO", referencedColumnName = "TMO_CODIGO")
    @ManyToOne(optional = false)
    private LtmoTpmov tmoCodigo;

    public LmtvMotiv() {
    }

    public LmtvMotiv(BigDecimal mtvCodigo) {
        this.mtvCodigo = mtvCodigo;
    }

    public LmtvMotiv(BigDecimal mtvCodigo, String mtvDestmoti, Character mtvTipo) {
        this.mtvCodigo = mtvCodigo;
        this.mtvDestmoti = mtvDestmoti;
        this.mtvTipo = mtvTipo;
    }

    public BigDecimal getMtvCodigo() {
        return mtvCodigo;
    }

    public void setMtvCodigo(BigDecimal mtvCodigo) {
        this.mtvCodigo = mtvCodigo;
    }

    public String getMtvDestmoti() {
        return mtvDestmoti;
    }

    public void setMtvDestmoti(String mtvDestmoti) {
        this.mtvDestmoti = mtvDestmoti;
    }

    public Character getMtvTipo() {
        return mtvTipo;
    }

    public void setMtvTipo(Character mtvTipo) {
        this.mtvTipo = mtvTipo;
    }

    public Double getMtvCodigoIe() {
        return mtvCodigoIe;
    }

    public void setMtvCodigoIe(Double mtvCodigoIe) {
        this.mtvCodigoIe = mtvCodigoIe;
    }

    public Character getMtvEspecial() {
        return mtvEspecial;
    }

    public void setMtvEspecial(Character mtvEspecial) {
        this.mtvEspecial = mtvEspecial;
    }

    public Character getMtvReplica() {
        return mtvReplica;
    }

    public void setMtvReplica(Character mtvReplica) {
        this.mtvReplica = mtvReplica;
    }

    public Character getMtvPerfil() {
        return mtvPerfil;
    }

    public void setMtvPerfil(Character mtvPerfil) {
        this.mtvPerfil = mtvPerfil;
    }

    @XmlTransient
    public List<LvehVehic> getLvehVehicList() {
        return lvehVehicList;
    }

    public void setLvehVehicList(List<LvehVehic> lvehVehicList) {
        this.lvehVehicList = lvehVehicList;
    }

    public LtmoTpmov getTmoCodigo() {
        return tmoCodigo;
    }

    public void setTmoCodigo(LtmoTpmov tmoCodigo) {
        this.tmoCodigo = tmoCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mtvCodigo != null ? mtvCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LmtvMotiv)) {
            return false;
        }
        LmtvMotiv other = (LmtvMotiv) object;
        if ((this.mtvCodigo == null && other.mtvCodigo != null) || (this.mtvCodigo != null && !this.mtvCodigo.equals(other.mtvCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.LmtvMotiv[ mtvCodigo=" + mtvCodigo + " ]";
    }
    
}
