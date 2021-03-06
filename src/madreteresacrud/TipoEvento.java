/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madreteresacrud;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leandro
 */
@Entity
@Table(name = "tipoEvento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEvento.findAll", query = "SELECT t FROM TipoEvento t"),
    @NamedQuery(name = "TipoEvento.findByIdtipoEvento", query = "SELECT t FROM TipoEvento t WHERE t.idtipoEvento = :idtipoEvento"),
    @NamedQuery(name = "TipoEvento.findByDescripcion", query = "SELECT t FROM TipoEvento t WHERE t.descripcion = :descripcion")})
public class TipoEvento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idtipoEvento")
    private Integer idtipoEvento;
    @Column(name = "descripcion")
    private String descripcion;

    public TipoEvento() {
    }

    public TipoEvento(Integer idtipoEvento) {
        this.idtipoEvento = idtipoEvento;
    }

    public Integer getIdtipoEvento() {
        return idtipoEvento;
    }

    public void setIdtipoEvento(Integer idtipoEvento) {
        this.idtipoEvento = idtipoEvento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoEvento != null ? idtipoEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEvento)) {
            return false;
        }
        TipoEvento other = (TipoEvento) object;
        if ((this.idtipoEvento == null && other.idtipoEvento != null) || (this.idtipoEvento != null && !this.idtipoEvento.equals(other.idtipoEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "madreteresacrud.TipoEvento[ idtipoEvento=" + idtipoEvento + " ]";
    }

}
