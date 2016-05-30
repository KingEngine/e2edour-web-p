package com.e2edour.web.p.controller;

import com.e2edour.app.facade.WeixinFacade;
import com.e2edour.app.facade.req.WeiXinReq;
import com.e2edour.app.facade.response.WeixinRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 微信接入
 *
 * @author King
 * @version 2016/5/30
 */
@Controller
@RequestMapping("wechatapi")
public class WeiXinController {


    @Autowired
    private WeixinFacade weixinFacade;

    @RequestMapping(method = {RequestMethod.POST})
    @ResponseBody
    public WeixinRes wexinReq(WeiXinReq req) {
        return weixinFacade.handlerMsg(req);
    }

    @RequestMapping(method = {RequestMethod.GET})
    @ResponseBody
    public String checkSignature(String signature, String timestamp, String nonce, String echostr) {
        if (weixinFacade.checkSignature(signature, timestamp, nonce, echostr)) {
            return echostr;
        }
        return "error";
    }
}
