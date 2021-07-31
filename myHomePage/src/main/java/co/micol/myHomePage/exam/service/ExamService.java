package co.micol.myHomePage.exam.service;

import java.util.List;

import co.micol.myHomePage.vo.ExamVO;

public interface ExamService {
	List<ExamVO> examSelectList();
	
	ExamVO examSelect(ExamVO vo);
	
	int examInsert(ExamVO vo);
	int examUpdate(ExamVO vo);
	int examDelete(ExamVO vo);
}
