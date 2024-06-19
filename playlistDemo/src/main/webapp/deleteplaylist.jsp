<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="cssdesign.css">
<link rel="stylesheet" href="playstyle.css">
<title>Delete Playlist</title>
</head>

<body>
<div class="tbl1">
       
        <div class="welcome">
            <h1>Welcome Back, Good evening!</h1>
        </div>
        <div class="logo">
            <img src="musiclogo1.jpg" alt="Music Logo">
        </div>
        <div class="navbar">
            <ul>
                <li><a href="#">Home</a></li>
                <li><a href="Search.jsp">Search</a></li>
                <li><a href="Payments.jsp">Activate Premium</a></li>
                <li><a href="Albums.jsp">Albums</a></li>
                <li><a href="playlistInsert.jsp">Playlist</a></li>
            </ul>
        </div>
        <a href="Logout.jsp"><button id="bttn2">Log out</button></a>
    </div>


<%
	String pid = request.getParameter("playlistID");
	String pname = request.getParameter("playlistName");
	String sname = request.getParameter("songName");
	String artistname = request.getParameter("artistName");
	String albumname = request.getParameter("albumName");
	
%>
<div class="welcome">
<h1>Playlist Delete</h1>
</div>
	
	<form action="delete" method="post">
	<div class="tblplay">
	<table class = "tblplay">
		<tr>
			<td class= "topic">Playlist ID</td>
			<td><input type="text" name="pid" value="<%= pid %>"  readonly></td>
		</tr>
		<tr>
			<td>Playlist name</td>
			<td><input type="text" name="playlistName" value="<%= pname %>"readonly></td>
		</tr>
		<tr>
			<td>Song name</td>
			<td><input type="text" name="songName" value="<%= sname %>"readonly></td>
		</tr>
		<tr>
			<td>Artist name</td>
			<td><input type="text" name="artistName" value="<%= artistname %>"readonly></td>
		</tr>
		<tr>
			<td>Album name</td>
			<td><input type="text" name="albumName" value="<%= albumname %>"readonly></td>
		</tr>
	</table>
	</div>
	<br>
		<input type="submit" class = "Btn" name="submit" value="delete playlist">

	</form>

</body>
</html>