/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.bdd.middleware.model.bogota;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 305
 */
@Entity
@Table(name = "telefono", catalog = "per_bog_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TelefonoBog.findAll", query = "SELECT t FROM TelefonoBog t")
    , @NamedQuery(name = "TelefonoBog.findByNum", query = "SELECT t FROM TelefonoBog t WHERE t.num = :num")
    , @NamedQuery(name = "TelefonoBog.findByOper", query = "SELECT t FROM TelefonoBog t WHERE t.oper = :oper")})
public class TelefonoBog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer num;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String oper;
    @JoinColumn(name = "prop", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private PersonaBog prop;

    public TelefonoBog() {
    }

    public TelefonoBog(Integer num) {
        this.num = num;
    }

    public TelefonoBog(Integer num, String oper) {
        this.num = num;
        this.oper = oper;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public PersonaBog getProp() {
        return prop;
    }

    public void setProp(PersonaBog prop) {
        this.prop = prop;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (num != null ? num.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelefonoBog)) {
            return false;
        }
        TelefonoBog other = (TelefonoBog) object;
        if ((this.num == null && other.num != null) || (this.num != null && !this.num.equals(other.num))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.bdd.middleware.model.bogota.TelefonoBog[ num=" + num + " ]";
    }
    
}
