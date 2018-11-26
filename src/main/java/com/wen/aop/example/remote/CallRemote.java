package com.wen.aop.example.remote;

import com.alibaba.fastjson.JSONObject;
import com.wen.aop.example.entity.RemoteDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author admin
 * @date 2018-11-26 22:11
 */
@RestController
public class CallRemote {
    private static Logger logger = LoggerFactory.getLogger(CallRemote.class);
    private String url = "http://localhost:8080/method";

    @Autowired
    RestTemplate restTemplate;

    /**
     * 通过对象实体传递参数
     *
     * @param remoteDate
     */
    @RequestMapping(value = "remot", method = RequestMethod.POST)
    public void callMethod(RemoteDate remoteDate) {
        String message = this.restTemplate.postForObject(url, remoteDate, String.class);
        logger.info("调用放回信息" + message);

    }

    /**
     * 接受请求
     *
     * @param remoteDate
     */
    public void receiveRequest(RemoteDate remoteDate) {

    }

    /**
     * 通过json对象传递参数
     *
     * @param name
     * @param content
     */
    @RequestMapping(value = "remot", method = RequestMethod.POST)
    public void callMethod01(String name, String content) {
        JSONObject postData = new JSONObject();
        postData.put("name", name);
        postData.put("content", content);
        String message = this.restTemplate.postForObject(url, postData, String.class);
        logger.info("调用返回值状态值" + message);
    }

    /**
     * 接受请求
     *
     * @param postData
     */
    public void receiveRequest01(JSONObject postData) {

    }
}
