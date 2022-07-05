package services.stock.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import services.stock.controller.constants.ApiEndpoints;
import services.stock.request.CreateRatesRequest;
import services.stock.response.CreateRatesResponse;
import services.stock.service.RateCommandService;
import services.stock.service.RateQueryService;
import services.stock.util.IdGenerator;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping(value = ApiEndpoints.RATE_API, produces = { ApiEndpoints.RESPONSE_CONTENT_TYPE}, consumes = {
        MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class RateController {
    private final IdGenerator idGenerator;
    private final RateCommandService commandService;
    private final RateQueryService queryService;

    @Autowired
    public RateController(RateCommandService commandService, RateQueryService queryService) {
        this.idGenerator = new IdGenerator(0);
        this.commandService = commandService;
        this.queryService = queryService;
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "", notes = "Save Rate With Currency Code")
    public CreateRatesResponse createRates(@Valid @RequestBody CreateRatesRequest request) {
        return new CreateRatesResponse(idGenerator.getString(), commandService.createRates(request.getCreateDTOS()));
    }

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "", notes = "Update Rates By Currency Code")
    public CreateRatesResponse updateRates(@Valid @RequestBody CreateRatesRequest request) {
        return new CreateRatesResponse(idGenerator.getString(), commandService.updateRates(request.getCreateDTOS()));
    }

    @GetMapping(value = "/get/{CURRENCY_CODE}", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "", notes = "Get Rate By Code")
    public CreateRatesResponse getRateByCode(HttpServletRequest httpServletRequest, @PathVariable("CURRENCY_CODE") String currencyCode){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        SecurityContext ctx = SecurityContextHolder.getContext();
        return new CreateRatesResponse(idGenerator.getString(), queryService.getRateByCode(currencyCode));
    }

    @GetMapping(value = "/all", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "", notes = "Get All Rates")
    public CreateRatesResponse getAllRates(){
        return new CreateRatesResponse(idGenerator.getString(), queryService.getAllRates());
    }
}
