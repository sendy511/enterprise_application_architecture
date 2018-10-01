package EnterpriseApplicationArchitecture;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class SqlUtil {

    static void ExecuteSql() {
        DriverManagerDataSource dataSource = getDriverManagerDataSource();

        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        jdbcTemplate.execute("Select * from enterprice_appliation_architecture.product");
    }

    static List queryForList(String sql, RowMapper rowMapper) {
        DriverManagerDataSource dataSource = getDriverManagerDataSource();

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List query = jdbcTemplate.query(sql, rowMapper);
        return query;
    }

    private static DriverManagerDataSource getDriverManagerDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        INSERT INTO "data_source" values (100, 'testdb1', 'org.postgresql.Driver', 'jdbc:postgresql://localhost:5432/postgres',

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/");
        dataSource.setUsername("postgres");
        dataSource.setPassword("123456");
        return dataSource;
    }

}
