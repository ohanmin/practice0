package poly.service;

import java.util.List;

import poly.dto.BoardDTO;

public interface IBoardService {

	List<BoardDTO> getBoardList();

	int insertPost(BoardDTO bDto);

	BoardDTO getBoardDetail(int post_no);

	int editPost(BoardDTO bDto);

	int deletePost(int post_no);

}
