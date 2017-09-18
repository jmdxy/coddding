package com.mycode.designpattern.filterchain;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * 模拟过滤器filter
 * <p/>
 * 将一个service，例子中是{@link MyService}，上下包围一些filter做处理，
 * 例如中将{@link CustomFilter1}和{@link CustomFilter2}作为过滤器使用。
 *
 * @author zhangxu
 */
public class App {

    /**
     * 打印结果:
     * <pre>
     * Place CustomFilter2 filter to core processor
     * Place CustomFilter1 filter to core processor
     * Here is pre - CustomFilter1
     * Here is pre - CustomFilter2
     * Here is post - CustomFilter2
     * Here is post - CustomFilter1
     * </pre>
     */
    @Test
    public void testFilterChain() {
        MyService myService = FilterBuilder.buildFilterChain(new MyServiceImpl());
        Request request = new Request();
        request.setReq("hello");
        Response response = myService.doAction(request);
        assertThat(response.getRes(), is("HELLO"));
    }

}
