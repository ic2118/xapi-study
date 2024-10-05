package com.yupi.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.project.model.entity.UserInterfaceInfo;

public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    /**
     * 检验
     *
     * @param interfaceInfo
     * @param add
     */
    void validUserInterfaceInfo(UserInterfaceInfo interfaceInfo, boolean add);


    /**
     * 统计用户调用接口
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId,long userId);
}
