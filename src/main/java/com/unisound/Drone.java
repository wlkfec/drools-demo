package com.unisound;

import lombok.Builder;
import lombok.Data;

/**
 * @author unisound
 */
@Data
@Builder
public class Drone {
    /**
     * 当前机器编号
     */
    private String id;
    /**
     * 特勤类信息
     */
    private SpecialCasesEnum specialCasesEnum;
    /**
     * 飞机所处阶段
     */
    private AircraftPhaseEnum aircraftPhaseEnum;
    /**
     *  处理状态
     */
    private ProcessingStatusEnum processingStatusEnum = ProcessingStatusEnum.Start;
    /**
     * 普通类指令
     */
    private NormalCasesEnum normalCasesEnum;

    // ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- -----
    /**
     * 高度
     */
    private Integer height;
    /**
     * 速度
     */
    private Integer speed;
    /**
     * “应急放起落架命令”是否被执行，规则中只允许执行一次
     */
    private Boolean emergencyLandingGearIsExecuted;
}
