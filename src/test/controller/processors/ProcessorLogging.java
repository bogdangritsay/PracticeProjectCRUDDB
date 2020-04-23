package test.controller.processors;

import test.dao.DAOConnection;
import test.dao.OracleDAOConnection;
import test.model.ProcessorResult;

import javax.servlet.http.HttpServletRequest;

public class ProcessorLogging extends  Processor {
    public ProcessorLogging() {action = "login";}
    @Override
    public ProcessorResult getResult(HttpServletRequest request) {
        String name = request.getParameter("user");
        DAOConnection connection = new OracleDAOConnection();

        //......
        return new ProcessorResult("/main", "", true);
    }
}
