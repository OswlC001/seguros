/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Oswaldo
 */
@Entity
@Table(name = "LSIN_SINIESTRO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LsinSiniestro.findAll", query = "SELECT l FROM LsinSiniestro l"),
    @NamedQuery(name = "LsinSiniestro.findBySinCodigo", query = "SELECT l FROM LsinSiniestro l WHERE l.sinCodigo = :sinCodigo"),
    @NamedQuery(name = "LsinSiniestro.findByMemCedula", query = "SELECT l FROM LsinSiniestro l WHERE l.memCedula = :memCedula"),
    @NamedQuery(name = "LsinSiniestro.findBySinFecha", query = "SELECT l FROM LsinSiniestro l WHERE l.sinFecha = :sinFecha"),
    @NamedQuery(name = "LsinSiniestro.findBySinObserv", query = "SELECT l FROM LsinSiniestro l WHERE l.sinObserv = :sinObserv"),
    @NamedQuery(name = "LsinSiniestro.findBySinRespciv", query = "SELECT l FROM LsinSiniestro l WHERE l.sinRespciv = :sinRespciv"),
    @NamedQuery(name = "LsinSiniestro.findBySinDeducible", query = "SELECT l FROM LsinSiniestro l WHERE l.sinDeducible = :sinDeducible"),
    @NamedQuery(name = "LsinSiniestro.findBySinCostrep", query = "SELECT l FROM LsinSiniestro l WHERE l.sinCostrep = :sinCostrep")})
public class LsinSiniestro implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SIN_CODIGO")
    private BigDecimal sinCodigo;
    @Size(max = 15)
    @Column(name = "MEM_CEDULA")
    private String memCedula;
    @Column(name = "SIN_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sinFecha;
    @Size(max = 250)
    @Column(name = "SIN_OBSERV")
    private String sinObserv;
    @Column(name = "SIN_RESPCIV")
    private Character sinRespciv;
    @Column(name = "SIN_DEDUCIBLE")
    private Short sinDeducible;
    @Column(name = "SIN_COSTREP")
    private Short sinCostrep;
    @JoinColumn(name = "TSI_CODIGO", referencedColumnName = "TSI_CODIGO")
    @ManyToOne
    private LtsiTipsinie tsiCodigo;
    @JoinColumn(name = "VEH_CODIGO", referencedColumnName = "VEH_CODIGO")
    @ManyToOne
    private LvehVehic vehCodigo;
    @OneToMany(mappedBy = "sinCodigo")
    private List<LtraTramite> ltraTramiteList;

    public LsinSiniestro() {
    }

    public LsinSiniestro(BigDecimal sinCodigo) {
        this.sinCodigo = sinCodigo;
    }

    public BigDecimal getSinCodigo() {
        return sinCodigo;
    }

    public void setSinCodigo(BigDecimal sinCodigo) {
        this.sinCodigo = sinCodigo;
    }

    public String getMemCedula() {
        return memCedula;
    }

    public void setMemCedula(String memCedula) {
        this.memCedula = memCedula;
    }

    public Date getSinFecha() {
        return sinFecha;
    }

    public void setSinFecha(Date sinFecha) {
        this.sinFecha = sinFecha;
    }

    public String getSinObserv() {
        return sinObserv;
    }

    public void setSinObserv(String sinObserv) {
        this.sinObserv = sinObserv;
    }

    public Character getSinRespciv() {
        return sinRespciv;
    }

    public void setSinRespciv(Character sinRespciv) {
        this.sinRespciv = sinRespciv;
    }

    public Short getSinDeducible() {
        return sinDeducible;
    }

    public void setSinDeducible(Short sinDeducible) {
        this.sinDeducible = sinDeducible;
    }

    public Short getSinCostrep() {
        return sinCostrep;
    }

    public void setSinCostrep(Short sinCostrep) {
        this.sinCostrep = sinCostrep;
    }

    public LtsiTipsinie getTsiCodigo() {
        return tsiCodigo;
    }

    public void setTsiCodigo(LtsiTipsinie tsiCodigo) {
        this.tsiCodigo = tsiCodigo;
    }

    public LvehVehic getVehCodigo() {
        return vehCodigo;
    }

    public void setVehCodigo(LvehVehic vehCodigo) {
        this.vehCodigo = vehCodigo;
    }

    @XmlTransient
    public List<LtraTramite> getLtraTramiteList() {
        return ltraTramiteList;
    }

    public void setLtraTramiteList(List<LtraTramite> ltraTramiteList) {
        this.ltraTramiteList = ltraTramiteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sinCodigo != null ? sinCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LsinSiniestro)) {
            return false;
        }
        LsinSiniestro other = (LsinSiniestro) object;
        if ((this.sinCodigo == null && other.sinCodigo != null) || (this.sinCodigo != null && !this.sinCodigo.equals(other.sinCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.LsinSiniestro[ sinCodigo=" + sinCodigo + " ]";
    }
    
}
