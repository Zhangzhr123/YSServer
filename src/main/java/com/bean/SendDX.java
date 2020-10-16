package com.bean;

public class SendDX {

    private String Mbl;

    private String SMSText;

    private String SendTime;

    public String getMbl() {
        return Mbl;
    }

    public void setMbl(String mbl) {
        Mbl = mbl;
    }

    public String getSMSText() {
        return SMSText;
    }

    public void setSMSText(String SMSText) {
        this.SMSText = SMSText;
    }

    public String getSendTime() {
        return SendTime;
    }

    public void setSendTime(String sendTime) {
        SendTime = sendTime;
    }
}
