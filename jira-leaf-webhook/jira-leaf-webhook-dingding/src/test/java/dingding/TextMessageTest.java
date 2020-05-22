package dingding;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;

public class TextMessageTest {

	private final static String url = "https://oapi.dingtalk.com/robot/send?access_token=1f7aaccf9bc2583576b5bc98bc92d23ab2127b56644e8739b47768559a3c6148"
			+ "&timestamp=1590147510318&sign=u4hc8MPgnL7xFR6aZ8QDfC14P4FvNR%2F7MRX4fd%2Fe8zw%3D";

	public static void main(String[] args) throws Throwable {
		DingTalkClient client = new DefaultDingTalkClient(url);

		OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
		text.setContent("新番时间表 \n"
				+ "BanG Dream! 少女乐团派对！☆PICO～大份～\n"
				+ "BanG Dream! 少女乐团派对！☆PICO～大份～\n"
				+ "\n"
				+ "更新至 3话八男？別鬧了！（僅限港澳台及其他地區）\n"
				+ "八男？別鬧了！（僅限港澳台及其他地區）");



		OapiRobotSendRequest request = new OapiRobotSendRequest();

		request.setMsgtype("text");
		request.setText(text);


		OapiRobotSendResponse response = client.execute(request);
	}
}
