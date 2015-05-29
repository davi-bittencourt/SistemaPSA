/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.*;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.EJB;

/**
 *
 * @author davi.bittencourt
 */
@Stateless
public class Fachada implements FachadaLocal {
    @EJB
    private CategoriaFacadeLocal categoriaEjb;
    @EJB
    private QuestaoFacadeLocal questaoEjb;
    @Override
    public List<QuestaoDTO> getQuestoes() throws FachadaException {
        try {
            List<Questao> questoes = questaoEjb.findAll();
            return copiarParaQuestoesDTO(questoes);
        } catch (Exception e) {
            throw new FachadaException("Erro ao buscar categorias", e);
        }
    }

    private List<QuestaoDTO> copiarParaQuestoesDTO(List<Questao> questoes) {
        List<QuestaoDTO> dtoQuestao = new ArrayList<QuestaoDTO>(questoes.size());
        for (Questao q : questoes) {
            Integer id_questao = q.getIdQuestao();
            String enunciado = q.getEnunciado();
            String categoria = "";
            for (Categoria c : q.getCategoriaCollection()) {
               categoria += c.getNome() + "; ";
            }
            String comentario = q.getComentario();
            String alternativa_correta = q.getAlternativaCorreta();
            String alternativa_a = q.getAlternativaA();
            String alternativa_b = q.getAlternativaB();
            String alternativa_c = q.getAlternativaC();
            String alternativa_d = q.getAlternativaD();
            String alternativa_e = q.getAlternativaE();

            QuestaoDTO dto = new QuestaoDTO(id_questao, enunciado, categoria, comentario, alternativa_correta, alternativa_a, alternativa_b, alternativa_c, alternativa_d, alternativa_e);
            dtoQuestao.add(dto);
        }
        return dtoQuestao;
    }

    @Override
    public List<CategoriaDTO> getCategorias() throws FachadaException {
        try {
            List<Categoria> categorias = categoriaEjb.findAll();
            return copiarParaCategoriaDTO(categorias);
        } catch (Exception e) {
            throw new FachadaException("Erro ao buscar categorias", e);
        }
    }

    private List<CategoriaDTO> copiarParaCategoriaDTO(List<Categoria> categorias) {
        List<CategoriaDTO> dtoCategoria = new ArrayList<CategoriaDTO>(categorias.size());
        for (Categoria c : categorias) {
            dtoCategoria.add(new CategoriaDTO(c.getIdCateg(), c.getNome()));
        }
        return dtoCategoria;
    }
}
