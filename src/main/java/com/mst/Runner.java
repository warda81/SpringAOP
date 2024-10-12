package com.mst;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mst.beans.Account;
import com.mst.config.Config;

public class Runner {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Account account = context.getBean(Account.class);
		try {
			account.deposit(2000.0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		account.withdraw(850);
	}

}
