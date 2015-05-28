/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Prova;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author davi.bittencourt
 */
@Local
public interface ProvaFacadeLocal {

    void create(Prova prova);

    void edit(Prova prova);

    void remove(Prova prova);

    Prova find(Object id);

    List<Prova> findAll();

    List<Prova> findRange(int[] range);

    int count();
    
}
