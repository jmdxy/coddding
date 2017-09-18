package com.mycode.guice.app;

import com.google.inject.*;
import com.google.inject.name.Names;
import com.mycode.guice.annotation.NS2;
import com.mycode.guice.named.NamedService;
import com.mycode.guice.named.NamedServiceImpl1;
import com.mycode.guice.named.NamedServiceImpl2;
import com.mycode.guice.order.OrderService;
import com.mycode.guice.order.OrderServiceImpl;
import com.mycode.guice.price.PriceService;
import com.mycode.guice.runtime.RuntimeService;
import com.mycode.guice.item.ItemService;
import com.mycode.guice.item.ItemServiceImpl1;
import com.mycode.guice.runtime.RuntimeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.google.common.collect.ImmutableList.of;
import static com.google.inject.Scopes.SINGLETON;
import static com.google.inject.matcher.Matchers.any;


public class AppModule extends AbstractModule implements Module {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppModule.class);

    private final RuntimeServiceImpl runtimeService;

    public AppModule(RuntimeServiceImpl runtimeService) {
        this.runtimeService = runtimeService;
    }

    @Override
    public void configure() {
        final Binder binder = binder();
        if (LOGGER.isDebugEnabled()) {
            binder.bindInterceptor(any(), any(), ExceptionMethodInterceptor.exception());
        }
        //TODO: bind named instance;
        binder.bind(NamedService.class).annotatedWith(Names.named("impl1")).to(NamedServiceImpl1.class);
        binder.bind(NamedService.class).annotatedWith(NS2.class).to(NamedServiceImpl2.class);

        //TODO: bind interface
        binder.bind(OrderService.class).to(OrderServiceImpl.class).in(SINGLETON);
        binder.bind(ItemService.class).to(ItemServiceImpl1.class).in(Scopes.SINGLETON);
        binder.bind(PriceService.class).in(Scopes.SINGLETON);

        //TODO: bind instance not class.
        binder.bind(RuntimeService.class).toInstance(runtimeService);

    }

}
