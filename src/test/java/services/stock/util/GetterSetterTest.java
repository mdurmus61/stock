package services.stock.util;

import org.junit.Test;

public class GetterSetterTest {
    @Test
    public void test_services_stock_dto() {
        TestUtil.validatePackage("services.stock.dto");
    }

    @Test
    public void test_services_stock_entity() {
        TestUtil.validatePackage("services.stock.entity");
    }

    @Test
    public void test_services_stock_entity_base() {
        TestUtil.validatePackage("services.stock.entity.base");
    }

    @Test
    public void test_services_stock_request() {
        TestUtil.validatePackage("services.stock.request");
    }

    @Test
    public void test_services_stock_response() {
        TestUtil.validatePackage("services.stock.response");
    }

    @Test
    public void test_services_stock_exception() {
        TestUtil.validatePackage("services.stock.exception");
    }
}
