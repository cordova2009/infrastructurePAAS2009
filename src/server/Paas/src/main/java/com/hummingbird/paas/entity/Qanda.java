package com.hummingbird.paas.entity;

/**
 * 答疑表,记录招标的答疑方式
 */
public class Qanda {
    /**
     * 标的id
     */
    private String object_id;

    /**
     * qq群答疑, YES 是,NO# 否
     */
    private String is_qq_answer;

    /**
     * email答疑,YES 是,NO# 否
     */
    private String is_email_answer;

    /**
     * 电话答疑,YES 是,NO# 否
     */
    private String is_tel_answer;

    /**
     * 现场答疑,YES 是,NO# 否
     */
    private String is_meetng_answer;

    /**
     * qq群号
     */
    private String qq_no;

    /**
     * qq群密码
     */
    private String qq_password;

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
    private String answer_time;

    /**
     * 现场答疑,答疑日期
     */
    private String answer_date;

    /**
     * @return 标的id
     */
    public String getObject_id() {
        return object_id;
    }

    /**
     * @param objectId 
	 *            标的id
     */
    public void setObject_id(String object_id) {
        this.object_id = object_id == null ? null : object_id.trim();
    }

    /**
     * @return qq群答疑, YES 是,NO# 否
     */
    public String getIs_qq_answer() {
        return is_qq_answer;
    }

    /**
     * @param isQqAnswer 
	 *            qq群答疑, YES 是,NO# 否
     */
    public void setIs_qq_answer(String is_qq_answer) {
        this.is_qq_answer = is_qq_answer == null ? null : is_qq_answer.trim();
    }

    /**
     * @return email答疑,YES 是,NO# 否
     */
    public String getIs_email_answer() {
        return is_email_answer;
    }

    /**
     * @param isEmailAnswer 
	 *            email答疑,YES 是,NO# 否
     */
    public void setIs_email_answer(String is_email_answer) {
        this.is_email_answer = is_email_answer == null ? null : is_email_answer.trim();
    }

    /**
     * @return 电话答疑,YES 是,NO# 否
     */
    public String getIs_tel_answer() {
        return is_tel_answer;
    }

    /**
     * @param isTelAnswer 
	 *            电话答疑,YES 是,NO# 否
     */
    public void setIs_tel_answer(String is_tel_answer) {
        this.is_tel_answer = is_tel_answer == null ? null : is_tel_answer.trim();
    }

    /**
     * @return 现场答疑,YES 是,NO# 否
     */
    public String getIs_meetng_answer() {
        return is_meetng_answer;
    }

    /**
     * @param isMeetngAnswer 
	 *            现场答疑,YES 是,NO# 否
     */
    public void setIs_meetng_answer(String is_meetng_answer) {
        this.is_meetng_answer = is_meetng_answer == null ? null : is_meetng_answer.trim();
    }

    /**
     * @return qq群号
     */
    public String getQq_no() {
        return qq_no;
    }

    /**
     * @param qqNo 
	 *            qq群号
     */
    public void setQq_no(String qq_no) {
        this.qq_no = qq_no == null ? null : qq_no.trim();
    }

    /**
     * @return qq群密码
     */
    public String getQq_password() {
        return qq_password;
    }

    /**
     * @param qqPassword 
	 *            qq群密码
     */
    public void setQq_password(String qq_password) {
        this.qq_password = qq_password == null ? null : qq_password.trim();
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
    public String getAnswer_time() {
        return answer_time;
    }

    /**
     * @param answerTime 
	 *            现场答疑,答疑时间
     */
    public void setAnswer_time(String answer_time) {
        this.answer_time = answer_time == null ? null : answer_time.trim();
    }

    /**
     * @return 现场答疑,答疑日期
     */
    public String getAnswer_date() {
        return answer_date;
    }

    /**
     * @param answerDate 
	 *            现场答疑,答疑日期
     */
    public void setAnswer_date(String answer_date) {
        this.answer_date = answer_date == null ? null : answer_date.trim();
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
        return (this.getObject_id() == null ? other.getObject_id() == null : this.getObject_id().equals(other.getObject_id()))
            && (this.getIs_qq_answer() == null ? other.getIs_qq_answer() == null : this.getIs_qq_answer().equals(other.getIs_qq_answer()))
            && (this.getIs_email_answer() == null ? other.getIs_email_answer() == null : this.getIs_email_answer().equals(other.getIs_email_answer()))
            && (this.getIs_tel_answer() == null ? other.getIs_tel_answer() == null : this.getIs_tel_answer().equals(other.getIs_tel_answer()))
            && (this.getIs_meetng_answer() == null ? other.getIs_meetng_answer() == null : this.getIs_meetng_answer().equals(other.getIs_meetng_answer()))
            && (this.getQq_no() == null ? other.getQq_no() == null : this.getQq_no().equals(other.getQq_no()))
            && (this.getQq_password() == null ? other.getQq_password() == null : this.getQq_password().equals(other.getQq_password()))
            && (this.getTelephone() == null ? other.getTelephone() == null : this.getTelephone().equals(other.getTelephone()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getAnswer_time() == null ? other.getAnswer_time() == null : this.getAnswer_time().equals(other.getAnswer_time()))
            && (this.getAnswer_date() == null ? other.getAnswer_date() == null : this.getAnswer_date().equals(other.getAnswer_date()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getObject_id() == null) ? 0 : getObject_id().hashCode());
        result = prime * result + ((getIs_qq_answer() == null) ? 0 : getIs_qq_answer().hashCode());
        result = prime * result + ((getIs_email_answer() == null) ? 0 : getIs_email_answer().hashCode());
        result = prime * result + ((getIs_tel_answer() == null) ? 0 : getIs_tel_answer().hashCode());
        result = prime * result + ((getIs_meetng_answer() == null) ? 0 : getIs_meetng_answer().hashCode());
        result = prime * result + ((getQq_no() == null) ? 0 : getQq_no().hashCode());
        result = prime * result + ((getQq_password() == null) ? 0 : getQq_password().hashCode());
        result = prime * result + ((getTelephone() == null) ? 0 : getTelephone().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getAnswer_time() == null) ? 0 : getAnswer_time().hashCode());
        result = prime * result + ((getAnswer_date() == null) ? 0 : getAnswer_date().hashCode());
        return result;
    }
}