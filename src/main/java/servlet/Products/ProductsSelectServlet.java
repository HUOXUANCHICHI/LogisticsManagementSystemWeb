package servlet.Products;

import Factory.DaoFactory;
import model.Products;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductsSelectServlet", value = "/ProductsSelectServlet")
public class ProductsSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
            List<Products> products = DaoFactory.productsDaoInstance().selectProducts();
            request.getSession().setAttribute("products", products);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("products.jsp");
    }
}
