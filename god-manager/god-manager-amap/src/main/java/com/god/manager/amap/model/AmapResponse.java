package com.god.manager.amap.model;

public class AmapResponse {

    // 值为0或1  1：成功；0：失败。
    private Integer status;

    // 返回的状态信息
    private String info;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "AmapResponse{" +
                "status=" + status +
                ", info='" + info + '\'' +
                '}';
    }
}
