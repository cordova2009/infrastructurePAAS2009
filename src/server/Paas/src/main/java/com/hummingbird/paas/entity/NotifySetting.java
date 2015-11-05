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
    private String access_way;

    /**
     * 访问实现，填写类名，通过反射获得实现类
     */
    private String access_class_name;

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
    public String getAccess_way() {
        return access_way;
    }

    /**
     * @param accessWay 
	 *            访问方式，API接口调用，REM远程调用
     */
    public void setAccess_way(String access_way) {
        this.access_way = access_way == null ? null : access_way.trim();
    }

    /**
     * @return 访问实现，填写类名，通过反射获得实现类
     */
    public String getAccess_class_name() {
        return access_class_name;
    }

    /**
     * @param accessClassName 
	 *            访问实现，填写类名，通过反射获得实现类
     */
    public void setAccess_class_name(String access_class_name) {
        this.access_class_name = access_class_name == null ? null : access_class_name.trim();
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
            && (this.getAccess_way() == null ? other.getAccess_way() == null : this.getAccess_way().equals(other.getAccess_way()))
            && (this.getAccess_class_name() == null ? other.getAccess_class_name() == null : this.getAccess_class_name().equals(other.getAccess_class_name()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAccess_way() == null) ? 0 : getAccess_way().hashCode());
        result = prime * result + ((getAccess_class_name() == null) ? 0 : getAccess_class_name().hashCode());
        return result;
    }
}