package poly.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.BoardDTO;
import poly.persistance.mapper.IBoardMapper;
import poly.service.IBoardService;
@Service("BoardService")
public class BoardService implements IBoardService{
	@Resource(name="BoardMapper")
	IBoardMapper iBoardMapper;
	@Override
	public List<BoardDTO> getBoardList() {
		// TODO Auto-generated method stub
		return iBoardMapper.getBoardList();
	}
	@Override
	public int insertPost(BoardDTO bDto) {
		// TODO Auto-generated method stub
		return iBoardMapper.insertPost(bDto);
	}
	@Override
	public BoardDTO getBoardDetail(int post_no) {
		// TODO Auto-generated method stub
		return iBoardMapper.getBoardDetail(post_no);
	}
	@Override
	public int editPost(BoardDTO bDto) {
		// TODO Auto-generated method stub
		return iBoardMapper.editPost(bDto);
	}
	@Override
	public int deletePost(int post_no) {
		// TODO Auto-generated method stub
		return iBoardMapper.deletePost(post_no);
	}


}
