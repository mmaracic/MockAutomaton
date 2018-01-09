/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.mmaracic.mockautomaton.model.internal;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author mmaracic
 */
@Getter
@RequiredArgsConstructor
public class InputHistory {
    private final String path;
    private final String input;
    private final Long delayMs;
}
