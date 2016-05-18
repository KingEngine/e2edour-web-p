$(function () {
    var page = {
        location: {
            register: "registerSubmit"
        },
        init: function () {
            this.bindUI();
            this.validate();
        },
        bindUI: function () {
            $("#registerSubmitBtn").on("click", this.logic.submit);
        },
        logic: {
            submit: function () {
                var validate = $("#registerForm").data('bootstrapValidator').validate();
                if (validate.isValid()) {
                    $.ajax({
                        url:page.location.register,
                        type:"POST",
                        data:$("#registerForm").serialize(),
                        success:function(response){
                            if(response.code='000000'){
                                $.messager.alert("注册成功，请重新登陆!");
                            }
                        }
                    });
                }
            }
        },

        validate: function () {
            $('#registerForm').bootstrapValidator({
                fields: {
                    name: {
                        validators: {
                            notEmpty: {
                                message: '请填写用户名'
                            }
                        }
                    },
                    passowrd: {
                        validators: {
                            notEmpty: {
                                message: '请输入密码'
                            },
                            identical: {
                                field: 'vipPwdConfirm',
                                message: '密码和确认密码需一致'
                            }
                        }
                    },
                    passwordConfirm: {
                        validators: {
                            notEmpty: {
                                message: '请输入确认密码'
                            },
                            identical: {
                                field: 'passowrd',
                                message: '确认密码和密码需一致'
                            }
                        }
                    },
                    email: {
                        validators: {
                            notEmpty: {
                                message: '请输入邮箱'
                            },
                            emailAddress: {
                                message: '邮箱格式不合法'
                            }
                        }
                    },

                }
            });
        }
    }
    page.init();
});
