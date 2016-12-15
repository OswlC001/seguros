/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Oswaldo
 */
@Entity
@Table(name = "LTRA_TRAMITE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LtraTramite.findAll", query = "SELECT l FROM LtraTramite l"),
    @NamedQuery(name = "LtraTramite.findByTraCodigo", query = "SELECT l FROM LtraTramite l WHERE l.traCodigo = :traCodigo"),
    @NamedQuery(name = "LtraTramite.findByTraFecha", query = "SELECT l FROM LtraTramite l WHERE l.traFecha = :traFecha"),
    @NamedQuery(name = "LtraTramite.findByTraObserv", query = "SELECT l FROM LtraTramite l WHERE l.traObserv = :traObserv")})
public class LtraTramite implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRA_CODIGO")
    private BigDecimal traCodigo;
    @Column(name = "TRA_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date traFecha;
    @Size(max = 500)
    @Column(name = "TRA_OBSERV")
    private String traObserv;
    @JoinColumn(name = "SIN_CODIGO", referencedColumnName = "SIN_CODIGO")
    @ManyToOne
    private LsinSiniestro sinCodigo;

    public LtraTramite() {
    }

    public LtraTramite(BigDecimal traCodigo) {
        this.traCodigo = traCodigo;
    }

    public BigDecimal getTraCodigo() {
        return traCodigo;
    }

    public void setTraCodigo(BigDecimal traCodigo) {
        this.traCodigo = traCodigo;
    }

    public Date getTraFecha() {
        return traFecha;
    }

    public void setTraFecha(Date traFecha) {
        this.traFecha = traFecha;
    }

    public String getTraObserv() {
        return traObserv;
    }

    public void setTraObserv(String traObserv) {
        this.traObserv = traObserv;
    }

    public LsinSiniestro getSinCodigo() {
        return sinCodigo;
    }

    public void setSinCodigo(LsinSiniestro sinCodigo) {
        this.sinCodigo = sinCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (traCodigo != null ? traCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LtraTramite)) {
            return false;
        }
        LtraTramite other = (LtraTramite) object;
        if ((this.traCodigo == null && other.traCodigo != null) || (this.traCodigo != null && !this.traCodigo.equals(other.traCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.LtraTramite[ traCodigo=" + traCodigo + " ]";
    }
    
}
