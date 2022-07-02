package services.stock.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import services.stock.controller.constants.ApiEndpoints;
import services.stock.exception.StockException;
import services.stock.response.ImageResponse;
import services.stock.response.StringResponse;
import services.stock.service.ImageCommandService;
import services.stock.service.ImageQueryService;
import services.stock.util.IdGenerator;

import java.io.IOException;

@RestController
@RequestMapping(value = ApiEndpoints.IMAGE_API, produces = { ApiEndpoints.RESPONSE_CONTENT_TYPE}, consumes = {
        MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class ImageController {
    private final IdGenerator idGenerator;
    private final ImageCommandService commandService;
    private final ImageQueryService queryService;

    @Autowired
    public ImageController(ImageCommandService commandService, ImageQueryService queryService) {
        this.idGenerator = new IdGenerator(0);
        this.commandService = commandService;
        this.queryService = queryService;
    }

    @PostMapping(value = "/create", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "", notes = "Save Image With Code")
    public StringResponse createImage(@RequestParam("code") String code, @RequestPart(required = true, name = "file") MultipartFile file) {
        byte[] contents;
        try {
            contents = file.getBytes();
        } catch (IOException e) {
            throw new StockException("RUN_TIME", "CREATE_IMAGE", e.getMessage(), e.getCause());
        }
        return new StringResponse(idGenerator.getString(), commandService.createImage(code, contents));
    }

    @PostMapping(value = "/update", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "", notes = "Update Image By Code")
    public StringResponse updateImage(@RequestParam("code") String code, @RequestPart(required = true, name = "file") MultipartFile file) {
        byte[] contents;
        try {
            contents = file.getBytes();
        } catch (IOException e) {
            throw new StockException("RUN_TIME", "UPDATE_IMAGE", e.getMessage(), e.getCause());
        }
        return new StringResponse(idGenerator.getString(), commandService.updateImage(code, contents));
    }

    @GetMapping(value = "/get/{CODE}", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "", notes = "Get Image By Code")
    public ImageResponse getImageByCode(@PathVariable("CODE") String code){
        return new ImageResponse(idGenerator.getString(), queryService.getImageByCode(code));
    }
}
