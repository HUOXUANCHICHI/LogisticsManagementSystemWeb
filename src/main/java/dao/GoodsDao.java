package dao;

import model.Goods;

import java.util.List;

/**
 * @Author: ablaze
 * @Date: 2023/05/15/13:36
 */
public interface GoodsDao {
    List<Goods> selectGoods() throws Exception;

    boolean insertGoods(Goods goods) throws Exception;

    boolean updateGoods(Goods goods) throws Exception;

    boolean deleteGoods(int goodsId) throws Exception;

    Goods selectGoodsById(Integer goodsId) throws Exception;
}
