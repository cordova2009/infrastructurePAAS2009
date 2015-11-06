package com.hummingbird.paas.entity;

/**
 * 通知方式配置表
 */
public class NotifySetting {
    /**
     * id
     */
    private String id;

    /**
     * 访问方式，API接口调用，REM远程调用
     */
    private String accessWay;

    /**
     * 访问实现，填写类名，通过反射获得实现类
     */
    private String accessClassName;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id 
	 *            id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return 访问方式，API接口调用，REM远程调用
     */
    public String getAccessWay() {
        return accessWay;
    }

    /**
     * @param accessWay 
	 *            访问方式，API接口调用，REM远程调用
     */
    public void setAccessWay(String accessWay) {
        this.accessWay = accessWay == null ? null : accessWay.trim();
    }

    /**
     * @return 访问实现，填写类名，通过反射获得实现类
     */
    public String getAccessClassName() {
        return accessClassName;
    }

    /**
     * @param accessClassName 
	 *            访问实现，填写类名，通过反射获得实现类
     */
    public void setAccessClassName(String accessClassName) {
        this.accessClassName = accessClassName == null ? null : accessClassName.trim();
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
        NotifySetting other = (NotifySetting) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAccessWay() == null ? other.getAccessWay() == null : this.getAccessWay().equals(other.getAccessWay()))
            && (this.getAccessClassName() == null ? other.getAccessClassName() == null : this.getAccessClassName().equals(other.getAccessClassName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAccessWay() == null) ? 0 : getAccessWay().hashCode());
        result = prime * result + ((getAccessClassName() == null) ? 0 : getAccessClassName().hashCode());
        return result;
    }
}