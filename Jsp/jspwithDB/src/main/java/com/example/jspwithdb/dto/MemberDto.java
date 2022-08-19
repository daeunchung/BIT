package com.example.jspwithdb.dto;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.jspwithdb.DB.DBClose;
import com.example.jspwithdb.DB.DBConnection;

public class MemberDto  implements Serializable {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private int auth; // 3- general 1- administrator

	public MemberDto(String id, String pwd, String name, String email, int auth) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.auth = auth;
	}

	public MemberDto login(MemberDto dto){
		String sql = " select id, name, email, auth "
				+ " from member "
				+ " where id=? and pwd=? ";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		MemberDto mDto = null;

		try {
			conn = DBConnection.getConnection();
			System.out.println("1/3 success");
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPwd());

			rs = psmt.executeQuery();
			System.out.println("2/3 success");

			if(rs.next()){
				String id = rs.getString(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				int auth = rs.getInt(4);

				mDto = new MemberDto(id, null, name, email, auth);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("login fail");
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		return mDto;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}

	@Override
	public String toString() {
		return "MemberDto{" +
				"id='" + id + '\'' +
				", pwd='" + pwd + '\'' +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", auth=" + auth +
				'}';
	}
}
