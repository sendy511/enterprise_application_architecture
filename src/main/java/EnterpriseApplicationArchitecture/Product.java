package EnterpriseApplicationArchitecture;

import lombok.Data;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Data
public class Product {
    private String name;

    private Long id;

    public Product find(String name){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
//        INSERT INTO "data_source" values (100, 'testdb1', 'org.postgresql.Driver', 'jdbc:postgresql://localhost:5432/postgres',

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/");
        dataSource.setUsername("postgres");
        dataSource.setPassword("123456");

        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        jdbcTemplate.execute("Select * from enterprice_appliation_architecture.product");

            return null;
    }
}
