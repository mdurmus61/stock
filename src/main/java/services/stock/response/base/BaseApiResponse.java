package services.stock.response.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel
public class BaseApiResponse implements Serializable {
    @ApiModelProperty(notes = "Unique identifier of this response, should be the same if there is a related input request")
    @NotEmpty
    private String id;

    private boolean success = true;

    @NotNull
    @ApiModelProperty(notes = "When this response is generated in epoch milliseconds")
    private Long timestamp = System.currentTimeMillis();

    public BaseApiResponse() {
        this.timestamp = System.currentTimeMillis();
    }

    public BaseApiResponse(String id, boolean success) {
        this.timestamp = System.currentTimeMillis();
        this.id = id;
        this.success = success;
    }
}
