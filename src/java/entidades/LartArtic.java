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
import javax.persistence.CascadeType;
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
@Table(name = "LART_ARTIC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LartArtic.findAll", query = "SELECT l FROM LartArtic l"),
    @NamedQuery(name = "LartArtic.findByArtCodigo", query = "SELECT l FROM LartArtic l WHERE l.artCodigo = :artCodigo"),
    @NamedQuery(name = "LartArtic.findByArtCodigoar", query = "SELECT l FROM LartArtic l WHERE l.artCodigoar = :artCodigoar"),
    @NamedQuery(name = "LartArtic.findByArtDescrip", query = "SELECT l FROM LartArtic l WHERE l.artDescrip = :artDescrip"),
    @NamedQuery(name = "LartArtic.findByArtNomcort", query = "SELECT l FROM LartArtic l WHERE l.artNomcort = :artNomcort"),
    @NamedQuery(name = "LartArtic.findByArtFungible", query = "SELECT l FROM LartArtic l WHERE l.artFungible = :artFungible"),
    @NamedQuery(name = "LartArtic.findByArtStockmin", query = "SELECT l FROM LartArtic l WHERE l.artStockmin = :artStockmin"),
    @NamedQuery(name = "LartArtic.findByArtStockmax", query = "SELECT l FROM LartArtic l WHERE l.artStockmax = :artStockmax"),
    @NamedQuery(name = "LartArtic.findByArtSwlote", query = "SELECT l FROM LartArtic l WHERE l.artSwlote = :artSwlote"),
    @NamedQuery(name = "LartArtic.findByArtObserva", query = "SELECT l FROM LartArtic l WHERE l.artObserva = :artObserva"),
    @NamedQuery(name = "LartArtic.findByArtCodigoAf", query = "SELECT l FROM LartArtic l WHERE l.artCodigoAf = :artCodigoAf"),
    @NamedQuery(name = "LartArtic.findByArtMantenimiento", query = "SELECT l FROM LartArtic l WHERE l.artMantenimiento = :artMantenimiento"),
    @NamedQuery(name = "LartArtic.findByArtCodalter", query = "SELECT l FROM LartArtic l WHERE l.artCodalter = :artCodalter"),
    @NamedQuery(name = "LartArtic.findByArtCodnsn", query = "SELECT l FROM LartArtic l WHERE l.artCodnsn = :artCodnsn")})
