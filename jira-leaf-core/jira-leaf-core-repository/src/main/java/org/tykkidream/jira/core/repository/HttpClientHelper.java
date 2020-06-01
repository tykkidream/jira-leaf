package org.tykkidream.jira.core.repository;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
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

    private static final String url = "http:///11111111111111111";

    // 创建默认的 httpclient 实例
    private static final CloseableHttpClient httpClient = HttpClients.createDefault();

    /**
     *
     * @param requestXmlText 请求的xml报文
     * @param checkWord 报文加密的校验码
     * @return
     */
    public static String doRequest(String requestXmlText, String checkWord) {

        List<NameValuePair> parameters = new ArrayList();
        parameters.add(new BasicNameValuePair("key1", "value1"));
        parameters.add(new BasicNameValuePair("key2", "value2"));

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
}
