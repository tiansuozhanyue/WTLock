package com.example.herocat.wtlock.bean;

import java.util.List;

public class TipBean {

    /**
     * result : SUCCESS
     * payload : [{"Power":345,"UserID":2,"WarnCode":"56","Type":"","Description":"低电量","LockModel":"21","UpListID":2,"DeviceMAC":"112233445566","CreateTime":"2018-08-31 12:12:12 789","Direction":"Up","Status":"11","HexCode":"56"}]
     */

    private String result;
    private List<PayloadBean> payload;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<PayloadBean> getPayload() {
        return payload;
    }

    public void setPayload(List<PayloadBean> payload) {
        this.payload = payload;
    }

    public static class PayloadBean {
        /**
         * Power : 345
         * UserID : 2
         * WarnCode : 56
         * Type :
         * Description : 低电量
         * LockModel : 21
         * UpListID : 2
         * DeviceMAC : 112233445566
         * CreateTime : 2018-08-31 12:12:12 789
         * Direction : Up
         * Status : 11
         * HexCode : 56
         */

        private int Power;
        private int UserID;
        private String WarnCode;
        private String Type;
        private String Description;
        private String LockModel;
        private int UpListID;
        private String DeviceMAC;
        private String CreateTime;
        private String Direction;
        private String Status;
        private String HexCode;

        public int getPower() {
            return Power;
        }

        public void setPower(int Power) {
            this.Power = Power;
        }

        public int getUserID() {
            return UserID;
        }

        public void setUserID(int UserID) {
            this.UserID = UserID;
        }

        public String getWarnCode() {
            return WarnCode;
        }

        public void setWarnCode(String WarnCode) {
            this.WarnCode = WarnCode;
        }

        public String getType() {
            return Type;
        }

        public void setType(String Type) {
            this.Type = Type;
        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(String Description) {
            this.Description = Description;
        }

        public String getLockModel() {
            return LockModel;
        }

        public void setLockModel(String LockModel) {
            this.LockModel = LockModel;
        }

        public int getUpListID() {
            return UpListID;
        }

        public void setUpListID(int UpListID) {
            this.UpListID = UpListID;
        }

        public String getDeviceMAC() {
            return DeviceMAC;
        }

        public void setDeviceMAC(String DeviceMAC) {
            this.DeviceMAC = DeviceMAC;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public String getDirection() {
            return Direction;
        }

        public void setDirection(String Direction) {
            this.Direction = Direction;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }

        public String getHexCode() {
            return HexCode;
        }

        public void setHexCode(String HexCode) {
            this.HexCode = HexCode;
        }
    }
}
