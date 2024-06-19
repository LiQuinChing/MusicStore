package com.playlist;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdatePlaylistServlet")
public class UpdatePlaylistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String playlistID = request.getParameter("pid");
		String playlistName = request.getParameter("playlistName");
		String songname = request.getParameter("songName");
		String artistname = request.getParameter("artistName");
		String albumname = request.getParameter("albumName");
		boolean isTrue;

		isTrue = playlistDButil.updateplaylist(playlistID, playlistName, songname, artistname,albumname);

		if(isTrue == true) {			
			List<playlist> playlistDetails = playlistDButil.getPlaylistDetails(playlistID);
			request.setAttribute("playlistDetails", playlistDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("userPlaylist.jsp");
			dis.forward(request, response);								
		}else {			
			List<playlist> playlistDetails = playlistDButil.getPlaylistDetails(playlistID);
			request.setAttribute("playlistDetails", playlistDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("userPlaylist.jsp");
			dis.forward(request, response);
		}

	}

}
