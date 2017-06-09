/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author Matheus Levi
 */
@Entity
@Table(name = "linguagem_programacao", catalog = "forum_programador", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LinguagemProgramacao.findAll", query = "SELECT l FROM LinguagemProgramacao l"),
    @NamedQuery(name = "LinguagemProgramacao.findByIdLinguagemProgramacao", query = "SELECT l FROM LinguagemProgramacao l WHERE l.idLinguagemProgramacao = :idLinguagemProgramacao"),
    @NamedQuery(name = "LinguagemProgramacao.findByNome", query = "SELECT l FROM LinguagemProgramacao l WHERE l.nome = :nome")})
public class LinguagemProgramacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idLinguagemProgramacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String codeRealceSintaxe;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLinguagemProgramacao")
    private List<Pergunta> perguntaList;

    public LinguagemProgramacao() {
    }

    public LinguagemProgramacao(Integer idLinguagemProgramacao) {
        this.idLinguagemProgramacao = idLinguagemProgramacao;
    }

    public LinguagemProgramacao(Integer idLinguagemProgramacao, String nome) {
        this.idLinguagemProgramacao = idLinguagemProgramacao;
        this.nome = nome;
    }

    public Integer getIdLinguagemProgramacao() {
        return idLinguagemProgramacao;
    }

    public void setIdLinguagemProgramacao(Integer idLinguagemProgramacao) {
        this.idLinguagemProgramacao = idLinguagemProgramacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<Pergunta> getPerguntaList() {
        return perguntaList;
    }

    public void setPerguntaList(List<Pergunta> perguntaList) {
        this.perguntaList = perguntaList;
    }
    
    public String getCodeRealceSintaxe() {
        return codeRealceSintaxe;
    }

    public void setCodeRealceSintaxe(String codeRealceSintaxe) {
        this.codeRealceSintaxe = codeRealceSintaxe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLinguagemProgramacao != null ? idLinguagemProgramacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LinguagemProgramacao)) {
            return false;
        }
        LinguagemProgramacao other = (LinguagemProgramacao) object;
        if ((this.idLinguagemProgramacao == null && other.idLinguagemProgramacao != null) || (this.idLinguagemProgramacao != null && !this.idLinguagemProgramacao.equals(other.idLinguagemProgramacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.LinguagemProgramacao[ idLinguagemProgramacao=" + idLinguagemProgramacao + " ]";
    }
    
}
