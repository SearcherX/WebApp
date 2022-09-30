package homework.webapp.db;

import homework.webapp.beans.Manufacturer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class ManufacturerControl {
    public static Manufacturer[] getAllManufacturers() {
        // открываем соединение
        try (Connection connection = DBConnection.openDBConnection()) {
            // 1. создать выражение
            assert connection != null;
            Statement statement = connection.createStatement();
            // 2. выполнить запрос
            ResultSet queryResult = statement.executeQuery("SELECT * FROM manufacturers");
            // 3. Перебор результатов
            LinkedList<Manufacturer> manufacturersList = new LinkedList<>();
            while (queryResult.next()) {
                int id = queryResult.getInt(1);
                String name = queryResult.getString(2);
                String countryName = queryResult.getString(3);
                String logo = queryResult.getString(4);
                int employeesNumber = queryResult.getInt(5);
                String briefInformation = queryResult.getString(6);

                Manufacturer manufacturer = new Manufacturer(id, name, countryName, logo,
                        employeesNumber, briefInformation);
                manufacturersList.add(manufacturer);
            }
            // 4. вернуть результат
            return manufacturersList.toArray(new Manufacturer[0]);
        } catch (SQLException e) {
            return null;
        }
    }
}


