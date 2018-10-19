package cn.hgxsp.miaosha_1;

import cn.hgxsp.miaosha_1.dao.GoodsDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Miaosha1ApplicationTests {

    @Autowired
    GoodsDao goodsDao ;

    @Test
    public void contextLoads() {
        goodsDao.reduceStock(2);
    }

}
