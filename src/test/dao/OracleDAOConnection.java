package test.dao;

import oracle.jdbc.driver.OracleDriver;
import test.model.Question;
import test.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleDAOConnection implements DAOConnection {
    private static OracleDAOConnection oracleDAOConnection;

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private Driver driver;

    public OracleDAOConnection() {
        super();
    }

    public static OracleDAOConnection getInstance() {
        if (oracleDAOConnection != null) {
            return oracleDAOConnection;
        } else {
            oracleDAOConnection = new OracleDAOConnection();
            return oracleDAOConnection;
        }
    }


    @Override
    public void connect() {
        driver = new OracleDriver();
        try {
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "QUESTIONS", "12345");
            if (!connection.isClosed()) {
                System.out.println("Connected successful!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void disconnect() {
        try {
            connection.close();
            if(resultSet != null) resultSet.close();
            if(statement != null) statement.close();
            System.out.println("Connection was closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //---------READ-------------
    @Override
    public List<Question> selectAllQuestions() {
            connect();
        List<Question> questions = new ArrayList<>();
        try {
            statement = connection.prepareStatement("SELECT * FROM QUESTIONS ");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                questions.add(parseQuestion(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
        return questions;
    }

    public User getUserByName(String userName) {
        User user = null;
        connect();
        try {
            statement = connection.prepareStatement("SELECT FROM USERS WHERE NAME = ?");
            statement.setString(1, "userName");
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
               // user = parseUser(resultSet)
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        disconnect();
        return null;

    }

    private Question parseQuestion(ResultSet resultSet) {

        Question question = null;
        try {
            int id = resultSet.getInt("ID");
            String questionStr = resultSet.getString("QUESTION");
            String answer = resultSet.getString("ANSWER");
            int points = resultSet.getInt("POINTS");
            question = new Question(id, questionStr, answer, points);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return question;
    }


    private User parseUser(ResultSet resultSet) {

        User user = null;
        try {
            int id = resultSet.getInt("ID");
            String name = resultSet.getString("NAME");
            int points = resultSet.getInt("MAX_TOTAL_POINTS");
            user = new User(id, name, points);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
