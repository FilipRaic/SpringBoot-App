package hr.tvz.raic.hardwareapp.scheduler;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class SchedulerConfig {

    @Bean
    public JobDetail stockAvailableJobDetail() {
        return JobBuilder
                .newJob(StockAvailableJob.class)
                .withIdentity("stockAvailableJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger stockAvailableJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder
                .simpleSchedule()
                .withIntervalInSeconds(10)
                .repeatForever();

        return TriggerBuilder.newTrigger().forJob(stockAvailableJobDetail())
                .withIdentity("stockAvailableTrigger")
                .withSchedule(scheduleBuilder)
                .startAt(new Date(System.currentTimeMillis() + 1000))
                .build();
    }

    @Bean
    public Trigger stockAvailableJobTriggerEveryWorkdayAtNoon() {
        return TriggerBuilder.newTrigger().forJob(stockAvailableJobDetail())
                .withIdentity("stockAvailableTrigger")
                .withSchedule(DailyTimeIntervalScheduleBuilder
                        .dailyTimeIntervalSchedule()
                        .onDaysOfTheWeek(DailyTimeIntervalScheduleBuilder.MONDAY_THROUGH_FRIDAY)
                        .startingDailyAt(TimeOfDay.hourAndMinuteOfDay(12, 0)))
                .build();
    }
}
