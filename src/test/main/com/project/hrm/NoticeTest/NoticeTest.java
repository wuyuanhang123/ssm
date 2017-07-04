package com.project.hrm.NoticeTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.hrm.BaseTest.BaseTest;
import com.project.hrm.Dao.NoticeDao;
import com.project.hrm.Page.PageModel;
import com.project.hrm.domain.Notice;

public class NoticeTest extends BaseTest{
	private final Logger log = LoggerFactory.getLogger(NoticeTest.class);
	@Autowired
    private NoticeDao noticedao;
	
	@Ignore
	@Test
	public void countNotice(){
		 Map<String,Object> params=new HashMap<String,Object>();
		 Integer record=noticedao.countNotice(params);
		if(record!=null){
		 log.info("error");
		}
	}
	@Ignore
	@Test
	public void selectByIdTest(){
		Integer id=1;
		Notice notice=noticedao.selectnoticeById(id);
		System.out.println(notice);
	}
	@Ignore
	@Test
	public void insertNoticeTest(){
		Notice notice=new Notice();
		notice.setTitle("֪ͨ");
		notice.setContent("֪ͨ");
		noticedao.insertNotice(notice);
	}
	@Test
	  public void selectBypageTest(){
		  Map<String,Object> params=new HashMap<String,Object>();
		  PageModel pageModel=new PageModel();
		  pageModel.setPageIndex(1);
		  pageModel.setFirstLimitParam(pageModel.getFirstLimitParam());
		  params.put("pageModel", pageModel);
		  List<Notice> notices=noticedao.selectByPage(params);
		  int record=noticedao.countNotice(params);
		  System.out.println(record);
		  for(int i=0;i<notices.size();i++){
				 System.out.println(notices.get(i));
			 }
}
	  @Test
	  public void updateDeptTest(){
		Notice notice=new Notice();
		 notice.setId(2);
		 notice.setTitle("֪ͨ");
		 noticedao.updateNotice(notice);
	  }
}
