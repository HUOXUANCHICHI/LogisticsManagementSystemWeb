package servlet.Goods;

import dao.DriverDao;
import dao.GoodsDao;
import dao.VehicleDao;
import dao.impl.DriverDaoImpl;
import dao.impl.GoodsDaoImpl;
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

@Slf4j
@WebServlet(name = "GoodsDispatcherServlet", value = "/GoodsDispatcherServlet")
public class GoodsDispatcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("goods.edit...");
        int goodsId = Integer.parseInt(request.getParameter("goodsId"));
        GoodsDao goodsDao = new GoodsDaoImpl();
        try {
            List<Goods> goodsList = goodsDao.selectGoods();
            Goods goods = goodsDao.selectGoodsById(goodsId);
            log.info("按状态去重后");
            List<Goods> goodsListByState = goodsList.stream()
                    .collect(Collectors.collectingAndThen(
                            Collectors.toCollection(
                                    () -> new TreeSet<>(
                                            Comparator.comparing(Goods::getState))), ArrayList::new));
//                    .forEach(System.out::println);

            VehicleDao vehicleDao = new VehicleDaoImpl();
            List<Vehicle> vehicleList = vehicleDao.selectVehicle();
            DriverDao driverDao = new DriverDaoImpl();
            List<Driver> driverList = driverDao.selectDriver();
            request.getSession().setAttribute("driverList", driverList);
            request.getSession().setAttribute("vehicleList", vehicleList);
            request.getSession().setAttribute("goodsListByState", goodsListByState);
            request.getSession().setAttribute("goods", goods);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("goods_update.jsp").forward(request, response);
    }
}
