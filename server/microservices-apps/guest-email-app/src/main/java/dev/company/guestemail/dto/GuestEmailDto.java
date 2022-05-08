package dev.company.guestemail.dto;

import java.util.Date;

public class GuestEmailDto {
	public class GuestEmail {

		private String emailAddress;

		private Date dateCreated;

		public GuestEmail() {
		}

		public String getEmailAddress() {
			return emailAddress;
		}

		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}

		public Date getDateCreated() {
			return dateCreated;
		}

		public void setDateCreated(Date dateCreated) {
			this.dateCreated = dateCreated;
		}

	}

}
