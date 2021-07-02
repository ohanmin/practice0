package poly.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.dto.BoardDTO;
import poly.service.IBoardService;


@Controller
public class BoardController {
	Logger log = Logger.getLogger(this.getClass());
	@Resource(name = "BoardService")
	IBoardService iBoardService;

	@RequestMapping(value = "board/boardList")
	public String springList(ModelMap model) {
		List<BoardDTO> rList = iBoardService.getBoardList();
		for(BoardDTO b : rList) {
			log.info("boardno = "+b.getPost_no());
		}
		model.addAttribute("rList", rList);
		return "/board/boardList";
	}
	@RequestMapping(value = "board/newPost" ,method=RequestMethod.GET)
	public String newPost() {
		
		return "/board/newPost";
	}
	@RequestMapping(value = "board/doPost")
	public String newPost(HttpServletRequest req, ModelMap model) {
		String id = "admin";
		String post_title = req.getParameter("post_title");
		String post_content = req.getParameter("post_content");
		BoardDTO bDto  = new BoardDTO();
		bDto.setReg_id(id);
		bDto.setPost_title(post_title);
		bDto.setPost_content(post_content);
		int res = iBoardService.insertPost(bDto);
		String msg;
		String url = "/board/boardList.do";
		if(res>0) {
			msg = "등록에 성공했습니다.";
		}else {
			msg = "등록에 실패했습니다.";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		return "/redirect";
	}
	@RequestMapping(value = "board/boardDetail")
	public String boardDetail(HttpServletRequest req, ModelMap model) {
		System.out.println("no :" + req.getParameter("no"));
		int post_no = Integer.parseInt(req.getParameter("no"));
		log.info("req:"+req.getParameter("no"));
		BoardDTO bDto = iBoardService.getBoardDetail(post_no);
		model.addAttribute("bDto", bDto);
		return "/board/boardDetail";
	}
	@RequestMapping(value = "board/editPost", method=RequestMethod.GET)
	public String editPost(HttpServletRequest req, ModelMap model) {
		int post_no = Integer.parseInt(req.getParameter("no"));
		BoardDTO bDto = iBoardService.getBoardDetail(post_no);
		model.addAttribute("bDto", bDto);
		return "/board/editPost";
	}
	@RequestMapping(value = "board/doEditPost")
	public String edittPost(HttpServletRequest req, ModelMap model) {
		int post_no = Integer.parseInt(req.getParameter("post_no"));
		String id = "admin";
		log.info("edit의 post_no ="+post_no);
		String post_title = req.getParameter("post_title");
		String post_content = req.getParameter("post_content");
		BoardDTO bDto = new BoardDTO();
		bDto.setPost_no(post_no);
		bDto.setReg_id(id);
		bDto.setPost_title(post_title);
		bDto.setPost_content(post_content);
		int res = iBoardService.editPost(bDto);
		String msg;
		String url = "/board/boardDetail.do?no="+Integer.toString(post_no);
		//String url ="/board/boardDetail.do?no="+Integer.toString(post_no);
		if(res>0) {
			msg = "등록에 성공했습니다.";
		}else {
			msg = "등록에 실패했습니다.";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		return "/redirect";
		
	}
	@RequestMapping(value = "board/deletePost")
	public String deletePost(HttpServletRequest req, ModelMap model) {
		int post_no = Integer.parseInt(req.getParameter("no"));
		int res = iBoardService.deletePost(post_no);
		String msg;
		String url = "/board/boardList.do";
		if(res>0) {
			msg = "삭제에 성공했습니다.";
		}else{
			msg = "등록 실패";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		return "/redirect";
	}
}