public class LartArtic implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ART_CODIGO")
    private BigDecimal artCodigo;
    @Size(max = 50)
    @Column(name = "ART_CODIGOAR")
    private String artCodigoar;
    @Size(max = 100)
    @Column(name = "ART_DESCRIP")
    private String artDescrip;
    @Size(max = 15)
    @Column(name = "ART_NOMCORT")
    private String artNomcort;
    @Size(max = 2)
    @Column(name = "ART_FUNGIBLE")
    private String artFungible;
    @Column(name = "ART_STOCKMIN")
    private Short artStockmin;
    @Column(name = "ART_STOCKMAX")
    private Integer artStockmax;
    @Size(max = 2)
    @Column(name = "ART_SWLOTE")
    private String artSwlote;
    @Size(max = 60)
    @Column(name = "ART_OBSERVA")
    private String artObserva;
    @Size(max = 10)
    @Column(name = "ART_CODIGO_AF")
    private String artCodigoAf;
    @Column(name = "ART_MANTENIMIENTO")
    private Character artMantenimiento;
    @Size(max = 10)
    @Column(name = "ART_CODALTER")
    private String artCodalter;
    @Size(max = 16)
    @Column(name = "ART_CODNSN")
    private String artCodnsn;
    @JoinColumn(name = "PST_CODIGO", referencedColumnName = "PST_CODIGO")
    @ManyToOne
    private LpstPrese pstCodigo;
    @JoinColumn(name = "CLA_CODIGO", referencedColumnName = "CLA_CODIGO")
    @ManyToOne
    private LclaClase claCodigo;
    @JoinColumn(name = "CNJ_CODIGO", referencedColumnName = "CNJ_CODIGO")
    @ManyToOne
    private LcnjConju cnjCodigo;
    @JoinColumn(name = "DCO_CODIGO", referencedColumnName = "DCO_CODIGO")
    @ManyToOne
    private LdcoDetcon dcoCodigo;
    @JoinColumn(name = "DSU_CODIGO", referencedColumnName = "DSU_CODIGO")
    @ManyToOne
    private LdsuDetsub dsuCodigo;
    @JoinColumn(name = "SER_CODIGO", referencedColumnName = "SER_CODIGO")
    @ManyToOne
    private LserServi serCodigo;
    @JoinColumn(name = "SUB_CODIGO", referencedColumnName = "SUB_CODIGO")
    @ManyToOne
    private LsubSubcj subCodigo;
    @JoinColumn(name = "TAR_CODIGO_TAR", referencedColumnName = "TAR_CODIGO_TAR")
    @ManyToOne
    private LtarTpoart tarCodigoTar;
    @JoinColumn(name = "TCE_CODIGO", referencedColumnName = "TCE_CODIGO")
    @ManyToOne
    private LtceTpcom tceCodigo;
    @JoinColumn(name = "TCO_CODIGO", referencedColumnName = "TCO_CODIGO")
    @ManyToOne
    private LtcoTipcon tcoCodigo;
    @JoinColumn(name = "UDM_CODIGO", referencedColumnName = "UDM_CODIGO")
    @ManyToOne
    private LudmUnime udmCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artCodigo")
    private List<LvehVehic> lvehVehicList;

    public LartArtic() {
    }

    public LartArtic(BigDecimal artCodigo) {
        this.artCodigo = artCodigo;
    }

    public BigDecimal getArtCodigo() {
        return artCodigo;
    }

    public void setArtCodigo(BigDecimal artCodigo) {
        this.artCodigo = artCodigo;
    }

    public String getArtCodigoar() {
        return artCodigoar;
    }

    public void setArtCodigoar(String artCodigoar) {
        this.artCodigoar = artCodigoar;
    }

    public String getArtDescrip() {
        return artDescrip;
    }

    public void setArtDescrip(String artDescrip) {
        this.artDescrip = artDescrip;
    }

    public String getArtNomcort() {
        return artNomcort;
    }

    public void setArtNomcort(String artNomcort) {
        this.artNomcort = artNomcort;
    }

    public String getArtFungible() {
        return artFungible;
    }

    public void setArtFungible(String artFungible) {
        this.artFungible = artFungible;
    }

    public Short getArtStockmin() {
        return artStockmin;
    }

    public void setArtStockmin(Short artStockmin) {
        this.artStockmin = artStockmin;
    }

    public Integer getArtStockmax() {
        return artStockmax;
    }

    public void setArtStockmax(Integer artStockmax) {
        this.artStockmax = artStockmax;
    }

    public String getArtSwlote() {
        return artSwlote;
    }

    public void setArtSwlote(String artSwlote) {
        this.artSwlote = artSwlote;
    }

    public String getArtObserva() {
        return artObserva;
    }

    public void setArtObserva(String artObserva) {
        this.artObserva = artObserva;
    }

    public String getArtCodigoAf() {
        return artCodigoAf;
    }

    public void setArtCodigoAf(String artCodigoAf) {
        this.artCodigoAf = artCodigoAf;
    }

    public Character getArtMantenimiento() {
        return artMantenimiento;
    }

    public void setArtMantenimiento(Character artMantenimiento) {
        this.artMantenimiento = artMantenimiento;
    }

    public String getArtCodalter() {
        return artCodalter;
    }

    public void setArtCodalter(String artCodalter) {
        this.artCodalter = artCodalter;
    }

    public String getArtCodnsn() {
        return artCodnsn;
    }

    public void setArtCodnsn(String artCodnsn) {
        this.artCodnsn = artCodnsn;
    }

    public LpstPrese getPstCodigo() {
        return pstCodigo;
    }

    public void setPstCodigo(LpstPrese pstCodigo) {
        this.pstCodigo = pstCodigo;
    }

    public LclaClase getClaCodigo() {
        return claCodigo;
    }

    public void setClaCodigo(LclaClase claCodigo) {
        this.claCodigo = claCodigo;
    }

    public LcnjConju getCnjCodigo() {
        return cnjCodigo;
    }

    public void setCnjCodigo(LcnjConju cnjCodigo) {
        this.cnjCodigo = cnjCodigo;
    }

    public LdcoDetcon getDcoCodigo() {
        return dcoCodigo;
    }

    public void setDcoCodigo(LdcoDetcon dcoCodigo) {
        this.dcoCodigo = dcoCodigo;
    }

    public LdsuDetsub getDsuCodigo() {
        return dsuCodigo;
    }

    public void setDsuCodigo(LdsuDetsub dsuCodigo) {
        this.dsuCodigo = dsuCodigo;
    }

    public LserServi getSerCodigo() {
        return serCodigo;
    }

    public void setSerCodigo(LserServi serCodigo) {
        this.serCodigo = serCodigo;
    }

    public LsubSubcj getSubCodigo() {
        return subCodigo;
    }

    public void setSubCodigo(LsubSubcj subCodigo) {
        this.subCodigo = subCodigo;
    }

    public LtarTpoart getTarCodigoTar() {
        return tarCodigoTar;
    }

    public void setTarCodigoTar(LtarTpoart tarCodigoTar) {
        this.tarCodigoTar = tarCodigoTar;
    }

    public LtceTpcom getTceCodigo() {
        return tceCodigo;
    }

    public void setTceCodigo(LtceTpcom tceCodigo) {
        this.tceCodigo = tceCodigo;
    }

    public LtcoTipcon getTcoCodigo() {
        return tcoCodigo;
    }

    public void setTcoCodigo(LtcoTipcon tcoCodigo) {
        this.tcoCodigo = tcoCodigo;
    }

    public LudmUnime getUdmCodigo() {
        return udmCodigo;
    }

    public void setUdmCodigo(LudmUnime udmCodigo) {
        this.udmCodigo = udmCodigo;
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
        hash += (artCodigo != null ? artCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LartArtic)) {
            return false;
        }
        LartArtic other = (LartArtic) object;
        if ((this.artCodigo == null && other.artCodigo != null) || (this.artCodigo != null && !this.artCodigo.equals(other.artCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.LartArtic[ artCodigo=" + artCodigo + " ]";
    }
    
}
