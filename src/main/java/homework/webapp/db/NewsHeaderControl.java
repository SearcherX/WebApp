package homework.webapp.db;

import homework.webapp.beans.NewsHeader;

import java.sql.*;
import java.util.LinkedList;

public class NewsHeaderControl {
    public static NewsHeader[] getNewsHeaderByManufacturerId(int selectId) {
        // открываем соединение
        try (Connection connection = DBConnection.openDBConnection()) {
            // 1. создать выражение
            assert connection != null;
            String queryString = "SELECT * FROM NewsHeader AS H WHERE H.ManufacturerId =?";
            PreparedStatement preparedStatement = connection.prepareStatement(queryString);
            preparedStatement.setInt(1, selectId);
            ResultSet queryResult = preparedStatement.executeQuery();

            // 3. Перебор результатов
            LinkedList<NewsHeader> newsHeaderList = new LinkedList<>();
            while (queryResult.next()) {
                int id = queryResult.getInt(1);
                String content = queryResult.getString(2);
                String type = queryResult.getString(3);
                int manufacturerId = queryResult.getInt(4);

                NewsHeader newsHeader = new NewsHeader(id, content, type, manufacturerId);
                newsHeaderList.add(newsHeader);
            }
            // 4. вернуть результат
            return newsHeaderList.toArray(new NewsHeader[0]);
        } catch (SQLException e) {
            return null;
        }
    }

    public static NewsHeader getNewsHeaderById(int selectId) {
        // открываем соединение
        try (Connection connection = DBConnection.openDBConnection()) {
            // 1. создать выражение
            assert connection != null;
            String queryString = "SELECT * FROM NewsHeader WHERE Id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(queryString);
            preparedStatement.setInt(1, selectId);
            ResultSet queryResult = preparedStatement.executeQuery();

            if (queryResult.next()) {
                int id = queryResult.getInt(1);
                String content = queryResult.getString(2);
                String type = queryResult.getString(3);
                int manufacturerId = queryResult.getInt(4);

                return new NewsHeader(id, content, type, manufacturerId);
            }
        } catch (SQLException ignored) {
        }
        return null;
    }
}
