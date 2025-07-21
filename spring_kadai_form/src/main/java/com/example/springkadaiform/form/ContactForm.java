package com.example.springkadaiform.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class ContactForm {
	@NotBlank(message = "お名前を入力してください")
	private String name;
	
	@Email
	@NotBlank(message = "メールアドレスの入力形式が正しくありません")
	private String email;
	
	@NotBlank(message = "お問い合わせ内容を入力してください")
	@Size(max = 300, message = "お問い合わせ内容は300文字以内で入力してください")
	private String message;
	
	
}
