package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.BoardDTO;
@Mapper("BoardMapper")
public interface IBoardMapper {

	List<BoardDTO> getBoardList();

	int insertPost(BoardDTO bDto);

	BoardDTO getBoardDetail(int post_no);

	int editPost(BoardDTO bDto);

	int deletePost(int post_no);

}
