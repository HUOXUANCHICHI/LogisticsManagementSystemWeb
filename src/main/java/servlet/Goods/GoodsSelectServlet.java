package servlet.Goods;

import Factory.DaoFactory;
import dao.DriverDao;
import dao.VehicleDao;
import dao.impl.DriverDaoImpl;
import dao.impl.VehicleDaoImpl;
import lombok.extern.slf4j.Slf4j;
import model.Driver;
import model.Goods;
import model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/*@Slf4j
@WebServlet("/GoodsSelectServlet")
public class GoodsSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opt = request.getAttribute("opt") == null ?
                "" : request.getAttribute("opt").toString();
        log.info("opt=" + opt);
        if ("GoodsSelectServlet".equalsIgnoreCase(opt)) {
            goodsSelectServlet(request, response);
        } else if ("GoodsSelectServletByOver".equalsIgnoreCase(opt)) {
            goodsSelectServletByOver(request, response);
        } else if ("GoodsSelectServletByStop".equalsIgnoreCase(opt)) {
            goodsSelectServletByStop(request, response);
        } else if ("GoodsSelectServletByProgress".equalsIgnoreCase(opt)) {
            goodsSelectServletByProgress(request, response);
        } else if ("GoodsSelectServletByArrive".equalsIgnoreCase(opt)) {
            goodsSelectServletByArrive(request, response);
        }

    }

    private void goodsSelectServlet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<Goods> goodsList = DaoFactory.goodsDaoInstance().selectGoods();
            log.info("goods.select...");
            goodsList.forEach(System.out::println);
            List<Goods> collect = goodsList.stream()
                    .filter(goods -> "条件".equals(goods.getState()))
                    .collect(Collectors.toList());

            request.getSession().setAttribute("goodsList", goodsList);

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("goods.jsp");
    }
    private void goodsSelectServletByProgress(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<Goods> goodsList = DaoFactory.goodsDaoInstance().selectGoods();
            log.info("goods.selectByProgress...");
            goodsList.forEach(System.out::println);
            List<Goods> progressCollect = goodsList.stream()
                    .filter(goods -> "运输".equals(goods.getState()))
                    .collect(Collectors.toList());

            request.getSession().setAttribute("progressCollect", progressCollect);

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("goodsStateProgress.jsp");
    }
    private void goodsSelectServletByArrive(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<Goods> goodsList = DaoFactory.goodsDaoInstance().selectGoods();
            log.info("goods.selectByArrive...");
            goodsList.forEach(System.out::println);
            List<Goods> arriveCollect = goodsList.stream()
                    .filter(goods -> "送达".equals(goods.getState()))
                    .collect(Collectors.toList());

            request.getSession().setAttribute("arriveCollect", arriveCollect);

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("goodsStateArrive.jsp");
    }
    private void goodsSelectServletByOver(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<Goods> goodsList = DaoFactory.goodsDaoInstance().selectGoods();
            log.info("goods.selectByOver...");
            goodsList.forEach(System.out::println);
            List<Goods> overCollect = goodsList.stream()
                    .filter(goods -> "验收".equals(goods.getState()))
                    .collect(Collectors.toList());

            request.getSession().setAttribute("overCollect", overCollect);

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("goodsStateOver.jsp");
    }

    private void goodsSelectServletByStop(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<Goods> goodsList = DaoFactory.goodsDaoInstance().selectGoods();
            log.info("goods.selectByStop...");
            goodsList.forEach(System.out::println);
            List<Goods> stopCollect = goodsList.stream()
                    .filter(goods -> "中断".equals(goods.getState()))
                    .collect(Collectors.toList());

            request.getSession().setAttribute("stopCollect", stopCollect);

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("goodsStateStop.jsp");
    }




}*/

@Slf4j
@WebServlet(name = "GoodsSelectServlet", value = "/GoodsSelectServlet")
public class GoodsSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Goods> goodsList = DaoFactory.goodsDaoInstance().selectGoods();
            log.info("goods.select...");
            goodsList.forEach(System.out::println);

            log.info("按状态去重后");
            List<Goods> goodsListByState = goodsList.stream()
                    .collect(Collectors.collectingAndThen(
                            Collectors.toCollection(
                                    () -> new TreeSet<>(
                                            Comparator.comparing(Goods::getState))), ArrayList::new));

            VehicleDao vehicleDao = new VehicleDaoImpl();
            List<Vehicle> vehicleList = vehicleDao.selectVehicle();
            DriverDao driverDao = new DriverDaoImpl();
            List<Driver> driverList = driverDao.selectDriver();
            request.getSession().setAttribute("driverList", driverList);
            request.getSession().setAttribute("vehicleList", vehicleList);
            request.getSession().setAttribute("goodsListByState", goodsListByState);
            request.getSession().setAttribute("goodsList", goodsList);

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("goods.jsp");
    }
}
