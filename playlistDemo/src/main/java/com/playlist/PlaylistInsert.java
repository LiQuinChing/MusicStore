package com.playlist;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PlaylistInsert")
public class PlaylistInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String pname = request.getParameter("playlistName");
		String song = request.getParameter("song");
		String artist = request.getParameter("artist");
		String album = request.getParameter("album");
		boolean isTrue;
		
		isTrue = playlistDButil.insertplaylist(pname, song, artist, album);
		//checks if our database connection is success
		if(isTrue == true) {
			List<playlist> playlistDetails = playlistDButil.getAllPlaylist(pname, song);
			request.setAttribute("playlistDetails", playlistDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("userPlaylist.jsp");
			dis.forward(request, response);
		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
		
	}

}
