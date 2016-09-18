package cn.qdgxy.shop.user.action;

import org.apache.struts2.ServletActionContext;

import cn.qdgxy.shop.utils.verifycode.VerifyCodeUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class VerifyCodeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		VerifyCodeUtils vc = new VerifyCodeUtils();

		// 生成验证码图片
		VerifyCodeUtils.output(vc.getImage(), ServletActionContext
				.getResponse().getOutputStream());

		// 将验证码存至Session
		ActionContext.getContext().getSession().put("verifyCode", vc.getText());
		return NONE;
	}

}