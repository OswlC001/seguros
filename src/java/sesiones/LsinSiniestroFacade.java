/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones;

import entidades.LsinSiniestro;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Oswaldo
 */
@Stateless
public class LsinSiniestroFacade extends AbstractFacade<LsinSiniestro> {

    @PersistenceContext(unitName = "segurosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LsinSiniestroFacade() {
        super(LsinSiniestro.class);
    }
    
}
