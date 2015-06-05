/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import negocio.CategoriaDTO;
import negocio.FachadaLocal;
import org.primefaces.context.RequestContext;


@Named
@RequestScoped
public class CadastrarQuestaoBean {
    @EJB
    private FachadaLocal fachadaEjb;

    private String txt_enunciado;
    private String txt_comentario;
    private String txt_alternativa_correta;
    private String txt_alternativa_a;
    private String txt_alternativa_b;
    private String txt_alternativa_c;
    private String txt_alternativa_d;
    private String txt_alternativa_e;
    
    private List<String> idCategoriasSelecionadas;
    
    public List<String> getCategoriasSelecionadas() {
        return idCategoriasSelecionadas;
    }

    public void setCategoriasSelecionadas(List<String> categoriasSelecionadas) { 
        this.idCategoriasSelecionadas = categoriasSelecionadas;
    }
    
    public FachadaLocal getFachadaEjb() {
        return fachadaEjb;
    }
    
    public List<CategoriaDTO> getCategorias() {
        return fachadaEjb.getCategorias();
    }
    
    public void setFachadaEjb(FachadaLocal fachadaEjb) {
        this.fachadaEjb = fachadaEjb;
    }

    public String getTxt_enunciado() {
        return txt_enunciado;
    }

    public void setTxt_enunciado(String txt_enunciado) {
        this.txt_enunciado = txt_enunciado;
    }

    public String getTxt_comentario() {
        return txt_comentario;
    }

    public void setTxt_comentario(String txt_comentario) {
        this.txt_comentario = txt_comentario;
    }

    public String getTxt_alternativa_correta() {
        return txt_alternativa_correta;
    }

    public void setTxt_alternativa_correta(String txt_alternativa_correta) {
        this.txt_alternativa_correta = txt_alternativa_correta;
    }

    public String getTxt_alternativa_a() {
        return txt_alternativa_a;
    }

    public void setTxt_alternativa_a(String txt_alternativa_a) {
        this.txt_alternativa_a = txt_alternativa_a;
    }

    public String getTxt_alternativa_b() {
        return txt_alternativa_b;
    }

    public void setTxt_alternativa_b(String txt_alternativa_b) {
        this.txt_alternativa_b = txt_alternativa_b;
    }

    public String getTxt_alternativa_c() {
        return txt_alternativa_c;
    }

    public void setTxt_alternativa_c(String txt_alternativa_c) {
        this.txt_alternativa_c = txt_alternativa_c;
    }

    public String getTxt_alternativa_d() {
        return txt_alternativa_d;
    }

    public void setTxt_alternativa_d(String txt_alternativa_d) {
        this.txt_alternativa_d = txt_alternativa_d;
    }

    public String getTxt_alternativa_e() {
        return txt_alternativa_e;
    }

    public void setTxt_alternativa_e(String txt_alternativa_e) {
        this.txt_alternativa_e = txt_alternativa_e;
    }
   
    public void buttonActionCadastrarQuestao() {
        
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;

        try {
            fachadaEjb.cadastrarQuestao(txt_enunciado, txt_comentario, txt_alternativa_correta, txt_alternativa_a, txt_alternativa_b, txt_alternativa_c, txt_alternativa_d, txt_alternativa_e, idCategoriasSelecionadas); 
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
