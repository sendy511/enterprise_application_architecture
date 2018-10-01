package EnterpriseApplicationArchitecture;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import lombok.Data;
import org.springframework.jdbc.core.RowMapper;

@Data
public class RevenueRecognition {
    private Contract contract;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    private double amount;

    public Date getRecognizedOn() {
        return recognizedOn;
    }

    public void setRecognizedOn(Date recognizedOn) {
        this.recognizedOn = recognizedOn;
    }

    private Date recognizedOn;

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    private int contractId;

    public Double findRecognitionFor(int contractId){
        List<RevenueRecognition> objects = (List<RevenueRecognition>)SqlUtil.queryForList(
            "Select \"contractId\", \"amount\", \"recongnizedOn\" from enterprice_appliation_architecture.revenuerecognition where \"contractId\" = " + contractId,
            new RevenueRecognitionRowMapper());

//        return objects.stream().reduce(0D, new BiFunction<Double, RevenueRecognition, Double>() {
//            @Override
//            public Double apply(Double aDouble, RevenueRecognition revenueRecognition) {
//                return aDouble + revenueRecognition.getAmount();
//            }
//        }, new BinaryOperator<RevenueRecognition>(){
//                @Override
//                public RevenueRecognition apply(RevenueRecognition revenueRecognition,
//                    RevenueRecognition revenueRecognition2) {
//                    return null;
//                }
//            }
//        );
        return objects.stream()
            .map(RevenueRecognition::getAmount)
            .reduce((x1, x2) -> x1 + x2)
            .get();
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
