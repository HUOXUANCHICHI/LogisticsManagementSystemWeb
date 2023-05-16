package servlet.Goods;

import Factory.DaoFactory;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(name = "GoodsDeleteServlet", value = "/GoodsDeleteServlet")
public class GoodsDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int goodsId = Integer.parseInt(request.getParameter("goodsId"));
        try {
            if (DaoFactory.goodsDaoInstance().deleteGoods(goodsId)) {
                log.info("goods.delete...");
                request.setAttribute("GoodsSelectServlet","opt");
                request.getRequestDispatcher("GoodsSelectServlet").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
