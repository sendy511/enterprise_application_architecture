package EnterpriseApplicationArchitecture;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RevenueRecognitionTest {

    @Test
    void should_be_able_to_get_total_mount() {
        RevenueRecognition revenueRecognition = new RevenueRecognition();
        double recognition = revenueRecognition.findRecognitionFor(1);
        Assertions.assertEquals(100, recognition);
    }
}
