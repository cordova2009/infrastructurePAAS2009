package com.hummingbird.capital.entity;

import java.util.Date;

public class FactoryTask {
    /**
     * 自增序号
     */
    private Integer idt_factory_task;

    /**
     * 产品编码，来自产品表
     */
    private String productId;

    /**
     * 产品名称，来自产品表
     */
    private String productName;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 制作号码数量
     */
    private Long amount;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态，CRT-创建任务，DNG-执行中，OK#-执行完成，DEL-任务撤销，FLS-任务无法执行，失败
     */
    private String status;

    /**
     * 开始执行时间
     */
    private Date startTime;

    /**
     * 发卡机构编码
     */
    private String unitId;

    /**
     * 当前任务生成账号计数器，用于表示这个任务执行到哪里了
     */
    private Long counter;

    /**
     * @return 自增序号
     */
    public Integer getIdt_factory_task() {
        return idt_factory_task;
    }

    /**
     * @param idtFactoryTask 
	 *            自增序号
     */
    public void setIdt_factory_task(Integer idt_factory_task) {
        this.idt_factory_task = idt_factory_task;
    }

    /**
     * @return 产品编码，来自产品表
     */
    public String getProductId() {
        return productId;
    }

    /**
     * @param productid 
	 *            产品编码，来自产品表
     */
    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    /**
     * @return 产品名称，来自产品表
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productname 
	 *            产品名称，来自产品表
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * @return 任务名称
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * @param taskname 
	 *            任务名称
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    /**
     * @return 制作号码数量
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * @param amount 
	 *            制作号码数量
     */
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    /**
     * @return 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark 
	 *            备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * @return 状态，CRT-创建任务，DNG-执行中，OK#-执行完成，DEL-任务撤销，FLS-任务无法执行，失败
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status 
	 *            状态，CRT-创建任务，DNG-执行中，OK#-执行完成，DEL-任务撤销，FLS-任务无法执行，失败
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return 开始执行时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @param starttime 
	 *            开始执行时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return 发卡机构编码
     */
    public String getUnitId() {
        return unitId;
    }

    /**
     * @param unitid 
	 *            发卡机构编码
     */
    public void setUnitId(String unitId) {
        this.unitId = unitId == null ? null : unitId.trim();
    }

    /**
     * @return 当前任务生成账号计数器，用于表示这个任务执行到哪里了
     */
    public Long getCounter() {
        return counter;
    }

    /**
     * @param counter 
	 *            当前任务生成账号计数器，用于表示这个任务执行到哪里了
     */
    public void setCounter(Long counter) {
        this.counter = counter;
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
        FactoryTask other = (FactoryTask) that;
        return (this.getIdt_factory_task() == null ? other.getIdt_factory_task() == null : this.getIdt_factory_task().equals(other.getIdt_factory_task()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
            && (this.getTaskName() == null ? other.getTaskName() == null : this.getTaskName().equals(other.getTaskName()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getUnitId() == null ? other.getUnitId() == null : this.getUnitId().equals(other.getUnitId()))
            && (this.getCounter() == null ? other.getCounter() == null : this.getCounter().equals(other.getCounter()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdt_factory_task() == null) ? 0 : getIdt_factory_task().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getTaskName() == null) ? 0 : getTaskName().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getUnitId() == null) ? 0 : getUnitId().hashCode());
        result = prime * result + ((getCounter() == null) ? 0 : getCounter().hashCode());
        return result;
    }
}