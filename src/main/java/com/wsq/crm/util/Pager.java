package com.wsq.crm.util;

/**
 * Created by admin on 2017/7/26.
 * 分页类，用于支持数据查询和在页面上生成分页信息及页码
 *
 */
public class Pager {
//    当前页码
    private int pageNo; //传过来的
    private int pageSize;//每页显示的数据条数 传过来的 默认的 是显示2条
    private int total;//总的数据条数  传过来的
    private int pageCount;//总页数 使用数据总条数和每页的数据数 计算得到
    private int showPageNos; // 最多显示的页码数  传过来的
    private int start; //起始页码  算出来的
    private int end; // 终止页码  算出来的

    public Pager(int pageNo, int total, int pageSize, int showPageNos){
        this.pageNo = pageNo;
        this.total = total;
        this.pageSize = pageSize;
        this.showPageNos = showPageNos;
        calc();
        //valid();
    }
    public Pager(int pageNo, int total){
        this(pageNo, total, 2,4);
    }
    private void calc(){
        pageCount = total % pageSize > 0 ? total/pageSize + 1:total/pageSize;
        //计算 start、end
        start = end = pageNo;
        while (end - start + 1 < showPageNos && (start > 1 || end < pageCount)){
            if (start > 1 ){
                start--;
            }
            if(end - start + 1 < showPageNos && end < pageCount){
                end++;
            }
        }
    }
    private void valid(){
        if (pageNo < 1) throw new PagerException("pageNo",1);
        if (pageSize < 1) throw new PagerException("pageSize",1);
        if (total < 0) throw  new PagerException("total",0);
        if (showPageNos < 1) throw new PagerException("showPageNos",1);
        if (total == 0) System.out.println("警告：分页数据总条数为0！");
    }
    public class PagerException extends RuntimeException{
        private static final long serialVersionUID = 1L;
        public PagerException(String property, int minValue){
            super(String.format("分页参数%s不能小于%d",property,minValue));
        }
    }
 /*   public static void main(String[] args){
        Pager page = new Pager(1,11);

    }*/

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getShowPageNos() {
        return showPageNos;
    }

    public void setShowPageNos(int showPageNos) {
        this.showPageNos = showPageNos;
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
}
