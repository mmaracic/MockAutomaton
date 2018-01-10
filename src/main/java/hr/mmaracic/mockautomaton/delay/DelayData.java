/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.mmaracic.mockautomaton.delay;

import java.time.OffsetDateTime;
import java.util.Map;

/**
 *
 * @author mmaracic
 */
public class DelayData {
    private Map<String, Object> delayData;
    private OffsetDateTime receivedDate;
    private Long delayMs;
    
    public DelayData(Map<String, Object> delayData, Long delayMs){
        this.delayData = delayData;
        
    }
}
