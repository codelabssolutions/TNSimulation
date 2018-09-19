package com.mobilicom.csv;

/**
 *
 * @author dhiraj
 */
public class SimuTestSetting {
    Integer srNo;
    String testSettingName;
    String GCSAntenna;
    String ADTAntenna;
    Integer forwardX;
    Integer maxDeviationEl;
    Integer maxDeviationAz;
    Integer maxDeviationGa;
    Integer  maxSensitivity; 

    public SimuTestSetting(Integer srNo, String testSettingName, String GCSAntenna, String ADTAntenna, Integer forwardX, Integer maxDeviationEl, Integer maxDeviationAz, Integer maxDeviationGa, Integer maxSensitivity) {
        this.srNo = srNo;
        this.testSettingName = testSettingName;
        this.GCSAntenna = GCSAntenna;
        this.ADTAntenna = ADTAntenna;
        this.forwardX = forwardX;
        this.maxDeviationEl = maxDeviationEl;
        this.maxDeviationAz = maxDeviationAz;
        this.maxDeviationGa = maxDeviationGa;
        this.maxSensitivity = maxSensitivity;
    }

    public SimuTestSetting() {
    }

    
    public Integer getSrNo() {
        return srNo;
    }

    public void setSrNo(Integer srNo) {
        this.srNo = srNo;
    }

    public String getTestSettingName() {
        return testSettingName;
    }

    public void setTestSettingName(String testSettingName) {
        this.testSettingName = testSettingName;
    }

    public String getGCSAntenna() {
        return GCSAntenna;
    }

    public void setGCSAntenna(String GCSAntenna) {
        this.GCSAntenna = GCSAntenna;
    }

    public String getADTAntenna() {
        return ADTAntenna;
    }

    public void setADTAntenna(String ADTAntenna) {
        this.ADTAntenna = ADTAntenna;
    }

    public Integer getForwardX() {
        return forwardX;
    }

    public void setForwardX(Integer forwardX) {
        this.forwardX = forwardX;
    }

    public Integer getMaxDeviationEl() {
        return maxDeviationEl;
    }

    public void setMaxDeviationEl(Integer maxDeviationEl) {
        this.maxDeviationEl = maxDeviationEl;
    }

    public Integer getMaxDeviationAz() {
        return maxDeviationAz;
    }

    public void setMaxDeviationAz(Integer maxDeviationAz) {
        this.maxDeviationAz = maxDeviationAz;
    }

    public Integer getMaxDeviationGa() {
        return maxDeviationGa;
    }

    public void setMaxDeviationGa(Integer maxDeviationGa) {
        this.maxDeviationGa = maxDeviationGa;
    }

    public Integer getMaxSensitivity() {
        return maxSensitivity;
    }

    public void setMaxSensitivity(Integer maxSensitivity) {
        this.maxSensitivity = maxSensitivity;
    }
            
            
            
            
}
