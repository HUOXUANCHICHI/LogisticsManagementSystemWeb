package servlet.Retailer;

import Factory.DaoFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RetailerDeleteServlet", value = "/RetailerDeleteServlet")
public class RetailerDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int retailerId = Integer.parseInt(request.getParameter("retailerId"));
        try {
            if (DaoFactory.retailerDaoInstance().deleteRetailer(retailerId)) {
                request.getRequestDispatcher("RetailerSelectServlet").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
