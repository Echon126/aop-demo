/**
 * 创建Jsonp类
 * @param url 请求的url
 * @param cb  接口返回参数的梳理
 * @constructor
 */
function Jsonp(url, cb) {
    this.callbackName = 'jsonp_' + Date.now();
    this.cb = cb;
    this.url = url;
    this.init()
}

/**
 * 初始化方法，用于拼接url
 */
Jsonp.prototype.init = function () {
    if (~this.url.indexOf('?')) {
        this.url = this.url + '&callback=' + this.callbackName;
    } else {
        this.url = this.url + '?callback=' + this.callbackName;
    }
    this.createCallback();
    this.createScript();
};

/**
 * 创建script标签，src取接口请求的url
 */
Jsonp.prototype.createScript = function () {
    var script = document.createElement('script');
    script.src = this.url;
    script.onload = function () {
        this.remove();
    };
    document.body.appendChild(script);
};

/**
 * 绑定回调函数
 */
Jsonp.prototype.createCallback = function () {
    window[this.callbackName] = this.cb;
};

/**
 * 创建Jsonp实例。并指定回调函数
 */
new Jsonp('http://124.224.232.203:8097/b2b/click/ctr.htm?lotteryId=1&userAccount=2324234&buttonno=1', function (data) {
    console.log(data)
});