/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "LTAR_TPOART")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LtarTpoart.findAll", query = "SELECT l FROM LtarTpoart l"),
    @NamedQuery(name = "LtarTpoart.findByTarCodigoTar", query = "SELECT l FROM LtarTpoart l WHERE l.tarCodigoTar = :tarCodigoTar"),
    @NamedQuery(name = "LtarTpoart.findByTarNomtabla", query = "SELECT l FROM LtarTpoart l WHERE l.tarNomtabla = :tarNomtabla"),
    @NamedQuery(name = "LtarTpoart.findByTarNam", query = "SELECT l FROM LtarTpoart l WHERE l.tarNam = :tarNam"),
    @NamedQuery(name = "LtarTpoart.findByTarNam2", query = "SELECT l FROM LtarTpoart l WHERE l.tarNam2 = :tarNam2"),
    @NamedQuery(name = "LtarTpoart.findByTarVidaUtil", query = "SELECT l FROM LtarTpoart l WHERE l.tarVidaUtil = :tarVidaUtil"),
    @NamedQuery(name = "LtarTpoart.findByTarTipoActivo", query = "SELECT l FROM LtarTpoart l WHERE l.tarTipoActivo = :tarTipoActivo"),
    @NamedQuery(name = "LtarTpoart.findByTarDepreciable", query = "SELECT l FROM LtarTpoart l WHERE l.tarDepreciable = :tarDepreciable"),
    @NamedQuery(name = "LtarTpoart.findByTarDescripcion", query = "SELECT l FROM LtarTpoart l WHERE l.tarDescripcion = :tarDescripcion"),
    @NamedQuery(name = "LtarTpoart.findByTarNivel", query = "SELECT l FROM LtarTpoart l WHERE l.tarNivel = :tarNivel"),
    @NamedQuery(name = "LtarTpoart.findByTarCodigoAfCs", query = "SELECT l FROM LtarTpoart l WHERE l.tarCodigoAfCs = :tarCodigoAfCs"),
    @NamedQuery(name = "LtarTpoart.findByTarVidaUtilMax", query = "SELECT l FROM LtarTpoart l WHERE l.tarVidaUtilMax = :tarVidaUtilMax")})
public class LtarTpoart implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TAR_CODIGO_TAR")
    private BigDecimal tarCodigoTar;
    @Size(max = 4000)
    @Column(name = "TAR_NOMTABLA")
    private String tarNomtabla;
    @Size(max = 40)
    @Column(name = "TAR_NAM")
    private String tarNam;
    @Size(max = 40)
    @Column(name = "TAR_NAM2")
    private String tarNam2;
    @Column(name = "TAR_VIDA_UTIL")
    private Short tarVidaUtil;
    @Column(name = "TAR_TIPO_ACTIVO")
    private Character tarTipoActivo;
    @Column(name = "TAR_DEPRECIABLE")
    private Character tarDepreciable;
    @Size(max = 2000)
    @Column(name = "TAR_DESCRIPCION")
    private String tarDescripcion;
    @Column(name = "TAR_NIVEL")
    private BigInteger tarNivel;
    @Size(max = 10)
    @Column(name = "TAR_CODIGO_AF_CS")
    private String tarCodigoAfCs;
    @Column(name = "TAR_VIDA_UTIL_MAX")
    private Short tarVidaUtilMax;
    @JoinColumn(name = "SER_CODIGO", referencedColumnName = "SER_CODIGO")
    @ManyToOne
    private LserServi serCodigo;
    @OneToMany(mappedBy = "tarCodigoTarAf")
    private List<LtarTpoart> ltarTpoartList;
    @JoinColumn(name = "TAR_CODIGO_TAR_AF", referencedColumnName = "TAR_CODIGO_TAR")
    @ManyToOne
    private LtarTpoart tarCodigoTarAf;
    @OneToMany(mappedBy = "tarCodigoTar")
    private List<LartArtic> lartArticList;

    public LtarTpoart() {
    }

    public LtarTpoart(BigDecimal tarCodigoTar) {
        this.tarCodigoTar = tarCodigoTar;
    }

    public BigDecimal getTarCodigoTar() {
        return tarCodigoTar;
    }

    public void setTarCodigoTar(BigDecimal tarCodigoTar) {
        this.tarCodigoTar = tarCodigoTar;
    }

    public String getTarNomtabla() {
        return tarNomtabla;
    }

    public void setTarNomtabla(String tarNomtabla) {
        this.tarNomtabla = tarNomtabla;
    }

    public String getTarNam() {
        return tarNam;
    }

    public void setTarNam(String tarNam) {
        this.tarNam = tarNam;
    }

    public String getTarNam2() {
        return tarNam2;
    }

    public void setTarNam2(String tarNam2) {
        this.tarNam2 = tarNam2;
    }

    public Short getTarVidaUtil() {
        return tarVidaUtil;
    }

    public void setTarVidaUtil(Short tarVidaUtil) {
        this.tarVidaUtil = tarVidaUtil;
    }

    public Character getTarTipoActivo() {
        return tarTipoActivo;
    }

    public void setTarTipoActivo(Character tarTipoActivo) {
        this.tarTipoActivo = tarTipoActivo;
    }

    public Character getTarDepreciable() {
        return tarDepreciable;
    }

    public void setTarDepreciable(Character tarDepreciable) {
        this.tarDepreciable = tarDepreciable;
    }

    public String getTarDescripcion() {
        return tarDescripcion;
    }

    public void setTarDescripcion(String tarDescripcion) {
        this.tarDescripcion = tarDescripcion;
    }

    public BigInteger getTarNivel() {
        return tarNivel;
    }

    public void setTarNivel(BigInteger tarNivel) {
        this.tarNivel = tarNivel;
    }

    public String getTarCodigoAfCs() {
        return tarCodigoAfCs;
    }

    public void setTarCodigoAfCs(String tarCodigoAfCs) {
        this.tarCodigoAfCs = tarCodigoAfCs;
    }

    public Short getTarVidaUtilMax() {
        return tarVidaUtilMax;
    }

    public void setTarVidaUtilMax(Short tarVidaUtilMax) {
        this.tarVidaUtilMax = tarVidaUtilMax;
    }

    public LserServi getSerCodigo() {
        return serCodigo;
    }

    public void setSerCodigo(LserServi serCodigo) {
        this.serCodigo = serCodigo;
    }

    @XmlTransient
    public List<LtarTpoart> getLtarTpoartList() {
        return ltarTpoartList;
    }

    public void setLtarTpoartList(List<LtarTpoart> ltarTpoartList) {
        this.ltarTpoartList = ltarTpoartList;
    }

    public LtarTpoart getTarCodigoTarAf() {
        return tarCodigoTarAf;
    }

    public void setTarCodigoTarAf(LtarTpoart tarCodigoTarAf) {
        this.tarCodigoTarAf = tarCodigoTarAf;
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
        hash += (tarCodigoTar != null ? tarCodigoTar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LtarTpoart)) {
            return false;
        }
        LtarTpoart other = (LtarTpoart) object;
        if ((this.tarCodigoTar == null && other.tarCodigoTar != null) || (this.tarCodigoTar != null && !this.tarCodigoTar.equals(other.tarCodigoTar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.LtarTpoart[ tarCodigoTar=" + tarCodigoTar + " ]";
    }
    
}
