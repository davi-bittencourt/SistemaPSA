/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author davi.bittencourt
 */
@Local
public interface FachadaLocal {
    
    /**
     * Obtém todas as questões cadastradas no banco de dados
     * @return List<QuestaoDTO>
     */
    List<QuestaoDTO> getQuestoes();
    
    /**
     * Obtém todas as categorias de questões cadastradas no banco de dados
     * @return List<CategoriaDTO>
     */
    List<CategoriaDTO> getCategorias();
    
    /**
     * Obtém todos os professores cadastrados no banco de dados
     * @return List<ProfessorDTO>
     */
    List<ProfessorDTO> getProfessores();
   
    /**
     * Obtem todas as provas cadastradas no banco de dados
     * @return List<ProvaDTO>
     */
    List<ProvaDTO> getProvas();
   
    /**
     * Retorna uma prova cadastrada no banco de dados
     * @param id da prova
     * @return objeto ProvaDTO, que será utilizado na camada de apresentação
     */
    ProvaDTO getProva(int id); 
    
    /**
     * Cadastra uma nova prova, obtida através de um objeto DTO construído dentro da fachada.
     * @param cod Código de acesso cadastrado na interface web.
     * @param id_prof id do professor selecionado na interface web.
     */
    void cadastrarProva(String cod, Integer id_prof);
    
    /**
     * Cadastra uma nova questão no no banco de dados.
     * 
     * @param txt_enunciado
     * @param txt_comentario
     * @param txt_alternativa_correta
     * @param txt_alternativa_a
     * @param txt_alternativa_b
     * @param txt_alternativa_c
     * @param txt_alternativa_d
     * @param txt_alternativa_e
     * @param idCategoriasSelecionadas Lista que contém os IDs das categorias pertencentes à questão.
     */
    public void cadastrarQuestao(String txt_enunciado, String txt_comentario, String txt_alternativa_correta, String txt_alternativa_a, String txt_alternativa_b, String txt_alternativa_c, String txt_alternativa_d, String txt_alternativa_e, List<String> idCategoriasSelecionadas);
    
    /**
     * Edita uma questão já existente
     * @param id
     * @param enunciado
     * @param comentario
     * @param alternativa_correta
     * @param alternativa_a
     * @param alternativa_b
     * @param alternativa_c
     * @param alternativa_d
     * @param alternativa_e
     * @param idCategoriasSelecionadas 
     */
    public void editarQuestao(Integer id, String enunciado, String comentario, String alternativa_correta, String alternativa_a, String alternativa_b, String alternativa_c, String alternativa_d, String alternativa_e, List<String> idCategoriasSelecionadas);

    /**
     * Retorna uma questão do banco de dados através de sua ID
     * @param id
     * @return QuestaoDTO
     */ 
    public QuestaoDTO getQuestao(int id);

    }
