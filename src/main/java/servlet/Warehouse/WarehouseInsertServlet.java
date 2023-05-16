package servlet.Warehouse;

import Factory.DaoFactory;
import model.Warehouse;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "WarehouseInsertServlet", value = "/WarehouseInsertServlet")
public class WarehouseInsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Warehouse warehouse = new Warehouse();
        warehouse.setWarehouseId(Integer.parseInt(request.getParameter("warehouseId")));
        warehouse.setWareName(request.getParameter("wareName"));
        warehouse.setWareAdd(request.getParameter("wareAdd"));
        warehouse.setProductsName(request.getParameter("productsName"));
        try {
            if (DaoFactory.warehouseDaoInstance().insertWarehouse(warehouse)) {
                request.getRequestDispatcher("WarehouseSelectServlet").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
