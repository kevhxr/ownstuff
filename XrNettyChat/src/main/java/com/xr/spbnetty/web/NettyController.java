package com.xr.spbnetty.web;

import com.xr.spbnetty.server.NettyServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/nettyserver", method = RequestMethod.GET)
public class NettyController {
    @Resource
    private NettyServer nettyServer;

    @RequestMapping("/localAddress")
    @ResponseBody
    public String localAddress() {
        return "nettyServer localAddress " + nettyServer.getChannel().localAddress();
    }

    @RequestMapping("/isOpen")
    @ResponseBody
    public String isOpen() {
        return "nettyServer isOpen " + nettyServer.getChannel().isOpen();
    }
}
