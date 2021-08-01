package co.micol.myHomePage.sns.ServiceImpl;

import java.util.List;

import co.micol.myHomePage.sns.Service.SnsService;
import co.micol.myHomePage.vo.SnsVO;

public class SnsServiceImpl implements SnsService {

	@Override
	public List<SnsVO> boardSelectList() {
		// TODO 게시판 리스트 출력
		return null;
	}

	@Override
	public List<SnsVO> boardSelectAndCommentsList(SnsVO vo) {
		// TODO 게시판 선택후 게시글과 댓글들 출력
		return null;
	}

	@Override
	public int boardInsert(SnsVO vo) {
		// TODO 게시글 삽입
		return 0;
	}

	@Override
	public int commentsInsert(SnsVO vo) {
		// TODO 선택된 게시글의 댓글 삽입
		return 0;
	}

	@Override
	public int boardUpdate(SnsVO vo) {
		// TODO 게시글 수정
		return 0;
	}

	@Override
	public int commentsUpdate(SnsVO vo) {
		// TODO 댓글 가져와서 수정
		return 0;
	}

	@Override
	public int boardDelete(SnsVO vo) {
		// TODO 게시글 삭제
		return 0;
	}

	@Override
	public int commentsDelete(SnsVO vo) {
		// TODO 댓글 삭제
		return 0;
	}

}
