/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import entidades.Questao;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import negocio.*;

/**
 *
 * @author davi.bittencourt
 */
public class Teste {
    
    public void executar() {        
        QuestaoFacade q1 = new QuestaoFacade();
        
        for (Questao q : q1.findAll()) {
            System.out.println(q.getEnunciado());
            System.out.println("88888888888888888888888888888888888888888888888888888888888888888888");
        }
    }
    
    public static void main(String args[]){
        Teste t = new Teste();
        t.executar();
    }
}
