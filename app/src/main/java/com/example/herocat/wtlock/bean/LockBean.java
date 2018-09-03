package com.example.herocat.wtlock.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class LockBean implements Serializable {

    /**
     * result : SUCCESS
     * payload : {"1":{"List":[{"Power":12,"CabName":"测试锁柜","WarnCode":"","ModelCode":"","CabID":1,"DeviceMAC":"112233445566","Detail":"杭州市西湖区","Status":"10","OrderBy":1,"UID":0,"LockModel":"20","DeviceName":"测试设备","CreateTime":"","County":"","City":"","Province":""}],"Detail":"杭州市西湖区"}}
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

    public static class PayloadBean implements Serializable {
        /**
         * 1 : {"List":[{"Power":12,"CabName":"测试锁柜","WarnCode":"","ModelCode":"","CabID":1,"DeviceMAC":"112233445566","Detail":"杭州市西湖区","Status":"10","OrderBy":1,"UID":0,"LockModel":"20","DeviceName":"测试设备","CreateTime":"","County":"","City":"","Province":""}],"Detail":"杭州市西湖区"}
         */

        @SerializedName("1")
        private _$1Bean _$1;

        public _$1Bean get_$1() {
            return _$1;
        }

        public void set_$1(_$1Bean _$1) {
            this._$1 = _$1;
        }

        public static class _$1Bean {
            /**
             * List : [{"Power":12,"CabName":"测试锁柜","WarnCode":"","ModelCode":"","CabID":1,"DeviceMAC":"112233445566","Detail":"杭州市西湖区","Status":"10","OrderBy":1,"UID":0,"LockModel":"20","DeviceName":"测试设备","CreateTime":"","County":"","City":"","Province":""}]
             * Detail : 杭州市西湖区
             */

            private String Detail;
            private java.util.List<ListBean> List;

            public String getDetail() {
                return Detail;
            }

            public void setDetail(String Detail) {
                this.Detail = Detail;
            }

            public List<ListBean> getList() {
                return List;
            }

            public void setList(List<ListBean> List) {
                this.List = List;
            }

            public static class ListBean implements Serializable {
                /**
                 * Power : 12
                 * CabName : 测试锁柜
                 * WarnCode :
                 * ModelCode :
                 * CabID : 1
                 * DeviceMAC : 112233445566
                 * Detail : 杭州市西湖区
                 * Status : 10
                 * OrderBy : 1
                 * UID : 0
                 * LockModel : 20
                 * DeviceName : 测试设备
                 * CreateTime :
                 * County :
                 * City :
                 * Province :
                 */

                private int Power;
                private String CabName;
                private String WarnCode;
                private String ModelCode;
                private int CabID;
                private String DeviceMAC;
                private String Detail;
                private String Status;
                private int OrderBy;
                private int UID;
                private String LockModel;
                private String DeviceName;
                private String CreateTime;
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
    }
}
