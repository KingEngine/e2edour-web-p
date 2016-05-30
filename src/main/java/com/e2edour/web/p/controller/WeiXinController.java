package com.e2edour.web.p.controller;

import com.e2edour.app.facade.WeixinFacade;
import com.e2edour.app.facade.req.WeiXinReq;
import com.e2edour.app.facade.response.WeixinRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger("WeiXinController");
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
        logger.info("signature:{}",signature);
        logger.info("timestamp:{}",timestamp);
        logger.info("nonce:{}",nonce);
        logger.info("echostr:{}",echostr);
        if (weixinFacade.checkSignature(timestamp, nonce,signature)) {
            return echostr;
        }
        return "error";
    }
}
