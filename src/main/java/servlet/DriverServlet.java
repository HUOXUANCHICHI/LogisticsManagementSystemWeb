package servlet;

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

/**
 * @Author: ablaze
 * @Date: 2023/05/15/13:50
 */
@Slf4j
@WebServlet("/Driver/*")
public class DriverServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opt = request.getAttribute("opt") == null ?
                "" : request.getAttribute("opt").toString();
        log.info("opt=" + opt);
        if (opt.equalsIgnoreCase("queryAll.do")) {
            queryAll(request, response);
        } else if (opt.equalsIgnoreCase("add.do")) {
            add(request, response);
        } else if (opt.equalsIgnoreCase("delete.do")) {
            delete(request, response);
        } else if (opt.equalsIgnoreCase("update.do")) {
            update(request, response);
        } else if (opt.equalsIgnoreCase("edit.do")) {
            edit(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Driver driver = new Driver();
        driver.setDriverId(Integer.parseInt(request.getParameter("driverId")));
        driver.setDriverName(request.getParameter("driverName"));
        driver.setTelephone(request.getParameter("telephone"));
        driver.setDriverAddress(request.getParameter("driverAddress"));
        try {
            if (DaoFactory.driverDaoInstance().updateDriver(driver)) {
                log.info("driver.update...");
                request.getRequestDispatcher("driver.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("driver.edit...");
        request.getRequestDispatcher("driver_update.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int driverId = Integer.parseInt(request.getParameter("driverId"));
        try {
            if (DaoFactory.driverDaoInstance().deleteDriver(driverId)) {
                log.info("driver.delete...");
                request.getRequestDispatcher("driver.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Driver driver = new Driver();
        driver.setDriverId(Integer.parseInt(request.getParameter("driverId")));
        driver.setDriverName(request.getParameter("driverName"));
        driver.setTelephone(request.getParameter("telephone"));
        driver.setDriverAddress(request.getParameter("driverAddress"));
        try {
            if (DaoFactory.driverDaoInstance().insertDriver(driver)) {
                log.info("driver.add...");
                request.getRequestDispatcher("driver.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void queryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Driver> driverList = DaoFactory.driverDaoInstance().selectDriver();
            log.info("driver.queryAll...");
            driverList.forEach(System.out::println);
            request.setAttribute("driverList", driverList);

            request.getRequestDispatcher("driver.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
