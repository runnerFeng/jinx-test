package common.demo46;

import com.common.test.demo46_Vertx.method1.MyFirstVerticle;
import io.vertx.core.Vertx;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @Author: Aug
 * @Date: 2021-06-02 17:30
 * @Desc:
 */
@RunWith(VertxUnitRunner.class)
public class MyFirstVerticleTest {

    private Vertx vertx;

    @Before
    public void setUp(TestContext context) throws Exception {
        vertx = Vertx.vertx();
        vertx.deployVerticle(new MyFirstVerticle(),context.asyncAssertSuccess());
    }

    @After
    public void tearDown(TestContext context) throws Exception {
        vertx.close(context.asyncAssertSuccess());
    }

    @Test
    public void testApplication(TestContext context) {
        final Async async = context.async();
        vertx.createHttpClient().getNow(8088,"localhost","/",response->{
            response.handler(body->{
                context.assertTrue(body.toString().contains("hello"));
                async.complete();
            });
        });
    }

}
