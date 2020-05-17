package com.capitanperegrina.geniusrating.web.controller.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import com.capitanperegrina.simpleuser.util.version.VersionUtils;
import com.capitanperegrina.simpleuser.web.naming.SimpleUserWebNaming;

@Component("interfazUsuarioFilter")
public class GeniusRatingUserInterfaceFilter extends GenericFilterBean {

	@Override
	public void destroy() {
		// Nothing to do
	}

	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
					throws IOException, ServletException {
		final HttpServletRequest httpRequest = (HttpServletRequest) request;

		String qs = "";
		if (!StringUtils.isEmpty(httpRequest.getQueryString())) {
			qs = "&" + httpRequest.getQueryString();
		}
		request.setAttribute("queryString", qs);
		chain.doFilter(request, response);
		
		httpRequest.getSession().setAttribute(SimpleUserWebNaming.REQUEST_APPVERSION, VersionUtils.obtenVersion());
		httpRequest.getSession().setAttribute(SimpleUserWebNaming.REQUEST_LANG, LocaleContextHolder.getLocale().getLanguage());
	}
}
