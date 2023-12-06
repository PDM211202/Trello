package IT6020003.objects;

public class UserObject {
	private int userId;
    private int userParentId;
    private String userEmail;
    private String userBackgroundSrc;
    private String userAvatarSrc;
    private String userCreatedDate;
    private String userRecentlyViewed;
    private String userPassword;
    private String userName;
    private String userFullName;
    private String userBirthday;
    private String userMobilePhone;
    private String userHomePhone;
    private String userAddress;
    private String userJobArea;
    private String userJob;
    private String userRoles;
    private boolean userLoggedIn;
	
	public UserObject() {

	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserParentId() {
		return userParentId;
	}

	public void setUserParentId(int userParentId) {
		this.userParentId = userParentId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserBackgroundSrc() {
		return userBackgroundSrc;
	}

	public void setUserBackgroundSrc(String userBackgroundSrc) {
		this.userBackgroundSrc = userBackgroundSrc;
	}

	public String getUserAvatarSrc() {
		return userAvatarSrc;
	}

	public void setUserAvatarSrc(String userAvatarSrc) {
		this.userAvatarSrc = userAvatarSrc;
	}

	public String getUserCreatedDate() {
		return userCreatedDate;
	}

	public void setUserCreatedDate(String userCreatedDate) {
		this.userCreatedDate = userCreatedDate;
	}

	public String getUserRecentlyViewed() {
		return userRecentlyViewed;
	}

	public void setUserRecentlyViewed(String userRecentlyViewed) {
		this.userRecentlyViewed = userRecentlyViewed;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public String getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getUserMobilePhone() {
		return userMobilePhone;
	}

	public void setUserMobilePhone(String userMobilePhone) {
		this.userMobilePhone = userMobilePhone;
	}

	public String getUserHomePhone() {
		return userHomePhone;
	}

	public void setUserHomePhone(String userHomePhone) {
		this.userHomePhone = userHomePhone;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserJobArea() {
		return userJobArea;
	}

	public void setUserJobArea(String userJobArea) {
		this.userJobArea = userJobArea;
	}

	public String getUserJob() {
		return userJob;
	}

	public void setUserJob(String userJob) {
		this.userJob = userJob;
	}

	public String getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(String userRoles) {
		this.userRoles = userRoles;
	}

	public boolean isUserLoggedIn() {
		return userLoggedIn;
	}

	public void setUserLoggedIn(boolean userLoggedIn) {
		this.userLoggedIn = userLoggedIn;
	}

	@Override
	public String toString() {
		return "UserObject [userId=" + userId + ", userParentId=" + userParentId + ", userEmail=" + userEmail
				+ ", userBackgroundSrc=" + userBackgroundSrc + ", userAvatarSrc=" + userAvatarSrc + ", userCreatedDate="
				+ userCreatedDate + ", userRecentlyViewed=" + userRecentlyViewed + ", userPassword=" + userPassword
				+ ", userName=" + userName + ", userFullName=" + userFullName + ", userBirthday=" + userBirthday
				+ ", userMobilePhone=" + userMobilePhone + ", userHomePhone=" + userHomePhone + ", userAddress="
				+ userAddress + ", userJobArea=" + userJobArea + ", userJob=" + userJob + ", userRoles=" + userRoles
				+ ", userLoggedIn=" + userLoggedIn + "]";
	}
}
