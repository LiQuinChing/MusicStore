package com.playlist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class playlistDButil {

	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;


	public static boolean validate(String playlistName){
		
				try {
				con = DBconnect.getConnection();
				stmt = con.createStatement();
				String sql = "select * FROM playlist WHERE playlistName = '"+playlistName+"' ";
				rs = stmt.executeQuery(sql);
		
					if(rs.next()) {
						isSuccess = true;
					}else {
						isSuccess = false;
					}
		
				}catch(Exception e) {
					e.printStackTrace();
				}
		
			return isSuccess;
		
			}
	//to retrieve values after inserting data to play-list
public static List<playlist> getAllPlaylist(String playlistName, String song) {
		
		ArrayList<playlist> playL = new ArrayList<>();
		
		try {
			
			con = DBconnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from playlist where playlistName='"+playlistName+"' and song = '"+song+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int pid = rs.getInt(1);
				String playlistname = rs.getString(2);
				String songname = rs.getString(3);
				String artist = rs.getString(4);
				String album = rs.getString(5);

				playlist play = new playlist(pid, playlistname, songname, artist, album ) ;
				playL.add(play);
			}
			
		} catch (Exception e) {
			
		}
		
		return playL;	
	}
	
	public static boolean insertplaylist(String playlistName,String song,String artist, String album) {

		boolean isSuccess = false;

		try {
			con = DBconnect.getConnection();
			stmt = con.createStatement();
			String sql = "insert into playlist values(0,'"+playlistName+"', '"+song+"', '"+artist+"', '"+album+"' )";
			int rs = stmt.executeUpdate(sql);

			//ensures values are added to the db using above query
			if(rs>0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}

		}catch(Exception e){
			e.printStackTrace();

		}
		return isSuccess;
	}
//data is updated in the play-list table
	public static boolean updateplaylist(String pid, String playlistName, String songname, String artistname, String albumname) {

		try {

			con = DBconnect.getConnection();
			stmt = con.createStatement();
			String sql = "update playlist set playlistName= '"+playlistName+"', song= '"+songname+"', artist = '"+artistname+"',"
					+ " album = '"+albumname+"'"
					 + "WHERE playlistid = '"+pid+"'";
			int rs = stmt.executeUpdate(sql);

			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return isSuccess;
	}

	//retrieve the passed values
	public static List<playlist> getPlaylistDetails(String Pid){

		int convertedPID = Integer.parseInt(Pid);

		ArrayList<playlist> playUp = new ArrayList<>();

		try {

			con = DBconnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from playlist where pid= '"+convertedPID+"'";
			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				int pid = rs.getInt(1);
				String playlistName = rs.getString(2);
				String song = rs.getString(3);
				String artist = rs.getString(4);
				String album = rs.getString(5);

				playlist p = new playlist(pid, playlistName, song, artist, album );
				playUp.add(p);
			}

		}catch(Exception e){
			e.printStackTrace();
		}

		return playUp;

	}
	
	public static boolean deletePlaylist(String pid) {
		
		int convertPID = Integer.parseInt(pid);
		
		try {
			con = DBconnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "DELETE FROM playlist WHERE playlistid = '"+convertPID+"'";
			int r = stmt.executeUpdate(sql);
			
			if(r>0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		}
		catch(Exception e){
			
		}		
		return isSuccess;
		
	}

}
