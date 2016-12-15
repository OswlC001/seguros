/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Oswaldo
 */
@Embeddable
public class LeatEstadPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CNA_CODIGO")
    private BigInteger cnaCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EAT_CODIGO")
    private BigInteger eatCodigo;

    public LeatEstadPK() {
    }

    public LeatEstadPK(BigInteger cnaCodigo, BigInteger eatCodigo) {
        this.cnaCodigo = cnaCodigo;
        this.eatCodigo = eatCodigo;
    }

    public BigInteger getCnaCodigo() {
        return cnaCodigo;
    }

    public void setCnaCodigo(BigInteger cnaCodigo) {
        this.cnaCodigo = cnaCodigo;
    }

    public BigInteger getEatCodigo() {
        return eatCodigo;
    }

    public void setEatCodigo(BigInteger eatCodigo) {
        this.eatCodigo = eatCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cnaCodigo != null ? cnaCodigo.hashCode() : 0);
        hash += (eatCodigo != null ? eatCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LeatEstadPK)) {
            return false;
        }
        LeatEstadPK other = (LeatEstadPK) object;
        if ((this.cnaCodigo == null && other.cnaCodigo != null) || (this.cnaCodigo != null && !this.cnaCodigo.equals(other.cnaCodigo))) {
            return false;
        }
        if ((this.eatCodigo == null && other.eatCodigo != null) || (this.eatCodigo != null && !this.eatCodigo.equals(other.eatCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.LeatEstadPK[ cnaCodigo=" + cnaCodigo + ", eatCodigo=" + eatCodigo + " ]";
    }
    
}
