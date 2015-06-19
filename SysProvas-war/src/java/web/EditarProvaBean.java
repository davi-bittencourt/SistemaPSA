/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.Map;
import javax.faces.application.FacesMessage;
import negocio.FachadaLocal;
import negocio.QuestaoDTO;
import negocio.ProvaDTO;
import org.primefaces.context.RequestContext;

@Named
@RequestScoped
public class EditarProvaBean {

    @EJB
    private FachadaLocal fachadaEjb;

    private Integer id_prova;
    private List<String> idQuestoesSelecionadas;
  
    public Integer getId_prova() {
        return this.id_prova;
    }

    public void setId_prova(Integer id_prova) {
        this.id_prova = id_prova;
    }

    public List<String> getIdQuestoesSelecionadas() {
        return idQuestoesSelecionadas;
    }

    public void setIdQuestoesSelecionadas(List<String> idQuestoesSelecionadas) {
        this.idQuestoesSelecionadas = idQuestoesSelecionadas;
    }

    public String outcome() {
        FacesContext fc = FacesContext.getCurrentInstance();    
        this.id_prova = Integer.valueOf(getIdParam(fc));
        ProvaDTO q = fachadaEjb.getProva(id_prova);

        return "editarProva";
    }

    //get value from "f:param"
    private String getIdParam(FacesContext fc) {

        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        return params.get("id");
    }

    public List<QuestaoDTO> getQuestoes() {
        return fachadaEjb.getQuestoes();
    }

    public void buttonActionEditarProva() {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
        try {
            System.out.println("ID ------------------------------: "+getId_prova());
            fachadaEjb.editarProva(getId_prova(),idQuestoesSelecionadas);
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Questão cadastrada com sucesso");
            FacesContext.getCurrentInstance().addMessage(null, message);
            context.addCallbackParam("loggedIn", loggedIn);
        } catch (Exception ex) {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
            FacesContext.getCurrentInstance().addMessage(null, message);
            context.addCallbackParam("loggedIn", loggedIn);
        }

    }
}
