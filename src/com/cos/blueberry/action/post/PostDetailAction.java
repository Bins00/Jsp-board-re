package com.cos.blueberry.action.post;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blueberry.action.Action;
import com.cos.blueberry.dao.PostDao;
import com.cos.blueberry.dto.PostResponseDto;

public class PostDetailAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int postId = Integer.parseInt(request.getParameter("id"));
		
		PostDao postDao = new PostDao();
		PostResponseDto postDetail = postDao.상세보기(postId);
		request.setAttribute("postDetail", postDetail);
		
		RequestDispatcher dis = request.getRequestDispatcher("post/detail.jsp");
		dis.forward(request, response);
	}
}

