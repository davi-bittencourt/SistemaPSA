/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import negocio.*;

@Named
@RequestScoped
public class painelBean {
    @EJB
    private FachadaLocal fachadaEjb;
    
    private ProvaDTO provaSelecionada;
    
    public List<ProvaDTO> getProvas() {
        return fachadaEjb.getProvas();
    }
    
    public ProvaDTO getProvaSelecionada() {
        return provaSelecionada;
    }
 
    public void setProvaSelecionada(ProvaDTO pSelecionada) {
        this.provaSelecionada = pSelecionada;
    }
    
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Prova selecionado", ((ProvaDTO) event.getObject()).getIdProva().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Prova não selecionada", ((ProvaDTO) event.getObject()).getIdProva().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
