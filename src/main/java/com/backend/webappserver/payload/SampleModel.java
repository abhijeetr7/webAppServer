package com.backend.webappserver.payload;

import java.util.List;

public class SampleModel {
    private Integer id;
    private Integer actid;
    private String activityname;
    private String shortname;
    private String parameterName;
    private String input;
    private String svparams;
    private Integer sampinvid;
    private String sampleinno;
    private String sampleno;
    private String samplenov;
    private String organismtype;
    private String identifiedgenus;
    private String species;
    private List<String> inputList;

    // Generate getters and setters for all the fields

    @Override
    public String toString() {
        return "SampleModel{" +
                "id=" + id +
                ", actid=" + actid +
                ", activityname='" + activityname + '\'' +
                ", shortname='" + shortname + '\'' +
                ", parameterName='" + parameterName + '\'' +
                ", input='" + input + '\'' +
                ", svparams='" + svparams + '\'' +
                ", sampinvid=" + sampinvid +
                ", sampleinno='" + sampleinno + '\'' +
                ", sampleno='" + sampleno + '\'' +
                ", samplenov='" + samplenov + '\'' +
                ", organismtype='" + organismtype + '\'' +
                ", identifiedgenus='" + identifiedgenus + '\'' +
                ", species='" + species + '\'' +
                ", inputList=" + inputList +
                '}';
    }
}