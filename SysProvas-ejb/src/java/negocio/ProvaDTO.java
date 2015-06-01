/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Professor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 12205170
 */
public class ProvaDTO {

    private Integer idProva;
    private String codigo;
    private List<QuestaoDTO> questoes;
    private String idProf;
    
    public ProvaDTO(Integer idProva, String codigo, ArrayList<QuestaoDTO> questoes, String nomeP) {
        this.idProva = idProva;
        this.codigo = codigo;
        this.questoes = questoes;
        this.idProf = nomeP;
    }
    
    /**
     * Retorna quantas questões existem na prova em questao
     * @return quantidade de questões na prova
     */
    public int getQuestoesSize(){
        if(questoes == null) return 0;
        return questoes.size();
    }

    public Integer getIdProva() {
        return idProva;
    }

    public void setIdProva(Integer idProva) {
        this.idProva = idProva;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<QuestaoDTO> getQuestoes() {
        return questoes;
    }

    public String getIdProf() {
        return idProf;
    }

    public void setIdProf(String idProf) {
        this.idProf = idProf;
    }
}
