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
@Table(name = "TEACHER")
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "SELECT t FROM Teacher t"),
    @NamedQuery(name = "Teacher.findByTid", query = "SELECT t FROM Teacher t WHERE t.tid = :tid"),
    @NamedQuery(name = "Teacher.findByTname", query = "SELECT t FROM Teacher t WHERE t.tname = :tname"),
    @NamedQuery(name = "Teacher.findBySubject", query = "SELECT t FROM Teacher t WHERE t.subject = :subject")})

@SequenceGenerator(sequenceName = "SEQ_TEACHER",name = "seqteacher",allocationSize = 1)
public class Teacher implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "TID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seqteacher")
    private Integer tid;
    @Column(name = "TNAME")
    private String tname;
    @Column(name = "SUBJECT")
    private String subject;
    @ManyToMany(mappedBy = "teacherList")
    private List<Class> classList;

    public Teacher() {
    }

    public Teacher(Integer tid) {
        this.tid = tid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<Class> getClassList() {
        return classList;
    }

    public void setClassList(List<Class> classList) {
        this.classList = classList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tid != null ? tid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.tid == null && other.tid != null) || (this.tid != null && !this.tid.equals(other.tid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.gov.ptt.teacher_class_app.entity.Teacher[ tid=" + tid + " ]";
    }
    
}
