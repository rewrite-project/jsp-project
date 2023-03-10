package com.rewrite.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rewrite.Action;
import com.rewrite.Result;
import com.rewrite.mypage.dao.MypageDAO;
import com.rewrite.mypage.domain.MypageDTO;

public class mycoinOkController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		MypageDTO mypageDTO = new MypageDTO();
		Long memberId = Long.valueOf(req.getParameter("memberId"));
		Result result = new Result();
		MypageDAO mypageDAO = new MypageDAO();
		
		req.setAttribute("mypage", mypageDAO.mycoinSelect(memberId));
		
		result.setPath(req.getContextPath() + "/templates/mypage/mycoin.jsp");
		
		return result;
	}

}
