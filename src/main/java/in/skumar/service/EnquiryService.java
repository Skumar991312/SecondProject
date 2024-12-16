package in.skumar.service;

import java.util.List;

import in.skumar.bindig.DashboardResponse;
import in.skumar.bindig.EnquiryForm;
import in.skumar.bindig.EnquirySearchCriteria;


public interface EnquiryService {
	
	public List<String> getCourseNames();
	
	public List<String> getEnqStatus();
	
	public DashboardResponse getDashboardData(Integer userId);
	
	public String addEnquiry(EnquiryForm form);
	
    public List<String> getEnquries(Integer userId,EnquirySearchCriteria criteria);
    
    public EnquiryForm getEnquiry(Integer enqId);
	
}
