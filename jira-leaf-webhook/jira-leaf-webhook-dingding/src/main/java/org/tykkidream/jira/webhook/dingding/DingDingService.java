package org.tykkidream.jira.webhook.dingding;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.taobao.api.ApiException;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.util.List;

public class DingDingService {
	private static final Logger logger = LoggerFactory.getLogger(DingDingService.class);

	private String accessToken = "60f92746603957320ac5a5020afc4f3acf55cb1ca89c1445c891009e1b814ce7";

	private String secret = "SECf08199833c768cfa4f6af785ca5b7accae23efd683c83d2cc120fceb4c6c1ab0";

	private long timestamp = 0;

	private String currentUrl = null;

	private DefaultDingTalkClient client = new DefaultDingTalkClient(null);

	/**
	 * 小于一小时。
	 *
	 * 钉钉的 timestamp 最多可用一小时。
	 */
	private long lessThanAnHour = (60 * 60 * 1000) - 1000;

	private boolean checkTimestampExpire() {
		long currentTimeMillis = System.currentTimeMillis();

		return currentTimeMillis - timestamp <= lessThanAnHour;
	}

	private String url() {
		timestamp = System.currentTimeMillis();

		try {
			String stringToSign = timestamp + "\n" + secret;
			Mac mac = Mac.getInstance("HmacSHA256");
			mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
			byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
			String sign = URLEncoder.encode(new String(Base64.encodeBase64(signData)),"UTF-8");

			currentUrl = buildUrl(accessToken, timestamp, sign);

		} catch (Throwable throwable) {
			if (logger.isErrorEnabled()) {
				logger.error("构建钉钉 webhook 的地址时异常：{}", throwable.getMessage(), throwable);
			}
		}

		return currentUrl;
	}

	private String buildUrl(String accessToken, long timestamp, String sign) {
		return "https://oapi.dingtalk.com/robot/send?access_token=" + accessToken + "&timestamp=" + timestamp +"&sign=" + sign;
	}

	private DefaultDingTalkClient client() {
		if (!checkTimestampExpire()) {
			client.resetServerUrl(url());
		}

		return client;
	}

	private void execute(OapiRobotSendRequest request) {
		try {
			client().execute(request);
		} catch (ApiException exception) {
			if (logger.isErrorEnabled()) {
				logger.error("钉钉推送消息失败：{}", exception.getMessage(), exception);
			}
		} catch (Throwable throwable) {
			if (logger.isErrorEnabled()) {
				logger.error("钉钉推送消息异常：{}", throwable.getMessage(), throwable);
			}
		}
	}

	public void sendText() {

	}

	public void sendMarkdown(String content, List<String> phones) {
		OapiRobotSendRequest request = new OapiRobotSendRequest();
		request.setMsgtype("markdown");


		OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
		markdown.setTitle("Markdown 测试标题！！！！！");
		markdown.setText(content);
		request.setMarkdown(markdown);

		if (phones != null && phones.size() > 0) {
			OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
			at.setAtMobiles(phones);
			request.setAt(at);
		}

		execute(request);
	}
}
