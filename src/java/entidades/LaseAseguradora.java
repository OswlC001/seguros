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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
@Table(name = "LASE_ASEGURADORA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LaseAseguradora.findAll", query = "SELECT l FROM LaseAseguradora l"),
    @NamedQuery(name = "LaseAseguradora.findByAseCodigo", query = "SELECT l FROM LaseAseguradora l WHERE l.aseCodigo = :aseCodigo"),
    @NamedQuery(name = "LaseAseguradora.findByAseRuc", query = "SELECT l FROM LaseAseguradora l WHERE l.aseRuc = :aseRuc"),
    @NamedQuery(name = "LaseAseguradora.findByAseNombre", query = "SELECT l FROM LaseAseguradora l WHERE l.aseNombre = :aseNombre"),
    @NamedQuery(name = "LaseAseguradora.findByAseDirecc", query = "SELECT l FROM LaseAseguradora l WHERE l.aseDirecc = :aseDirecc"),
    @NamedQuery(name = "LaseAseguradora.findByAseTelef", query = "SELECT l FROM LaseAseguradora l WHERE l.aseTelef = :aseTelef"),
    @NamedQuery(name = "LaseAseguradora.findByAseCedrepresent", query = "SELECT l FROM LaseAseguradora l WHERE l.aseCedrepresent = :aseCedrepresent"),
    @NamedQuery(name = "LaseAseguradora.findByAseNomrepresent", query = "SELECT l FROM LaseAseguradora l WHERE l.aseNomrepresent = :aseNomrepresent")})
public class LaseAseguradora implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ASE_CODIGO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ASEGURADORA_")
    @SequenceGenerator(name = "SEQ_ASEGURADORA_", sequenceName = "SEQ_ASEGURADORA", initialValue=5, allocationSize=1)
    private BigDecimal aseCodigo;
    @Size(max = 20)
    @Column(name = "ASE_RUC")
    private String aseRuc;
    @Size(max = 100)
    @Column(name = "ASE_NOMBRE")
    private String aseNombre;
    @Size(max = 250)
    @Column(name = "ASE_DIRECC")
    private String aseDirecc;
    @Size(max = 15)
    @Column(name = "ASE_TELEF")
    private String aseTelef;
    @Size(max = 20)
    @Column(name = "ASE_CEDREPRESENT")
    private String aseCedrepresent;
    @Size(max = 100)
    @Column(name = "ASE_NOMREPRESENT")
    private String aseNomrepresent;
    @OneToMany(mappedBy = "aseCodigo")
    private List<LpolPoliza> lpolPolizaList;

    public LaseAseguradora() {
    }

    public LaseAseguradora(BigDecimal aseCodigo) {
        this.aseCodigo = aseCodigo;
    }

    public BigDecimal getAseCodigo() {
        return aseCodigo;
    }

    public void setAseCodigo(BigDecimal aseCodigo) {
        this.aseCodigo = aseCodigo;
    }

    public String getAseRuc() {
        return aseRuc;
    }

    public void setAseRuc(String aseRuc) {
        this.aseRuc = aseRuc;
    }

    public String getAseNombre() {
        return aseNombre;
    }

    public void setAseNombre(String aseNombre) {
        this.aseNombre = aseNombre;
    }

    public String getAseDirecc() {
        return aseDirecc;
    }

    public void setAseDirecc(String aseDirecc) {
        this.aseDirecc = aseDirecc;
    }

    public String getAseTelef() {
        return aseTelef;
    }

    public void setAseTelef(String aseTelef) {
        this.aseTelef = aseTelef;
    }

    public String getAseCedrepresent() {
        return aseCedrepresent;
    }

    public void setAseCedrepresent(String aseCedrepresent) {
        this.aseCedrepresent = aseCedrepresent;
    }

    public String getAseNomrepresent() {
        return aseNomrepresent;
    }

    public void setAseNomrepresent(String aseNomrepresent) {
        this.aseNomrepresent = aseNomrepresent;
    }

    @XmlTransient
    public List<LpolPoliza> getLpolPolizaList() {
        return lpolPolizaList;
    }

    public void setLpolPolizaList(List<LpolPoliza> lpolPolizaList) {
        this.lpolPolizaList = lpolPolizaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aseCodigo != null ? aseCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LaseAseguradora)) {
            return false;
        }
        LaseAseguradora other = (LaseAseguradora) object;
        if ((this.aseCodigo == null && other.aseCodigo != null) || (this.aseCodigo != null && !this.aseCodigo.equals(other.aseCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.LaseAseguradora[ aseCodigo=" + aseCodigo + " ]";
    }

}
