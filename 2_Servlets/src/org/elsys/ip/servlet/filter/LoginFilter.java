package org.elsys.ip.servlet.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// The hardcode is here ;)
		String usernameHardcoded = "hristian";
		String passwordHardcoded = "milko";
		HttpServletRequest httpRequest = ((HttpServletRequest)request);
		HttpServletResponse httpResponse = ((HttpServletResponse)response);
		boolean authorized = false;

		PrintWriter out = response.getWriter();

		String username = request.getParameter("name");
		String password = request.getParameter("password");

		if (usernameHardcoded.equals(username) && passwordHardcoded.equals(password)) {
			authorized = true;
		}

		Cookie[] cookies = httpRequest.getCookies();
		for (Cookie c : cookies) {
			if (c.getName().equals("autorization")) {
				if (c.getValue().equals("true")) {
					authorized = true;
				}
			}
		}

		// check username and password (can be hardcoded, can use the userService)
		// add if the person is logged in to a cookie (Google it), so that we do not check at every page
		if (authorized) {

			Cookie authorization = new Cookie("autorization", "true");

			httpResponse.addCookie(authorization);

			chain.doFilter(request, response);
		} else {
			request.setAttribute("error", "Wrong username or password!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
