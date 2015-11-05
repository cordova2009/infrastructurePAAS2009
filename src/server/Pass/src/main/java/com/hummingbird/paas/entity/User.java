package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 注册用户表
 */
public class User {
    /**
     * id
     */
    private Integer id;

    /**
     * user_name
     */
    private String user_name;

    /**
     * mobile_num
     */
    private String mobile_num;

    /**
     * city
     */
    private String city;

    /**
     * district
     */
    private String district;

    /**
     * insert_time
     */
    private Date insert_time;

    /**
     * update_time
     */
    private Date update_time;

    /**
     * union_id
     */
    private String union_id;

    /**
     * qq
     */
    private String qq;

    /**
     * email
     */
    private String email;

    /**
     * 昵称
     */
    private String nick_name;

    /**
     * 地址
     */
    private String address;

    /**
     * 头像
     */
    private String head_image;

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
     * @return user_name
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     * @param userName 
	 *            user_name
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name == null ? null : user_name.trim();
    }

    /**
     * @return mobile_num
     */
    public String getMobile_num() {
        return mobile_num;
    }

    /**
     * @param mobileNum 
	 *            mobile_num
     */
    public void setMobile_num(String mobile_num) {
        this.mobile_num = mobile_num == null ? null : mobile_num.trim();
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city 
	 *            city
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * @return district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * @param district 
	 *            district
     */
    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    /**
     * @return insert_time
     */
    public Date getInsert_time() {
        return insert_time;
    }

    /**
     * @param insertTime 
	 *            insert_time
     */
    public void setInsert_time(Date insert_time) {
        this.insert_time = insert_time;
    }

    /**
     * @return update_time
     */
    public Date getUpdate_time() {
        return update_time;
    }

    /**
     * @param updateTime 
	 *            update_time
     */
    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    /**
     * @return union_id
     */
    public String getUnion_id() {
        return union_id;
    }

    /**
     * @param unionId 
	 *            union_id
     */
    public void setUnion_id(String union_id) {
        this.union_id = union_id == null ? null : union_id.trim();
    }

    /**
     * @return qq
     */
    public String getQq() {
        return qq;
    }

    /**
     * @param qq 
	 *            qq
     */
    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email 
	 *            email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * @return 昵称
     */
    public String getNick_name() {
        return nick_name;
    }

    /**
     * @param nickName 
	 *            昵称
     */
    public void setNick_name(String nick_name) {
        this.nick_name = nick_name == null ? null : nick_name.trim();
    }

    /**
     * @return 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address 
	 *            地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * @return 头像
     */
    public String getHead_image() {
        return head_image;
    }

    /**
     * @param headImage 
	 *            头像
     */
    public void setHead_image(String head_image) {
        this.head_image = head_image == null ? null : head_image.trim();
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
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUser_name() == null ? other.getUser_name() == null : this.getUser_name().equals(other.getUser_name()))
            && (this.getMobile_num() == null ? other.getMobile_num() == null : this.getMobile_num().equals(other.getMobile_num()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getDistrict() == null ? other.getDistrict() == null : this.getDistrict().equals(other.getDistrict()))
            && (this.getInsert_time() == null ? other.getInsert_time() == null : this.getInsert_time().equals(other.getInsert_time()))
            && (this.getUpdate_time() == null ? other.getUpdate_time() == null : this.getUpdate_time().equals(other.getUpdate_time()))
            && (this.getUnion_id() == null ? other.getUnion_id() == null : this.getUnion_id().equals(other.getUnion_id()))
            && (this.getQq() == null ? other.getQq() == null : this.getQq().equals(other.getQq()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getNick_name() == null ? other.getNick_name() == null : this.getNick_name().equals(other.getNick_name()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getHead_image() == null ? other.getHead_image() == null : this.getHead_image().equals(other.getHead_image()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUser_name() == null) ? 0 : getUser_name().hashCode());
        result = prime * result + ((getMobile_num() == null) ? 0 : getMobile_num().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getDistrict() == null) ? 0 : getDistrict().hashCode());
        result = prime * result + ((getInsert_time() == null) ? 0 : getInsert_time().hashCode());
        result = prime * result + ((getUpdate_time() == null) ? 0 : getUpdate_time().hashCode());
        result = prime * result + ((getUnion_id() == null) ? 0 : getUnion_id().hashCode());
        result = prime * result + ((getQq() == null) ? 0 : getQq().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getNick_name() == null) ? 0 : getNick_name().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getHead_image() == null) ? 0 : getHead_image().hashCode());
        return result;
    }
}