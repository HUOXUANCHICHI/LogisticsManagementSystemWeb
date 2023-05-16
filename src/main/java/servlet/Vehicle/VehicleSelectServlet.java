package servlet.Vehicle;

import Factory.DaoFactory;
import lombok.extern.slf4j.Slf4j;
import model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Slf4j
@WebServlet(name = "VehicleSelectServlet", value = "/VehicleSelectServlet")
public class VehicleSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Vehicle> vehicleList = DaoFactory.vehicleDaoInstance().selectVehicle();
            log.info("vehicle.select...");
            request.getSession().setAttribute("vehicleList", vehicleList);

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("vehicle.jsp");
    }
}
