package com.example.Start_Wechat;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText Account;
	private EditText Password;
	private Button login;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Account = (EditText)findViewById(R.id.ET1);
		Password= (EditText)findViewById(R.id.ET2);
		login   = (Button)findViewById(R.id.Login);
		
		login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(Account.getText().toString().equals("老猪新路")){			
					if(Password.getText().toString().equals("357371000")){
						//SR.setText("用户名与密码正确");	
						Account.setText(null);
						Password.setText(null);
						//启动微信
						Intent i = new Intent();
						i.setClassName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
						//com.tencent.mm:微信的包名
						i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//必须添加
						getApplicationContext().startActivity(i);
					}
					else{
						Password.setText(null);						
						showDialog(2);  
					}								
				}
				else{
					Account.setText(null);
					showDialog(1);  
				}
			}
		});

	}
	
	//自定义弹框形式
	 protected Dialog onCreateDialog(int id) { 

		 	//简单提示，并提供Button供用户执行
	        if (id == 1) {  
	            return new AlertDialog.Builder(MainActivity.this)  
	            		//设置弹框的内容
	                    .setMessage("不要随便看别人隐私！！！")  
	                    //设置弹框的标题
	                    .setTitle("--账号错误--") 
	                    //设置确定按键
	                    .setPositiveButton("确定",  
	                            new DialogInterface.OnClickListener() {  
	  
	                                public void onClick(DialogInterface dialog,  
	                                        int which) { 
	                                	//以下是“确定”按键的操作
	                                    dialog.dismiss();  
	                                    android.os.Process  
	                                            .killProcess(android.os.Process  
	                                                    .myPid());  
	                                    finish();  
	  
	                                }  
	                            })  
	                     //设置取消按键
	                    .setNegativeButton("取消",  
	                            new DialogInterface.OnClickListener() {  
	  
	                                public void onClick(DialogInterface dialog,  
	                                        int which) { 
	                                	//以下是“取消”按键的操作
	                                    dialog.dismiss();  //去掉弹框
	  
	                                }  
	                            }).create();          	
	        }  
	        
	        if(id==2){
	        	
	        	  
	            return new AlertDialog.Builder(MainActivity.this)  
	            		//设置弹框的内容
	                    .setMessage("不要随便看别人隐私！！！")  
	                    //设置弹框的标题
	                    .setTitle("--密码错误--") 
	                    //设置确定按键
	                    .setPositiveButton("确定",  
	                            new DialogInterface.OnClickListener() {  
	  
	                                public void onClick(DialogInterface dialog,  
	                                        int which) { 
	                                	//以下是“确定”按键的操作
	                                    dialog.dismiss();  
	                                    android.os.Process  
	                                            .killProcess(android.os.Process  
	                                                    .myPid());  
	                                    finish();  
	  
	                                }  
	                            })  
	                     //设置取消按键
	                    .setNegativeButton("取消",  
	                            new DialogInterface.OnClickListener() {  
	  
	                                public void onClick(DialogInterface dialog,  
	                                        int which) { 
	                                	//以下是“取消”按键的操作
	                                    dialog.dismiss();  //去掉弹框
	  
	                                }  
	                            }).create();          	
	        
	        }
	        return null;  
	  
	    }  


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
