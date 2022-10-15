package com.onlineordermanagement.action;

public class Encrypt {
	public String encrypt(String pln_txt) {
		String lwrcase = "abcdefghijklmnopqrstuvwxyz";
		String upprcase = lwrcase.toUpperCase();
		String num = "0123456789";
		String encrypted_text = "";
		int str_len = pln_txt.length();
		for(int i=0;i<str_len;i++) {
			if((pln_txt.charAt(i)>='a' && pln_txt.charAt(i)<='z')||(pln_txt.charAt(i)>='A' && pln_txt.charAt(i)<='Z'))
			{
				int pos = lwrcase.indexOf(pln_txt.charAt(i))+upprcase.indexOf(pln_txt.charAt(i))+1;
				int shift = (pos+1)%26;
				char shifted_char = pln_txt.charAt(i)<='Z'?upprcase.charAt(shift):lwrcase.charAt(shift);
				encrypted_text+=shifted_char;
			}
			else {
				int pos = num.indexOf(pln_txt.charAt(i));
				int shift = (pos+1)%10;
				char shifted_char = num.charAt(shift);
				encrypted_text+=shifted_char;
			}
		}
		return encrypted_text;
	}
}
