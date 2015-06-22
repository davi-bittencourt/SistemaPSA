/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import negocio.FachadaLocal;
import negocio.ProfessorDTO;

@Named
@RequestScoped
public class CadastrarProvaBean {
    @EJB
    private FachadaLocal fachadaEjb;

    private Integer idProfSelecionado;
    private String codSelecionado;
    
    public Integer getIdProfSelecionado() {
        return idProfSelecionado;
    }

    public void setIdProfSelecionado(Integer idprofSelecionado) {
        this.idProfSelecionado = idprofSelecionado;
    }

    public String getCodSelecionado() {
        return codSelecionado;
    }

    public void setCodSelecionado(String codSelecionado) {     
        this.codSelecionado = codSelecionado;
    }
    
    public List<SelectItem> getProfessores() {
        
        List<SelectItem> profs = new ArrayList();
        
        for (ProfessorDTO p : fachadaEjb.getProfessores()){
            profs.add(new SelectItem(p.getId(), p.getNome()));
        }
        return profs;
    }
    
    public void buttonActionCadastrarProva() {
       
       if(codSelecionado.equals("nao")){
           codSelecionado = "";
       }else{
           codSelecionado = codGenerator();
       }
       
       fachadaEjb.cadastrarProva(codSelecionado, idProfSelecionado);
       
       //TODO: Fazer com que página para adicionar questões a prova cadastrada seja aberta.
       FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Prova cadastrada com sucesso!\n Professor: "+idProfSelecionado+"\nCódigo: "+codSelecionado,  null);
       FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    private String codGenerator() {
       UUID uuid = UUID.randomUUID();  
       String myRandom = uuid.toString();  
       return myRandom.substring(0,8);
    }
}
