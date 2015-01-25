package page;

	public class Pager {
	    
	    private String url;
	    private int size;
	    private int rows;
	    private int cpage;
	    private int pagers;
	    private int nums;
	    
	    /**
	     * 构造方法
	     * @param url 链接
	     * @param size 每页显示数量
	     * @param cpage    当前页数
	     * @param rows 总数据行数
	     */
	    private Pager(String url,int size,int rows,int cpage,int nums) {
	        this.url = url.indexOf("?")>-1?url+"&offset.pager=":url+"?offset.pager=";
	        this.size = size;
	        this.rows = rows;
	        this.pagers = rows%size>0?rows/size+1:rows/size;
	        this.cpage = cpage<1?1:cpage>this.pagers?this.pagers:cpage;
	        this.nums = nums<5?5:nums;
	    }
	    
	    
	    /**
	     * 获得分页字符串
	     * @param url 链接
	     * @param size 每页显示数量
	     * @param cpage    当前页数
	     * @param rows 总数据行数
	     * @return 分页字符串
	     */
	    public static String getPagerStr(String url,int size,int rows,int cpage,int nums) {
	        StringBuffer page=new StringBuffer();
	        Pager pager=new Pager(url,size,rows,cpage,nums);
	        page.append("<table border=\"0\" cellspacing=\"5\" cellpadding=\"0\"><tr>");
	        page.append("<td><div class=\"pageclass1\">&nbsp;&nbsp;&nbsp;<a href=\""+pager.url+1+"\">首页</a>&nbsp;&nbsp;</div></td>");
	        page.append("<td><div class=\"pageclass1\"><a href=\""+pager.url+pager.getPrivior()+"\">上一页</a>&nbsp;&nbsp;</div></td>");
	        
	        for(int i= pager.getStart(); i<pager.getEnd()+1; i++) {
	            if(i==pager.cpage)
	                page.append("<td><div class=\"pageclass2\">"+i+"&nbsp;&nbsp;</div></td>");
	            else
	                page.append("<td><div class=\"pageclass1\"><a href=\""+pager.url+i+"\">"+i+"</a>&nbsp;&nbsp;</div></td>");
	        }
	        
	        page.append("<td><div class=\"pageclass1\"><a href=\""+pager.url+pager.getNext()+"\">下一页</a>&nbsp;&nbsp;</div></td>");
	        page.append("<td><div class=\"pageclass1\"><a href=\""+pager.url+pager.pagers+"\">末页</a>&nbsp;&nbsp;&nbsp;&nbsp;</div></td>");
	        page.append("<td><select onchange=\"window.location='"+pager.url+"'+this.value;\">");
	        for(int i=1; i<pager.pagers+1; i++) {
	            if(i==cpage)
	                page.append("<option selected=selected value=\""+i+"\">"+i+"</option> ");
	            else
	                page.append("<option value=\""+i+"\">"+i+"</option> ");
	        }
	        page.append("</select>&nbsp;&nbsp;&nbsp;&nbsp;</td>");
	        page.append("<td><div class=\"pageclass2\">当前页数/总页数："+pager.cpage+"/"+pager.pagers+"&nbsp;&nbsp;</div></td>");
	        page.append("<td><div class=\"pageclass2\">每页"+pager.size+"条数据 &nbsp;&nbsp;共"+pager.rows+"条数据</div></td>");
	        page.append("</tr></table>");
	        return page.toString();
	    }
	    /**
	     * 本页开始数字
	     * @return 数字
	     */
	    private int getStart() {
	        return this.cpage%this.nums>0?this.cpage/this.nums*this.nums+1:(this.cpage-1)/this.nums*this.nums+1;
	    }
	    
	    /**
	     * 本页结束数字
	     * @return 数字
	     */
	    private int getEnd() {
	        int temp = (this.cpage/this.nums+1)*this.nums;
	        return this.cpage%this.nums>0?temp>this.pagers?this.pagers:temp:this.cpage;
	    }
	    /**
	     * 上一页
	     * @return 上一页页码
	     */
	    private int getPrivior() {
	        return cpage>1?cpage-1:1;
	    }
	    /**
	     * 下一页
	     * @return 下一页页码
	     */
	    private int getNext() {
	        return cpage<this.pagers?cpage+1:this.pagers;
	    }
	    
	}
