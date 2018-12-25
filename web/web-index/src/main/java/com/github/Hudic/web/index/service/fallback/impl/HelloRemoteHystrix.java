package com.github.Hudic.web.index.service.fallback.impl;

import com.github.Hudic.web.index.service.fallback.HelloRemote;
import org.springframework.stereotype.Component;

/**
 * Hudic
 * Created by Makkah at 2018/12/25 16:40
 */
@Component
public class HelloRemoteHystrix implements HelloRemote {
    @Override
    public String hello() {
        return "Oops, something went wrong.";
    }
}
