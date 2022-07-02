package services.stock.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import services.stock.request.*;
import services.stock.service.impl.StockService;

public class StockControllerTest {

    private StockController stockController;
    private MockMvc mockMvc;
    private ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

    @Before
    public void setup() {
        stockController = new StockController();
        mockMvc = MockMvcBuilders.standaloneSetup(stockController).build();
    }

    @Test
    public void welcome() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/" ))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

}
