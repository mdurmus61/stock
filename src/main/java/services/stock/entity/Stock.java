package services.stock.entity;

import services.stock.entity.base.BaseEntity;

import javax.persistence.Entity;

@Entity
public class Stock extends BaseEntity {
    private String name;

}
