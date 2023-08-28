package model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "test_a")
@Entity
public class A implements Serializable {
    @Id
    @Column(name = "col_1")
    private String col1;

    @Column(name = "col_2")
    private String col2;

    @OneToOne
    @JoinColumn(name = "col_2", referencedColumnName = "col_2",insertable = false,updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private B b;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "col_2", referencedColumnName = "col_2", insertable = false, updatable = false)
    private List<C> cs;

    public String getCol1() {
        return col1;
    }

    public void setCol1(String col1) {
        this.col1 = col1;
    }

    public String getCol2() {
        return col2;
    }

    public void setCol2(String col2) {
        this.col2 = col2;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public List<C> getCs() {
        return cs;
    }

    public void setCs(List<C> cs) {
        this.cs = cs;
    }
}