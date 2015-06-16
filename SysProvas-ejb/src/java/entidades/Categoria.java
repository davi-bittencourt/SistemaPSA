/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author davi.bittencourt
 */
@Entity
@Table(name = "CATEGORIAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c"),
    @NamedQuery(name = "Categoria.findByIdCateg", query = "SELECT c FROM Categoria c WHERE c.idCateg = :idCateg"),
    @NamedQuery(name = "Categoria.findByNome", query = "SELECT c FROM Categoria c WHERE c.nome = :nome")})
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CATEG")
    private Integer idCateg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOME")
    private String nome;
    
    public Categoria() {
    }

    public Categoria(Integer idCateg) {
        this.idCateg = idCateg;
    }

    public Categoria(Integer idCateg, String nome) {
        this.idCateg = idCateg;
        this.nome = nome;
    }

    public Integer getIdCateg() {
        return idCateg;
    }

    public void setIdCateg(Integer idCateg) {
        this.idCateg = idCateg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

//    @XmlTransient
//    public Collection<Questao> getQuestaoCollection() {
//        return questaoCollection;
//    }
//
//    public void setQuestaoCollection(Collection<Questao> questaoCollection) {
//        this.questaoCollection = questaoCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCateg != null ? idCateg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.idCateg == null && other.idCateg != null) || (this.idCateg != null && !this.idCateg.equals(other.idCateg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Categoria[ idCateg=" + idCateg + " ]";
    }
    
}
