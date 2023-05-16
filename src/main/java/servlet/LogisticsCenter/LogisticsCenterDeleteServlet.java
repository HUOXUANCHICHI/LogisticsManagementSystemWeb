package servlet.LogisticsCenter;

import Factory.DaoFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogisticsCenterDeleteServlet", value = "/LogisticsCenterDeleteServlet")
public class LogisticsCenterDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int logisticsCenterId = Integer.parseInt(request.getParameter("logisticsCenterId"));
        try {
            if (DaoFactory.logisticsCenterDaoInstance().deleteLogisticsCenter(logisticsCenterId)) {
                request.getRequestDispatcher("LogisticsCenterSelectServlet").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
