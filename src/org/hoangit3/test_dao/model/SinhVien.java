package org.hoangit3.test_dao.model;

public class SinhVien {
    private int sid;
    private String sname;
    private String address;
    private int cid;
    public SinhVien() {

    }

    public SinhVien(int sid, String sname, String address, int cid) {
        this.sid = sid;
        this.sname = sname;
        this.address = address;
        this.cid = cid;
    }
    @Override
    public String toString() {
        return "SinhVien{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", address='" + address + '\'' +
                ", cid=" + cid +
                '}';
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
