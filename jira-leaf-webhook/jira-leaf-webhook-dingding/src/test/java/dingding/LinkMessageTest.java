package dingding;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;

import java.util.Arrays;

/**
 * Link 消息类型测试
 */
public class LinkMessageTest {

	private final static String url = "https://oapi.dingtalk.com/robot/send?access_token=1f7aaccf9bc2583576b5bc98bc92d23ab2127b56644e8739b47768559a3c6148"
			+ "&timestamp=1590147510318&sign=u4hc8MPgnL7xFR6aZ8QDfC14P4FvNR%2F7MRX4fd%2Fe8zw%3D";

	public static void main(String[] args) throws Throwable {
		DingTalkClient client = new DefaultDingTalkClient(url);



		OapiRobotSendRequest.Link link = new OapiRobotSendRequest.Link();
		link.setMessageUrl("https://www.bilibili.com/anime/");
		link.setPicUrl("https://i0.hdslb.com/bfs/bangumi/image/ed57f591f44f79d618d39d7e2ddbd8d6c475c3c0.jpg@2320w_664h.jpg");
		link.setTitle("看这个！看这个！看这个！");
		link.setText("八男后宫一大片八男后宫一大片八男后宫一大片八男后宫一大片八男后宫一大片");




		OapiRobotSendRequest request = new OapiRobotSendRequest();

		request.setMsgtype("link");
		request.setLink(link);


		OapiRobotSendResponse response = client.execute(request);
	}

}
