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
@Table(name = "LDSU_DETSUB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LdsuDetsub.findAll", query = "SELECT l FROM LdsuDetsub l"),
    @NamedQuery(name = "LdsuDetsub.findByDsuCodigo", query = "SELECT l FROM LdsuDetsub l WHERE l.dsuCodigo = :dsuCodigo"),
    @NamedQuery(name = "LdsuDetsub.findByDsuDescripcion", query = "SELECT l FROM LdsuDetsub l WHERE l.dsuDescripcion = :dsuDescripcion"),
    @NamedQuery(name = "LdsuDetsub.findByDsuEstado", query = "SELECT l FROM LdsuDetsub l WHERE l.dsuEstado = :dsuEstado")})
public class LdsuDetsub implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DSU_CODIGO")
    private BigDecimal dsuCodigo;
    @Size(max = 100)
    @Column(name = "DSU_DESCRIPCION")
    private String dsuDescripcion;
    @Column(name = "DSU_ESTADO")
    private Character dsuEstado;
    @JoinColumn(name = "DCO_CODIGO", referencedColumnName = "DCO_CODIGO")
    @ManyToOne
    private LdcoDetcon dcoCodigo;
    @OneToMany(mappedBy = "dsuCodigo")
    private List<LartArtic> lartArticList;

    public LdsuDetsub() {
    }

    public LdsuDetsub(BigDecimal dsuCodigo) {
        this.dsuCodigo = dsuCodigo;
    }

    public BigDecimal getDsuCodigo() {
        return dsuCodigo;
    }

    public void setDsuCodigo(BigDecimal dsuCodigo) {
        this.dsuCodigo = dsuCodigo;
    }

    public String getDsuDescripcion() {
        return dsuDescripcion;
    }

    public void setDsuDescripcion(String dsuDescripcion) {
        this.dsuDescripcion = dsuDescripcion;
    }

    public Character getDsuEstado() {
        return dsuEstado;
    }

    public void setDsuEstado(Character dsuEstado) {
        this.dsuEstado = dsuEstado;
    }

    public LdcoDetcon getDcoCodigo() {
        return dcoCodigo;
    }

    public void setDcoCodigo(LdcoDetcon dcoCodigo) {
        this.dcoCodigo = dcoCodigo;
    }

    @XmlTransient
    public List<LartArtic> getLartArticList() {
        return lartArticList;
    }

    public void setLartArticList(List<LartArtic> lartArticList) {
        this.lartArticList = lartArticList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dsuCodigo != null ? dsuCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LdsuDetsub)) {
            return false;
        }
        LdsuDetsub other = (LdsuDetsub) object;
        if ((this.dsuCodigo == null && other.dsuCodigo != null) || (this.dsuCodigo != null && !this.dsuCodigo.equals(other.dsuCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.LdsuDetsub[ dsuCodigo=" + dsuCodigo + " ]";
    }
    
}
