package services.stock.entity;

import org.hibernate.annotations.Immutable;
import services.stock.entity.base.BaseEntity;

import javax.persistence.*;

@Immutable
@Entity
public class Role extends BaseEntity {

    @Column(length = 20)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
