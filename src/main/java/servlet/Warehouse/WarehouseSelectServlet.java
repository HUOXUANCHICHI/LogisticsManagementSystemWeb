package servlet.Warehouse;

import Factory.DaoFactory;
import model.Warehouse;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "WarehouseSelectServlet", value = "/WarehouseSelectServlet")
public class WarehouseSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
            List<Warehouse> warehouses = DaoFactory.warehouseDaoInstance().warehouseSelect();
            request.getSession().setAttribute("warehouses", warehouses);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("warehouse.jsp");
    }
}
