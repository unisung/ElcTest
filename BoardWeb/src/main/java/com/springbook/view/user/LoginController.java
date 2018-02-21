package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;


public class LoginController implements Controller {
	HttpSession session;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그인 처리");
		//1. 사용자 정보
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		//2. DB처리
		UserVO user = new UserVO();
		user.setId(id);
		user.setPassword(password);
		UserDAO dao = new UserDAO();
		UserVO user2 = dao.getUser(user);
		session = request.getSession();
		ModelAndView mav = new ModelAndView();
		//3.화면이동
		if(user2!=null){
			session.setAttribute("id",user.getId());
			mav.setViewName("getBoardList.do");
		}else{
			mav.setViewName("login.jsp");
		}
		return mav;
	}

}
