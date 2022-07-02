package services.stock.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import services.stock.repository.UserRepository;
import services.stock.service.impl.StockService;

@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@DataJpaTest(includeFilters = @ComponentScan.Filter(classes = {Service.class}))
public class StockServiceTest {

    @Autowired
    private UserRepository userRepository;

    private StockService stockService;

    @Before
    public void setup() {
        stockService = new StockService();
    }

    @Test
    public void simple_test() {
        Assert.assertEquals(1, 1);
        Assert.assertTrue(true);
    }
}
