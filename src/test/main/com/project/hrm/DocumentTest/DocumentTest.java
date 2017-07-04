package com.project.hrm.DocumentTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.hrm.BaseTest.BaseTest;
import com.project.hrm.Dao.DocumentDao;
import com.project.hrm.Page.PageModel;
import com.project.hrm.domain.Document;


public class DocumentTest  extends BaseTest{
	@Autowired
	private DocumentDao documentdao;
	
	@Test
	public void updateDocument(){
		Document document=new Document();
		document.setTitle("≤‚ ‘");
		document.setRemark("≤‚ ‘");
		document.setId(1);
		documentdao.updateDocument(document);
	}

	@Test
	public void countNotice(){
		 Map<String,Object> params=new HashMap<String,Object>();
		 Integer record=documentdao.countDocument(params);
		 System.out.println(record);
		
	}

	@Test
	public void selectByIdTest(){
		Integer id=1;
		Document document=documentdao.selectdocumentById(id);
		System.out.println(document);
	}

	@Test
	public void insertNoticeTest(){
		Document document=new Document();
		document.setTitle("≤‚ ‘");
		document.setFilename("≤‚ ‘");
		document.setRemark("≤‚ ‘");
		documentdao.insertDocument(document);
	}
	@Test
	  public void selectBypageTest(){
		  Map<String,Object> params=new HashMap<String,Object>();
		  PageModel pageModel=new PageModel();
		  pageModel.setPageIndex(1);
		  pageModel.setFirstLimitParam(pageModel.getFirstLimitParam());
		  params.put("pageModel", pageModel);
		  List<Document> documents=documentdao.selectByPage(params);
		  int record=documentdao.countDocument(params);
		  System.out.println(record);
		  for(int i=0;i<documents.size();i++){
				 System.out.println(documents.get(i));
			 }
	}
}
