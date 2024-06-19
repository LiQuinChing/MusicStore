package com.playlist;

public class playlist {

	private int pid;
	private String playlistName;
	private String artist;
	private String song;
	private String album;
	
	public playlist(int playlistid, String playlistName, String song, String artist, String album) {
		
		this.pid = playlistid;
		this.playlistName = playlistName;
		this.song = song;
		this.artist = artist;
		this.album = album;
	}

	public int getPlaylistid() {
		return pid;
	}

	public String getPlaylistName() {
		return playlistName;
	}

	public String getArtist() {
		return artist;
	}

	public String getSong() {
		return song;
	}

	public String getAlbum() {
		return album;
	}
	
}
