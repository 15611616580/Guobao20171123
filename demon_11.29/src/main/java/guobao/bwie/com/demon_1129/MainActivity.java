package guobao.bwie.com.demon_1129;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String str ="";
    private TextView tv2;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.text);
        tv2 = (TextView) findViewById(R.id.text2);
        yanghui();
        jiecheng();

    }

    private void jiecheng() {
            int i = 1;
            for(int x = 1; x <= 30; x++)
            {
                i= i*x;
            }
            //System.out.println(i);

          tv2.setText(jc(30)+"");
        }
        public static int jc(int i) {
            if(i==1)
                return 1;
            else
                return i*jc(i-1);

    }

    private void yanghui() {
        int triangle[][] = new int[10][];// 创建二维数组
        // 遍历二维数组的第一层
        for (int i = 0; i < triangle.length; i++) {
            triangle[i] = new int[i + 1];// 初始化第二层数组的大小
            // 遍历第二层数组
            for (int j = 0; j <= i; j++) {
                // 将两侧的数组元素赋值为1
                if (i == 0 || j == 0 || j == i) {
                    triangle[i][j] = 1;
                } else {// 其他数值通过公式计算
                    triangle[i][j] = triangle[i - 1][j] + triangle[i - 1][j - 1];
                }
                System.out.print(triangle[i][j] + "\t");         // 输出数组元素

                String s = triangle[i][j] + "\t";
                str += s+"  ";
                Log.e("string", str);
            }
            str += "\n";        //换行
        }

        tv.setText(str);

    }

}
