/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task.pkg2;

import java.util.Arrays;

/**
 *
 * @author Kristen
 */
public class Shark {
    private String commonName;
    private String latinName;
    private int maxLengthOfGrowthInCm;
    private int maxSwimmingDepthInMeters;
    private String maxYoung;
    private int globalPresenceIndicator;
    private String [] oceanicRegions;
    
    public Shark() {
        
    }
    
    public Shark(String commonName, String latinName, int maxLengthOfGrowthInCm, int maxSwimmingDepthInMeters, String maxYoung, int globalPresenceIndicator, String[] oceanicRegions) {
        this.commonName = commonName;
        this.latinName = latinName;
        this.maxLengthOfGrowthInCm = maxLengthOfGrowthInCm;
        this.maxSwimmingDepthInMeters = maxSwimmingDepthInMeters;
        this.maxYoung = maxYoung;
        this.globalPresenceIndicator = globalPresenceIndicator;
        this.oceanicRegions = oceanicRegions;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    public int getMaxLengthOfGrowthInCm() {
        return maxLengthOfGrowthInCm;
    }

    public void setMaxLengthOfGrowthInCm(int maxLengthOfGrowthInCm) {
        this.maxLengthOfGrowthInCm = maxLengthOfGrowthInCm;
    }

    public int getMaxSwimmingDepthInMeters() {
        return maxSwimmingDepthInMeters;
    }

    public void setMaxSwimmingDepthInMeters(int maxSwimmingDepthInMeters) {
        this.maxSwimmingDepthInMeters = maxSwimmingDepthInMeters;
    }

    public String getMaxYoung() {
        return maxYoung;
    }

    public void setMaxYoung(String maxYoung) {
        this.maxYoung = maxYoung;
    }

    public int getGlobalPresenceIndicator() {
        return globalPresenceIndicator;
    }

    public void setGlobalPresenceIndicator(int globalPresenceIndicator) {
        this.globalPresenceIndicator = globalPresenceIndicator;
    }

    public String[] getOceanicRegions() {
        return oceanicRegions;
    }

    public void setOceanicRegions(String[] oceanicRegions) {
        this.oceanicRegions = oceanicRegions;
    }

    @Override
    public String toString() {
        return "Shark{" + "commonName=" + commonName + ", latinName=" + latinName + ", maxLengthOfGrowthInCm=" + maxLengthOfGrowthInCm + ", maxSwimmingDepthInMeters=" + maxSwimmingDepthInMeters + ", maxYoung=" + maxYoung + ", globalPresenceIndicator=" + globalPresenceIndicator + ", oceanicRegions=" + Arrays.toString(oceanicRegions) + '}';
    }
    
    
    
}
