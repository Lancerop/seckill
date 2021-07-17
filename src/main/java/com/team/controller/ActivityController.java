package com.team.controller;

import com.team.DTO.ActivityInventoryDTO;
import com.team.DTO.BookActivityDTO;
import com.team.DTO.InitActivityInventoryDTO;
import com.team.Service.ActivityService;
import com.team.common.MyResult;
import com.team.common.exception.CommonErrorCodeEnum;
import com.team.common.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname ActivityController
 * @Description TODO
 * @Date 2021/7/16 下午11:52
 * @Created by muyi
 */

@RestController
@RequestMapping("/activity/")
public class ActivityController {

    @Autowired
    private ActivityService activityService;



    /**
     * 初始化库存
     * @param initActivityInventoryDTO
     * @return
     */
    @PostMapping("initActivityInventory")
    @ResponseBody
    public MyResult initActivityInventory(InitActivityInventoryDTO initActivityInventoryDTO){
        if(initActivityInventoryDTO == null
                || initActivityInventoryDTO.getActivityNum() == null
                || initActivityInventoryDTO.getNum() == null){
            throw new MyException(CommonErrorCodeEnum.INVALID_PARAM.getResultCode(),CommonErrorCodeEnum.INVALID_PARAM.getResultMsg());
        }
        activityService.initActivityInventory(initActivityInventoryDTO.getActivityNum(), initActivityInventoryDTO.getNum());
        return MyResult.ok();
    }


    /**
     * 查询活动库存
     * @return
     */
    @GetMapping("getActivityInventory")
    @ResponseBody
    public MyResult<ActivityInventoryDTO> getActivityInventory(){
        ActivityInventoryDTO activityInventoryDTO = activityService.getActivityInventory();
        return MyResult.ok(activityInventoryDTO);
    }

    @PostMapping("bookActivity")
    @ResponseBody
    public MyResult<Integer> bookActivity(BookActivityDTO activityDTO){
        if(activityDTO == null
                || activityDTO.getActivityNum() == null
                || activityDTO.getMemberId() == null){
            throw new MyException(CommonErrorCodeEnum.INVALID_PARAM.getResultCode(),CommonErrorCodeEnum.INVALID_PARAM.getResultMsg());
        }
        Integer result = activityService.bookActivity(activityDTO);
        return MyResult.ok(result);
    }

    // 抢票

    // 查询抢票结果

    // 代替定时处理会员身份
}
