package algorithm.arduino;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;

/**
 * Created by HunJin on 2017-06-09.
 */
public class SerialCommunication {
    public static void main(String[] args) {
        try {
            (new Serial()).connect("COM4"); //입력한 포트로 연결
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class Serial {
    public Serial() {
        super();
    }

    void connect(String portName) throws Exception {
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
        if (portIdentifier.isCurrentlyOwned()) {
            System.out.println("Error: Port is currently in use");
        } else {
            //클래스 이름을 식별자로 사용하여 포트 오픈
            CommPort commPort = portIdentifier.open(this.getClass().getName(), 2000);

            if (commPort instanceof SerialPort) {
                //포트 설정(통신속도 설정. 기본 9600으로 사용)
                SerialPort serialPort = (SerialPort) commPort;
                serialPort.setSerialPortParams(115200, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

                //Input,OutputStream 버퍼 생성 후 오픈
                InputStream in = serialPort.getInputStream();
                OutputStream out = serialPort.getOutputStream();

                //읽기, 쓰기 쓰레드 작동
                (new Thread(new SerialReader(in))).start();
//                (new Thread(new SerialWriter(out))).start();

            } else {
                System.out.println("Error: Only serial ports are handled by this example.");
            }
        }
    }
}

class SerialReader implements Runnable {
    InputStream in;

    boolean isAvailable = false;

    public SerialReader(InputStream in) {
        this.in = in;
    }

    public void run() {
        System.out.println("이건 몇 번이나 실행");
        byte[] buffer = new byte[1024];
        int len = -1;
        try {
            len = this.in.read(buffer);
            while (len > -1) {
                String str = new String(buffer, 0, len);
                str = str.trim().toString();
                System.out.println(str);
                //System.out.println(isAvailable);
                if ((str.equals("on")) && (isAvailable == false)) {
                    isAvailable = true;
                    System.out.println("now : " + isAvailable);
                    mysqlConnect();
                    Thread.sleep(4000);
                    //break;
                } else if ((str.equals("off")) && (isAvailable == true)) {
                    isAvailable = false;
                    System.out.println("now : " + isAvailable);
                    mysqlConnect();
                    Thread.sleep(4000);
                    //break;
                } else {
                    System.out.println("available : " + isAvailable + " value : " + str);
                }
                Thread.sleep(100);
//                System.out.print(new String(buffer,0,len));
                len = this.in.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    Connection con = null;
    Statement st = null;
//    ResultSet rs = null;

    void mysqlConnect() {
        try {


            con = DriverManager.getConnection("jdbc:mysql://117.123.102.30:3306/hoke",

                    "root", "mosquito");

            st = con.createStatement();

            String sql = "update `value` set `val` = '" + isAvailable + "' where `id` = '1';";

            st.execute(sql);

//            rs = st.executeQuery(sql);


            System.out.println("success update");


//            rs.close();
            st.close();
            con.close();


        } catch (SQLException sqex) {

            System.out.println("SQLException: " + sqex.getMessage());

            System.out.println("SQLState: " + sqex.getSQLState());

        } finally {
            try {
                if (st != null)
                    st.close();
            } catch (SQLException se2) {
            }
            try {
                if (con != null)
                    con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}

/** */
//데이터 송신
class SerialWriter implements Runnable {
    OutputStream out;

    public SerialWriter(OutputStream out) {
        this.out = out;
    }

    public void run() {
        try {
            int c = 0;
            while ((c = System.in.read()) > -1) {
                this.out.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}