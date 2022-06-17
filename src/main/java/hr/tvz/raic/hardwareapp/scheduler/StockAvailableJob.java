package hr.tvz.raic.hardwareapp.scheduler;

import hr.tvz.raic.hardwareapp.service.HardwareService;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class StockAvailableJob extends QuartzJobBean {

    @Autowired
    private HardwareService hardwareService;

    private String name;

    private static final Logger log = LoggerFactory.getLogger(StockAvailableJob.class);

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) {
        log.info("This is the currently available hardware");
        log.info("------------------------------");
        hardwareService.getHardwareWithQty().forEach(hardware -> {
            log.info(hardware.getName() + " - " + hardware.getAmount());
        });
        log.info("------------------------------");
    }
}
