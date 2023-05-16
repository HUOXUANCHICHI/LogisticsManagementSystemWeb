package servlet.Goods;

import dao.GoodsDao;
import dao.impl.GoodsDaoImpl;
import lombok.extern.slf4j.Slf4j;
import model.Goods;

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

            request.getSession().setAttribute("goodsListByState", goodsListByState);
            request.getSession().setAttribute("goods", goods);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("goods_update.jsp").forward(request, response);
    }
}
