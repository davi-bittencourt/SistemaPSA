package web;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import negocio.FachadaLocal;
import negocio.QuestaoDTO;

@Named
@RequestScoped
public class TesteBean {  
    @EJB
    private FachadaLocal fachadaEjb;
    
    public List<QuestaoDTO> getQuestoes() {
        return fachadaEjb.getQuestoes();
    }
    
}
