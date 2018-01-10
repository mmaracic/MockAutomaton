/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.mmaracic.mockautomaton.delay;

import java.util.Map;

/**
 *
 * @author mmaracic
 */
public interface DelayExecutorSubscriber {
    public void receiveNotificationData(Map<String, Object> delayData);
}
