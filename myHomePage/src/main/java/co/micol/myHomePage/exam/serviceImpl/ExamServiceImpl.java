package co.micol.myHomePage.exam.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.VoiceStatus;

import co.micol.myHomePage.dao.DataSource;
import co.micol.myHomePage.exam.service.ExamService;
import co.micol.myHomePage.vo.ExamVO;

public class ExamServiceImpl implements ExamService {
	
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
	public List<ExamVO> examSelectList() {
		List<ExamVO> list = new ArrayList<>();
		ExamVO vo;
		String sql = "select a.id, a.name, b.fid, b.file_path, b.fDate "
				+ "from member a join exam b "
				+ "on (a.id = b.id)";
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new ExamVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				
				vo.setfId(rs.getInt("fid"));
				vo.setFilePath(rs.getString("file_path"));
				vo.setfDate(rs.getDate("fDate"));
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
	public ExamVO examSelect(ExamVO vo) {
		String sql = "select a.id, a.name, b.fid, b.file_path, b.fDate "
				+ "from member a join exam b "
				+ "on (a.id = b.id) "
				+ "where id = ?";
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo = new ExamVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				
				vo.setfId(rs.getInt("fid"));
				vo.setFilePath(rs.getString("file_path"));
				vo.setfDate(rs.getDate("fDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}
	
	// ?????? ??? ???????????????.
	@Override
	public int examInsert(ExamVO vo) {
		String sql = "insert into exam(id, file_path, fid) "
				+ "values(?, ?, fid_seq.nextval)";
		int result = 0;
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getFilePath());
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

	@Override
	public int examUpdate(ExamVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int examDelete(ExamVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
