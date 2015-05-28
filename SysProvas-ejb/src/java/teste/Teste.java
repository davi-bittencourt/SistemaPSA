/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.util.List;
import javax.ejb.EJB;
import negocio.*;

/**
 *
 * @author davi.bittencourt
 */
public class Teste {
    public void executar() {      
        Fachada f = new Fachada();
        List<QuestaoDTO> questoes = f.getQuestoes();
        for (QuestaoDTO q : questoes) {
            System.out.println(q.getEnunciado());
        }
    }

    public static void main(String[] args) {
        Teste t = new Teste();
        t.executar();
    }
}
