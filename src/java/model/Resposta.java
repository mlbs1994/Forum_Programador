/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Matheus Levi
 */
@Entity
@Table(catalog = "forum_programador", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resposta.findAll", query = "SELECT r FROM Resposta r"),
    @NamedQuery(name = "Resposta.findByIdResposta", query = "SELECT r FROM Resposta r WHERE r.idResposta = :idResposta"),
    @NamedQuery(name = "Resposta.findByDataSubmissao", query = "SELECT r FROM Resposta r WHERE r.dataSubmissao = :dataSubmissao"),
    @NamedQuery(name = "Resposta.findByMelhorResposta", query = "SELECT r FROM Resposta r WHERE r.melhorResposta = :melhorResposta"),
    @NamedQuery(name = "Resposta.findByNumLikes", query = "SELECT r FROM Resposta r WHERE r.numLikes = :numLikes")})
public class Resposta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idResposta;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataSubmissao;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    private String descricao;
    @Basic(optional = false)
    @NotNull
    private boolean melhorResposta;
    @Basic(optional = false)
    @NotNull
    private int numLikes;
    @JoinColumn(name = "idPergunta", referencedColumnName = "idPergunta")
    @ManyToOne(optional = false)
    private Pergunta idPergunta;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Resposta() {
    }

    public Resposta(Integer idResposta) {
        this.idResposta = idResposta;
    }

    public Resposta(Integer idResposta, Date dataSubmissao, String descricao, boolean melhorResposta, int numLikes) {
        this.idResposta = idResposta;
        this.dataSubmissao = dataSubmissao;
        this.descricao = descricao;
        this.melhorResposta = melhorResposta;
        this.numLikes = numLikes;
    }

    public Integer getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(Integer idResposta) {
        this.idResposta = idResposta;
    }

    public Date getDataSubmissao() {
        return dataSubmissao;
    }

    public void setDataSubmissao(Date dataSubmissao) {
        this.dataSubmissao = dataSubmissao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean getMelhorResposta() {
        return melhorResposta;
    }

    public void setMelhorResposta(boolean melhorResposta) {
        this.melhorResposta = melhorResposta;
    }

    public int getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(int numLikes) {
        this.numLikes = numLikes;
    }

    public Pergunta getIdPergunta() {
        return idPergunta;
    }

    public void setIdPergunta(Pergunta idPergunta) {
        this.idPergunta = idPergunta;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResposta != null ? idResposta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resposta)) {
            return false;
        }
        Resposta other = (Resposta) object;
        if ((this.idResposta == null && other.idResposta != null) || (this.idResposta != null && !this.idResposta.equals(other.idResposta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Resposta[ idResposta=" + idResposta + " ]";
    }
    
}
