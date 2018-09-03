package com.example.herocat.wtlock.bean;

public class LockCodeBean {

    /**
     * result : SUCCESS
     * payload : {"PinCode":"3016 5730 7953"}
     */

    private String result;
    private PayloadBean payload;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public PayloadBean getPayload() {
        return payload;
    }

    public void setPayload(PayloadBean payload) {
        this.payload = payload;
    }

    public static class PayloadBean {
        /**
         * PinCode : 3016 5730 7953
         */

        private String PinCode;

        public String getPinCode() {
            return PinCode;
        }

        public void setPinCode(String PinCode) {
            this.PinCode = PinCode;
        }
    }
}
