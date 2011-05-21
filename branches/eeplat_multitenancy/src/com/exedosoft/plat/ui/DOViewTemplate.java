package com.exedosoft.plat.ui;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.exedosoft.plat.template.HtmlTemplateGenerator;
import com.exedosoft.plat.util.DOGlobals;

public abstract class DOViewTemplate implements DOIViewTemplate {

	protected String templateFile = "panel/Panel.ftl";

	private static Log log = LogFactory.getLog(DOViewTemplate.class);

	public String getHtmlCode(DOIModel doimodel) {

		Map<String, Object> data = this.putData(doimodel);

		String s = "";
		try {
			log.info("TemplateFile:::" + templateFile);
			s = HtmlTemplateGenerator.getContentFromTemplate(this.templateFile,
					data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("Get Html Code Finish!" );

		return s;
	}

	public Map<String, Object> putData(DOIModel doimodel) {

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("model", doimodel);
		data.put("contextPath", DOGlobals.PRE_FULL_FOLDER);
		data.put("webmodule", DOGlobals.URL);
		
		return data;
	}

}
