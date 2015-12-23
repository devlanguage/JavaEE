package com.lovo.cq.shopping10_1.po;

import java.util.Map;

public class NotePager {

	private Map noteMap; // 鍏憡闆嗗悎

	private int totalNum; // 鍒嗛〉鐨勬�绘潯鏁�

	private int pageSize; // 姣忛〉鏄剧ず鐨勬潯鏁�

	private int pagecurrentPageNo; // 褰撳墠绗嚑椤�

	private int pageNum; // 鎬婚〉鏁�

	private int pageOffset; // 鏁版嵁搴搇imit璇彞涓殑绱㈠紩鍊�

	public Map getNoteMap() {
		return noteMap;
	}

	public void setNoteMap(Map noteMap) {
		this.noteMap = noteMap;
	}

	public int getPagecurrentPageNo() {
		return pagecurrentPageNo;
	}

	public void setPagecurrentPageNo(int pagecurrentPageNo) {
		this.pagecurrentPageNo = pagecurrentPageNo;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageOffset() {
		return pageOffset;
	}

	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
}
