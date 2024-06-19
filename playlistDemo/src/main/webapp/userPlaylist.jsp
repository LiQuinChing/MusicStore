<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Playlist</title>
<link rel="stylesheet" href="cssdesign.css">
<link rel="stylesheet" href="playstyle.css">
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
		<h1>User Playlist</h1>
	</div>
	<div class="tblplay">

		<table class="tblplay">
			<c:forEach var="playlist" items="${playlistDetails}">

				<c:set var="playlistID" value="${playlist.playlistid}" />
				<c:set var="playlistName" value="${playlist.playlistName}" />
				<c:set var="songName" value="${playlist.song }" />
				<c:set var="artistName" value="${playlist.artist }" />
				<c:set var="albumName" value="${playlist.album}" />

				<tr>
					<td>Playlist ID</td>
					<td>${playlist.playlistid}</td>
				</tr>
				<tr>
					<td>Playlist Name</td>
					<td>${playlist.playlistName}</td>
				</tr>

				<tr>
					<td>Song name</td>
					<td>${playlist.song}</td>
				</tr>
				<tr>
					<td>Artist Name</td>
					<td>${playlist.artist}</td>
				</tr>
				<tr>
					<td>Album Name</td>
					<td>${playlist.album}</td>
				</tr>

			</c:forEach>

		</table>
	</div>
	<c:url value="updatePlaylist.jsp" var="playlistupdate">

		<c:param name="playlistID" value="${playlistID}"/>
		<c:param name="playlistName" value="${playlistName}"/>
		<c:param name="songName" value="${songName}"/>
		<c:param name="artistName" value="${artistName}"/>
		<c:param name="albumName" value="${albumName}"/>

	</c:url>
	<a href="${playlistupdate}"> <input type="button" class="Btn"
		name="update" value="Update playlist">
	</a>

	<br>
	<c:url value="deleteplaylist.jsp" var="playlistdelete">
		
		<c:param name="playlistID" value="${playlistID}"/>
		<c:param name="playlistName" value="${playlistName}"/>
		<c:param name="songName" value="${songName}"/>
		<c:param name="artistName" value="${artistName}"/>
		<c:param name="albumName" value="${albumName}"/>
	</c:url>

	<a href="${playlistdelete}"> <input type="button" class="Btn"
		name="delete" value="Delete playlist">
	</a>



</body>
</html>