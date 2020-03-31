package com.boots.repository.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
@Repository
public class LetterStateDao {
    @Value("${spring.datasource.url}")
    public String url;
    @Value("${spring.datasource.username}")
    public String username;
    @Value("${spring.datasource.password}")
    public String password;

    public int getLastTry(Long gameId) {
        try(Connection connection = DriverManager.getConnection(url,username, password);
                PreparedStatement statement = connection.prepareStatement("select coalesce(max(trial_number), 0) as max_number from letter_state where game_id =?")) {
            statement.setLong(1, gameId);
            try(ResultSet rs = statement.executeQuery()){
                    if (rs.next()) {
                        return rs.getInt("max_number");
                    }
                }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
