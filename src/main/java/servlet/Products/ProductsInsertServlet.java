package servlet.Products;

import Factory.DaoFactory;
import model.Products;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductsInsertServlet", value = "/ProductsInsertServlet")
public class ProductsInsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Products products = new Products();
        products.setProductsId(Integer.parseInt(request.getParameter("productsId")));
        products.setProductsName(request.getParameter("productsName"));
        try {
            if (DaoFactory.productsDaoInstance().insertProducts(products)) {
                request.getRequestDispatcher("ProductsSelectServlet").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
