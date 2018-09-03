package com.example.herocat.wtlock.bean;

import java.util.List;

public class ActionBean {

    /**
     * result : SUCCESS
     * payload : [{"Power":0,"CabName":"测试锁柜","WarnCode":"10","ModelCode":"","Description":"读取状态","CabID":1,"DeviceMAC":"112233445566","Detail":"杭州市西湖区","Action":"00","Direction":"Down","Status":"10","OrderBy":1,"HexCode":"00","UserID":1,"Type":"","UID":0,"LockModel":"21","DeviceName":"测试设备","CreateTime":"","DownListID":4,"County":"","City":"","Province":""},{"Power":0,"CabName":"测试锁柜","WarnCode":"10","ModelCode":"","Description":"读取状态","CabID":1,"DeviceMAC":"112233445566","Detail":"杭州市西湖区","Action":"00","Direction":"Down","Status":"10","OrderBy":1,"HexCode":"00","UserID":1,"Type":"","UID":0,"LockModel":"21","DeviceName":"测试设备","CreateTime":"","DownListID":3,"County":"","City":"","Province":""}]
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
         * Power : 0
         * CabName : 测试锁柜
         * WarnCode : 10
         * ModelCode :
         * Description : 读取状态
         * CabID : 1
         * DeviceMAC : 112233445566
         * Detail : 杭州市西湖区
         * Action : 00
         * Direction : Down
         * Status : 10
         * OrderBy : 1
         * HexCode : 00
         * UserID : 1
         * Type :
         * UID : 0
         * LockModel : 21
         * DeviceName : 测试设备
         * CreateTime :
         * DownListID : 4
         * County :
         * City :
         * Province :
         */

        private int Power;
        private String CabName;
        private String WarnCode;
        private String ModelCode;
        private String Description;
        private int CabID;
        private String DeviceMAC;
        private String Detail;
        private String Action;
        private String Direction;
        private String Status;
        private int OrderBy;
        private String HexCode;
        private int UserID;
        private String Type;
        private int UID;
        private String LockModel;
        private String DeviceName;
        private String CreateTime;
        private int DownListID;
        private String County;
        private String City;
        private String Province;

        public int getPower() {
            return Power;
        }

        public void setPower(int Power) {
            this.Power = Power;
        }

        public String getCabName() {
            return CabName;
        }

        public void setCabName(String CabName) {
            this.CabName = CabName;
        }

        public String getWarnCode() {
            return WarnCode;
        }

        public void setWarnCode(String WarnCode) {
            this.WarnCode = WarnCode;
        }

        public String getModelCode() {
            return ModelCode;
        }

        public void setModelCode(String ModelCode) {
            this.ModelCode = ModelCode;
        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(String Description) {
            this.Description = Description;
        }

        public int getCabID() {
            return CabID;
        }

        public void setCabID(int CabID) {
            this.CabID = CabID;
        }

        public String getDeviceMAC() {
            return DeviceMAC;
        }

        public void setDeviceMAC(String DeviceMAC) {
            this.DeviceMAC = DeviceMAC;
        }

        public String getDetail() {
            return Detail;
        }

        public void setDetail(String Detail) {
            this.Detail = Detail;
        }

        public String getAction() {
            return Action;
        }

        public void setAction(String Action) {
            this.Action = Action;
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

        public int getOrderBy() {
            return OrderBy;
        }

        public void setOrderBy(int OrderBy) {
            this.OrderBy = OrderBy;
        }

        public String getHexCode() {
            return HexCode;
        }

        public void setHexCode(String HexCode) {
            this.HexCode = HexCode;
        }

        public int getUserID() {
            return UserID;
        }

        public void setUserID(int UserID) {
            this.UserID = UserID;
        }

        public String getType() {
            return Type;
        }

        public void setType(String Type) {
            this.Type = Type;
        }

        public int getUID() {
            return UID;
        }

        public void setUID(int UID) {
            this.UID = UID;
        }

        public String getLockModel() {
            return LockModel;
        }

        public void setLockModel(String LockModel) {
            this.LockModel = LockModel;
        }

        public String getDeviceName() {
            return DeviceName;
        }

        public void setDeviceName(String DeviceName) {
            this.DeviceName = DeviceName;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public int getDownListID() {
            return DownListID;
        }

        public void setDownListID(int DownListID) {
            this.DownListID = DownListID;
        }

        public String getCounty() {
            return County;
        }

        public void setCounty(String County) {
            this.County = County;
        }

        public String getCity() {
            return City;
        }

        public void setCity(String City) {
            this.City = City;
        }

        public String getProvince() {
            return Province;
        }

        public void setProvince(String Province) {
            this.Province = Province;
        }
    }
}
