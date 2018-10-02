package EnterpriseApplicationArchitecture;

import lombok.Data;

@Data
public class Product {
    private String name;

    private long id;

    public Product find(String name){
        SqlUtil.ExecuteSql();

            return null;
    }

    public void calculateRecognization(Contract contract){

    }

}
