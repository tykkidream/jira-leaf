package dingding;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;

import java.util.Arrays;

public class AtPeopleMessageTest {

	private final static String url = "https://oapi.dingtalk.com/robot/send?access_token=1f7aaccf9bc2583576b5bc98bc92d23ab2127b56644e8739b47768559a3c6148"
			+ "&timestamp=1590151057004&sign=rGs4huS0bJC8GXa2u7mIpP2YrOBOkbpnjVPC8jL5aAc%3D";

	public static void main(String[] args) throws Throwable {
		DingTalkClient client = new DefaultDingTalkClient(url);

		{

			OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
			text.setContent("测试文本消息");



			OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
			at.setAtMobiles(Arrays.asList("111111111"));



			OapiRobotSendRequest request = new OapiRobotSendRequest();
			request.setMsgtype("text");
			request.setText(text);
			request.setAt(at);

			OapiRobotSendResponse response = client.execute(request);

		}


		{

			OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
			text.setContent("测试文本消息");



			OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
			at.setIsAtAll("true");



			OapiRobotSendRequest request = new OapiRobotSendRequest();
			request.setMsgtype("text");
			request.setText(text);
			request.setAt(at);

			OapiRobotSendResponse response = client.execute(request);

		}





	}
}
