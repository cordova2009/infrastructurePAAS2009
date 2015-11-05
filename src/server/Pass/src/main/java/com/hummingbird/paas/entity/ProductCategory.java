package com.hummingbird.paas.entity;

/**
 * 产品分类表
 */
public class ProductCategory {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 分类名称
     */
    private String title;

    /**
     * 分类代码
     */
    private String name;

    /**
     * 上级分类
     */
    private Integer pid;

    /**
     * 状态
     */
    private String status;

    /**
     * 优先级
     */
    private Integer sort;

    /**
     * @return 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 
	 *            主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 分类名称
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title 
	 *            分类名称
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * @return 分类代码
     */
    public String getName() {
        return name;
    }

    /**
     * @param name 
	 *            分类代码
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return 上级分类
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * @param pid 
	 *            上级分类
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * @return 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status 
	 *            状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return 优先级
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * @param sort 
	 *            优先级
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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
        ProductCategory other = (ProductCategory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        return result;
    }
}