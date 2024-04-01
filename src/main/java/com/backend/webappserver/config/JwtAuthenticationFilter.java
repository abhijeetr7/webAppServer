package com.backend.webappserver.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.backend.webappserver.CurrentTenantId;
import com.backend.webappserver.config.JwtTokenProvider;
import com.backend.webappserver.service.UserService;

import io.jsonwebtoken.Claims;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtTokenProvider tokenProvider;
//
	@Autowired
	private UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String jwt = getJwtFromRequest(request);
//       String tenantId = getTokenFromRequest(request);
//       CurrentTenantId.set(tenantId);
			if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
				Claims claims = tokenProvider.getUserIdFromJWT(jwt);

				String comanycode = (String) claims.get("comanycode");
				CurrentTenantId.set(comanycode);
				String username = (String) claims.get("username");
				Integer userId = Integer.parseInt(claims.getSubject());

				/*
				 * Note that you could also encode the user's username and roles inside JWT
				 * claims and create the UserDetails object by parsing those claims from the
				 * JWT. That would avoid the following database hit. It's completely up to you.
				 */
				UserDetails userDetails = userService.loadUserById(userId, comanycode);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		} catch (Exception ex) {
			logger.error("Could not set user authentication in security context", ex);
		}

		filterChain.doFilter(request, response);
	}

	private String getJwtFromRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7, bearerToken.length());
		}
		return null;
	}

	private String getTokenFromRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader("token");

		return bearerToken;
	}
}
