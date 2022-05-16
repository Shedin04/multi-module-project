package com.shedin.desktop.constants;

public interface Creds {

	enum STANDARD_ACCOUNT {
		LOGIN("standard_user"), PASSWORD("secret_sauce");
		private final String value;
		STANDARD_ACCOUNT(String value){
			this.value = value;
		}

		public String get() {
			return value;
		}
	}
}
