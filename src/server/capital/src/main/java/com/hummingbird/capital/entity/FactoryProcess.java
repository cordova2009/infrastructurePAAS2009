package com.hummingbird.capital.entity;

public class FactoryProcess {
    private Long idt_factory_process;

    private String productId;

    /**
     * 发卡机构编码
     */
    private String unitId;

    private Long couter;

    public Long getIdt_factory_process() {
        return idt_factory_process;
    }

    public void setIdt_factory_process(Long idt_factory_process) {
        this.idt_factory_process = idt_factory_process;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
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

    public Long getCouter() {
        return couter;
    }

    public void setCouter(Long couter) {
        this.couter = couter;
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
        FactoryProcess other = (FactoryProcess) that;
        return (this.getIdt_factory_process() == null ? other.getIdt_factory_process() == null : this.getIdt_factory_process().equals(other.getIdt_factory_process()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getUnitId() == null ? other.getUnitId() == null : this.getUnitId().equals(other.getUnitId()))
            && (this.getCouter() == null ? other.getCouter() == null : this.getCouter().equals(other.getCouter()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdt_factory_process() == null) ? 0 : getIdt_factory_process().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getUnitId() == null) ? 0 : getUnitId().hashCode());
        result = prime * result + ((getCouter() == null) ? 0 : getCouter().hashCode());
        return result;
    }
}