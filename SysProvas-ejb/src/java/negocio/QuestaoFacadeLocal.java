/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Questao;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author davi.bittencourt
 */
@Local
public interface QuestaoFacadeLocal {

    void create(Questao questao);

    void edit(Questao questao);

    void remove(Questao questao);

    Questao find(Object id);

    List<Questao> findAll();

    List<Questao> findRange(int[] range);

    int count();
    
}
