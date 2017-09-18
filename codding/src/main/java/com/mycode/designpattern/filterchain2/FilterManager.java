package com.mycode.designpattern.filterchain2;

/**
 * Filter Manager manages the filters and Filter Chain.
 */
public class FilterManager {

    private FilterChain filterChain;

    public FilterManager(Target target) {
        filterChain = new FilterChain(target);
    }

    public void addFilter(Filter filter) {
        filterChain.addFilter(filter);
    }

    public String filterRequest(Order order) {
        return filterChain.execute(order);
    }
}
