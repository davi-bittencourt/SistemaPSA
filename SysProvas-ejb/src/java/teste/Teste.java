/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import entidades.Questao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import negocio.*;

/**
 *
 * @author davi.bittencourt
 */
public class Teste {
    
    
    public void executar() {        
        QuestaoFacadeLocal q1 = lookupQuestaoFacadeLocal(); 
        
        for (Questao q : q1.findAll()) {
            System.out.println(q.getEnunciado());
        }
    }
    
    public static void main(String args[]){
        Teste t = new Teste();
        t.executar();
    }
    
    /**
     * Método criado pelo professor, para testar funções com classe de teste.
     * @return 
     */    
    private QuestaoFacadeLocal lookupQuestaoFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (QuestaoFacadeLocal) c.lookup("java:global/SysProvas/SysProvas-ejb/QuestaoFacade!negocio.QuestaoFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
