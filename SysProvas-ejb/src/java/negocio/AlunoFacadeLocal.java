/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Aluno;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author davi.bittencourt
 */
@Local
public interface AlunoFacadeLocal {

    void create(Aluno aluno);

    void edit(Aluno aluno);

    void remove(Aluno aluno);

    Aluno find(Object id);

    List<Aluno> findAll();

    List<Aluno> findRange(int[] range);

    int count();
    
}
