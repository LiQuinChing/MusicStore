package com.playlist;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeletePlaylistServlet")
public class DeletePlaylistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String playlistID = request.getParameter("pid");
		
		boolean isTrue;
		
		isTrue = playlistDButil.deletePlaylist(playlistID);
		
		if(isTrue == true) {
			RequestDispatcher dispatch = request.getRequestDispatcher("success.jsp");
			dispatch.forward(request, response);
		}else {
			List<playlist> playlistDetails = playlistDButil.getPlaylistDetails(playlistID);
			request.setAttribute("playlistDetails", playlistDetails);
			
			RequestDispatcher dispatch = request.getRequestDispatcher("userPlaylist.jsp");
			dispatch.forward(request, response);
		}
		
	}

}
