/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones;

import entidades.LtsiTipsinie;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Oswaldo
 */
@Stateless
public class LtsiTipsinieFacade extends AbstractFacade<LtsiTipsinie> {

    @PersistenceContext(unitName = "segurosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LtsiTipsinieFacade() {
        super(LtsiTipsinie.class);
    }
    
}
