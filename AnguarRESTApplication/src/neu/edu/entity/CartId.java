package neu.edu.entity;
// Generated Apr 27, 2017 6:00:41 PM by Hibernate Tools 5.2.1.Final

/**
 * CartId generated by hbm2java
 */
public class CartId implements java.io.Serializable {

	private Integer userId;
	private Integer thisServiceId;

	public CartId() {
	}

	public CartId(Integer userId, Integer thisServiceId) {
		this.userId = userId;
		this.thisServiceId = thisServiceId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getThisServiceId() {
		return this.thisServiceId;
	}

	public void setThisServiceId(Integer thisServiceId) {
		this.thisServiceId = thisServiceId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CartId))
			return false;
		CartId castOther = (CartId) other;

		return ((this.getUserId() == castOther.getUserId()) || (this.getUserId() != null
				&& castOther.getUserId() != null && this.getUserId().equals(castOther.getUserId())))
				&& ((this.getThisServiceId() == castOther.getThisServiceId())
						|| (this.getThisServiceId() != null && castOther.getThisServiceId() != null
								&& this.getThisServiceId().equals(castOther.getThisServiceId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result + (getThisServiceId() == null ? 0 : this.getThisServiceId().hashCode());
		return result;
	}

}