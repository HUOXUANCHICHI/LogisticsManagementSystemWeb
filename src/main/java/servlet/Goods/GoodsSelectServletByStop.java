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
@WebServlet(name = "GoodsSelectServletByStop", value = "/GoodsSelectServletByStop")
public class GoodsSelectServletByStop extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Goods> goodsList = DaoFactory.goodsDaoInstance().selectGoods();
            log.info("goods.selectByStop...");
            goodsList.forEach(System.out::println);
            List<Goods> stopCollect = goodsList.stream()
                    .filter(goods -> "中断".equals(goods.getState()))
                    .collect(Collectors.toList());
            System.out.println("----中断后----");
            stopCollect.forEach(System.out::println);
            request.getSession().setAttribute("stopCollect", stopCollect);

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("goodsStateStop.jsp");
    }


}
