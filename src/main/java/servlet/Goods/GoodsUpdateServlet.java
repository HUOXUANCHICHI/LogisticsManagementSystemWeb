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

@Slf4j
@WebServlet(name = "GoodsUpdateServlet", value = "/GoodsUpdateServlet")
public class GoodsUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Goods goods = new Goods();
        goods.setGoodsId(Integer.parseInt(request.getParameter("goodsId")));
        goods.setGoodsName(request.getParameter("goodsName"));
        goods.setGoodsAddress(request.getParameter("goodsAddress"));
        goods.setGoodsWeight(request.getParameter("goodsWeight"));
        goods.setRange(request.getParameter("range"));
        goods.setCustomName(request.getParameter("customName"));
        goods.setState(request.getParameter("state"));
        goods.setDate(request.getParameter("date"));

        try {
            if (DaoFactory.goodsDaoInstance().updateGoods(goods)) {
                log.info("Goods.update...");
                request.getRequestDispatcher("GoodsSelectServlet").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
