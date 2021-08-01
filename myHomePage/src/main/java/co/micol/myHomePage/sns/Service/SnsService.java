package co.micol.myHomePage.sns.Service;

import java.util.List;

import co.micol.myHomePage.vo.SnsVO;

public interface SnsService {
	
	List<SnsVO> boardSelectList();
	// 게시글 목록
	
	List<SnsVO> boardSelectAndCommentsList(SnsVO vo);
	// 게시글 선택후 댓글 보여주기
	
	int boardInsert(SnsVO vo);
	int commentsInsert(SnsVO vo);
	
	int boardUpdate(SnsVO vo);
	int commentsUpdate(SnsVO vo);
	
	int boardDelete(SnsVO vo);
	int commentsDelete(SnsVO vo);
	
}
