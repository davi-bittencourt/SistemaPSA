/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import negocio.*;

/**
 *
 * @author davi.bittencourt
 */
public class Teste {
    public static void main(String[] args) {
        Fachada f = new Fachada();
        for(QuestaoDTO q : f.getQuestoes()){
        System.out.println(q.getEnunciado());
    }
    }
}
