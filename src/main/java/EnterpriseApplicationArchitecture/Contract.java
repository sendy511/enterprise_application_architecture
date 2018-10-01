package EnterpriseApplicationArchitecture;

import java.util.Date;
import lombok.Data;

@Data
public class Contract {
    private int id;
    private Product product;
    private double revenue;
    private Date signedDate;
}
