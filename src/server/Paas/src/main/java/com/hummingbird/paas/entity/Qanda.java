package com.hummingbird.paas.entity;

/**
 * 答疑表,记录招标的答疑方式
 */
public class Qanda {
    /**
     * id
     */
    private Integer id;

    /**
     * 标的id
     */
    private String objectId;

    /**
     * qq群答疑, YES 是,NO# 否
     */
    private String isQqAnswer;

    /**
     * email答疑,YES 是,NO# 否
     */
    private String isEmailAnswer;

    /**
     * 电话答疑,YES 是,NO# 否
     */
    private String isTelAnswer;

    /**
     * 现场答疑,YES 是,NO# 否
     */
    private String isMeetngAnswer;

    /**
     * qq群号
     */
    private String qqNo;

    /**
     * qq群密码
     */
    private String qqPassword;

    /**
     * 电话号码
     */
    private String telephone;

    /**
     * 邮件地址
     */
    private String email;

    /**
     * 现场答疑,答疑地址
     */
    private String address;

    /**
     * 现场答疑,答疑时间
     */
    private String answerTime;

    /**
     * 现场答疑,答疑日期
     */
    private String answerDate;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 
	 *            id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 标的id
     */
    public String getObjectId() {
        return objectId;
    }

    /**
     * @param objectId 
	 *            标的id
     */
    public void setObjectId(String objectId) {
        this.objectId = objectId == null ? null : objectId.trim();
    }

    /**
     * @return qq群答疑, YES 是,NO# 否
     */
    public String getIsQqAnswer() {
        return isQqAnswer;
    }

    /**
     * @param isQqAnswer 
	 *            qq群答疑, YES 是,NO# 否
     */
    public void setIsQqAnswer(String isQqAnswer) {
        this.isQqAnswer = isQqAnswer == null ? null : isQqAnswer.trim();
    }

    /**
     * @return email答疑,YES 是,NO# 否
     */
    public String getIsEmailAnswer() {
        return isEmailAnswer;
    }

    /**
     * @param isEmailAnswer 
	 *            email答疑,YES 是,NO# 否
     */
    public void setIsEmailAnswer(String isEmailAnswer) {
        this.isEmailAnswer = isEmailAnswer == null ? null : isEmailAnswer.trim();
    }

    /**
     * @return 电话答疑,YES 是,NO# 否
     */
    public String getIsTelAnswer() {
        return isTelAnswer;
    }

    /**
     * @param isTelAnswer 
	 *            电话答疑,YES 是,NO# 否
     */
    public void setIsTelAnswer(String isTelAnswer) {
        this.isTelAnswer = isTelAnswer == null ? null : isTelAnswer.trim();
    }

    /**
     * @return 现场答疑,YES 是,NO# 否
     */
    public String getIsMeetngAnswer() {
        return isMeetngAnswer;
    }

    /**
     * @param isMeetngAnswer 
	 *            现场答疑,YES 是,NO# 否
     */
    public void setIsMeetngAnswer(String isMeetngAnswer) {
        this.isMeetngAnswer = isMeetngAnswer == null ? null : isMeetngAnswer.trim();
    }

    /**
     * @return qq群号
     */
    public String getQqNo() {
        return qqNo;
    }

    /**
     * @param qqNo 
	 *            qq群号
     */
    public void setQqNo(String qqNo) {
        this.qqNo = qqNo == null ? null : qqNo.trim();
    }

    /**
     * @return qq群密码
     */
    public String getQqPassword() {
        return qqPassword;
    }

    /**
     * @param qqPassword 
	 *            qq群密码
     */
    public void setQqPassword(String qqPassword) {
        this.qqPassword = qqPassword == null ? null : qqPassword.trim();
    }

    /**
     * @return 电话号码
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone 
	 *            电话号码
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * @return 邮件地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email 
	 *            邮件地址
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * @return 现场答疑,答疑地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address 
	 *            现场答疑,答疑地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * @return 现场答疑,答疑时间
     */
    public String getAnswerTime() {
        return answerTime;
    }

    /**
     * @param answerTime 
	 *            现场答疑,答疑时间
     */
    public void setAnswerTime(String answerTime) {
        this.answerTime = answerTime == null ? null : answerTime.trim();
    }

    /**
     * @return 现场答疑,答疑日期
     */
    public String getAnswerDate() {
        return answerDate;
    }

    /**
     * @param answerDate 
	 *            现场答疑,答疑日期
     */
    public void setAnswerDate(String answerDate) {
        this.answerDate = answerDate == null ? null : answerDate.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Qanda other = (Qanda) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getObjectId() == null ? other.getObjectId() == null : this.getObjectId().equals(other.getObjectId()))
            && (this.getIsQqAnswer() == null ? other.getIsQqAnswer() == null : this.getIsQqAnswer().equals(other.getIsQqAnswer()))
            && (this.getIsEmailAnswer() == null ? other.getIsEmailAnswer() == null : this.getIsEmailAnswer().equals(other.getIsEmailAnswer()))
            && (this.getIsTelAnswer() == null ? other.getIsTelAnswer() == null : this.getIsTelAnswer().equals(other.getIsTelAnswer()))
            && (this.getIsMeetngAnswer() == null ? other.getIsMeetngAnswer() == null : this.getIsMeetngAnswer().equals(other.getIsMeetngAnswer()))
            && (this.getQqNo() == null ? other.getQqNo() == null : this.getQqNo().equals(other.getQqNo()))
            && (this.getQqPassword() == null ? other.getQqPassword() == null : this.getQqPassword().equals(other.getQqPassword()))
            && (this.getTelephone() == null ? other.getTelephone() == null : this.getTelephone().equals(other.getTelephone()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getAnswerTime() == null ? other.getAnswerTime() == null : this.getAnswerTime().equals(other.getAnswerTime()))
            && (this.getAnswerDate() == null ? other.getAnswerDate() == null : this.getAnswerDate().equals(other.getAnswerDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getObjectId() == null) ? 0 : getObjectId().hashCode());
        result = prime * result + ((getIsQqAnswer() == null) ? 0 : getIsQqAnswer().hashCode());
        result = prime * result + ((getIsEmailAnswer() == null) ? 0 : getIsEmailAnswer().hashCode());
        result = prime * result + ((getIsTelAnswer() == null) ? 0 : getIsTelAnswer().hashCode());
        result = prime * result + ((getIsMeetngAnswer() == null) ? 0 : getIsMeetngAnswer().hashCode());
        result = prime * result + ((getQqNo() == null) ? 0 : getQqNo().hashCode());
        result = prime * result + ((getQqPassword() == null) ? 0 : getQqPassword().hashCode());
        result = prime * result + ((getTelephone() == null) ? 0 : getTelephone().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getAnswerTime() == null) ? 0 : getAnswerTime().hashCode());
        result = prime * result + ((getAnswerDate() == null) ? 0 : getAnswerDate().hashCode());
        return result;
    }
}