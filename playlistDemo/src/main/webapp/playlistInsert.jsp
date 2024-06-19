<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <title>Create Playlist</title>
 <link rel="stylesheet" href="cssdesign.css">
<link rel="stylesheet" href="playstyle.css">
        
<meta charset="ISO-8859-1">
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
<div class="welcome">
<h1>Create Playlist</h1>
</div>
    
	<form action = "insert" method = "post">
	<div class="tblplay">

	<table class = "tblplay">
		<tr>
		<td>PlaylistName</td>
		<td><input type = "text" name = "playlistName"></td>
		</tr>
		<tr>
		<td>Song name </td>
		<td><input type = "text" name = "song"></td>
		</tr>
		<tr>
		<td>Artist </td>
		<td><input type = "text" name = "artist"></td>
		</tr>
		<tr>
		<td>Album </td>
		<td><input type = "text" name = "album"></td>
		
		</tr>
		</table>
		</div>
	
		<input type = "submit" class = "Btn" value = "create playlist">
	</form>

</body>
</html>