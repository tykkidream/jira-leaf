package org.tykkidream.jira.core.repository;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class HttpClientHelper {

    private static final Logger logger = LoggerFactory.getLogger(HttpClientHelper.class);

    // 创建默认的 httpclient 实例
    private CloseableHttpClient httpClient = HttpClients.createDefault();

    /**
     * 请求 JIRA REST API 时的认证信息
     *
     * 生成方式，在 Linux 中执行 ： echo -n <username>:<password> | base64
     *
     * 把 <username> 替换成真实的用户账号，把 <password> 替换成真实的用户密码。
     *
     */
    private String authorization;

    public String post(String url, String value1, String value2) {

        List<NameValuePair> parameters = new ArrayList();
        parameters.add(new BasicNameValuePair("key1", value1));
        parameters.add(new BasicNameValuePair("key2", value2));

        // 创建 POST 请求
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new UrlEncodedFormEntity(parameters, Charset.forName("UTF-8")));

        CloseableHttpResponse response = null;

        String result = null;

        try {
            // httpclient 执行请求，得到响应
            response = httpClient.execute(httpPost);

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();

                if(entity != null){
                    // 结果转换成 string类型
                    result = EntityUtils.toString(entity,"utf-8");
                }
            }
        } catch (Throwable throwable) {
            if (logger.isErrorEnabled()) {
                logger.error("HTTP 请求异常：{}", throwable.getMessage(), throwable);
            }
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (Throwable throwable) {
                if (logger.isErrorEnabled()) {
                    logger.error("HTTP 关闭异常：{}", throwable.getMessage(), throwable);
                }
            }
        }

        return result;
    }

    public String get(String url) {
        // 创建 GET 请求
        HttpGet httpGet = new HttpGet(url);

        httpGet.addHeader("Authorization", authorization);
        httpGet.addHeader("Content-Type", "application/json");

        CloseableHttpResponse response = null;

        String result = null;

        try {
            // httpclient 执行请求，得到响应
            response = httpClient.execute(httpGet);

            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();

                if(entity != null){
                    // 结果转换成 string类型
                    result = EntityUtils.toString(entity,"utf-8");
                }
            } else if (statusCode == HttpStatus.SC_UNAUTHORIZED) {
                if (logger.isErrorEnabled()) {
                    logger.error("HTTP 请求异常，认证失败！");
                }
            }
        } catch (Throwable throwable) {
            if (logger.isErrorEnabled()) {
                logger.error("HTTP 请求异常：{}", throwable.getMessage(), throwable);
            }
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (Throwable throwable) {
                if (logger.isErrorEnabled()) {
                    logger.error("HTTP 关闭异常：{}", throwable.getMessage(), throwable);
                }
            }
        }

        return result;
    }

    public void setAuthorization(String authorization) {
        if (authorization != null) {
            if (authorization.startsWith("Basic ")) {
                this.authorization = authorization;
            } else {
                this.authorization = "Basic " + authorization;
            }
        }
    }
}
