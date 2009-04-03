package com.sitechasia.webx.petstore.web;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.struts.action.ActionServlet;
import org.springframework.core.io.Resource;
import org.springframework.web.context.support.ServletContextResource;

public class MultiStrutsConfigActionServlet extends ActionServlet {
	private static final long serialVersionUID = 1104613293902347526L;
	private static final String EXTRA_COFIG_INIT_PARAMETER_NAME = "extraConfigPath";
	private static final String DEFAULT_EXTRA_STRUTS_CONFIG_PATH = "/WEB-INF/struts-conf";

	private String extraStrutsConfigPath = DEFAULT_EXTRA_STRUTS_CONFIG_PATH;

	public String getExtraStrutsConfigPath() {
		return extraStrutsConfigPath;
	}

	public void setExtraStrutsConfigPath(String extraStrutsConfigPath) {
		this.extraStrutsConfigPath = extraStrutsConfigPath;
	}

	@Override
	public void init() throws ServletException {
		String extraConfigPath = getServletConfig().getInitParameter(
				EXTRA_COFIG_INIT_PARAMETER_NAME);
		if (extraConfigPath != null) {
			setExtraStrutsConfigPath(extraConfigPath);
		}
		this.config = getConfigFilenames();
		super.init();
	}

	private String getConfigFilenames() {
		Resource resource = new ServletContextResource(getServletContext(),
				getExtraStrutsConfigPath());
		String[] filenames = null;
		try {
			filenames = resource.getFile().list();
		} catch (IOException e) {
			log("Error occurred when get files from extra struts config path",
					e);
			return this.config;
		}
		if (filenames == null)
			return this.config;
		StringBuffer configFilenames = new StringBuffer(this.config);
		for (String filename : filenames) {
			configFilenames.append(",").append(getExtraStrutsConfigPath())
					.append("/").append(filename);
		}
		return configFilenames.toString();
	}
}
