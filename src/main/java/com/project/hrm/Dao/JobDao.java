package com.project.hrm.Dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.project.hrm.Dao.provider.JobDynaSqlProvider;
import com.project.hrm.domain.Job;

public interface JobDao {

	@Select("SELECT * FROM job_inf WHERE id=#{id}")
	public Job selectjobById(Integer id);
	
	@Select("SELECT * FROM job_inf")
	public List<Job> findAllJob();
	
	@Delete("DELETE FROM job_inf WHERE id=#{id} ")
	public void deletejobById(Integer id);
	
	@SelectProvider(type=JobDynaSqlProvider.class,method="selectBypage")
	public List<Job> SelectBypage(Map<String,Object> params);
	
	@SelectProvider(type=JobDynaSqlProvider.class ,method="selectCount")
	public int countJob(Map<String,Object> params);
	
	@InsertProvider(type=JobDynaSqlProvider.class,method="insertJob")
	public void insertJob(Job job);
	
	@UpdateProvider(type=JobDynaSqlProvider.class,method="updateJob")
	public void updateJob(Job job);
}
