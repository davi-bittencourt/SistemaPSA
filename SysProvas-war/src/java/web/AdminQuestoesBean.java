/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import negocio.*;

@Named
@RequestScoped
public class AdminQuestoesBean {
    @EJB
    private FachadaLocal fachadaEjb;
     
    public List<QuestaoDTO> getQuestoes(){
        return fachadaEjb.getQuestoes();
    } 
}
