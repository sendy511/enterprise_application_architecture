package EnterpriseApplicationArchitecture;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import lombok.Data;
import org.springframework.jdbc.core.RowMapper;

@Data
public class RevenueRecognition {
    private Contract contract;
    private double amount;
    private Date recognizedOn;
    private int contractId;

    public Double findRecognitionFor(int contractId){
        List<RevenueRecognition> objects = (List<RevenueRecognition>)SqlUtil.queryForList(
            "Select \"contractId\", \"amount\", \"recongnizedOn\" from enterprice_appliation_architecture.revenuerecognition where \"contractId\" = " + contractId,
            new RevenueRecognitionRowMapper());
        return objects.stream().reduce(
            0D,
            (aDouble, revenueRecognition) -> aDouble + revenueRecognition.getAmount(),
            (aDouble, aDouble2) -> aDouble
        );
//        return objects.stream()
//            .map(RevenueRecognition::getAmount)
//            .reduce((x1, x2) -> x1 + x2)
//            .get();
    }

    public boolean isRecognized(Date date){
        return 0;
    }
}

class RevenueRecognitionRowMapper implements RowMapper<RevenueRecognition> {

    @Override
    public RevenueRecognition mapRow(ResultSet rs, int rowNum) throws SQLException {
        RevenueRecognition revenueRecognition = new RevenueRecognition();
        revenueRecognition.setContractId(rs.getInt(1));
        revenueRecognition.setAmount(rs.getDouble(2));
        revenueRecognition.setRecognizedOn(rs.getDate(3));
        return revenueRecognition;
    }
}
