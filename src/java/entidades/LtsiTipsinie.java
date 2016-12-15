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
@Table(name = "LTSI_TIPSINIE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LtsiTipsinie.findAll", query = "SELECT l FROM LtsiTipsinie l"),
    @NamedQuery(name = "LtsiTipsinie.findByTsiCodigo", query = "SELECT l FROM LtsiTipsinie l WHERE l.tsiCodigo = :tsiCodigo"),
    @NamedQuery(name = "LtsiTipsinie.findByTsiDescri", query = "SELECT l FROM LtsiTipsinie l WHERE l.tsiDescri = :tsiDescri"),
    @NamedQuery(name = "LtsiTipsinie.findByTsiSiglas", query = "SELECT l FROM LtsiTipsinie l WHERE l.tsiSiglas = :tsiSiglas")})
public class LtsiTipsinie implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TSI_CODIGO")
    private BigDecimal tsiCodigo;
    @Size(max = 100)
    @Column(name = "TSI_DESCRI")
    private String tsiDescri;
    @Size(max = 8)
    @Column(name = "TSI_SIGLAS")
    private String tsiSiglas;
    @OneToMany(mappedBy = "tsiCodigo")
    private List<LsinSiniestro> lsinSiniestroList;

    public LtsiTipsinie() {
    }

    public LtsiTipsinie(BigDecimal tsiCodigo) {
        this.tsiCodigo = tsiCodigo;
    }

    public BigDecimal getTsiCodigo() {
        return tsiCodigo;
    }

    public void setTsiCodigo(BigDecimal tsiCodigo) {
        this.tsiCodigo = tsiCodigo;
    }

    public String getTsiDescri() {
        return tsiDescri;
    }

    public void setTsiDescri(String tsiDescri) {
        this.tsiDescri = tsiDescri;
    }

    public String getTsiSiglas() {
        return tsiSiglas;
    }

    public void setTsiSiglas(String tsiSiglas) {
        this.tsiSiglas = tsiSiglas;
    }

    @XmlTransient
    public List<LsinSiniestro> getLsinSiniestroList() {
        return lsinSiniestroList;
    }

    public void setLsinSiniestroList(List<LsinSiniestro> lsinSiniestroList) {
        this.lsinSiniestroList = lsinSiniestroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tsiCodigo != null ? tsiCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LtsiTipsinie)) {
            return false;
        }
        LtsiTipsinie other = (LtsiTipsinie) object;
        if ((this.tsiCodigo == null && other.tsiCodigo != null) || (this.tsiCodigo != null && !this.tsiCodigo.equals(other.tsiCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.LtsiTipsinie[ tsiCodigo=" + tsiCodigo + " ]";
    }
    
}
