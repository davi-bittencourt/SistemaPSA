/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import negocio.*;

/**
 *
 * @author davi.bittencourt
 */
public class Teste {
    @EJB
    private FachadaLocal f;
    @PostConstruct
    public void executar() {        
        List<QuestaoDTO> questoes = f.getQuestoes();
        for (QuestaoDTO q : questoes) {
            System.out.println(q.getEnunciado());
            System.out.println("88888888888888888888888888888888888888888888888888888888888888888888");
        }
    }
}
