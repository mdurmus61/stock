package services.stock.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import services.stock.controller.constants.ApiEndpoints;
import services.stock.request.CreateProductsRequest;
import services.stock.request.CreateWarehousesRequest;
import services.stock.response.CreateProductsResponse;
import services.stock.response.CreateWarehousesResponse;
import services.stock.service.ProductCommandService;
import services.stock.service.ProductQueryService;
import services.stock.service.WarehouseCommandService;
import services.stock.service.WarehouseQueryService;
import services.stock.util.IdGenerator;

import javax.validation.Valid;

@RestController
@RequestMapping(value = ApiEndpoints.WAREHOUSE_API, produces = { ApiEndpoints.RESPONSE_CONTENT_TYPE}, consumes = {
        MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class WarehouseController {
    private final IdGenerator idGenerator;
    private final WarehouseCommandService commandService;
    private final WarehouseQueryService queryService;

    @Autowired
    public WarehouseController(WarehouseCommandService commandService, WarehouseQueryService queryService) {
        this.idGenerator = new IdGenerator(0);
        this.commandService = commandService;
        this.queryService = queryService;
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "", notes = "Save Warehouse")
    public CreateWarehousesResponse createWarehouse(@Valid @RequestBody CreateWarehousesRequest request) {
        return new CreateWarehousesResponse(idGenerator.getString(), commandService.createWarehouse(request.getCreateDTOS()));
    }

    @GetMapping(value = "/code/{CODE}", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "", notes = "Get Warehouse By Code")
    public CreateWarehousesResponse getWarehouseByCode(@PathVariable("CODE") String code){
        return new CreateWarehousesResponse(idGenerator.getString(), queryService.getWarehouseByCode(code));
    }

    @GetMapping(value = "/all", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "", notes = "Get All Warehouses")
    public CreateWarehousesResponse getAllWarehouses(){
        return new CreateWarehousesResponse(idGenerator.getString(), queryService.getAllWarehouses());
    }

    @GetMapping(value = "/district/{DISTRICT}", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "", notes = "Get All Warehouses By District")
    public CreateWarehousesResponse getAllWarehousesByDistrict(@PathVariable("DISTRICT") String district){
        return new CreateWarehousesResponse(idGenerator.getString(), queryService.getAllWarehousesByDistrict(district));
    }

    @GetMapping(value = "/city/{CITY}", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "", notes = "Get All Warehouses By City")
    public CreateWarehousesResponse getAllWarehousesByCity(@PathVariable("CITY") String city){
        return new CreateWarehousesResponse(idGenerator.getString(), queryService.getAllWarehousesByCity(city));
    }
}
