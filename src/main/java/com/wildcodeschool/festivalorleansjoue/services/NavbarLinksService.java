package com.wildcodeschool.festivalorleansjoue.services;

import org.springframework.stereotype.Service;


@Service
public class NavbarLinksService {
	
	private String currentPage;	
	
	
	public NavbarLinksService() {
	}

	
	public String getCurrentPage() {
		
		return this.currentPage;
	}
	

	public void setCurrentPage(String currentPage) {
		
		this.currentPage = currentPage;
	}	
}
