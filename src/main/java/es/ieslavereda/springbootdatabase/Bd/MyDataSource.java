package es.ieslavereda.springbootdatabase.Bd;

import com.mysql.cj.jdbc.MysqlDataSource;
import oracle.jdbc.datasource.impl.OracleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import java.sql.SQLException;
@Configuration
public class MyDataSource {
    @Bean(name = "oracleDataSource")
    public static DataSource getOracleDataSorce() throws SQLException {
        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setUser("C##_1DAWDEVIS");
        dataSource.setPassword("1234");
        dataSource.setURL("jdbc:oracle:thin:@//172.28.201.239/xe");
        return dataSource;
    }
    @Bean(name = "mysqlDataSource")
    public static DataSource getMySQLDataSorce() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("jalonso");
        dataSource.setPassword("1111");
        dataSource.setURL("jdbc:mysql://localhost:3306/java");
        return dataSource;
    }
}
