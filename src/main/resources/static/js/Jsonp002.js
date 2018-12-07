/**
 * 创建跨域请求Jsonp类
 * @param url
 * @param fun
 * @constructor
 */

function Jsonp(url, fun) {
    var callbackName = "fn" + Math.round(Math.random() * 1000000000) + Math.round(Math.random() * 1000000);

    window[callbackName] = function (msg) {
        if (fun) {
            fun(msg);
        }
        document.getElementsByTagName('head')[0].removeChild(document.getElementById("scirpt" + callBackFunName));
        delete window[callBackFunName];
    }

    var script = document.createElement('script');
    script.type = 'text/javascript';
    if (url.indexOf("?") > -1) {
        script.src = url + "&callback=" + callbackName;
    } else {
        script.src = url + "?calllback=" + callbackName;
    }
    script.id = "script" + callbackName;
    document.getElementsByTagName('head')[0].appendChild(script);
}

/**
 * demo
 */
function demo() {
    Jsonp('url', function (data) {
        console.log("回调返回值" + data)
    })
}