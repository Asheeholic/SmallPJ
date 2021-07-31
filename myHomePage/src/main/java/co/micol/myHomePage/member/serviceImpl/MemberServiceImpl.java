package co.micol.myHomePage.member.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.myHomePage.dao.DataSource;
import co.micol.myHomePage.member.service.MemberService;
import co.micol.myHomePage.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	
	//싱글톤
	DataSource dataSource = DataSource.getInstance();
	
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	
	private void disconnect() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public List<MemberVO> memberSelectList() {
		//회원(학생,교수) 전체조회
		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO vo;
		String sql = "select * from member";
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setDepartment(rs.getString("department"));
				vo.setAuthor(rs.getString("author"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		// TODO 한건 조회 
		
		String sql = "select * from member where id =?";
		
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setDepartment(rs.getString("department")); //학과명
				vo.setAuthor(rs.getString("author"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return vo;
	}

	@Override
	public MemberVO memberLogin(MemberVO vo) {
		// TODO 로그인
		String sql ="select name, author from member where id=? and password=? and state='Y'";
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPassword());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setName(rs.getString("name"));
				vo.setAuthor(rs.getString("author"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return vo;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// TODO 회원(교수 및 학생) 가입 
		String sql ="insert into member(id, password, name, age, department, author, state) values(?,?,?,?,?,?,'Y')";
		int n = 0;
			conn = dataSource.getConnection();
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, vo.getId());
				psmt.setString(2, vo.getPassword());
				psmt.setString(3, vo.getName());
				psmt.setInt(4, vo.getAge());
				psmt.setString(5, vo.getDepartment());
				psmt.setString(6, vo.getAuthor());
				
				n = psmt.executeUpdate();
	
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
			
		return n;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
