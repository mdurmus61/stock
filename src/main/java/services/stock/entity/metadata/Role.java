package services.stock.entity.metadata;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import services.stock.entity.base.BaseEntity;

import javax.persistence.*;

@Immutable
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @Column(length = 20)
    private String name;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
