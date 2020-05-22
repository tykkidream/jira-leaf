package dingding;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;

import java.util.Arrays;

public class MarkdownMessageTest {

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
				+ "\n"
				+ "***\n"
				+ "\n"
				+ "[百度](http://www.baidu.com/)\n"
				+ "\n"
				+ "---\n"
				+ "\n"
				+ ">\n"
				+ "> abcdefghijklmn\n"
				+ "> \n"
				+ "> opqrstuvwxyz\n"
				+ ">\n"
				+ "\n"
				+ "___\n"
				+ "\n"
				+ "```java\n"
				+ "public class Main {\n"
				+ "	public static void main(String[] args) throws Throwable {\n"
				+ "		System.out.print(\"Hello World!\");\n"
				+ "	}\n"
				+ "}\n"
				+ "```\n"
				+ "\n"
				+ "---\n"
				+ "\n"
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


		OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
		markdown.setTitle("Markdown 测试标题！！！！！");
		markdown.setText(content);




		OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
		//at.setAtMobiles(Arrays.asList("444444444444444"));
		at.setAtMobiles(Arrays.asList("44444444444"));
		//at.setIsAtAll("true");


		OapiRobotSendRequest request = new OapiRobotSendRequest();
		request.setMsgtype("markdown");
		request.setMarkdown(markdown);
		request.setAt(at);

		OapiRobotSendResponse response = client.execute(request);
	}
}
