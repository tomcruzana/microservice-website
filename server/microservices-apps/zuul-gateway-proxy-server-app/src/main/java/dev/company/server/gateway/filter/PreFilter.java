package dev.company.server.gateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class PreFilter extends ZuulFilter {

	// logger
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	// filter configuration
	final private String FILTER_TYPE = "pre";
	final private int FILTER_ORDER = 1;
	final private boolean IS_FILTER_ACTIVE = true;

	@Override
	public boolean shouldFilter() {
		LOGGER.info(this.FILTER_TYPE + " filter type is active: " + this.IS_FILTER_ACTIVE + ".");
		return this.IS_FILTER_ACTIVE;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		LOGGER.info("Request Method : " + request.getMethod() + " Request URL : " + request.getRequestURL().toString());
		return null;
	}

	@Override
	public String filterType() {
		LOGGER.info(this.FILTER_TYPE + " filter type executed.");
		return this.FILTER_TYPE;
	}

	@Override
	public int filterOrder() {
		LOGGER.info(" filter order priority is set to: " + this.FILTER_ORDER);
		return this.FILTER_ORDER;
	}

}
