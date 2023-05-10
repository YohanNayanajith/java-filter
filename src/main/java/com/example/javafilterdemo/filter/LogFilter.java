package com.example.javafilterdemo.filter;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.UUID;

public class LogFilter implements Filter {
    public static final String CORRELATION_ID_KEY = "correlationId";
    public static final String CORRELATION_ID_HEADER_KEY = "X-Correlation-Id";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest httpServletRequest) {

            final String correlationId = StringUtils.isNotEmpty(httpServletRequest.getHeader(CORRELATION_ID_HEADER_KEY)) ?
                    httpServletRequest.getHeader(CORRELATION_ID_HEADER_KEY) : UUID.randomUUID().toString();

            filterChain.doFilter(servletRequest, servletResponse);

        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
