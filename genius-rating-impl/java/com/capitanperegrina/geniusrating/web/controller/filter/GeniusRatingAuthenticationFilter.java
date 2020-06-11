package com.capitanperegrina.geniusrating.web.controller.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.capitanperegrina.simpleuser.web.naming.SimpleUserWebNaming;
import com.capitanperegrina.simpleuser.web.ui.UserUI;
import com.capitanperegrina.utils.net.social.Gravatar;

@Component("authenticationFilter")
public class GeniusRatingAuthenticationFilter extends GenericFilterBean {

	private static final Logger LOGGER = LoggerFactory.getLogger(GeniusRatingAuthenticationFilter.class);
	
	// TODO - Read this from somwhere
    private final List<String> publicActions = new ArrayList<>();
    private final List<String> privateActions = new ArrayList<>();

    @Override
    public void destroy() {
    	// Do nothing
    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
            throws IOException, ServletException {
    	
        final HttpServletRequest httpRequest = (HttpServletRequest) request;

        final UserUI u = (UserUI) httpRequest.getSession().getAttribute(SimpleUserWebNaming.SESSION_LOGGED_USER);
        if (u == null) {
            request.setAttribute(SimpleUserWebNaming.REQUEST_LOGGED, null);
            if (!this.publicActions.contains(httpRequest.getServletPath())) {
                final HttpServletResponse httpResponse = (HttpServletResponse) response;
                httpResponse.sendRedirect("login.do");
                return;
            }
        } else {
            request.setAttribute(SimpleUserWebNaming.REQUEST_LOGGED, "S");
            request.setAttribute(SimpleUserWebNaming.REQUEST_USER, u);
            request.setAttribute("gravatarMd5", Gravatar.md5Hex(u.getMail()));
        }
        chain.doFilter(request, response);
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @PostConstruct
    public void init() {
    	// Simple User
        this.publicActions.add("/main.do");
        this.publicActions.add("/login.do");
        this.publicActions.add("/loginRest.do");
        this.publicActions.add("/logoutRest.do");
        this.publicActions.add("/register.do");
        this.publicActions.add("/registerRest.do");
        this.publicActions.add("/recoverPassInit.do");
        this.publicActions.add("/recoverPassInitRest.do");
        this.publicActions.add("/recoverPassExec.do");
        this.publicActions.add("/recoverPassExecRest.do");
        
        // Genius Rating
        this.publicActions.add("/boatList.do");
        
    	// Simple User
        this.privateActions.add("/changePassRest.do");
        
        // Genius Rating
        this.publicActions.add("/myBoats.do");        
    }
}
