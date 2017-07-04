package com.project.hrm.Controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.hrm.Page.PageModel;
import com.project.hrm.Service.HrmService;

import com.project.hrm.domain.Document;
import com.project.hrm.domain.User;


@Controller
public class DocumentController {
  @Autowired
  @Qualifier("hrmService")
  private HrmService hrmService;
  
  /*
   * 处理查询文件功能
   * param Model对象
   * param Document对象
   * param PageIndex
   */
  @RequestMapping(value="/document/selectDocument")
	public String selectDept(Integer pageIndex,
			@ModelAttribute Document document,
			Model model){
		System.out.println("document-->"+document);
		PageModel pageModel=new PageModel();
		if(pageIndex!=null){
			pageModel.setPageIndex(pageIndex);
		}
		List<Document> documents=hrmService.SelectBypage(document, pageModel);
		model.addAttribute("document",document);
		model.addAttribute("documents",documents);
		model.addAttribute("pageModel",pageModel);
		return "document/document";
	}
  /*
   * 处理上传文件请求
   * @param String flag ,1表示跳转到上传页面 2执行上传操作
   * @param Document 文件
   * @param ModelAndView mv
   */
  
  @RequestMapping(value="/document/insertDocument")
  public ModelAndView insertDocument(
		  String flag,
		  @ModelAttribute Document document,
		  ModelAndView mv,
		  HttpSession session)throws Exception{
	  if(flag.equals("1")){
		  mv.setViewName("document/showinsertDocument");
	  }else{
		  String path=session.getServletContext().getRealPath("/upload/");
		  System.out.println("path "+path);
		  String fileName=document.getFile().getOriginalFilename();
		  System.out.println("fileName "+fileName);
		  File targetfile=new File(path,fileName);
		  if(!targetfile.exists()){
			  targetfile.mkdirs();
		  }
		  document.getFile().transferTo(targetfile);
		  document.setFilename(fileName);
		  System.out.println("document "+document);
		  User user=(User)session.getAttribute("user");
		  document.setUser(user);
		  hrmService.insertDocument(document);
		  mv.setViewName("redirect:/document/selectDocument");
	  }
	  return mv;
  }
  
  @RequestMapping(value="/document/deleteDocument")
	public ModelAndView removeDocument(String ids,ModelAndView mv){
		String[] idArray=ids.split(",");
		for(String id:idArray){
			hrmService.deletedocumentById(Integer.parseInt(id));
		}
		mv.setViewName("redirect:/document/selectDocument");
		return mv;
	}
  
  @RequestMapping(value="/document/updateDocument")
	public ModelAndView updateDocument(
			String flag,
			@ModelAttribute Document document,
			ModelAndView mv){
		if(flag.equals("1")){
              
			Document target=hrmService.selectDocumentById(document.getId());
			mv.addObject("document",target);
			mv.setViewName("document/showupdateDocument");
		}else{
			hrmService.updateDocument(document);
			mv.setViewName("redirect:/document/selectDocument");
		}	
		return mv;
	}
  
  @RequestMapping(value="/document/downLoad")
  public ResponseEntity<byte[]> downLoad(
		  Integer id,
		  HttpSession session)throws Exception{
      Document target=hrmService.selectDocumentById(id);
      String fileName=target.getFilename();
      String path=session.getServletContext().getRealPath("/upload/");
      File file=new File(path+File.separator+fileName);
      HttpHeaders headers=new HttpHeaders();
      String downloadFielName=new String(fileName.getBytes("UTF-8"),"iso-8859-1");
      headers.setContentDispositionFormData("attachment",downloadFielName);
      headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
      return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);
  }
}
