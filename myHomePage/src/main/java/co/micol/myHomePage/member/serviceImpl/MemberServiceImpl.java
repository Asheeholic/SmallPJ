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
			if(!rs.isClosed()) rs.close();
			if(!psmt.isClosed()) psmt.close();
			if(!conn.isClosed()) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public List<MemberVO> memberSelectList() {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO memberLogin(MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
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
