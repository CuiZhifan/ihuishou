package com.qianfeng.index.VO;

import java.util.List;

public class IndexFQuery {
    private String fname;
    private List<IndexCQuery> clist;

    @Override
    public String toString() {
        return "IndexFQuery{" +
                "fname='" + fname + '\'' +
                ", clist=" + clist +
                '}';
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public List<IndexCQuery> getClist() {
        return clist;
    }

    public void setClist(List<IndexCQuery> clist) {
        this.clist = clist;
    }
}
