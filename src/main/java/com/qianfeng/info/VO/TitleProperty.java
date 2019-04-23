package com.qianfeng.info.VO;

import java.util.List;

public class TitleProperty {
    private String estimateName;
    private int estimatePage;
    private List<InfoProperty> infolist;

    @Override
    public String toString() {
        return "TitleProperty{" +
                "estimateName='" + estimateName + '\'' +
                ", estimatePage=" + estimatePage +
                ", infolist=" + infolist +
                '}';
    }

    public String getEstimateName() {
        return estimateName;
    }

    public void setEstimateName(String estimateName) {
        this.estimateName = estimateName;
    }

    public int getEstimatePage() {
        return estimatePage;
    }

    public void setEstimatePage(int estimatePage) {
        this.estimatePage = estimatePage;
    }

    public List<InfoProperty> getInfolist() {
        return infolist;
    }

    public void setInfolist(List<InfoProperty> infolist) {
        this.infolist = infolist;
    }
}
