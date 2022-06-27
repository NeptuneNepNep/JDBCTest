package sample;

public class Fruit {


    public Fruit(Integer fid, String fname, Integer fprice, Integer fcount, String remark) {
        this.fid = fid;
        this.fname = fname;
        this.fprice = fprice;
        this.fcount = fcount;
        this.remark = remark;
    }

    private  Integer fid;
    private  String fname;
    private  Integer fprice;
    private  Integer fcount;
    private  String remark;
    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Integer getFprice() {
        return fprice;
    }

    public void setFprice(Integer fprice) {
        this.fprice = fprice;
    }

    public Integer getFcount() {
        return fcount;
    }

    public void setFcount(Integer fcount) {
        this.fcount = fcount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
