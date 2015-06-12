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
import negocio.CategoriaDTO;
import negocio.FachadaLocal;
import negocio.QuestaoDTO;
import org.primefaces.context.RequestContext;

@Named
@RequestScoped
public class EditarQuestaoBean {

    @EJB
    private FachadaLocal fachadaEjb;

    private Integer id_questao;
    private String txt_enunciado;
    private String txt_comentario;
    private String txt_alternativa_correta;
    private String txt_alternativa_a;
    private String txt_alternativa_b;
    private String txt_alternativa_c;
    private String txt_alternativa_d;
    private String txt_alternativa_e;

    private List<String> idCategoriasSelecionadas;
  
    public Integer getId_questao() {
        return id_questao;
    }

    public void setId_questao(Integer id_questao) {
        this.id_questao = id_questao;
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

    public List<String> getIdCategoriasSelecionadas() {
        return idCategoriasSelecionadas;
    }

    public void setIdCategoriasSelecionadas(List<String> idCategoriasSelecionadas) {
        this.idCategoriasSelecionadas = idCategoriasSelecionadas;
    }

    public String outcome() {
        FacesContext fc = FacesContext.getCurrentInstance();
        this.id_questao = new Integer(getIdParam(fc));
        QuestaoDTO q = fachadaEjb.getQuestao(id_questao);

        //Preenche os atributos do bean para posteriormente atualizar o arquivo
        id_questao = q.getId_questao();
        txt_enunciado = q.getEnunciado();
        txt_comentario = q.getComentario();
        txt_alternativa_correta = q.getAlternativa_correta();
        txt_alternativa_a = q.getAlternativa_a();
        txt_alternativa_b = q.getAlternativa_b();
        txt_alternativa_c = q.getAlternativa_c();
        txt_alternativa_d = q.getAlternativa_d();
        txt_alternativa_e = q.getAlternativa_e();

        return "editarQuestao";
    }

    //get value from "f:param"
    private String getIdParam(FacesContext fc) {

        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        return params.get("id");
    }

    public List<CategoriaDTO> getCategorias() {
        return fachadaEjb.getCategorias();
    }

    public void buttonActionEditarQuestao() {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
        try {
            System.out.println("ID ------------------------------: "+getId_questao());
            fachadaEjb.editarQuestao(getId_questao(), getTxt_enunciado(), getTxt_comentario(), getTxt_alternativa_correta(), getTxt_alternativa_a(),getTxt_alternativa_b(), getTxt_alternativa_c(), getTxt_alternativa_d(), getTxt_alternativa_e(), idCategoriasSelecionadas);
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
