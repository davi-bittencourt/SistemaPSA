/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Professor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author davi.bittencourt
 */
@Stateless
public class ProfessorFacade extends AbstractFacade<Professor> implements ProfessorFacadeLocal {
    @PersistenceContext(unitName = "SysProvas-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProfessorFacade() {
        super(Professor.class);
    }
    
}
