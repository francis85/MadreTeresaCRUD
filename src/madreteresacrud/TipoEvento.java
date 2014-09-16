/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package madreteresacrud;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author francis
 */
@Entity
@Table(name = "tipoEvento", catalog = "circuloo_francisco", schema = "")
@NamedQueries({
    @NamedQuery(name = "TipoEvento.findAll", query = "SELECT t FROM TipoEvento t"),
    @NamedQuery(name = "TipoEvento.findByIdtipoEvento", query = "SELECT t FROM TipoEvento t WHERE t.idtipoEvento = :idtipoEvento"),
    @NamedQuery(name = "TipoEvento.findByDescripcion", query = "SELECT t FROM TipoEvento t WHERE t.descripcion = :descripcion")})
public class TipoEvento implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idtipoEvento")
    private Integer idtipoEvento;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;

    public TipoEvento() {
    }

    public TipoEvento(Integer idtipoEvento) {
        this.idtipoEvento = idtipoEvento;
    }

    public TipoEvento(Integer idtipoEvento, String descripcion) {
        this.idtipoEvento = idtipoEvento;
        this.descripcion = descripcion;
    }

    public Integer getIdtipoEvento() {
        return idtipoEvento;
    }

    public void setIdtipoEvento(Integer idtipoEvento) {
        Integer oldIdtipoEvento = this.idtipoEvento;
        this.idtipoEvento = idtipoEvento;
        changeSupport.firePropertyChange("idtipoEvento", oldIdtipoEvento, idtipoEvento);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        String oldDescripcion = this.descripcion;
        this.descripcion = descripcion;
        changeSupport.firePropertyChange("descripcion", oldDescripcion, descripcion);
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

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}