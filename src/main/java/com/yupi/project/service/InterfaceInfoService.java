package com.yupi.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.project.model.entity.InterfaceInfo;

/**
 * 接口信息服务
 *
 * @author
 */
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    /**
     * 检验
     * @param interfaceInfo
     * @param add
     */
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
