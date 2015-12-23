package com.lovo.cq.shopping10_1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lovo.cq.shopping10_1.model.Model;
import com.lovo.cq.shopping10_1.po.OrderSendPager;
import com.lovo.cq.shopping10_1.po.UserPager;

public class GetOrderSendPagerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//浠庣鍑犳潯璁板綍寮�濮嬫煡璇�
		String pagerOffset = request.getParameter("pager.offset");
		//鏌ヨ澶氬皯鏉℃暟鎹�
		String pageSize_str = request.getParameter("pageSize");
		int offset = 0;
		int pagecurrentPageNo = 1;
		int pageSize = 5;
		if(pagerOffset != null && pageSize_str != null) {
			offset = Integer.parseInt(pagerOffset);
			pageSize = Integer.parseInt(pageSize_str);
		}
		Model model = new Model();
		OrderSendPager osp = model.getOrderSendPager(offset, pageSize);
		if(osp.getOrderMap().size() == 0 && offset != 0) {
			offset -=pageSize;
			osp = model.getOrderSendPager(offset, pageSize);
		}
		if(offset%pageSize == 0 || offset/pageSize >0) {
			pagecurrentPageNo = offset/pageSize + 1;
		}
		osp.setPageOffset(offset);
		osp.setPagecurrentPageNo(pagecurrentPageNo);
		request.getSession().setAttribute("orderPager", osp);
		request.getSession().setAttribute("orderList", osp.getOrderMap().values());
		request.getRequestDispatcher("Admin/pages/manageSendOrder.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
