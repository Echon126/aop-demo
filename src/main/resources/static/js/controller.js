Router = new (function () {
    current = this;
    this.routes = {};
    this.curUrl = '';
    this.params = [];

    //配置路由
    this.route = function (path, callback) {
        current.routes[path] = callback || function () {
        };
         console.log('routes[path]:' + this.routes[path])
    };

    //监听到触发的方法
    this.refresh = function () {
        current.curUrl = location.hash.slice(1) || '/';
        current.routes[current.curUrl]();
        // console.log('location.hash:' + location.hash);
        // console.log('curUrl:' + this.curUrl);
        // console.log('this.routes[this.curUrl]:' + this.routes[this.curUrl])
    };

    //监听load（加载url）、hashchange（hash改变）事件
    function init() {
        // console.log("开始初始化路由");
        window.addEventListener('load', current.refresh.bind(current), false);
        window.addEventListener('hashchange', current.refresh.bind(current), false)
        // console.log("结束初始化路由");
    }

    init();
})();


function ajaxRequest(data, sucFun, errFun) {
    $.ajax({
        type: "GET",
        url: "/page",
        data: data,
        success: sucFun,
        error: errFun
    });
}