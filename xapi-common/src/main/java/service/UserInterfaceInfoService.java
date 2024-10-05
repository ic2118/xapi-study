package service;

import com.baomidou.mybatisplus.extension.service.IService;
import model.entity.InterfaceInfo;
import model.entity.User;
import model.entity.UserInterfaceInfo;

public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    /**
     * // 1. 数据库中是否已分配给用户密钥（accessKey,secretKey,布尔）
     * @param accessKey
     * @param secretKey
     * @return
     */
    User getInvokeUser(String accessKey,String secretKey);

    /**
     * 从数据库中查询模拟接口是否存在（请求路径，请求方法，请求参数，布尔）
     */

    InterfaceInfo getInterfaceInfo(String path,String method);




    /**
     * 统计用户调用接口
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId,long userId);
}
