/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "LVEH_VEHIC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LvehVehic.findAll", query = "SELECT l FROM LvehVehic l"),
    @NamedQuery(name = "LvehVehic.findByVehCodigo", query = "SELECT l FROM LvehVehic l WHERE l.vehCodigo = :vehCodigo"),
    @NamedQuery(name = "LvehVehic.findByMemCedula", query = "SELECT l FROM LvehVehic l WHERE l.memCedula = :memCedula"),
    @NamedQuery(name = "LvehVehic.findByUniCodigo2", query = "SELECT l FROM LvehVehic l WHERE l.uniCodigo2 = :uniCodigo2"),
    @NamedQuery(name = "LvehVehic.findByOrgNumero", query = "SELECT l FROM LvehVehic l WHERE l.orgNumero = :orgNumero"),
    @NamedQuery(name = "LvehVehic.findByPorOrgNumero", query = "SELECT l FROM LvehVehic l WHERE l.porOrgNumero = :porOrgNumero"),
    @NamedQuery(name = "LvehVehic.findByVehNumreg", query = "SELECT l FROM LvehVehic l WHERE l.vehNumreg = :vehNumreg"),
    @NamedQuery(name = "LvehVehic.findByVehAno", query = "SELECT l FROM LvehVehic l WHERE l.vehAno = :vehAno"),
    @NamedQuery(name = "LvehVehic.findByVehColor", query = "SELECT l FROM LvehVehic l WHERE l.vehColor = :vehColor"),
    @NamedQuery(name = "LvehVehic.findByVehFeccom", query = "SELECT l FROM LvehVehic l WHERE l.vehFeccom = :vehFeccom"),
    @NamedQuery(name = "LvehVehic.findByVehValcom", query = "SELECT l FROM LvehVehic l WHERE l.vehValcom = :vehValcom"),
    @NamedQuery(name = "LvehVehic.findByVehChasis", query = "SELECT l FROM LvehVehic l WHERE l.vehChasis = :vehChasis"),
    @NamedQuery(name = "LvehVehic.findByVehNummotor", query = "SELECT l FROM LvehVehic l WHERE l.vehNummotor = :vehNummotor"),
    @NamedQuery(name = "LvehVehic.findByVehFechasig", query = "SELECT l FROM LvehVehic l WHERE l.vehFechasig = :vehFechasig"),
    @NamedQuery(name = "LvehVehic.findByVehPlaca", query = "SELECT l FROM LvehVehic l WHERE l.vehPlaca = :vehPlaca"),
    @NamedQuery(name = "LvehVehic.findByVehFecbaja", query = "SELECT l FROM LvehVehic l WHERE l.vehFecbaja = :vehFecbaja"),
    @NamedQuery(name = "LvehVehic.findByVehNumacta", query = "SELECT l FROM LvehVehic l WHERE l.vehNumacta = :vehNumacta"),
    @NamedQuery(name = "LvehVehic.findByVehDueorig", query = "SELECT l FROM LvehVehic l WHERE l.vehDueorig = :vehDueorig"),
    @NamedQuery(name = "LvehVehic.findByVehTiemdur", query = "SELECT l FROM LvehVehic l WHERE l.vehTiemdur = :vehTiemdur"),
    @NamedQuery(name = "LvehVehic.findByVehNumdicta", query = "SELECT l FROM LvehVehic l WHERE l.vehNumdicta = :vehNumdicta"),
    @NamedQuery(name = "LvehVehic.findByVehValremat", query = "SELECT l FROM LvehVehic l WHERE l.vehValremat = :vehValremat"),
    @NamedQuery(name = "LvehVehic.findByVehFecrecep", query = "SELECT l FROM LvehVehic l WHERE l.vehFecrecep = :vehFecrecep"),
    @NamedQuery(name = "LvehVehic.findByVehObservac", query = "SELECT l FROM LvehVehic l WHERE l.vehObservac = :vehObservac"),
    @NamedQuery(name = "LvehVehic.findByVehEstado", query = "SELECT l FROM LvehVehic l WHERE l.vehEstado = :vehEstado"),
    @NamedQuery(name = "LvehVehic.findByVehObservacion", query = "SELECT l FROM LvehVehic l WHERE l.vehObservacion = :vehObservacion"),
    @NamedQuery(name = "LvehVehic.findByVehPlacaAnt", query = "SELECT l FROM LvehVehic l WHERE l.vehPlacaAnt = :vehPlacaAnt"),
    @NamedQuery(name = "LvehVehic.findByVehKilometraje", query = "SELECT l FROM LvehVehic l WHERE l.vehKilometraje = :vehKilometraje"),
    @NamedQuery(name = "LvehVehic.findByVehCupo", query = "SELECT l FROM LvehVehic l WHERE l.vehCupo = :vehCupo"),
    @NamedQuery(name = "LvehVehic.findByVehSeguro", query = "SELECT l FROM LvehVehic l WHERE l.vehSeguro = :vehSeguro"),
    @NamedQuery(name = "LvehVehic.findByVehStiker", query = "SELECT l FROM LvehVehic l WHERE l.vehStiker = :vehStiker"),
    @NamedQuery(name = "LvehVehic.findByVehPoliza", query = "SELECT l FROM LvehVehic l WHERE l.vehPoliza = :vehPoliza")})
