package com.yupi.project.model.dto.interfaceinfo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author su
 * @Date 2024/9/30 22:25
 * @Description 封装类，接口调用请求
 */
@Data
public class InterfaceInfoInvokeRequest implements Serializable {


    private static final long serialVersionUID = 292782897087102989L;

    /**
     * 主键
     */
    private Long id;



    /**
     * 用户请求参数
     */
    private String userRequestParams;


}
