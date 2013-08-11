package ch.boretti.integrator.camelactiviti;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Un filtre pour bypasser le filtre VAADIN
 * @author borettim
 *
 */
public class IgnoreFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = ((HttpServletRequest) request);
		String path = httpRequest.getServletPath()+"/"+httpRequest.getPathInfo();
		request.getRequestDispatcher(path).forward(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}
}
