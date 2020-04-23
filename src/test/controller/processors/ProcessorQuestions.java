package test.controller.processors;

import test.dao.DAOConnection;
import test.dao.OracleDAOConnection;
import test.model.ProcessorResult;

import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;

public class ProcessorQuestions extends Processor{
    public ProcessorQuestions() {action = "questions";}
    @Override
    public ProcessorResult getResult(HttpServletRequest request) {
        Session session = (Session) request.getSession();
        return null;
        //return new ProcessorResult("")

    }
}
