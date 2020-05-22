package dingding;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;

import org.apache.commons.codec.binary.Base64;

public class SecretTest {
	public static void main(String[] args) throws Exception {
		String secret = "SECf08199833c768cfa4f6af785ca5b7accae23efd683c83d2cc120fceb4c6c1ab0";


		Long timestamp = System.currentTimeMillis();

		String stringToSign = timestamp + "\n" + secret;
		Mac mac = Mac.getInstance("HmacSHA256");
		mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
		byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
		String sign = URLEncoder.encode(new String(Base64.encodeBase64(signData)),"UTF-8");
		System.out.println(sign);

		String url = "https://oapi.dingtalk.com/robot/send?access_token=1f7aaccf9bc2583576b5bc98bc92d23ab2127b56644e8739b47768559a3c6148";

		url = url + "&timestamp=" + timestamp +"&sign=" + sign;

		System.out.println(url);
	}
}
