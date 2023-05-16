package servlet.Goods;

import Factory.DaoFactory;
import lombok.extern.slf4j.Slf4j;
import model.Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@WebServlet(name = "GoodsSelectServletByArrive", value = "/GoodsSelectServletByArrive")
public class GoodsSelectServletByArrive extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Goods> goodsList = DaoFactory.goodsDaoInstance().selectGoods();
            log.info("goods.selectByArrive...");
            goodsList.forEach(System.out::println);
            List<Goods> arriveCollect = goodsList.stream()
                    .filter(goods -> "送达".equals(goods.getState()))
                    .collect(Collectors.toList());
            System.out.println("----送达后----");
            arriveCollect.forEach(System.out::println);
            request.getSession().setAttribute("arriveCollect", arriveCollect);

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("goodsStateArrive.jsp");
    }


}
