package servlet.Manufacturer;

import Factory.DaoFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ManufacturerDeleteServlet", value = "/ManufacturerDeleteServlet")
public class ManufacturerDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int manufacturerId = Integer.parseInt(request.getParameter("manufacturerId"));
        try {
            if (DaoFactory.manufacturerDaoInstance().deleteManufacturer(manufacturerId)) {
                request.getRequestDispatcher("ManufacturerSelectServlet").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
