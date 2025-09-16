package com.Eamcet.predictor.model;

import jakarta.persistence.*;

@Entity
@Table(name = "colleges")
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sno;

    @Column(name = "name_of_the_institution")
    private String nameOfTheInstitution;

    private String region;
    private String place;
    private String affl;

    @Column(name = "branch_code")
    private String branchCode;

    @Column(name = "oc_boys")
    private Integer ocBoys;
    @Column(name = "oc_girls")
    private Integer ocGirls;
    @Column(name = "sc_boys")
    private Integer scBoys;
    @Column(name = "sc_girls")
    private Integer scGirls;
    @Column(name = "st_boys")
    private Integer stBoys;
    @Column(name = "st_girls")
    private Integer stGirls;
    @Column(name = "bca_boys")
    private Integer bcaBoys;
    @Column(name = "bca_girls")
    private Integer bcaGirls;
    @Column(name = "bcb_boys")
    private Integer bcbBoys;
    @Column(name = "bcb_girls")
    private Integer bcbGirls;
    @Column(name = "bcc_boys")
    private Integer bccBoys;
    @Column(name = "bcc_girls")
    private Integer bccGirls;
    @Column(name = "bcd_boys")
    private Integer bcdBoys;
    @Column(name = "bcd_girls")
    private Integer bcdGirls;
    @Column(name = "bce_boys")
    private Integer bceBoys;
    @Column(name = "bce_girls")
    private Integer bceGirls;
    @Column(name = "oc_ews_boys")
    private Integer ocEwsBoys;
    @Column(name = "oc_ews_girls")
    private Integer ocEwsGirls;

    public College() {}

    // Getters and Setters
    public Integer getSno() { return sno; }
    public void setSno(Integer sno) { this.sno = sno; }
    public String getNameOfTheInstitution() { return nameOfTheInstitution; }
    public void setNameOfTheInstitution(String nameOfTheInstitution) { this.nameOfTheInstitution = nameOfTheInstitution; }
    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }
    public String getPlace() { return place; }
    public void setPlace(String place) { this.place = place; }
    public String getAffl() { return affl; }
    public void setAffl(String affl) { this.affl = affl; }
    public String getBranchCode() { return branchCode; }
    public void setBranchCode(String branchCode) { this.branchCode = branchCode; }
    public Integer getOcBoys() { return ocBoys; }
    public void setOcBoys(Integer ocBoys) { this.ocBoys = ocBoys; }
    public Integer getOcGirls() { return ocGirls; }
    public void setOcGirls(Integer ocGirls) { this.ocGirls = ocGirls; }
    public Integer getScBoys() { return scBoys; }
    public void setScBoys(Integer scBoys) { this.scBoys = scBoys; }
    public Integer getScGirls() { return scGirls; }
    public void setScGirls(Integer scGirls) { this.scGirls = scGirls; }
    public Integer getStBoys() { return stBoys; }
    public void setStBoys(Integer stBoys) { this.stBoys = stBoys; }
    public Integer getStGirls() { return stGirls; }
    public void setStGirls(Integer stGirls) { this.stGirls = stGirls; }
    public Integer getBcaBoys() { return bcaBoys; }
    public void setBcaBoys(Integer bcaBoys) { this.bcaBoys = bcaBoys; }
    public Integer getBcaGirls() { return bcaGirls; }
    public void setBcaGirls(Integer bcaGirls) { this.bcaGirls = bcaGirls; }
    public Integer getBcbBoys() { return bcbBoys; }
    public void setBcbBoys(Integer bcbBoys) { this.bcbBoys = bcbBoys; }
    public Integer getBcbGirls() { return bcbGirls; }
    public void setBcbGirls(Integer bcbGirls) { this.bcbGirls = bcbGirls; }
    public Integer getBccBoys() { return bccBoys; }
    public void setBccBoys(Integer bccBoys) { this.bccBoys = bccBoys; }
    public Integer getBccGirls() { return bccGirls; }
    public void setBccGirls(Integer bccGirls) { this.bccGirls = bccGirls; }
    public Integer getBcdBoys() { return bcdBoys; }
    public void setBcdBoys(Integer bcdBoys) { this.bcdBoys = bcdBoys; }
    public Integer getBcdGirls() { return bcdGirls; }
    public void setBcdGirls(Integer bcdGirls) { this.bcdGirls = bcdGirls; }
    public Integer getBceBoys() { return bceBoys; }
    public void setBceBoys(Integer bceBoys) { this.bceBoys = bceBoys; }
    public Integer getBceGirls() { return bceGirls; }
    public void setBceGirls(Integer bceGirls) { this.bceGirls = bceGirls; }
    public Integer getOcEwsBoys() { return ocEwsBoys; }
    public void setOcEwsBoys(Integer ocEwsBoys) { this.ocEwsBoys = ocEwsBoys; }
    public Integer getOcEwsGirls() { return ocEwsGirls; }
    public void setOcEwsGirls(Integer ocEwsGirls) { this.ocEwsGirls = ocEwsGirls; }
}