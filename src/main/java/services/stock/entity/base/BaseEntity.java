package services.stock.entity.base;

import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @NotNull
    @Column(nullable = false)
    private Long createdUserId;

    @Column(length = 200)
    private String initiatedFromComputer;

    @NotNull
    @Column(nullable = false)
    private OffsetDateTime createDate;

    private Long modifiedUserId;

    @Column(length = 200)
    private String modifiedFromComputer;

    private OffsetDateTime modifiedDate;


    public void applyEntityStamps() {
        if (hasId()) {
            modifiedUserId = 1L;
            modifiedFromComputer = "";
            modifiedDate = OffsetDateTime.now();
        } else {
            createdUserId = 1L;
            initiatedFromComputer = "";
            createDate = OffsetDateTime.now();
        }
    }

    public boolean hasId() {
        if(getId() != null)
            return new BigDecimal(Objects.toString(getId(), "0")).compareTo(new BigDecimal(0)) > 0;

        return false;
    }

    public Long getId() {
        return id;
    }

    public Long getCreatedUserId() {
        return createdUserId;
    }

    public String getInitiatedFromComputer() {
        return initiatedFromComputer;
    }

    public OffsetDateTime getCreateDate() {
        return createDate;
    }

    public Long getModifiedUserId() {
        return modifiedUserId;
    }

    public String getModifiedFromComputer() {
        return modifiedFromComputer;
    }

    public OffsetDateTime getModifiedDate() {
        return modifiedDate;
    }
}
