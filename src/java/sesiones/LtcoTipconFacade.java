/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones;

import entidades.LtcoTipcon;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Oswaldo
 */
@Stateless
public class LtcoTipconFacade extends AbstractFacade<LtcoTipcon> {

    @PersistenceContext(unitName = "segurosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LtcoTipconFacade() {
        super(LtcoTipcon.class);
    }
    
}
