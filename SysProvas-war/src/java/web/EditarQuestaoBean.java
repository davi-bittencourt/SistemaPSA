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
import negocio.CategoriaDTO;
import negocio.FachadaLocal;
import negocio.QuestaoDTO;

@Named
@RequestScoped
public class EditarQuestaoBean {

    @EJB
    private FachadaLocal fachadaEjb;

    private String id;
    private String enunciado;
    private List<CategoriaDTO> categorias;
    private String comentario;
    private String alternativa_correta;
    private String alternativa_a;
    private String alternativa_b;
    private String alternativa_c;
    private String alternativa_d;
    private String alternativa_e;

    public String outcome() {

        FacesContext fc = FacesContext.getCurrentInstance();
        this.id = getCountryParam(fc);

        return "editarQuestao";
    }

    //get value from "f:param"
    public String getCountryParam(FacesContext fc) {

        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        return params.get("id");

    }

    public QuestaoDTO getQuestao(int id) {
        
        
        
        return fachadaEjb.getQuestao(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
