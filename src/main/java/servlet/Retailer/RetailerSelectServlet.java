package servlet.Retailer;

import Factory.DaoFactory;
import model.Retailer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RetailerSelectServlet", value = "/RetailerSelectServlet")
public class RetailerSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
            List<Retailer> retailers = DaoFactory.retailerDaoInstance().selectRetailer();
            request.getSession().setAttribute("retailers", retailers);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("retailer.jsp");
    }
}
