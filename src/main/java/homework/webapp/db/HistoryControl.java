package homework.webapp.db;

import homework.webapp.beans.History;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class HistoryControl {
    public static History[] getHistory(int selectId) {
        // открываем соединение
        try (Connection connection = DBConnection.openDBConnection()) {
            // 1. создать выражение
            assert connection != null;
            Statement statement = connection.createStatement();
            // 2. выполнить запрос
            ResultSet queryResult = statement.executeQuery(
                    "SELECT * FROM history AS H WHERE H.ManufacturerId = " + selectId);
            // 3. Перебор результатов
            LinkedList<History> historyList = new LinkedList<>();
            while (queryResult.next()) {
                int id = queryResult.getInt(1);
                String content = queryResult.getString(2);
                String type = queryResult.getString(3);
                int manufacturerId = queryResult.getInt(4);

                History history = new History(id, content, type, manufacturerId);
                historyList.add(history);
            }
            // 4. вернуть результат
            return historyList.toArray(new History[0]);
        } catch (SQLException e) {
            return null;
        }
    }
}
