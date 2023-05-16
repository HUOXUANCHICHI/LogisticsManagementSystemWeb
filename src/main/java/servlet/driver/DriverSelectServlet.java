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
import java.util.List;
@Slf4j
@WebServlet(name = "DriverSelectServlet", value = "/DriverSelectServlet")
public class DriverSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Driver> driverList = DaoFactory.driverDaoInstance().selectDriver();
            log.info("driver.select...");
            driverList.forEach(System.out::println);
            request.getSession().setAttribute("driverList", driverList);

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("driver.jsp");
    }
}
