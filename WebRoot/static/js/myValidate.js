$().ready(function() {

	// 自定义验证规则
	$.validator.addMethod("email", function(value, element) {
		var emailReg = /.*@.*\.?.*?\.(com|cn)$/;
		return this.optional(element) || (emailReg.test(value));
	}, "请正确填写您的邮箱");
	$.validator.addMethod("number", function(value, element) {
		var numberReg = /^[1][3458][0-9]{9}$/;
		return this.optional(element) || (numberReg.test(value));
	}, "请正确填写您的手机号码");
	$.validator.addMethod("usernp", function(value, element) {
		var usernameReg = /^[a-zA-Z0-9_][a-zA-Z0-9_]{3,9}$/;
		return this.optional(element) || (usernameReg.test(value));
	}, "请正确填写您的用户名/密码");
	//规则（把XXX改为相应的表单id）
	$("#checkForm").validate({
		errorElement : 'span',
		errorClass : 'help-block',
		focusInvalid : false,
		rules : {
			codeCheck : {
				required : true,
				equalTo : "#checkCode"
			},
			password2 : {
				required : true,
				equalTo : "#inputPassword"
			},
			username : {
				required : true,
				usernp : true
			},
			password : {
				required : true,
				usernp : true
			},
			name : {
				required : true,
				rangelength : [ 2, 15 ]
			},
			parentId : {
				digits : true,
				min : 0,
				maxlength : 6
			},
			sort : {
				digits : true,
				min : 0,
				required : true,
				rangelength : [ 1, 15 ]
			},
			account : {
				required : true,
				number : true
			},
			desc : {
				required : true,
				rangelength : [ 5, 100 ]
			},
			account : {
				required : true,
				number : true
			}
		},
		messages : {
			codeCheck : {
				required : "验证码为空",
				equalTo : "验证码输入错误"
			},
			username : {
				required : "用户名为空",
				usernp : "用户名格式不正确，4-10位数字/字母/下划线"
			},
			password : {
				required : "密码为空",
				usernp : "密码格式不正确，4-10位数字/字母/下划线"
			},
			password2 : {
				required : "确认密码为空",
				equalTo : "两次输入不一致"
			},
			name : {
				required : "请输入正确分类",
				rangelength : "分类名必须为2-15个字符"
			},
			parentId : {
				digits : "请输入大于0的数字或不填",
				min : "请输入大于0的数字或不填",
				maxlength : "所属分类必须为0-15个字符"
			},
			account : {
				required : "用户账号为空",
				number : "请输入正确手机号"
			},
			sort : {
				required : "请输入正确序号",
				digits : "请输入正确的数字",
				min : "请输入正确的数字",
				rangelength : "序号必须为1-15个字符"
			},
			desc : {
				required : "请输入正确简介",
				rangelength : "简介必须为5-100个字符"
			}
		},
		highlight : function(element) {
			$(element).closest('.form-group').addClass('has-error');
		},
		success : function(label) {
			label.closest('.form-group').removeClass('has-error');
			label.remove();
		},
		errorPlacement : function(error, element) {
			element.parent('div').append(error);
		}
	});
});