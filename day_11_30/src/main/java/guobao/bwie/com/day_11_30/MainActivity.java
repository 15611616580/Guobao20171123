package guobao.bwie.com.day_11_30;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText ed;
    private EditText ed2;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed= (EditText) findViewById(R.id.edtext);
        ed2= (EditText) findViewById(R.id.edtext2);
        button= (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //生兔子
                /*String string = ed.getText().toString();
                int result =fib(Integer.valueOf(string));
                Log.i("dd","这个月生了"+result);*/
                //判断字
                //number2();
                //计算字符串中子串出现的次数
               // number5();
                //从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，问最后留下的是原来第几号的那位。
                //number6();
            }

        });
        //4位数组成
       // number3();
        //1到20和
        //number4();
        //素数
         //number7();
        number8();

    }

    private void number8() {
        String string = ed.getText().toString();
        int[] num=new int[5];
        for(int i=num.length-1;i>=0;i--) {
            num[i]=Integer.valueOf(string)%10;
            Integer.valueOf(string)/=10;
        }
        //判断是否是回文数  
        //第一位数字==最后一位数字   
        //第二位数字==倒数第二位数字   
        for(int i=0;i<num.length/2;i++) {
            if(num[i]!=num[num.length-1-i]) {
                System.out.println("这个数字不是回文数");
                return;
            }
        }
        System.out.println("这个数字是回文数");
    }

    private void number7() {
        int[] a = new int[101];
        int i, j = 2;

        while (j < 101) {
            if (a[j] == 0) {
                for (i = j + 1; i < 101; i++) {
                    if (i % j == 0) {
                        a[i] = 1;
                    }
                }
            }
            j++;
        }

        for (int k = 0; k < 101; k++) {
            if (k >= 2 && a[k] == 0) {
                Log.i("dd","素数"+k);
            }
        }
    }

    private void number5() {
        String str1 = ed.getText().toString();
        String str2 = ed2.getText().toString();
        int count=0;
        if(str1.equals("")||str2.equals(""))
        {
            Log.i("dd","你没有输入字符串或子串,无法比较!");
        }
        else
        {
            for(int i=0;i<=str1.length()-str2.length();i++)
            {
                if(str2.equals(str1.substring(i, str2.length()+i)))
                    //这种比法有问题，会把"aaa"看成有2个"aa"子串。
                    count++;
            }
            Log.i("dd","子串在字符串中出现: "+count+" 次");
        }
    }

    private void number4() {
        long temp = 1;
        long sum = 0;
        for (int i = 1; i <= 20; i++)
        {
            temp = temp * i;
            sum += temp;
        }
        Log.i("dd","总和为"+sum);
    }

    private void number3() {
        int[] bai={1,2,3,4};//定义百位可能出现的数字
        int[] shi={1,2,3,4};//定义十位可能出现的数字
        int[] ge={1,2,3,4};//定义个位可能出现的数字
        int count=0;//计算满足条件的数的个数
        for(int i=0;i<bai.length;i++)
            for(int j=0;j<shi.length;j++)
                for(int k=0;k<ge.length;k++){
                    if(bai[i]!=shi[j]&&bai[i]!=ge[k]&&shi[j]!=ge[k]){
                        count++;
                    }
                }
        Log.i("dd","总共有"+count+"个。");

    }

    private void number2() {
        char c[]=ed.getText().toString().toCharArray();
        int letter=0;
        int dital=0;
        int space=0;
        int others=0;
        int	chinese=0;
        for(int i=0;i<c.length;i++){
            if(('a'<= c[i] && c[i] <= 'z')||('A'<= c[i] && c[i] <= 'Z')){
                letter++;
            }
            if(c[i]>='0'&&c[i]<='9'){
                dital++;
            }
            if(c[i]==' '){
                space++;

            }if(c[i]>= 0x0391 && c[i]<= 0xFFE5){
                chinese++;
            }else{
                others++;
            }

        }
        Log.i("dd","输入的汉字个数"+chinese);
        Log.i("dd","输入的字母个数"+letter);
        Log.i("dd","输入的数字个数"+dital);
        Log.i("dd","输入的空格个数"+space);
        Log.i("dd","输入的其它字符个数"+others);
    }
    public static int fib(int n){
        if(n == 0) {
            return 0;
        }
        if(n == 1 || n ==2){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }
    private void number6() {
        String string = ed.getText().toString();
        boolean[] a=new boolean[Integer.valueOf(string)];
        for(int i=0;i<Integer.valueOf(string);i++){
            a[i]=true;}
        int countnum=0;
        int leftnum=Integer.valueOf(string);
        int index=0;
        while(leftnum>1){
            if(a[index]==true){
                countnum++;
                if(countnum==3){
                    a[index]=false;
                    countnum=0;
                    leftnum--;}}
            index++;
            if(index==Integer.valueOf(string)){
                index=0;
            }
        }
        for(int i=0;i<Integer.valueOf(string);i++){
            if(a[i]==true){
               Log.i("dd",""+(i+1));}}
    }
}
