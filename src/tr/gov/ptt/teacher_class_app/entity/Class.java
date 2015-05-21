/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.teacher_class_app.entity;

import java.io.Serializable;

import java.util.List;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "CLASS")
@NamedQueries({
    @NamedQuery(name = "Class.findAll", query = "SELECT c FROM Class c"),
    @NamedQuery(name = "Class.findByCid", query = "SELECT c FROM Class c WHERE c.cid = :cid"),
    @NamedQuery(name = "Class.findByCname", query = "SELECT c FROM Class c WHERE c.cname = :cname")})
@SequenceGenerator(sequenceName = "SEQ_CLASS",name = "seqclass",allocationSize = 1)
public class Class implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "CID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seqclass")
    private Integer cid;
    @Column(name = "CNAME")
    private String cname;
    @JoinTable(name = "TEACHER_CLASS", joinColumns = {
        @JoinColumn(name = "CID", referencedColumnName = "CID")}, inverseJoinColumns = {
        @JoinColumn(name = "TID", referencedColumnName = "TID")})
    @ManyToMany
    private List<Teacher> teacherList;

    public Class() {
    }

    public Class(Integer cid) {
        this.cid = cid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cid != null ? cid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Class)) {
            return false;
        }
        Class other = (Class) object;
        if ((this.cid == null && other.cid != null) || (this.cid != null && !this.cid.equals(other.cid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.gov.ptt.teacher_class_app.entity.Class[ cid=" + cid + " ]";
    }
    
}
