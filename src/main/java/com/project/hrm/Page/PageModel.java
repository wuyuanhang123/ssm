package com.project.hrm.Page;

public class PageModel {
    private int recordCount;
    private int pageIndex;
    private int pageSize=4;
    private int totalSize;
    private int FirstLimitParam;
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public int getPageIndex() {

		
		this.pageIndex=this.pageIndex==0?1:this.pageIndex;
		if(this.getRecordCount()>0){
		
		this.pageIndex=this.pageIndex>=this.getTotalSize()?this.getTotalSize():this.pageIndex;
		}
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;

	}
	public int getPageSize() {
		this.pageSize=this.pageSize<=4?4:this.pageSize;
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalSize() {
		if(this.getRecordCount()<=0){
			totalSize=0;
		}else{
			totalSize=(this.getRecordCount()-1)/this.getPageSize()+1;
		}
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public int getFirstLimitParam(){
	
		int Firstlimit= (this.getPageIndex()-1)*this.getPageSize();
		return Firstlimit;
	}
	public void setFirstLimitParam(int FirstLimitParam){
		if(FirstLimitParam<0) FirstLimitParam=0;
		this.FirstLimitParam=FirstLimitParam;
	}
	
	
}
