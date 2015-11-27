package com.hummingbird.capital.entity;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.hummingbird.common.face.AbstractAppLog;

public class AppLog extends AbstractAppLog {
	
    protected Integer idtAppLog;


    /**
	 * 构造函数
	 * @param applog
	 */
	public AppLog(AbstractAppLog applog) {
		this.appid = applog.getAppid();
		this.inserttime = applog.getInserttime();
		this.method=applog.getMethod();
		this.request= StringUtils.substring(applog.getRequest(),0,2000);
		this.respone = StringUtils.substring(applog.getRespone(),0,2000);
	}

	public AppLog() {
		super();
	}

	public Integer getIdtAppLog() {
        return idtAppLog;
    }

    public void setIdtAppLog(Integer idtAppLog) {
        this.idtAppLog = idtAppLog;
    }

   

    public void setRequest(String request) {
        this.request = request == null ? null : StringUtils.substring(request.trim(),0,2000);
    }


    public void setRespone(String respone) {
        this.respone = respone == null ? null : StringUtils.substring(respone.trim(),0,2000);
    }

}