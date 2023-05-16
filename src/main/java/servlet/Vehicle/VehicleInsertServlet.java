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

@Slf4j
@WebServlet(name = "VehicleInsertServlet", value = "/VehicleInsertServlet")
public class VehicleInsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId(Integer.parseInt(request.getParameter("vehicleId")));
        vehicle.setCarNumber(request.getParameter("carNumber"));
        vehicle.setDescription(request.getParameter("description"));
        try {
            if (DaoFactory.vehicleDaoInstance().insertVehicle(vehicle)) {
                log.info("vehicle.add...");
                request.getRequestDispatcher("VehicleSelectServlet").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
