/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.Serializable;

public class CategoriaDTO implements Serializable{

    public CategoriaDTO(Integer idCateg, String Nome) {
        this.idCateg = idCateg;
        this.Nome = Nome;
    }

    public Integer getIdCateg() {
        return idCateg;
    }

    public void setIdCateg(Integer idCateg) {
        this.idCateg = idCateg;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    
    private Integer idCateg;
    private String Nome;
}
