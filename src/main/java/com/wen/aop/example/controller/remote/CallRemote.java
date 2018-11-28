package com.wen.aop.example.remote;

import com.alibaba.fastjson.JSONObject;
import com.wen.aop.example.entity.RemoteDate;
import com.wen.aop.example.entity.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Map;

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
     * RestTemplate传递对象作为参数
     *
     * @param responseData
     * @return
     */

    @RequestMapping(value = "/entity", method = RequestMethod.POST)
    public String postByObject(@RequestBody ResponseData responseData) {
        if (responseData == null) return "Faile";

        return "Success-------" + responseData.toString();
    }

    //TODO 将对象作为参数
    public void ResceiveEntity() {
        ResponseData responseData = new ResponseData("200", "调用成功", new Date());
        String message = this.restTemplate.postForObject(url + "entity", responseData, String.class);
        logger.info("调用返回值信息" + message);
    }

    //
    @RequestMapping(value = "/map", method = RequestMethod.POST)
    public String postByMap(@RequestBody Map<String, Object> map) {
        if (map == null || map.isEmpty()) return "Faile";
        return "SUCCESS-------" + map.toString();
    }

    @RequestMapping(value = "/json", method = RequestMethod.POST)
    public String postByJsonObj(@RequestBody JSONObject jsonRequest) {
        if (jsonRequest == null || jsonRequest.isEmpty()) {
            return "FAIL";
        }
        return "SUCCESS:" + jsonRequest.toString();
    }
}
