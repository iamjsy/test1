package kr.ac.jejunu;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;



public class ProductDaoTest {

    private ProductDao productDao;
    private ProductDao hallaProductDao;

    @Before
    public void setup() {
        productDao = new JejuProductDao();
        hallaProductDao = new HallaProductDao();
    }

    @Test
    public void get() throws SQLException, ClassNotFoundException {
        Long id = 1L;
        String title = "제주감귤";
        Integer price = 15000;

        Product product = productDao.get(id);
        assertEquals(id, product.getId());
        assertEquals(title, product.getTitle());
        assertEquals(price, product.getPrice());
    }

    @Test
    public void add() throws SQLException, ClassNotFoundException {
        Product product = new Product();
        product.setId(4L);
        product.setTitle("제주한라봉");
        product.setPrice(26000);
        Long id = productDao.insert(product);

        Product insertedProduct = productDao.get(id);
        assertThat(insertedProduct.getId(), is(id));
        assertThat(insertedProduct.getTitle(), is(product.getTitle()));
        assertThat(insertedProduct.getPrice(), is(product.getPrice()));
    }

    @Test
    public void hallaget() throws SQLException, ClassNotFoundException {
        Long id = 1L;
        String title = "제주감귤";
        Integer price = 15000;

        Product product = hallaProductDao.get(id);
        assertEquals(id, product.getId());
        assertEquals(title, product.getTitle());
        assertEquals(price, product.getPrice());
    }

    @Test
    public void hallaadd() throws SQLException, ClassNotFoundException {
        Product product = new Product();
        product.setId(5L);
        product.setTitle("제주한라봉");
        product.setPrice(27000);
        Long id = hallaProductDao.insert(product);

        Product insertedProduct = hallaProductDao.get(id);
        assertThat(insertedProduct.getId(), is(id));
        assertThat(insertedProduct.getTitle(), is(product.getTitle()));
        assertThat(insertedProduct.getPrice(), is(product.getPrice()));
    }
}