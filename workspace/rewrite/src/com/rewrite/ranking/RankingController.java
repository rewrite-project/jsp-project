package com.rewrite.ranking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.rewrite.Action;
import com.rewrite.Result;
import com.rewrite.member.dao.MemberDAO;
import com.rewrite.member.domain.MemberDTO;

public class RankingController extends Result implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Result result = new Result();
		JSONArray jsons = new JSONArray();
		Map<String, Object> searchMap = new HashMap<String, Object>();
		MemberDAO memberDAO = new MemberDAO();
		
		searchMap.put("startRow", 0);
		searchMap.put("rowCount", 5);
		
		memberDAO.selectAll(searchMap).stream().map(member -> new JSONObject(member)).forEach(jsons::put);
		req.setAttribute("members", jsons);
		
		
		
		result.setPath("/templates/ranking/ranking.jsp");
		return result;
	}

}
