package com.yupi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.project.common.ErrorCode;
import com.yupi.project.exception.BusinessException;
import com.yupi.project.mapper.UserInterfaceInfoMapper;
import com.yupi.project.model.entity.InterfaceInfo;
import com.yupi.project.model.entity.UserInterfaceInfo;
import com.yupi.project.service.UserInterfaceInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
        implements UserInterfaceInfoService {

    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        Long id = userInterfaceInfo.getId();
        Long userId = userInterfaceInfo.getUserId();
        Long interfaceInfoId = userInterfaceInfo.getInterfaceInfoId();
        Integer totalNum = userInterfaceInfo.getTotalNum();
        Integer leftNum = userInterfaceInfo.getLeftNum();
        Integer status = userInterfaceInfo.getStatus();
        Date createTime = userInterfaceInfo.getCreateTime();
        Date updateTime = userInterfaceInfo.getUpdateTime();
        Integer isDelete = userInterfaceInfo.getIsDelete();


        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }


        // 创建时，所有参数必须非非空
        if (add) {
            if(userInterfaceInfo.getInterfaceInfoId() <= 0 || userInterfaceInfo.getUserId() <= 0){
                throw new BusinessException(ErrorCode.PARAMS_ERROR,"接口或用户不存在");
            }
        }

        if(userInterfaceInfo.getLeftNum() < 0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"剩余次数不能小于等于0");
        }


    }

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        // 校验
        if(interfaceInfoId <= 0 || userId <= 0){
            throw new  BusinessException(ErrorCode.PARAMS_ERROR);
        }

        UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("interfaceInfoId",interfaceInfoId);
        updateWrapper.eq("userId",userId);
        updateWrapper.setSql("leftNum = leftNum - 1, totalNum = totalNum + 1");
        boolean update = this.update(updateWrapper);
        return update;


    }
}