public class LvehVehic implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "VEH_CODIGO")
    private BigDecimal vehCodigo;
    @Size(max = 15)
    @Column(name = "MEM_CEDULA")
    private String memCedula;
    @Size(max = 25)
    @Column(name = "UNI_CODIGO2")
    private String uniCodigo2;
    @Column(name = "ORG_NUMERO")
    private BigInteger orgNumero;
    @Column(name = "POR_ORG_NUMERO")
    private BigInteger porOrgNumero;
    @Size(max = 20)
    @Column(name = "VEH_NUMREG")
    private String vehNumreg;
    @Column(name = "VEH_ANO")
    private Short vehAno;
    @Size(max = 15)
    @Column(name = "VEH_COLOR")
    private String vehColor;
    @Column(name = "VEH_FECCOM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vehFeccom;
    @Column(name = "VEH_VALCOM")
    private BigDecimal vehValcom;
    @Size(max = 20)
    @Column(name = "VEH_CHASIS")
    private String vehChasis;
    @Size(max = 20)
    @Column(name = "VEH_NUMMOTOR")
    private String vehNummotor;
    @Column(name = "VEH_FECHASIG")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vehFechasig;
    @Size(max = 7)
    @Column(name = "VEH_PLACA")
    private String vehPlaca;
    @Column(name = "VEH_FECBAJA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vehFecbaja;
    @Size(max = 15)
    @Column(name = "VEH_NUMACTA")
    private String vehNumacta;
    @Size(max = 20)
    @Column(name = "VEH_DUEORIG")
    private String vehDueorig;
    @Size(max = 10)
    @Column(name = "VEH_TIEMDUR")
    private String vehTiemdur;
    @Size(max = 20)
    @Column(name = "VEH_NUMDICTA")
    private String vehNumdicta;
    @Column(name = "VEH_VALREMAT")
    private Integer vehValremat;
    @Column(name = "VEH_FECRECEP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vehFecrecep;
    @Size(max = 60)
    @Column(name = "VEH_OBSERVAC")
    private String vehObservac;
    @Column(name = "VEH_ESTADO")
    private Character vehEstado;
    @Size(max = 3000)
    @Column(name = "VEH_OBSERVACION")
    private String vehObservacion;
    @Size(max = 9)
    @Column(name = "VEH_PLACA_ANT")
    private String vehPlacaAnt;
    @Column(name = "VEH_KILOMETRAJE")
    private Integer vehKilometraje;
    @Column(name = "VEH_CUPO")
    private Short vehCupo;
    @Size(max = 1)
    @Column(name = "VEH_SEGURO")
    private String vehSeguro;
    @Column(name = "VEH_STIKER")
    private Integer vehStiker;
    @Column(name = "VEH_POLIZA")
    private Integer vehPoliza;
    @OneToMany(mappedBy = "vehCodigo")
    private List<LasgAsegurados> lasgAseguradosList;
    @OneToMany(mappedBy = "vehCodigo")
    private List<LsinSiniestro> lsinSiniestroList;
    @JoinColumn(name = "ART_CODIGO", referencedColumnName = "ART_CODIGO")
    @ManyToOne(optional = false)
    private LartArtic artCodigo;
    @JoinColumns({
        @JoinColumn(name = "CNA_CODIGO", referencedColumnName = "CNA_CODIGO"),
        @JoinColumn(name = "EAT_CODIGO", referencedColumnName = "EAT_CODIGO")})
    @ManyToOne
    private LeatEstad leatEstad;
    @JoinColumn(name = "MTV_CODIGO", referencedColumnName = "MTV_CODIGO")
    @ManyToOne
    private LmtvMotiv mtvCodigo;
    @JoinColumn(name = "TEX_CODIGO", referencedColumnName = "TEX_CODIGO")
    @ManyToOne
    private LtexTpexi texCodigo;
    @JoinColumn(name = "TMO_CODIGO", referencedColumnName = "TMO_CODIGO")
    @ManyToOne
    private LtmoTpmov tmoCodigo;
    @JoinColumn(name = "TVH_CODIGO", referencedColumnName = "TVH_CODIGO")
    @ManyToOne
    private LtvhTipvh tvhCodigo;

    public LvehVehic() {
    }

    public LvehVehic(BigDecimal vehCodigo) {
        this.vehCodigo = vehCodigo;
    }

    public BigDecimal getVehCodigo() {
        return vehCodigo;
    }

    public void setVehCodigo(BigDecimal vehCodigo) {
        this.vehCodigo = vehCodigo;
    }

    public String getMemCedula() {
        return memCedula;
    }

    public void setMemCedula(String memCedula) {
        this.memCedula = memCedula;
    }

    public String getUniCodigo2() {
        return uniCodigo2;
    }

    public void setUniCodigo2(String uniCodigo2) {
        this.uniCodigo2 = uniCodigo2;
    }

    public BigInteger getOrgNumero() {
        return orgNumero;
    }

    public void setOrgNumero(BigInteger orgNumero) {
        this.orgNumero = orgNumero;
    }

    public BigInteger getPorOrgNumero() {
        return porOrgNumero;
    }

    public void setPorOrgNumero(BigInteger porOrgNumero) {
        this.porOrgNumero = porOrgNumero;
    }

    public String getVehNumreg() {
        return vehNumreg;
    }

    public void setVehNumreg(String vehNumreg) {
        this.vehNumreg = vehNumreg;
    }

    public Short getVehAno() {
        return vehAno;
    }

    public void setVehAno(Short vehAno) {
        this.vehAno = vehAno;
    }

    public String getVehColor() {
        return vehColor;
    }

    public void setVehColor(String vehColor) {
        this.vehColor = vehColor;
    }

    public Date getVehFeccom() {
        return vehFeccom;
    }

    public void setVehFeccom(Date vehFeccom) {
        this.vehFeccom = vehFeccom;
    }

    public BigDecimal getVehValcom() {
        return vehValcom;
    }

    public void setVehValcom(BigDecimal vehValcom) {
        this.vehValcom = vehValcom;
    }

    public String getVehChasis() {
        return vehChasis;
    }

    public void setVehChasis(String vehChasis) {
        this.vehChasis = vehChasis;
    }

    public String getVehNummotor() {
        return vehNummotor;
    }

    public void setVehNummotor(String vehNummotor) {
        this.vehNummotor = vehNummotor;
    }

    public Date getVehFechasig() {
        return vehFechasig;
    }

    public void setVehFechasig(Date vehFechasig) {
        this.vehFechasig = vehFechasig;
    }

    public String getVehPlaca() {
        return vehPlaca;
    }

    public void setVehPlaca(String vehPlaca) {
        this.vehPlaca = vehPlaca;
    }

    public Date getVehFecbaja() {
        return vehFecbaja;
    }

    public void setVehFecbaja(Date vehFecbaja) {
        this.vehFecbaja = vehFecbaja;
    }

    public String getVehNumacta() {
        return vehNumacta;
    }

    public void setVehNumacta(String vehNumacta) {
        this.vehNumacta = vehNumacta;
    }

    public String getVehDueorig() {
        return vehDueorig;
    }

    public void setVehDueorig(String vehDueorig) {
        this.vehDueorig = vehDueorig;
    }

    public String getVehTiemdur() {
        return vehTiemdur;
    }

    public void setVehTiemdur(String vehTiemdur) {
        this.vehTiemdur = vehTiemdur;
    }

    public String getVehNumdicta() {
        return vehNumdicta;
    }

    public void setVehNumdicta(String vehNumdicta) {
        this.vehNumdicta = vehNumdicta;
    }

    public Integer getVehValremat() {
        return vehValremat;
    }

    public void setVehValremat(Integer vehValremat) {
        this.vehValremat = vehValremat;
    }

    public Date getVehFecrecep() {
        return vehFecrecep;
    }

    public void setVehFecrecep(Date vehFecrecep) {
        this.vehFecrecep = vehFecrecep;
    }

    public String getVehObservac() {
        return vehObservac;
    }

    public void setVehObservac(String vehObservac) {
        this.vehObservac = vehObservac;
    }

    public Character getVehEstado() {
        return vehEstado;
    }

    public void setVehEstado(Character vehEstado) {
        this.vehEstado = vehEstado;
    }

    public String getVehObservacion() {
        return vehObservacion;
    }

    public void setVehObservacion(String vehObservacion) {
        this.vehObservacion = vehObservacion;
    }

    public String getVehPlacaAnt() {
        return vehPlacaAnt;
    }

    public void setVehPlacaAnt(String vehPlacaAnt) {
        this.vehPlacaAnt = vehPlacaAnt;
    }

    public Integer getVehKilometraje() {
        return vehKilometraje;
    }

    public void setVehKilometraje(Integer vehKilometraje) {
        this.vehKilometraje = vehKilometraje;
    }

    public Short getVehCupo() {
        return vehCupo;
    }

    public void setVehCupo(Short vehCupo) {
        this.vehCupo = vehCupo;
    }

    public String getVehSeguro() {
        return vehSeguro;
    }

    public void setVehSeguro(String vehSeguro) {
        this.vehSeguro = vehSeguro;
    }

    public Integer getVehStiker() {
        return vehStiker;
    }

    public void setVehStiker(Integer vehStiker) {
        this.vehStiker = vehStiker;
    }

    public Integer getVehPoliza() {
        return vehPoliza;
    }

    public void setVehPoliza(Integer vehPoliza) {
        this.vehPoliza = vehPoliza;
    }

    @XmlTransient
    public List<LasgAsegurados> getLasgAseguradosList() {
        return lasgAseguradosList;
    }

    public void setLasgAseguradosList(List<LasgAsegurados> lasgAseguradosList) {
        this.lasgAseguradosList = lasgAseguradosList;
    }

    @XmlTransient
    public List<LsinSiniestro> getLsinSiniestroList() {
        return lsinSiniestroList;
    }

    public void setLsinSiniestroList(List<LsinSiniestro> lsinSiniestroList) {
        this.lsinSiniestroList = lsinSiniestroList;
    }

    public LartArtic getArtCodigo() {
        return artCodigo;
    }

    public void setArtCodigo(LartArtic artCodigo) {
        this.artCodigo = artCodigo;
    }

    public LeatEstad getLeatEstad() {
        return leatEstad;
    }

    public void setLeatEstad(LeatEstad leatEstad) {
        this.leatEstad = leatEstad;
    }

    public LmtvMotiv getMtvCodigo() {
        return mtvCodigo;
    }

    public void setMtvCodigo(LmtvMotiv mtvCodigo) {
        this.mtvCodigo = mtvCodigo;
    }

    public LtexTpexi getTexCodigo() {
        return texCodigo;
    }

    public void setTexCodigo(LtexTpexi texCodigo) {
        this.texCodigo = texCodigo;
    }

    public LtmoTpmov getTmoCodigo() {
        return tmoCodigo;
    }

    public void setTmoCodigo(LtmoTpmov tmoCodigo) {
        this.tmoCodigo = tmoCodigo;
    }

    public LtvhTipvh getTvhCodigo() {
        return tvhCodigo;
    }

    public void setTvhCodigo(LtvhTipvh tvhCodigo) {
        this.tvhCodigo = tvhCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vehCodigo != null ? vehCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LvehVehic)) {
            return false;
        }
        LvehVehic other = (LvehVehic) object;
        if ((this.vehCodigo == null && other.vehCodigo != null) || (this.vehCodigo != null && !this.vehCodigo.equals(other.vehCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.LvehVehic[ vehCodigo=" + vehCodigo + " ]";
    }
    
}
