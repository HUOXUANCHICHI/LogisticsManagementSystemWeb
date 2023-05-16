package servlet.Retailer;

import Factory.DaoFactory;
import model.Retailer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RetailerInsertServlet", value = "/RetailerInsertServlet")
public class RetailerInsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Retailer retailer = new Retailer();
        retailer.setRetailerId(Integer.parseInt(request.getParameter("retailerId")));
        retailer.setRetName(request.getParameter("retName"));
        retailer.setRetAdd(request.getParameter("retAdd"));
        retailer.setRetCon(request.getParameter("retCon"));
        retailer.setProductsName(request.getParameter("productsName"));
        try {
            if (DaoFactory.retailerDaoInstance().insertRetailer(retailer)) {
                request.getRequestDispatcher("RetailerSelectServlet").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
