package servlet.driver;

import Factory.DaoFactory;
import lombok.extern.slf4j.Slf4j;
import model.Driver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Slf4j
@WebServlet(name = "DriverInsertServlet", value = "/DriverInsertServlet")
public class DriverInsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Driver driver = new Driver();
        driver.setDriverId(Integer.parseInt(request.getParameter("driverId")));
        driver.setDriverName(request.getParameter("driverName"));
        driver.setTelephone(request.getParameter("telephone"));
        driver.setDriverAddress(request.getParameter("driverAddress"));
        try {
            if (DaoFactory.driverDaoInstance().insertDriver(driver)) {
                log.info("driver.add...");
                request.getRequestDispatcher("DriverSelectServlet").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
