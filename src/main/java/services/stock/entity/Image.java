package services.stock.entity;

import com.sun.istack.NotNull;
import services.stock.dto.ImageDTO;
import services.stock.entity.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"code"})})
public class Image extends BaseEntity {

    @NotNull
    private String code;

    @NotNull
    @Lob
    private byte[] image;

    public Image() { }

    public Image(String code, byte[] image) {
        this.applyEntityStamps();
        this.code = code;
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public ImageDTO toDTO() {
        ImageDTO dto = new ImageDTO();
        dto.setId(getId());
        dto.setImage(getImage());
        dto.setCode(getCode());

        return dto;
    }
}
