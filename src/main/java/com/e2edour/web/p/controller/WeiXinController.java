package com.e2edour.web.p.controller;

import com.alibaba.fastjson.JSON;
import com.e2edour.app.facade.WeixinFacade;
import com.e2edour.app.facade.req.WeiXinReq;
import com.e2edour.app.facade.response.WeixinRes;
import com.e2edour.common.utils.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;

/**
 * 微信接入
 *
 * @author King
 * @version 2016/5/30
 */
@Controller
@RequestMapping("wechatapi")
public class WeiXinController {

    private Logger logger = LoggerFactory.getLogger("wechatapi");
    @Autowired
    private WeixinFacade weixinFacade;

    @RequestMapping(method = {RequestMethod.POST})
    @ResponseBody
    public String handlerMsgReq(HttpServletRequest request) {
        try {
            ServletInputStream in = request.getInputStream();
            StringBuilder xmlMsg = new StringBuilder();
            byte[] b = new byte[4096];
            for (int n; (n = in.read(b)) != -1; ) {
                xmlMsg.append(new String(b, 0, n, "UTF-8"));
            }
            logger.info("--------------------微信请求xml--------------------\n{}", xmlMsg);
            JAXBContext jaxbContext = JAXBContext.newInstance(WeiXinReq.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            WeiXinReq wexinReq = (WeiXinReq) unmarshaller.unmarshal(new StringReader(xmlMsg.toString()));
            String res = weixinFacade.handlerMsg(wexinReq);
            logger.info("--------------------微信res--------------------\n{}", res);
            return res;
        } catch (IOException e) {
            logger.error("wexinReq IOException error:{}", LoggerUtil.getErrorMsg(e));
        } catch (JAXBException e) {
            logger.error("wexinReq JAXBException error:{}", LoggerUtil.getErrorMsg(e));
        }
        return "error";
    }

    @RequestMapping(method = {RequestMethod.GET})
    @ResponseBody
    public String checkSignature(String signature, String timestamp, String nonce, String echostr) {
        logger.info("------微信验签------");
        logger.info("signature:{}", signature);
        logger.info("timestamp:{}", timestamp);
        logger.info("nonce:{}", nonce);
        logger.info("echostr:{}", echostr);
        if (weixinFacade.checkSignature(timestamp, nonce, signature)) {
            return echostr;
        }
        return "error";
    }
}
