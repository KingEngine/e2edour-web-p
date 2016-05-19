$(function () {
    var page = {
        init: function () {
            this.validate();//校验
            this.bindUI();//绑定地址
        },
        bindUI: function () {
            //navigation绑定事件
            $("[navigation]").on("click", this.logic.showMain);
            $("[register-navigation]").on("click", this.logic.showRegister);
            //用户注册

            //$("#leaveMsgBtnShow").on("click", function () {
            //	$("#leaveMsgModel").removeData("bs.modal");
            //	$("#msg").val('');
            //	$("#leaveMsgForm").data('bootstrapValidator').resetForm();
            //	$('#leaveMsgModel').modal('show')
            //});
            //$("#leaveMsgModel").on("hidden.bs.modal", function () {
            //	$(this).removeData("bs.modal");
            //});
            //$("#leaveMsgSubmitBtn").on("click", function () {
            //	var result = $("#leaveMsgForm").data('bootstrapValidator').isValid();
            //	if (result) {
            //		var data = $('#leaveMsgForm').serialize();
            //		$.ajax({
            //			url: 'addLeaveMsg',
            //			type: 'post',
            //			async: false,
            //			data: data,
            //			success: function (msg) {
            //				if ("success" == msg) {
            //					$.messager.popup("谢谢您的留言!");
            //				}
            //			},
            //			error: function (msg) {
            //
            //			}
            //		});
            //	}
            //});
        },
        logic: {
            showMain: function () {
                $("[navigation]").parent().removeClass("active");
                //得到url
                var navigation = $(this).attr("navigation");
                //设置为active
                $(this).parent().addClass("active");
                $.ajax({
                    type: "post",
                    url: navigation,
                    success: function (data) {
                        $("#main").html(data);
                    }
                });
            },
            showRegister: function () {
                //得到url
                var url = $(this).attr("register-navigation");
                $.ajax({
                    type: "post",
                    url: url,
                    success: function (data) {
                        $("#main").html(data);
                    }
                });
            }

        },
        validate: function () {
            //$('#leaveMsgForm').bootstrapValidator({
            //	message : 'This value is not valid',
            //	fields : {
            //		msg : {
            //			validators : {
            //				notEmpty : {
            //					message : '您好,请填写留言内容...'
            //				}
            //			}
            //		}
            //
            //	}
            //});
        }
    }
    page.init();
});
