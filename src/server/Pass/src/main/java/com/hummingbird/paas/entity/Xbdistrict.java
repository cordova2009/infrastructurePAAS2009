package com.hummingbird.paas.entity;

/**
 * 区域表
 */
public class Xbdistrict {
    /**
     * id
     */
    private Integer id;

    /**
     * name
     */
    private String name;

    /**
     * level
     */
    private Byte level;

    /**
     * pid
     */
    private Integer pid;

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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name 
	 *            name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return level
     */
    public Byte getLevel() {
        return level;
    }

    /**
     * @param level 
	 *            level
     */
    public void setLevel(Byte level) {
        this.level = level;
    }

    /**
     * @return pid
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * @param pid 
	 *            pid
     */
    public void setPid(Integer pid) {
        this.pid = pid;
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
        Xbdistrict other = (Xbdistrict) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        return result;
    }
}