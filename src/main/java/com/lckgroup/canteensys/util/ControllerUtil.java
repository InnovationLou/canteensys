package com.lckgroup.canteensys.util;

import com.lckgroup.canteensys.util.constant.DataCode;
import com.lckgroup.canteensys.util.constant.RespCode;
import com.lckgroup.canteensys.vo.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControllerUtil {
    Logger logger = LoggerFactory.getLogger(ControllerUtil.class);

    public static ResponseVO getTrueOrFalseResult(boolean rs) {
        ResponseVO ResponseVO = new ResponseVO();
        if (rs)
            ResponseVO.success(null);
        else
            ResponseVO.error(RespCode.FAILURE_CODE, "方法执行时返回了false", "");
        return ResponseVO;
    }
    public static <T> ResponseVO<T> getDataResult(T data) {
        ResponseVO<T> ResponseVO = new ResponseVO<>();
        if (null != data)
            ResponseVO.success(data);
        else
            ResponseVO.error(RespCode.FAILURE_CODE, "ControllerUtil.getDataResult获得空的数据", null);
        return ResponseVO;
    }

    public static <T> ResponseVO<T> getSuccessResultBySelf(T data) {
        ResponseVO ResponseVO = new ResponseVO<>();
        ResponseVO.success(data);
        return ResponseVO;
    }

    public static <T> ResponseVO<T> getFalseResultMsgBySelf(String msg) {
        ResponseVO ResponseVO = new ResponseVO<>();
        ResponseVO.error(RespCode.FAILURE_CODE, msg, null);
        return ResponseVO;
    }


    public static <T> ResponseVO<T> parData(Integer result, T data) {
        ResponseVO ResponseVO = new ResponseVO();
        if (result == DataCode.DATA_CONFLIC) {
            ResponseVO.error(-1, "数据冲突", null);
        } else if (result == DataCode.DATA_OPERATION_ERROR) {
            ResponseVO.error(-1, "操作失败", null);
        } else if (result == DataCode.DATA_OPERATION_SUCCESS) {
            ResponseVO.success(data);
        } else if (result == DataCode.DATA_OPERATION_FAILURE) {
            ResponseVO.serverError();
        }
        return ResponseVO;
    }
}
