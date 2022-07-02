package services.stock.controller.constants;

import org.springframework.http.MediaType;

public final class ApiEndpoints {

    public static final String RESPONSE_CONTENT_TYPE = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8";

    public static final String API_BASE_URL = "/api";

    public static final String USER_API = API_BASE_URL + "/user";
    public static final String IMAGE_API = API_BASE_URL + "/image";
    public static final String STOCK_API = API_BASE_URL + "/stock";
    public static final String RATE_API = API_BASE_URL + "/rate";
    public static final String PRODUCT_API = API_BASE_URL + "/product";
    public static final String WAREHOUSE_API = API_BASE_URL + "/warehouse";


    public static final ApiEndpoints instance = new ApiEndpoints();

    private ApiEndpoints() {

    }
}
