package test.dao;

import test.model.Question;


import java.util.List;

public interface DAOConnection {
    void connect();
    void disconnect();
    List<Question> selectAllQuestions(); /*
    void updateStudent(int id, float sum);
    void deleteStudent(int id);*/
}

