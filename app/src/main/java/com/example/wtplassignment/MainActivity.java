package com.example.wtplassignment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WebView mwebview;
    ProgressBar progressBar;
    String sb="";
    AlertDialog.Builder alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mwebview = findViewById(R.id.webview);
        progressBar = findViewById(R.id.pb);

        if(savedInstanceState == null)
            mwebview.loadUrl("https://in.yahoo.com/");

        mwebview.getSettings().setJavaScriptEnabled(true);
        mwebview.setWebViewClient(new MyWebViewClient());
        mwebview.setWebChromeClient(new MyWebCromeClient());
    }
    class MyWebViewClient extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            String url = request.getUrl().toString();
            view.loadUrl(url);
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            getSupportActionBar().setTitle(view.getTitle());
        }
    }

    class MyWebCromeClient extends WebChromeClient
    {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            //super.onProgressChanged(view, newProgress);
            progressBar.setProgress(newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            //super.onReceivedTitle(view, title);
            sb= title;
            getSupportActionBar().setTitle(title);

        }

        @Override
        public void onReceivedIcon(WebView view, Bitmap icon) {
            super.onReceivedIcon(view, icon);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int k = item.getItemId();

        switch (k)
        {
            case R.id.back:
                if(mwebview.canGoBack())
                    alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("PASSCODE");
                alertDialog.setMessage(" Enter Security Passcode ");
                final EditText input = new EditText(MainActivity.this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                alertDialog.setView(input);
                alertDialog.setPositiveButton("YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                String password = input.getText().toString();

                                if (password.equals("1234")) {
                                    Toast toast = Toast.makeText(getApplicationContext(), "Hey,Passcode Matched", Toast.LENGTH_SHORT);
                                    View view=toast.getView();
                                    view.getBackground().setColorFilter(Color.LTGRAY, PorterDuff.Mode.SRC_IN);
                                    TextView text =view.findViewById(android.R.id.message);
                                    text.setTextColor(Color.BLUE);
                                    toast.show();
                                    mwebview.goBack();
                                }
                                else
                                {
                                    Toast toast = Toast.makeText(getApplicationContext(), "Sorry,Wrong Passcode!", Toast.LENGTH_SHORT);
                                    View view=toast.getView();
                                    view.getBackground().setColorFilter(Color.LTGRAY, PorterDuff.Mode.SRC_IN);
                                    TextView text =view.findViewById(android.R.id.message);
                                    text.setTextColor(Color.RED);
                                    toast.show();
                                }
                            }
                        });

                alertDialog.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                alertDialog.show();
                break;
            case R.id.forward:
                if(mwebview.canGoForward())
                    alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("PASSCODE");
                alertDialog.setMessage(" Enter Security Passcode ");
                final EditText input1 = new EditText(MainActivity.this);
                LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input1.setLayoutParams(lp1);
                alertDialog.setView(input1);
                alertDialog.setPositiveButton("YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                String password = input1.getText().toString();

                                if (password.equals("1234")) {
                                    Toast toast = Toast.makeText(getApplicationContext(), "Hey,Passcode Matched", Toast.LENGTH_SHORT);
                                    View view=toast.getView();
                                    view.getBackground().setColorFilter(Color.LTGRAY, PorterDuff.Mode.SRC_IN);
                                    TextView text =view.findViewById(android.R.id.message);
                                    text.setTextColor(Color.BLUE);
                                    toast.show();
                                    mwebview.goForward();
                                }
                                else
                                {
                                    Toast toast = Toast.makeText(getApplicationContext(), "Sorry,Wrong Passcode!", Toast.LENGTH_SHORT);
                                    View view=toast.getView();
                                    view.getBackground().setColorFilter(Color.LTGRAY, PorterDuff.Mode.SRC_IN);
                                    TextView text =view.findViewById(android.R.id.message);
                                    text.setTextColor(Color.RED);
                                    toast.show();
                                }
                            }
                        });

                alertDialog.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                alertDialog.show();
                break;
            case R.id.reload:
                alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("PASSCODE");
                alertDialog.setMessage(" Enter Security Passcode ");
                final EditText input2 = new EditText(MainActivity.this);
                LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input2.setLayoutParams(lp2);
                alertDialog.setView(input2);
                alertDialog.setPositiveButton("YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                String password = input2.getText().toString();

                                if (password.equals("1234")) {
                                    Toast toast = Toast.makeText(getApplicationContext(), "Hey,Passcode Matched", Toast.LENGTH_SHORT);
                                    View view=toast.getView();
                                    view.getBackground().setColorFilter(Color.LTGRAY, PorterDuff.Mode.SRC_IN);
                                    TextView text =view.findViewById(android.R.id.message);
                                    text.setTextColor(Color.BLUE);
                                    toast.show();
                                    mwebview.reload();
                                }
                                else
                                {
                                    Toast toast = Toast.makeText(getApplicationContext(), "Sorry,Wrong Passcode!", Toast.LENGTH_SHORT);
                                    View view=toast.getView();
                                    view.getBackground().setColorFilter(Color.LTGRAY, PorterDuff.Mode.SRC_IN);
                                    TextView text =view.findViewById(android.R.id.message);
                                    text.setTextColor(Color.RED);
                                    toast.show();
                                }
                            }
                        });

                alertDialog.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                alertDialog.show();
                break;
            case R.id.close:
                alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("PASSCODE");
                alertDialog.setMessage(" Enter Security Passcode ");
                final EditText input3 = new EditText(MainActivity.this);
                LinearLayout.LayoutParams lp3 = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input3.setLayoutParams(lp3);
                alertDialog.setView(input3);
                alertDialog.setPositiveButton("YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                String password = input3.getText().toString();

                                if (password.equals("1234")) {
                                    Toast toast = Toast.makeText(getApplicationContext(), "Hey,Passcode Matched", Toast.LENGTH_SHORT);
                                    View view=toast.getView();
                                    view.getBackground().setColorFilter(Color.LTGRAY, PorterDuff.Mode.SRC_IN);
                                    TextView text =view.findViewById(android.R.id.message);
                                    text.setTextColor(Color.BLUE);
                                    toast.show();
                                    finish();
                                }
                                else
                                {
                                    Toast toast = Toast.makeText(getApplicationContext(), "Sorry,Wrong Passcode!", Toast.LENGTH_SHORT);
                                    View view=toast.getView();
                                    view.getBackground().setColorFilter(Color.LTGRAY, PorterDuff.Mode.SRC_IN);
                                    TextView text =view.findViewById(android.R.id.message);
                                    text.setTextColor(Color.RED);
                                    toast.show();
                                }
                            }
                        });

                alertDialog.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                alertDialog.show();
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        //getSupportActionBar().setTitle(sb);
        if(mwebview.canGoBack())
        {
            alertDialog = new AlertDialog.Builder(MainActivity.this);
            alertDialog.setTitle("PASSCODE");
            alertDialog.setMessage(" Enter Security Passcode ");
            final EditText input = new EditText(MainActivity.this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            input.setLayoutParams(lp);
            alertDialog.setView(input);
            alertDialog.setPositiveButton("YES",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            String password = input.getText().toString();

                            if (password.equals("1234")) {
                                Toast toast = Toast.makeText(getApplicationContext(), "Hey,Passcode Matched", Toast.LENGTH_SHORT);
                                View view=toast.getView();
                                view.getBackground().setColorFilter(Color.LTGRAY, PorterDuff.Mode.SRC_IN);
                                TextView text =view.findViewById(android.R.id.message);
                                text.setTextColor(Color.BLUE);
                                toast.show();
                                mwebview.goBack();
                            }
                            else
                            {
                                Toast toast = Toast.makeText(getApplicationContext(), "Sorry,Wrong Passcode!", Toast.LENGTH_SHORT);
                                View view=toast.getView();
                                view.getBackground().setColorFilter(Color.LTGRAY, PorterDuff.Mode.SRC_IN);
                                TextView text =view.findViewById(android.R.id.message);
                                text.setTextColor(Color.RED);
                                toast.show();
                            }
                        }
                    });

            alertDialog.setNegativeButton("NO",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

            alertDialog.show();
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mwebview.saveState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mwebview.restoreState(savedInstanceState);
    }
}


