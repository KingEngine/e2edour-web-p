$(function () {
    var page = {
        init: function () {
            this.validate();//校验
            this.bindUI();//绑定地址
        },
        bindUI: function () {
            $("#customerLoginBtn").on("click",this.logic.login);
        },
        logic: {
            login:function(){
                //验证是否通过

                //提交form表单
                $("#loginForm").submit();
            }

        },
        validate: function () {

        }
    }
    page.init();
});
