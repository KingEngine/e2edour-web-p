package com.e2edour.web.p.common;

public enum MenuTranCodes {

    TRANCODE_TEXTJOKE("F_001", "文字笑话"), TRANCODE_IMGJOKE("F_002", "国片笑话"), TRANCODE_SURPRISE(
            "F_003", "奇思妙趣"), TRANCODE_ADVS("F_004", "广而告之");

    private String tranCode;
    private String desc;

    public String getTranCode() {
        return this.tranCode;
    }

    public void setTranCode(String tranCode) {
        this.tranCode = tranCode;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private MenuTranCodes(String tranCode, String desc) {
        this.tranCode = tranCode;
        this.desc = desc;
    }

}
