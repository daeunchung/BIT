package ajax4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class HelloServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		System.out.println("id:" + id);
		System.out.println("pw:" + pwd);
				
		/*
		// String
		String str = "World";
		
		JSONObject sObj = new JSONObject();
		sObj.put("str", str);
		
		resp.setContentType("application/x-json; charset=utf-8");
		resp.getWriter().print(sObj);
		*/
		
		/*
		// map 전송
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("title", "제목입니다");
		map.put("content", "내용입니다");
		
		JSONObject mObj = new JSONObject();
		mObj.put("map", map);
		
		resp.setContentType("application/x-json; charset=utf-8");
		resp.getWriter().print(mObj);
		*/
		
		
		List<MemberDto> list = new ArrayList<MemberDto>();
		list.add(new MemberDto(1001, "홍길동"));
		list.add(new MemberDto(1002, "성춘향"));
		
		JSONObject lObj = new JSONObject();
		lObj.put("list", list);
		
		resp.setContentType("application/x-json; charset=utf-8");
		resp.getWriter().print(lObj);		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}	
}




