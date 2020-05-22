package dingding;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;

import java.util.LinkedList;
import java.util.List;

public class FeedCardMessageTest {

	private final static String url = "https://oapi.dingtalk.com/robot/send?access_token=1f7aaccf9bc2583576b5bc98bc92d23ab2127b56644e8739b47768559a3c6148"
			+ "&timestamp=1590151057004&sign=rGs4huS0bJC8GXa2u7mIpP2YrOBOkbpnjVPC8jL5aAc%3D";

	public static void main(String[] args) throws Throwable {
		DingTalkClient client = new DefaultDingTalkClient(url);

		List<OapiRobotSendRequest.Links> links = new LinkedList<>();

		{
			OapiRobotSendRequest.Links link = new OapiRobotSendRequest.Links();

			link.setTitle("八男？别闹了！");
			link.setMessageURL("https://www.bilibili.com/bangumi/play/ep317419");
			link.setPicURL("https://i0.hdslb.com/bfs/bangumi/image/ed57f591f44f79d618d39d7e2ddbd8d6c475c3c0.jpg@2320w_664h.jpg");

			links.add(link);
		}

		{
			OapiRobotSendRequest.Links link = new OapiRobotSendRequest.Links();

			link.setTitle("神之塔");
			link.setMessageURL("https://www.bilibili.com/bangumi/play/ep317448");
			link.setPicURL("https://i0.hdslb.com/bfs/bangumi/image/0dac77f04bce0ba9d53914f57150526437ea0a1f.jpg@2320w_664h.jpg");

			links.add(link);
		}

		{
			OapiRobotSendRequest.Links link = new OapiRobotSendRequest.Links();

			link.setTitle("攻壳机动队 SAC_2045");
			link.setMessageURL("https://www.bilibili.com/bangumi/play/ep320562");
			link.setPicURL("https://i0.hdslb.com/bfs/bangumi/image/946028bd3dc719f4b39fb6ed357cbd65036b7a03.jpg@2320w_664h.jpg");

			links.add(link);
		}

		OapiRobotSendRequest.Feedcard feedCard = new OapiRobotSendRequest.Feedcard();
		feedCard.setLinks(links);



		OapiRobotSendRequest request = new OapiRobotSendRequest();

		request.setMsgtype("feedCard");
		request.setFeedCard(feedCard);


		OapiRobotSendResponse response = client.execute(request);
	}
}
