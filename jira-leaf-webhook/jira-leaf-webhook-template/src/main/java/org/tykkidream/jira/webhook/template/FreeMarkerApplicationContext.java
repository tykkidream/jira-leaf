package org.tykkidream.jira.webhook.template;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;

public class FreeMarkerApplicationContext {

	private static final Logger logger = LoggerFactory.getLogger(FreeMarkerApplicationContext.class);

	private Configuration config = null;
	
	/**
	 * 初始化模板配置
	 * @param templateDir
	 */
	public void loadDirectory(String templateDir){
		try {
			config = new Configuration(Configuration.VERSION_2_3_30);
			// 指定模板文件从何处加载的数据源，这里设置成一个文件目录。
			config.setDirectoryForTemplateLoading(new File(templateDir));
			config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			config.setDefaultEncoding("UTF-8");  
			config.setEncoding(Locale.CHINA, "UTF-8");
			
		} catch (Throwable throwable) {
			if (logger.isErrorEnabled()) {
				logger.error("加载 Freemarker 模板异常： {}", throwable.getMessage(), throwable);
			}
		}
		
	}

	public void loadClasspath(String templateDir){
		try {
			config = new Configuration(Configuration.VERSION_2_3_30);
			config.setClassLoaderForTemplateLoading(FreeMarkerApplicationContext.class.getClassLoader(), templateDir);
			config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			config.setDefaultEncoding("UTF-8");
			config.setEncoding(Locale.CHINA, "UTF-8");

		} catch (Throwable throwable) {
			if (logger.isErrorEnabled()) {
				logger.error("加载 Freemarker 模板异常： {}", throwable.getMessage(), throwable);
			}
		}

	}
	
	public void processTemplate(String templateName, Map<?,?> data, Writer out){
		try {
			Template temp = config.getTemplate(templateName);
			temp.process(data, out);
			out.flush();
		} catch (Throwable throwable) {
			if (logger.isErrorEnabled()) {
				logger.error("渲染机器人消息时异常： {}", throwable.getMessage(), throwable);
			}
		}
	}

	public String processTemplate(String templateName, Object data){
		try {
			StringWriter writer = new StringWriter();


			Template temp = config.getTemplate(templateName);
			temp.process(data, writer);
			writer.flush();

			return writer.toString();
		} catch (Throwable throwable) {
			if (logger.isErrorEnabled()) {
				logger.error("渲染机器人消息时异常： {}", throwable.getMessage(), throwable);
			}
		}

		return "";
	}

	
}
