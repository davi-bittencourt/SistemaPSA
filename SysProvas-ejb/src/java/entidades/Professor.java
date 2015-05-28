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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "PROFESSORES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Professor.findAll", query = "SELECT p FROM Professor p"),
    @NamedQuery(name = "Professor.findByIdProf", query = "SELECT p FROM Professor p WHERE p.idProf = :idProf"),
    @NamedQuery(name = "Professor.findByNome", query = "SELECT p FROM Professor p WHERE p.nome = :nome")})
public class Professor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PROF")
    private Integer idProf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NOME")
    private String nome;
    @OneToMany(mappedBy = "idProf")
    private Collection<Prova> provaCollection;

    public Professor() {
    }

    public Professor(Integer idProf) {
        this.idProf = idProf;
    }

    public Professor(Integer idProf, String nome) {
        this.idProf = idProf;
        this.nome = nome;
    }

    public Integer getIdProf() {
        return idProf;
    }

    public void setIdProf(Integer idProf) {
        this.idProf = idProf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Prova> getProvaCollection() {
        return provaCollection;
    }

    public void setProvaCollection(Collection<Prova> provaCollection) {
        this.provaCollection = provaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProf != null ? idProf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Professor)) {
            return false;
        }
        Professor other = (Professor) object;
        if ((this.idProf == null && other.idProf != null) || (this.idProf != null && !this.idProf.equals(other.idProf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Professor[ idProf=" + idProf + " ]";
    }
    
}
