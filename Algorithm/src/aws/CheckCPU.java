package aws;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cloudwatch.AmazonCloudWatchClient;
import com.amazonaws.services.cloudwatch.model.Datapoint;
import com.amazonaws.services.cloudwatch.model.Dimension;
import com.amazonaws.services.cloudwatch.model.GetMetricStatisticsRequest;
import com.amazonaws.services.cloudwatch.model.GetMetricStatisticsResult;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.Reservation;

import java.util.*;

/**
 * Created by HunJin on 2016-12-26.
 */
public class CheckCPU {

    // PERIOD : 측정 기간 (일주일)
    // START_TIME : 현재 날짜로부터 측정을 시작하고 하는 날짜
    // CPU 사용량 체크할 단위 (0.1%)
    final static int PERIOD = 60 * 60 * 24 * 7;
    final static long START_TIME = 1000 * 60 * 60 * 24;
    final static double CHECK_PERCENT = 0.1;

    AWSCredentials credentials = null;


    public static void main(String[] args) {
        new CheckCPU().init();
    }

    void init() {
        try {
            credentials = new ProfileCredentialsProvider().getCredentials();
        } catch (Exception e) {
            e.printStackTrace();
        }

        getId(credentials);
    }

    /**
     * credential 키를 사용하여 사용중인 ec2의 instance id를 가져옵니다.
     *
     * @param credential
     */
    void getId(AWSCredentials credential) {
        AmazonEC2 ec2 = new AmazonEC2Client(credentials);
        Region usWest2 = Region.getRegion(Regions.AP_NORTHEAST_1);
        ec2.setRegion(usWest2);

        DescribeInstancesResult describeInstancesResult = ec2.describeInstances();
        List<Reservation> reservations = describeInstancesResult.getReservations();
        Set<Instance> instances = new HashSet<>();
        for (Reservation reservation : reservations) {
            instances.addAll(reservation.getInstances());
        }

        for (Instance ins : instances) {
            String instanceId = ins.getInstanceId();
            monitorInstance(credential, instanceId);
        }
    }


    /**
     * 인스텐스 ID를 통해 그 EC2에 사용되는 CPU 부하량을 체크합니다.
     * 체크 할 때 10% 미만일 경우 instance id를 출력합니다.
     * @param credential
     * @param instanceId
     */
    void monitorInstance(AWSCredentials credential, String instanceId) {
        try {
            AmazonCloudWatchClient cw = new AmazonCloudWatchClient(credential);
            cw.setRegion(Region.getRegion(Regions.AP_NORTHEAST_1));

            long offsetInMilliseconds = START_TIME;
            GetMetricStatisticsRequest request = new GetMetricStatisticsRequest()
                    .withStartTime(new Date(
                            new Date().getTime() - offsetInMilliseconds))
                    .withNamespace("AWS/EC2")
                    .withPeriod(PERIOD)
                    .withDimensions(new Dimension().withName("InstanceId")
                            .withValue(instanceId))
                    .withMetricName("CPUUtilization")
                    .withStatistics("Average")
                    .withEndTime(new Date());
            GetMetricStatisticsResult
                    getMetricStatisticsResult = cw.getMetricStatistics(request);

            TreeMap metricValues = new TreeMap<Long, Double>();

            for (Datapoint dp : getMetricStatisticsResult.getDatapoints()) {
                metricValues.put(
                        new Date(dp.getTimestamp().getTime()),
                        dp.getAverage()
                );
            }

            Set set = metricValues.entrySet();
            Iterator i = set.iterator();
            while (i.hasNext()) {
                Map.Entry me = (Map.Entry) i.next();
                Object value = me.getValue();
                if ((double) value < CHECK_PERCENT) {
                    System.out.println("CPU 사용량이 적습니다 : " + instanceId);
                }
            }

        } catch (AmazonServiceException ase) {
            System.out.println(ase.getErrorCode());
            System.out.println(ase.getErrorMessage());
            System.out.println(ase.getErrorType());
        }
    }
}
