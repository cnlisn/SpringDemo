package com.lisn.demo.core.tesks;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
/**
 * 开启定时任务的注解
 *
 * @Scheduled为设置定时任务周期的注解
 */
//@EnableScheduling
public class tesk {
    //定时任务参数常用的为两种：

    /**
     * 第一种就是fixedRate，他表示以一种固定频率去执行，单位为毫秒，
     * 例如@Scheduled(fixedRate = 5000)  表示为每五秒执行一次
     */
    @Scheduled(fixedRate = 5000)
    public void job1() {
        System.out.println("定时任务1 " + new Date());
    }

    /**
     * 第二种为cron，他可以表达某种特定频率，例如每天晚上三点执行，每个星期三中午十二点等
     */
    // 具体cron表达式用法大家可以百度，这里列出几个常用的：
    // 每隔5秒执行一次：*/5****?
    // 每隔1分钟执行一次：0*/1***?
    // 每天23点执行一次：0 0 23**?
    // 每天凌晨1点执行一次：0 0 1**?
    // 每月1号凌晨1点执行一次：0 0 1 1*?
    // 每月最后一天23点执行一次：0 0 23 L *?
    // 每周星期天凌晨1点实行一次：0 0 1?*L
    // 在26分、29 分、33 分执行一次：0 26,29,33***?
    // 每天的0点、13 点、18 点、21 点都执行一次：0 0 0,13,18,21**?
    // 每隔5分钟执行一次：0 0/5***?
    @Scheduled(cron = "0/5 * * * * ?")
    public void job2() {
        System.out.println("定时任务2 " + new Date());
    }
}
