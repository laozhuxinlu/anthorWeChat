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
				if(Account.getText().toString().equals("������·")){			
					if(Password.getText().toString().equals("357371000")){
						//SR.setText("�û�����������ȷ");	
						Account.setText(null);
						Password.setText(null);
						//����΢��
						Intent i = new Intent();
						i.setClassName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
						//com.tencent.mm:΢�ŵİ���
						i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//�������
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
	
	//�Զ��嵯����ʽ
	 protected Dialog onCreateDialog(int id) { 

		 	//����ʾ�����ṩButton���û�ִ��
	        if (id == 1) {  
	            return new AlertDialog.Builder(MainActivity.this)  
	            		//���õ��������
	                    .setMessage("��Ҫ��㿴������˽������")  
	                    //���õ���ı���
	                    .setTitle("--�˺Ŵ���--") 
	                    //����ȷ������
	                    .setPositiveButton("ȷ��",  
	                            new DialogInterface.OnClickListener() {  
	  
	                                public void onClick(DialogInterface dialog,  
	                                        int which) { 
	                                	//�����ǡ�ȷ���������Ĳ���
	                                    dialog.dismiss();  
	                                    android.os.Process  
	                                            .killProcess(android.os.Process  
	                                                    .myPid());  
	                                    finish();  
	  
	                                }  
	                            })  
	                     //����ȡ������
	                    .setNegativeButton("ȡ��",  
	                            new DialogInterface.OnClickListener() {  
	  
	                                public void onClick(DialogInterface dialog,  
	                                        int which) { 
	                                	//�����ǡ�ȡ���������Ĳ���
	                                    dialog.dismiss();  //ȥ������
	  
	                                }  
	                            }).create();          	
	        }  
	        
	        if(id==2){
	        	
	        	  
	            return new AlertDialog.Builder(MainActivity.this)  
	            		//���õ��������
	                    .setMessage("��Ҫ��㿴������˽������")  
	                    //���õ���ı���
	                    .setTitle("--�������--") 
	                    //����ȷ������
	                    .setPositiveButton("ȷ��",  
	                            new DialogInterface.OnClickListener() {  
	  
	                                public void onClick(DialogInterface dialog,  
	                                        int which) { 
	                                	//�����ǡ�ȷ���������Ĳ���
	                                    dialog.dismiss();  
	                                    android.os.Process  
	                                            .killProcess(android.os.Process  
	                                                    .myPid());  
	                                    finish();  
	  
	                                }  
	                            })  
	                     //����ȡ������
	                    .setNegativeButton("ȡ��",  
	                            new DialogInterface.OnClickListener() {  
	  
	                                public void onClick(DialogInterface dialog,  
	                                        int which) { 
	                                	//�����ǡ�ȡ���������Ĳ���
	                                    dialog.dismiss();  //ȥ������
	  
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
