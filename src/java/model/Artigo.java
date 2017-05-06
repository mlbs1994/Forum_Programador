/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Matheus Levi
 */
@Entity
@Table(catalog = "forum_programador", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artigo.findAll", query = "SELECT a FROM Artigo a"),
    @NamedQuery(name = "Artigo.findByIdArtigo", query = "SELECT a FROM Artigo a WHERE a.idArtigo = :idArtigo"),
    @NamedQuery(name = "Artigo.findByTitulo", query = "SELECT a FROM Artigo a WHERE a.titulo = :titulo"),
    @NamedQuery(name = "Artigo.findByDataSubmissao", query = "SELECT a FROM Artigo a WHERE a.dataSubmissao = :dataSubmissao")})
public class Artigo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idArtigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataSubmissao;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    private String descricao;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArtigo")
    private List<Comentario> comentarioList;

    public Artigo() {
    }

    public Artigo(Integer idArtigo) {
        this.idArtigo = idArtigo;
    }

    public Artigo(Integer idArtigo, String titulo, Date dataSubmissao, String descricao) {
        this.idArtigo = idArtigo;
        this.titulo = titulo;
        this.dataSubmissao = dataSubmissao;
        this.descricao = descricao;
    }

    public Integer getIdArtigo() {
        return idArtigo;
    }

    public void setIdArtigo(Integer idArtigo) {
        this.idArtigo = idArtigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public List<Comentario> getComentarioList() {
        return comentarioList;
    }

    public void setComentarioList(List<Comentario> comentarioList) {
        this.comentarioList = comentarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArtigo != null ? idArtigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artigo)) {
            return false;
        }
        Artigo other = (Artigo) object;
        if ((this.idArtigo == null && other.idArtigo != null) || (this.idArtigo != null && !this.idArtigo.equals(other.idArtigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Artigo[ idArtigo=" + idArtigo + " ]";
    }
    
}
