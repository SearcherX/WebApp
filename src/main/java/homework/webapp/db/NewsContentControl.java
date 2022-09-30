package homework.webapp.db;

import homework.webapp.beans.NewsContent;
import homework.webapp.beans.NewsHeader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class NewsContentControl {

    public static NewsContent[] getNewsContent(int selectId) {
        // открываем соединение
        try (Connection connection = DBConnection.openDBConnection()) {
            // 1. создать выражение
            assert connection != null;
            String queryString = "SELECT * FROM NewsContent AS H WHERE H.NewsHeaderId =?";
            PreparedStatement preparedStatement = connection.prepareStatement(queryString);
            preparedStatement.setInt(1, selectId);
            // 2. получить таблицу результатов
            ResultSet queryResult = preparedStatement.executeQuery();

            // 3. Перебор результатов
            LinkedList<NewsContent> newsContentList = new LinkedList<>();
            while (queryResult.next()) {
                int id = queryResult.getInt(1);
                String content = queryResult.getString(2);
                String type = queryResult.getString(3);
                int newsHeaderId = queryResult.getInt(4);

                NewsContent newsContent = new NewsContent(id, content, type, newsHeaderId);
                newsContentList.add(newsContent);
            }
            // 4. вернуть результат
            return newsContentList.toArray(new NewsContent[0]);
        } catch (SQLException e) {
            return null;
        }
    }
}
