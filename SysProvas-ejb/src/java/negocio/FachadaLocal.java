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
    List<QuestaoDTO> getQuestoes();
    List<CategoriaDTO> getCategorias();
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
}
