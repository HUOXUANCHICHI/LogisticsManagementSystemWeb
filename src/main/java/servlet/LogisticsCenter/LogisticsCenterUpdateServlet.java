package servlet.LogisticsCenter;

import Factory.DaoFactory;
import model.LogisticsCenter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogisticsCenterUpdateServlet", value = "/LogisticsCenterUpdateServlet")
public class LogisticsCenterUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        LogisticsCenter logisticsCenter = new LogisticsCenter();
        logisticsCenter.setLogisticsCenterId(Integer.parseInt(request.getParameter("logisticsCenterId")));
        logisticsCenter.setLogisticsCenName(request.getParameter("logisticsCenName"));
        logisticsCenter.setLogisticsCenAdd(request.getParameter("logisticsCenAdd"));
        try {
            if (DaoFactory.logisticsCenterDaoInstance().updateLogisticsCenter(logisticsCenter)) {
                request.getRequestDispatcher("LogisticsCenterSelectServlet").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
