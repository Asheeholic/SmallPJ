package co.micol.myHomePage.sns.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.myHomePage.dao.DataSource;
import co.micol.myHomePage.sns.service.SnsService;
import co.micol.myHomePage.vo.SnsVO;

public class SnsServiceImpl implements SnsService {
	
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
	public List<SnsVO> snsSelectList() {
		// TODO 게시판 리스트 출력
		String sql = "select * from sns";
		List<SnsVO> list = new ArrayList<SnsVO>();
		SnsVO vo;
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new SnsVO();
				vo.setsNo(rs.getInt("sno"));
				vo.setsWriter(rs.getString("swriter"));
				vo.setsDate(rs.getDate("sDate"));
				vo.setsTitle(rs.getString("stitle"));
				vo.setsAno(rs.getInt("sano"));
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
	public List<SnsVO> snsSelectAndCommentsList(String sno) {
		// TODO 게시판 선택후 게시글과 댓글들 출력
		String sql = "select s.*, c.cno, c.cname, c.csubject, c.cdate "
				+ "from sns s left outer join comments c "
				+ "on (s.sno = c.sno) "
				+ "where s.sno = ? "
				+ "order by c.cno";
		List<SnsVO> list = new ArrayList<SnsVO>();
		SnsVO vo;
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sno);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new SnsVO();
				vo.setsNo(rs.getInt("sno"));
				vo.setsWriter(rs.getString("swriter"));
				vo.setsContents(rs.getString("scontents"));
				vo.setsDate(rs.getDate("sDate"));
				vo.setsTitle(rs.getString("stitle"));
				vo.setsAno(rs.getInt("sano"));
				
				vo.setcNo(rs.getInt("cno"));
				vo.setcName(rs.getString("cname"));
				vo.setcSubject(rs.getString("cSubject"));
				vo.setcDate(rs.getDate("cdate"));
				
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
	public int snsInsert(SnsVO vo) {
		// TODO 게시글 삽입
		String sql = "insert into sns(sno, swriter, stitle, scontents) "
				+ "values(SNO_SEQ.nextval, ?, ?, ?)";
		int result = 0;
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getsWriter());
			psmt.setString(2, vo.getsTitle());
			psmt.setString(3, vo.getsContents());
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
	public int commentsInsert(SnsVO vo) {
		// TODO 선택된 게시글의 댓글 삽입
		String sql = "insert into comments(sno, cno, cname, csubject) "
				+ "values(?, CNO_SEQ.nextval, ?, ?)";
		int result = 0;
		conn = dataSource.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getsNo());
			psmt.setString(2, vo.getcName());
			psmt.setString(3, vo.getcSubject());
			result = psmt.executeUpdate();
			
			updateSano(vo.getsNo());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

	private void updateSano(int sNo) {
		String sql = "update sns set sano = (sano + 1) "
				+ "where sno = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, sNo);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public int snsUpdate(SnsVO vo) {
		// TODO 게시글 수정
		return 0;
	}

	@Override
	public int commentsUpdate(SnsVO vo) {
		// TODO 댓글 가져와서 수정
		return 0;
	}

	@Override
	public int snsDelete(SnsVO vo) {
		// TODO 게시글 삭제
		return 0;
	}

	@Override
	public int commentsDelete(SnsVO vo) {
		// TODO 댓글 삭제
		return 0;
	}

}
