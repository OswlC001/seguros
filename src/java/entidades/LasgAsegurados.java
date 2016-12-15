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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Oswaldo
 */
@Entity
@Table(name = "LASG_ASEGURADOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LasgAsegurados.findAll", query = "SELECT l FROM LasgAsegurados l"),
    @NamedQuery(name = "LasgAsegurados.findByAsgCodigo", query = "SELECT l FROM LasgAsegurados l WHERE l.asgCodigo = :asgCodigo"),
    @NamedQuery(name = "LasgAsegurados.findByAsgFecha", query = "SELECT l FROM LasgAsegurados l WHERE l.asgFecha = :asgFecha"),
    @NamedQuery(name = "LasgAsegurados.findByAsgEstado", query = "SELECT l FROM LasgAsegurados l WHERE l.asgEstado = :asgEstado"),
    @NamedQuery(name = "LasgAsegurados.findByAsgPrima", query = "SELECT l FROM LasgAsegurados l WHERE l.asgPrima = :asgPrima")})
public class LasgAsegurados implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ASG_CODIGO")
    private BigDecimal asgCodigo;
    @Column(name = "ASG_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date asgFecha;
    @Column(name = "ASG_ESTADO")
    private Character asgEstado;
    @Column(name = "ASG_PRIMA")
    private Short asgPrima;
    @JoinColumn(name = "POL_CODIGO", referencedColumnName = "POL_CODIGO")
    @ManyToOne
    private LpolPoliza polCodigo;
    @JoinColumn(name = "VEH_CODIGO", referencedColumnName = "VEH_CODIGO")
    @ManyToOne
    private LvehVehic vehCodigo;

    public LasgAsegurados() {
    }

    public LasgAsegurados(BigDecimal asgCodigo) {
        this.asgCodigo = asgCodigo;
    }

    public BigDecimal getAsgCodigo() {
        return asgCodigo;
    }

    public void setAsgCodigo(BigDecimal asgCodigo) {
        this.asgCodigo = asgCodigo;
    }

    public Date getAsgFecha() {
        return asgFecha;
    }

    public void setAsgFecha(Date asgFecha) {
        this.asgFecha = asgFecha;
    }

    public Character getAsgEstado() {
        return asgEstado;
    }

    public void setAsgEstado(Character asgEstado) {
        this.asgEstado = asgEstado;
    }

    public Short getAsgPrima() {
        return asgPrima;
    }

    public void setAsgPrima(Short asgPrima) {
        this.asgPrima = asgPrima;
    }

    public LpolPoliza getPolCodigo() {
        return polCodigo;
    }

    public void setPolCodigo(LpolPoliza polCodigo) {
        this.polCodigo = polCodigo;
    }

    public LvehVehic getVehCodigo() {
        return vehCodigo;
    }

    public void setVehCodigo(LvehVehic vehCodigo) {
        this.vehCodigo = vehCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asgCodigo != null ? asgCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LasgAsegurados)) {
            return false;
        }
        LasgAsegurados other = (LasgAsegurados) object;
        if ((this.asgCodigo == null && other.asgCodigo != null) || (this.asgCodigo != null && !this.asgCodigo.equals(other.asgCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.LasgAsegurados[ asgCodigo=" + asgCodigo + " ]";
    }
    
}
