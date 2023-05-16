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
@WebServlet(name = "GoodsSelectServletByStock", value = "/GoodsSelectServletByStock")
public class GoodsSelectServletByStock extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Goods> goodsList = DaoFactory.goodsDaoInstance().selectGoods();
            log.info("goods.selectByStock...");
            goodsList.forEach(System.out::println);
            List<Goods> stockCollect = goodsList.stream()
                    .filter(goods -> "库存".equals(goods.getState()))
                    .collect(Collectors.toList());
            System.out.println("----库存后----");
            stockCollect.forEach(System.out::println);
            request.getSession().setAttribute("stockCollect", stockCollect);

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("goodsStateStock.jsp");
    }


}
