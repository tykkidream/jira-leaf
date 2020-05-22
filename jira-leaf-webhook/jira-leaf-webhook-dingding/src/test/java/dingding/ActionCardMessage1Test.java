package dingding;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;

public class ActionCardMessage1Test {

	private final static String url = "https://oapi.dingtalk.com/robot/send?access_token=1f7aaccf9bc2583576b5bc98bc92d23ab2127b56644e8739b47768559a3c6148"
			+ "&timestamp=1590151057004&sign=rGs4huS0bJC8GXa2u7mIpP2YrOBOkbpnjVPC8jL5aAc%3D";

	public static void main(String[] args) throws Throwable {
		DingTalkClient client = new DefaultDingTalkClient(url);

		String content =
				"大大大大大标题\n"
						+ "=======================================\n"
						+ "\n"
						+ "\n"
						+ "1. aaaaaa： `AAA` ;\n"
						+ "2. bbbbbb： ___BBB___ ;\n"
						+ "3. cccccc： **AAA** ;\n"
						+ "---\n"
						+ "```xml\n"
						+ "<root>\n"
						+ "	<items>\n"
						+ "		<item>\n"
						+ "			<id>989</id>\n"
						+ "			<name>上衣</name>\n"
						+ "		</item>\n"
						+ "	</items>\n"
						+ "</root>\n"
						+ "```\n"
						+ "\n"
						+ "\n";

		OapiRobotSendRequest.Actioncard actionCard = new OapiRobotSendRequest.Actioncard();
		actionCard.setTitle("ActionCard 的测试标题");
		actionCard.setText(content);
		actionCard.setSingleTitle("点击这里 ActionCard 的测试小按钮");
		actionCard.setSingleURL("https://www.bilibili.com/anime/");
		actionCard.setBtnOrientation("1");

		OapiRobotSendRequest request = new OapiRobotSendRequest();

		request.setMsgtype("actionCard");
		request.setActionCard(actionCard);


		OapiRobotSendResponse response = client.execute(request);
	}
}
