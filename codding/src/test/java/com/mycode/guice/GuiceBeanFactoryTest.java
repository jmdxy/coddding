package com.mycode.guice;

import com.mycode.guice.app.GuiceBeanFactory;
import com.mycode.guice.order.OrderService;
import com.mycode.guice.order.OrderServiceImpl;
import com.mycode.guice.app.AppModule;
import com.mycode.guice.app.BeanFactory;
import com.mycode.guice.order.Order;
import com.mycode.guice.runtime.RuntimeServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by xu.zhang on 12/18/16.
 */
public class GuiceBeanFactoryTest {

    private BeanFactory beanFactory;

    @Before
    public void setUp() throws Exception {
        beanFactory = new GuiceBeanFactory(new AppModule(new RuntimeServiceImpl()));
    }

    @Test
    public void should_get_order_service_from_guice_module() throws Exception {
        final OrderService instance = beanFactory.getBean(OrderService.class);
        assertThat(instance, is(instanceOf(OrderServiceImpl.class)));
        instance.add(new Order(100));
    }

}
