package servlet.Manufacturer;

import Factory.DaoFactory;
import model.Manufacturer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ManufacturerInsertServlet", value = "/ManufacturerInsertServlet")
public class ManufacturerInsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setManufacturerId(Integer.parseInt(request.getParameter("manufacturerId")));
        manufacturer.setManuName(request.getParameter("manuName"));
        manufacturer.setManuAdd(request.getParameter("manuAdd"));
        manufacturer.setManuCon(request.getParameter("manuCon"));
        manufacturer.setProductsName(request.getParameter("productsName"));
        try {
            if (DaoFactory.manufacturerDaoInstance().insertManufacturer(manufacturer)) {
                request.getRequestDispatcher("ManufacturerSelectServlet").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
