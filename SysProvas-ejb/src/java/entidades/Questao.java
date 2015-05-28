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
@Table(name = "QUESTOES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Questao.findAll", query = "SELECT q FROM Questao q"),
    @NamedQuery(name = "Questao.findByIdQuestao", query = "SELECT q FROM Questao q WHERE q.idQuestao = :idQuestao"),
    @NamedQuery(name = "Questao.findByEnunciado", query = "SELECT q FROM Questao q WHERE q.enunciado = :enunciado"),
    @NamedQuery(name = "Questao.findByComentario", query = "SELECT q FROM Questao q WHERE q.comentario = :comentario"),
    @NamedQuery(name = "Questao.findByAlternativaCorreta", query = "SELECT q FROM Questao q WHERE q.alternativaCorreta = :alternativaCorreta"),
    @NamedQuery(name = "Questao.findByAlternativaA", query = "SELECT q FROM Questao q WHERE q.alternativaA = :alternativaA"),
    @NamedQuery(name = "Questao.findByAlternativaB", query = "SELECT q FROM Questao q WHERE q.alternativaB = :alternativaB"),
    @NamedQuery(name = "Questao.findByAlternativaC", query = "SELECT q FROM Questao q WHERE q.alternativaC = :alternativaC"),
    @NamedQuery(name = "Questao.findByAlternativaD", query = "SELECT q FROM Questao q WHERE q.alternativaD = :alternativaD"),
    @NamedQuery(name = "Questao.findByAlternativaE", query = "SELECT q FROM Questao q WHERE q.alternativaE = :alternativaE")})
public class Questao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_QUESTAO")
    private Integer idQuestao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "ENUNCIADO")
    private String enunciado;
    @Size(max = 300)
    @Column(name = "COMENTARIO")
    private String comentario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ALTERNATIVA_CORRETA")
    private String alternativaCorreta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "ALTERNATIVA_A")
    private String alternativaA;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "ALTERNATIVA_B")
    private String alternativaB;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "ALTERNATIVA_C")
    private String alternativaC;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "ALTERNATIVA_D")
    private String alternativaD;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "ALTERNATIVA_E")
    private String alternativaE;
    @ManyToMany(mappedBy = "questaoCollection")
    private Collection<Categoria> categoriaCollection;
    @JoinTable(name = "QUESTOES_PROVAS", joinColumns = {
        @JoinColumn(name = "ID_QUESTAO", referencedColumnName = "ID_QUESTAO")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_PROVA", referencedColumnName = "ID_PROVA")})
    @ManyToMany
    private Collection<Prova> provaCollection;

    public Questao() {
    }

    public Questao(Integer idQuestao) {
        this.idQuestao = idQuestao;
    }

    public Questao(Integer idQuestao, String enunciado, String alternativaCorreta, String alternativaA, String alternativaB, String alternativaC, String alternativaD, String alternativaE) {
        this.idQuestao = idQuestao;
        this.enunciado = enunciado;
        this.alternativaCorreta = alternativaCorreta;
        this.alternativaA = alternativaA;
        this.alternativaB = alternativaB;
        this.alternativaC = alternativaC;
        this.alternativaD = alternativaD;
        this.alternativaE = alternativaE;
    }

    public Integer getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(Integer idQuestao) {
        this.idQuestao = idQuestao;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getAlternativaCorreta() {
        return alternativaCorreta;
    }

    public void setAlternativaCorreta(String alternativaCorreta) {
        this.alternativaCorreta = alternativaCorreta;
    }

    public String getAlternativaA() {
        return alternativaA;
    }

    public void setAlternativaA(String alternativaA) {
        this.alternativaA = alternativaA;
    }

    public String getAlternativaB() {
        return alternativaB;
    }

    public void setAlternativaB(String alternativaB) {
        this.alternativaB = alternativaB;
    }

    public String getAlternativaC() {
        return alternativaC;
    }

    public void setAlternativaC(String alternativaC) {
        this.alternativaC = alternativaC;
    }

    public String getAlternativaD() {
        return alternativaD;
    }

    public void setAlternativaD(String alternativaD) {
        this.alternativaD = alternativaD;
    }

    public String getAlternativaE() {
        return alternativaE;
    }

    public void setAlternativaE(String alternativaE) {
        this.alternativaE = alternativaE;
    }

    @XmlTransient
    public Collection<Categoria> getCategoriaCollection() {
        return categoriaCollection;
    }

    public void setCategoriaCollection(Collection<Categoria> categoriaCollection) {
        this.categoriaCollection = categoriaCollection;
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
        hash += (idQuestao != null ? idQuestao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questao)) {
            return false;
        }
        Questao other = (Questao) object;
        if ((this.idQuestao == null && other.idQuestao != null) || (this.idQuestao != null && !this.idQuestao.equals(other.idQuestao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Questao[ idQuestao=" + idQuestao + " ]";
    }
    
}
