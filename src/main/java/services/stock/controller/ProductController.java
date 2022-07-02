package services.stock.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import services.stock.controller.constants.ApiEndpoints;
import services.stock.request.CreateProductsRequest;
import services.stock.response.CreateProductsResponse;
import services.stock.service.ProductCommandService;
import services.stock.service.ProductQueryService;
import services.stock.util.IdGenerator;

import javax.validation.Valid;

@RestController
@RequestMapping(value = ApiEndpoints.PRODUCT_API, produces = { ApiEndpoints.RESPONSE_CONTENT_TYPE}, consumes = {
        MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class ProductController {
    private final IdGenerator idGenerator;
    private final ProductCommandService commandService;
    private final ProductQueryService queryService;

    @Autowired
    public ProductController(ProductCommandService commandService, ProductQueryService queryService) {
        this.idGenerator = new IdGenerator(0);
        this.commandService = commandService;
        this.queryService = queryService;
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "", notes = "Save Products")
    public CreateProductsResponse createProducts(@Valid @RequestBody CreateProductsRequest request) {
        return new CreateProductsResponse(idGenerator.getString(), commandService.createProducts(request.getCreateDTOS()));
    }

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "", notes = "Update Products")
    public CreateProductsResponse updateProducts(@Valid @RequestBody CreateProductsRequest request) {
        return new CreateProductsResponse(idGenerator.getString(), commandService.updateProducts(request.getCreateDTOS()));
    }

    @GetMapping(value = "/get/{TYPE}/{NAME}", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "", notes = "Get Product By Type and Name")
    public CreateProductsResponse getProductByTypeAndName(@PathVariable("TYPE") String type, @PathVariable("NAME") String name){
        return new CreateProductsResponse(idGenerator.getString(), queryService.getProductByTypeAndName(type, name));
    }

    @GetMapping(value = "/all", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "", notes = "Get All Products")
    public CreateProductsResponse getAllProducts(){
        return new CreateProductsResponse(idGenerator.getString(), queryService.getAllProducts());
    }
}
