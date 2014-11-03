package com.tarena.netctoss.action.main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import com.tarena.netctoss.action.BaseAction;
import com.tarena.netctoss.util.Const;
import com.tarena.netctoss.util.VerificationCodeUtil;

/**
 * 获取验证码请求与验证码
 * 
 * @author Ivan
 * 
 */
public class VerificationCodeAction extends BaseAction {
	private InputStream imgCodeStream;
	private String verifiCode;

	// 获取验证码图片与验证码
	public String code() throws IOException {
		Map<String, BufferedImage> map = VerificationCodeUtil.createImage();
		String code = map.keySet().iterator().next();
		BufferedImage image = map.get(code);
		session.put(Const.SESSION_VERIFICATION_CODE, code);
		imgCodeStream = VerificationCodeUtil.getInputStream(image);
		return SUCCESS;
	}

	public InputStream getImgCodeStream() {
		return imgCodeStream;
	}

	public String getVerifiCode() {
		return verifiCode;
	}
}
