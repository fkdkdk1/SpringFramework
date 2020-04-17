package com.mvc.upgrade.model.dto;

public class PageDto {
	
	private int nowPage;	//현재 페이지
	private int startPage;	//시작 페이지
	private int endPage;	// 끝페이지
	private int total;		// 게시글 총 개수
	private int cntPerPage;	// 페이지당 글 갯수
	private int lastPage;	// 마지막 페이지 
	private int start;		// SQL 쿼리에 쓸 start
	private int end;		// SQL 쿼리에 쓸 end
	
	private int pagegroup;
	
	private int cntPage = 5; 
	
	
	public PageDto() {}
	

	 
	public PageDto(int total, int nowPage, int cntPerPage) {
		
		// HomeController에서 아규먼트로 보낸 파라미터들을 set
		setNowPage(nowPage);
		setCntPerPage(cntPerPage);
		setTotal(total);
		
	}
	
	// 제일 마지막 페이지 계산
	public void calcLastPage(int total, int cntPerPage) {
		// ex ) total : 31 , cntPerPage : 5  -> LastPage = 7
		setLastPage((int)Math.ceil((double)total / (double)cntPerPage));
	}
	
	
	
	//DB 쿼리에서 사용할 start, end값 계산
	public void calcStartEnd(int nowPage, int cntPerPage) {
		setEnd(nowPage * cntPerPage);
		setStart(getEnd() - cntPerPage + 1);
	}
	
	public void calcGroup() {
		
		setPagegroup((int)Math.ceil((double)nowPage/(double)cntPage));  
		setEndPage(getPagegroup() * cntPage);
		setStartPage(getEndPage() - cntPage + 1);
	}
	
	public int getNowPage() {
		
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCntPerPage() {
		return cntPerPage;
	}

	public void setCntPerPage(int cntPerPage) {
		this.cntPerPage = cntPerPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getCntPage() {
		return cntPage;
	}

	public void setCntPage(int cntPage) {
		this.cntPage = cntPage;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}



	public int getPagegroup() {
		return pagegroup;
	}



	public void setPagegroup(int pagegroup) {
		this.pagegroup = pagegroup;
	}



	
	
	
}