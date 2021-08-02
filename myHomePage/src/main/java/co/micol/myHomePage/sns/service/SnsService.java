package co.micol.myHomePage.sns.service;

import java.util.List;

import co.micol.myHomePage.vo.SnsVO;

public interface SnsService {
	
	List<SnsVO> snsSelectList();
	// 게시글 목록
	
	List<SnsVO> snsSelectAndCommentsList(String sno);
	// 게시글 선택후 댓글 보여주기
	
	int	snsInsert(SnsVO vo);
	int commentsInsert(SnsVO vo);
	
	int snsUpdate(SnsVO vo);
	int commentsUpdate(SnsVO vo);
	
	int snsDelete(SnsVO vo);
	int commentsDelete(SnsVO vo);
	
}
