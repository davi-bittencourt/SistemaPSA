/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.*;
import java.util.ArrayList;
import java.util.Collection;
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
    @EJB
    private ProvaFacadeLocal provaEjb;
    @EJB
    private ProfessorFacadeLocal professorEjb;

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

    @Override
    public ProvaDTO getProva(int id) throws FachadaException {
        try {
            Prova p = provaEjb.find(id);
            List<QuestaoDTO> questoes = copiarParaQuestoesDTO(new ArrayList(p.getQuestaoCollection()));
            ProvaDTO dto = new ProvaDTO(p.getIdProva(), p.getCodigo(), questoes, p.getIdProf().getNome());
            return dto;
        } catch (Exception e) {
            throw new FachadaException("Erro ao buscar a prova de id: " + id + " - ", e);
        }
    }

    @Override
    public List<ProvaDTO> getProvas() throws FachadaException {
        try {
            List<Prova> provas = provaEjb.findAll();
            return copiarParaProvasDTO(provas);
        } catch (Exception e) {
            throw new FachadaException("Erro ao buscar provas cadastradas", e);
        }
    }

    private List<ProvaDTO> copiarParaProvasDTO(List<Prova> provas) {
        List<ProvaDTO> dtoProvas = new ArrayList<ProvaDTO>(provas.size());
        for (Prova p : provas) {
            Integer id = p.getIdProva();
            String cod = p.getCodigo();
            String profName = p.getIdProf().getNome();

            List<QuestaoDTO> questoes = copiarParaQuestoesDTO(new ArrayList(p.getQuestaoCollection()));
            dtoProvas.add(new ProvaDTO(id, cod, questoes, profName));
        }
        return dtoProvas;
    }

    @Override
    public List<ProfessorDTO> getProfessores() throws FachadaException {
        try {
            List<Professor> profs = professorEjb.findAll();
            return copiarParaProfessorDTO(profs);
        } catch (Exception e) {
            throw new FachadaException("Erro ao buscar todos os professores", e);
        }
    }

    private List<ProfessorDTO> copiarParaProfessorDTO(List<Professor> profs) {
        List<ProfessorDTO> dtoProfessores = new ArrayList<ProfessorDTO>(profs.size());
        for (Professor p : profs) {
            dtoProfessores.add(new ProfessorDTO(p.getIdProf(), p.getNome()));
        }
        return dtoProfessores;
    }

    @Override
    public void cadastrarProva(String cod, Integer id_prof) {

        Prova prova = new Prova();
        Professor prof = new Professor();

        prova.setCodigo(cod);
        prof.setIdProf(id_prof);

        prova.setIdProf(prof);
        try {
            provaEjb.create(prova);

        } catch (Exception e) {
            throw new FachadaException("Ocorreu um erro ao cadastrar a prova no banco de dados: ", e);
        }

    }

    @Override
    public void cadastrarQuestao(String txt_enunciado, String txt_comentario, String txt_alternativa_correta, String txt_alternativa_a, String txt_alternativa_b, String txt_alternativa_c, String txt_alternativa_d, String txt_alternativa_e, List<String> idCategoriasSelecionadas) {
        Questao q = copiarParaQuestao(null, txt_enunciado, txt_comentario, txt_alternativa_correta, txt_alternativa_a, txt_alternativa_b, txt_alternativa_c, txt_alternativa_d, txt_alternativa_e, idCategoriasSelecionadas);
        try {
            questaoEjb.create(q);
        } catch (Exception e) {
            throw new FachadaException("Ocorreu um erro ao cadastrar a questão no banco de dados: ", e);
        }
    }
    
    @Override
    public void editarQuestao(Integer id, String txt_enunciado, String txt_comentario, String txt_alternativa_correta, String txt_alternativa_a, String txt_alternativa_b, String txt_alternativa_c, String txt_alternativa_d, String txt_alternativa_e, List<String> idCategoriasSelecionadas) {
        Questao q = copiarParaQuestao(id, txt_enunciado, txt_comentario, txt_alternativa_correta, txt_alternativa_a, txt_alternativa_b, txt_alternativa_c, txt_alternativa_d, txt_alternativa_e, idCategoriasSelecionadas);
        try {
            questaoEjb.edit(q);
        } catch (Exception e) {
            throw new FachadaException("Ocorreu um erro ao cadastrar a questão no banco de dados: ", e);
        }
    }

    @Override
    public QuestaoDTO getQuestao(int id) {
        try {
            Questao q = questaoEjb.find(id);
            return copiarParaQuestaoDTO(q);
        } catch (Exception e) {
            throw new FachadaException("Erro ao buscar a questão de ID: " + id, e);
        }
    }

    private Questao copiarParaQuestao(Integer id, String txt_enunciado, String txt_comentario, String txt_alternativa_correta, String txt_alternativa_a, String txt_alternativa_b, String txt_alternativa_c, String txt_alternativa_d, String txt_alternativa_e, List<String> idCategoriasSelecionadas) {
        Questao q = new Questao();

        Collection<Categoria> cc = new ArrayList<>();

        for (String idCat : idCategoriasSelecionadas) {
            cc.add(new Categoria(new Integer(idCat)));
        }
        q.setIdQuestao(id);
        q.setEnunciado(txt_enunciado);
        q.setComentario(txt_comentario);
        q.setAlternativaCorreta(txt_alternativa_correta);
        q.setAlternativaA(txt_alternativa_a);
        q.setAlternativaB(txt_alternativa_b);
        q.setAlternativaC(txt_alternativa_c);
        q.setAlternativaD(txt_alternativa_d);
        q.setAlternativaE(txt_alternativa_e);
        q.setCategoriaCollection(cc);

        return q;
    }

    private QuestaoDTO copiarParaQuestaoDTO(Questao q) {

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

        return dto;
    } 
}
