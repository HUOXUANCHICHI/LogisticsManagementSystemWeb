package servlet.Manufacturer;

import Factory.DaoFactory;
import model.Manufacturer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ManufacturerSelectServlet", value = "/ManufacturerSelectServlet")
public class ManufacturerSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
            List<Manufacturer> manufacturers = DaoFactory.manufacturerDaoInstance().selectManufacturer();
            request.getSession().setAttribute("manufacturers", manufacturers);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("manufacturer.jsp");
    }
}
