package com.trip.domain;

public class Traffic {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_traffic.tp_Tid
     *
     * @mbg.generated
     */
    private Integer tpTid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_traffic.tp_type
     *
     * @mbg.generated
     */
    private String tpType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_traffic.tp_current
     *
     * @mbg.generated
     */
    private String tpCurrent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_traffic.tp_destination
     *
     * @mbg.generated
     */
    private String tpDestination;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_traffic.tp_current_time
     *
     * @mbg.generated
     */
    private String tpCurrentTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_traffic.tp_arrive_time
     *
     * @mbg.generated
     */
    private String tpArriveTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_traffic.tp_tprice
     *
     * @mbg.generated
     */
    private String tpTprice;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_traffic.tp_Tid
     *
     * @return the value of tp_traffic.tp_Tid
     *
     * @mbg.generated
     */
    public Integer getTpTid() {
        return tpTid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_traffic.tp_Tid
     *
     * @param tpTid the value for tp_traffic.tp_Tid
     *
     * @mbg.generated
     */
    public void setTpTid(Integer tpTid) {
        this.tpTid = tpTid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_traffic.tp_type
     *
     * @return the value of tp_traffic.tp_type
     *
     * @mbg.generated
     */
    public String getTpType() {
        return tpType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_traffic.tp_type
     *
     * @param tpType the value for tp_traffic.tp_type
     *
     * @mbg.generated
     */
    public void setTpType(String tpType) {
        this.tpType = tpType == null ? null : tpType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_traffic.tp_current
     *
     * @return the value of tp_traffic.tp_current
     *
     * @mbg.generated
     */
    public String getTpCurrent() {
        return tpCurrent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_traffic.tp_current
     *
     * @param tpCurrent the value for tp_traffic.tp_current
     *
     * @mbg.generated
     */
    public void setTpCurrent(String tpCurrent) {
        this.tpCurrent = tpCurrent == null ? null : tpCurrent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_traffic.tp_destination
     *
     * @return the value of tp_traffic.tp_destination
     *
     * @mbg.generated
     */
    public String getTpDestination() {
        return tpDestination;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_traffic.tp_destination
     *
     * @param tpDestination the value for tp_traffic.tp_destination
     *
     * @mbg.generated
     */
    public void setTpDestination(String tpDestination) {
        this.tpDestination = tpDestination == null ? null : tpDestination.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_traffic.tp_current_time
     *
     * @return the value of tp_traffic.tp_current_time
     *
     * @mbg.generated
     */
    public String getTpCurrentTime() {
        return tpCurrentTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_traffic.tp_current_time
     *
     * @param tpCurrentTime the value for tp_traffic.tp_current_time
     *
     * @mbg.generated
     */
    public void setTpCurrentTime(String tpCurrentTime) {
        this.tpCurrentTime = tpCurrentTime == null ? null : tpCurrentTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_traffic.tp_arrive_time
     *
     * @return the value of tp_traffic.tp_arrive_time
     *
     * @mbg.generated
     */
    public String getTpArriveTime() {
        return tpArriveTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_traffic.tp_arrive_time
     *
     * @param tpArriveTime the value for tp_traffic.tp_arrive_time
     *
     * @mbg.generated
     */
    public void setTpArriveTime(String tpArriveTime) {
        this.tpArriveTime = tpArriveTime == null ? null : tpArriveTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_traffic.tp_tprice
     *
     * @return the value of tp_traffic.tp_tprice
     *
     * @mbg.generated
     */
    public String getTpTprice() {
        return tpTprice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_traffic.tp_tprice
     *
     * @param tpTprice the value for tp_traffic.tp_tprice
     *
     * @mbg.generated
     */
    public void setTpTprice(String tpTprice) {
        this.tpTprice = tpTprice == null ? null : tpTprice.trim();
    }
}