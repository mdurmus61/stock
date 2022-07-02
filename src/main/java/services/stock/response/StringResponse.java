package services.stock.response;

import services.stock.response.base.BaseApiResponse;

public class StringResponse extends BaseApiResponse {
    private String retValue;

    public StringResponse(String id, String retValue) {
        super(id, true);
        this.retValue = retValue;
    }

    public String getRetValue() {
        return retValue;
    }

    public void setRetValue(String retValue) {
        this.retValue = retValue;
    }
}
