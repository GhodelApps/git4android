package com.example.git;

import java.io.File;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SingleRepositoryActivity extends Activity{

				private final String TAG = getClass().getName();
				private String repoPath = "";
				GitRepository repository;
				
				@Override
				public void onCreate(Bundle savedInstanceState) {
					super.onCreate(savedInstanceState);
					setContentView(R.layout.single_repository_overview);
	        
	        Bundle extras = getIntent().getExtras();
	        if (extras != null) {
	            repoPath = extras.getString("repo");
	      			Log.d(TAG, repoPath.toString());
	        }
	        
	        //init repo
	        if (repoPath != "") {
	        	repository = new GitRepository();
	        	repository.hookIn(repoPath);
	        
	        Button buttonAddFiles = (Button) findViewById(R.id.button_add_files);
	        Button buttonCommit = (Button) findViewById(R.id.button_commit);
	        Button buttonPush = (Button) findViewById(R.id.button_push);
	        Button buttonAddRemote = (Button) findViewById(R.id.button_add_remote);
	        Button buttonLog = (Button) findViewById(R.id.button_log);
	        Button buttonStatus = (Button) findViewById(R.id.button_status);
					
	        buttonAddFiles.setOnClickListener(new View.OnClickListener() {
	      		public void onClick(View v) {
	      		//	repository.add();
	  				}
	        });
	        
	        buttonCommit.setOnClickListener(new View.OnClickListener() {
	      		public void onClick(View v) {
	  				}
	        });
	        
	        buttonPush.setOnClickListener(new View.OnClickListener() {
	      		public void onClick(View v) {
	  				}
	        });
	        
	        buttonAddRemote.setOnClickListener(new View.OnClickListener() {
	      		public void onClick(View v) {
	  				}
	        });
	        
	        buttonLog.setOnClickListener(new View.OnClickListener() {
	      		public void onClick(View v) {
	  				}
	        });
	        
	        buttonStatus.setOnClickListener(new View.OnClickListener() {
	      		public void onClick(View v) {
	      			String status = repository.status();
	      			Toaster.makeToast(status, Toast.LENGTH_LONG, SingleRepositoryActivity.this);
	  				}
	        });
	        } else {
	        	Toaster.makeToast("Wasn't able to find this repo : (", Toast.LENGTH_LONG, SingleRepositoryActivity.this);
	        }
				}
					
}

