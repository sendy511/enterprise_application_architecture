package EnterpriseApplicationArchitecture;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ProductTest {

    @Test
    void should_be_true() {
        Product product = new Product();
        Product product1 = product.find("test");
        Assertions.assertNotNull(product1);
    }
}
