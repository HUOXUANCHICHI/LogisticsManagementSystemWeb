package servlet.Warehouse;

import Factory.DaoFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "WarehouseDeleteServlet", value = "/WarehouseDeleteServlet")
public class WarehouseDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int warehouseId = Integer.parseInt(request.getParameter("warehouseId"));
        try {
            if (DaoFactory.warehouseDaoInstance().deleteWarehouse(warehouseId)) {
                request.getRequestDispatcher("WarehouseSelectServlet").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
