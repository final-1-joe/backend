package com.mysite.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.project.service.SBQuestionService;
import com.mysite.project.vo.Pageing;
import com.mysite.project.vo.SBQuestionVO;


@RequestMapping("/support/board")
@RestController
public class SBQuestionController {
	
	private SBQuestionService sbquestionService;
	
	public SBQuestionController(SBQuestionService sbquestionService) {
		this.sbquestionService = sbquestionService;
	}

	
	@RequestMapping("/list")
	public List<SBQuestionVO> list(@RequestBody Pageing pg) {
	    List<SBQuestionVO> paging = this.sbquestionService.getList(pg.getPage(), pg.getLimit());
	    return paging;
	}
	@RequestMapping("/adlist")
	public List<SBQuestionVO> adlist(@RequestBody Pageing pg) {
	    List<SBQuestionVO> paging = this.sbquestionService.getAdList(pg.getPage(), pg.getLimit());
	    return paging;
	}
	
	@RequestMapping("/count") 
	public int getCount() { 
		int res = this.sbquestionService.getCount();
		return res;
	}
	
	@RequestMapping("/adcount") 
	public int getAdCount() { 
		return this.sbquestionService.getAdCount();
	}
	
	@RequestMapping("/insert")
    public void questionCreate(@RequestBody SBQuestionVO sbq) {
        this.sbquestionService.insert(sbq);

    }

	@RequestMapping("/detail") 
	public SBQuestionVO detail(@RequestBody SBQuestionVO sbq) {
	  SBQuestionVO question = this.sbquestionService.getQuestion(sbq);
	  return question;
	}
	
	@RequestMapping("/comment") 
	public SBQuestionVO comment(@RequestBody SBQuestionVO sbq) {
	  SBQuestionVO question = this.sbquestionService.getComment(sbq);
	  return question;
	}
	
	@RequestMapping("/update")
	public void update(@RequestBody SBQuestionVO sbq) {
	    this.sbquestionService.update(sbq);
	}
	
	@RequestMapping("/delete")
    public void delete(@RequestBody SBQuestionVO sbq) {
        this.sbquestionService.delete(sbq);

    }


}