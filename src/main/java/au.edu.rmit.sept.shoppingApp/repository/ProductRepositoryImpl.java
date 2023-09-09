package au.edu.rmit.sept.shoppingApp.repository;

import au.edu.rmit.sept.shoppingApp.model.Product;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.datasource.init.UncategorizedScriptException;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {


    //replace when added database in application properties
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:file:/tmp/demodb");
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("password");
        return dataSourceBuilder.build();
    }

    @Override
    public List<Product> listAll() {
        try {
            Connection connection = this.getDataSource().getConnection();
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM Products;");
            List<Product> Products = new ArrayList<>();
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3));
                Products.add(p);
            }
            connection.close();
            return Products;
        } catch (SQLException e) {
            throw new UncategorizedScriptException("Error in listAll", e);
        }
    }
}
