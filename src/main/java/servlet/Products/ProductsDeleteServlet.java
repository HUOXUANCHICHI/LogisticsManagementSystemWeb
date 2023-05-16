package servlet.Products;

import Factory.DaoFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductsDeleteServlet", value = "/ProductsDeleteServlet")
public class ProductsDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productsId = Integer.parseInt(request.getParameter("productsId"));
        try {
            if (DaoFactory.productsDaoInstance().deleteProducts(productsId)) {
                request.getRequestDispatcher("ProductsSelectServlet").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
