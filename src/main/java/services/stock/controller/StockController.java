package services.stock.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import services.stock.controller.constants.ApiEndpoints;

@RestController
@RequestMapping(value = ApiEndpoints.STOCK_API, produces = { ApiEndpoints.RESPONSE_CONTENT_TYPE}, consumes = {
        MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class StockController {

}
