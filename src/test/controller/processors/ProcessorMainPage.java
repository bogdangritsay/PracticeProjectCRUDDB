package test.controller.processors;

        import test.dao.DAOConnection;
        import test.dao.OracleDAOConnection;
        import test.model.ProcessorResult;

        import javax.servlet.http.HttpServletRequest;

public class ProcessorMainPage extends Processor {
    public ProcessorMainPage() {
        action = "mainPage";
    }

    @Override
    public ProcessorResult getResult(HttpServletRequest request) {
        DAOConnection connection = new OracleDAOConnection();

        String userName = request.getParameter("userName");
        request.getSession().setAttribute("userName", userName);
        return new ProcessorResult("/main", "", true);
    }
}
