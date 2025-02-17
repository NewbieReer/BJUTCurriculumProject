package server.action;

import commons.Request;
import commons.Response;
import commons.ServerAction;
import commons.User;
import commons.util.XStreamUtil;

/**
 * 发送信息处理
 * 
 * @author Howen howen1994@163.com
 * @version 1.0 <br>
 *          Copyright (C), 2014, Howen <br>
 *          This program is protected by copyright laws.
 */

public class MessageAction extends ServerAction {

	public void execute(Request request, Response response) {
		String userID = (String) request.getParameter("userID");
		String message = (String) request.getParameter("message");

		response.setData("userName", server.getUsers().get(userID).getName());
		response.setData("message", message);

		for (String key : server.getUsers().keySet()) {
			if (!key.equals(userID)) {
				User u = server.getUsers().get(key);
				u.getPrintStream().println(XStreamUtil.toXML(response));
			}
		}
	}

}
