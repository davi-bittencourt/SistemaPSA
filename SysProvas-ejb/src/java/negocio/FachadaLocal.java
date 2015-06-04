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
}
