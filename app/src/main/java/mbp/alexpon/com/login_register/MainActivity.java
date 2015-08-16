package mbp.alexpon.com.login_register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    private EditText name;
    private EditText age;
    private EditText username;
    private Button logout;
    private UserLocalStore userLocalStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setListener();
    }

    public void initViews(){
        name = (EditText) findViewById(R.id.edMN);
        age = (EditText) findViewById(R.id.edMAge);
        username = (EditText) findViewById(R.id.edMUN);
        logout = (Button) findViewById(R.id.logout);
        userLocalStore = new UserLocalStore(this);
    }

    public void setListener(){
        logout.setOnClickListener(myListener);
    }

    private View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            userLocalStore.clearUserData();
            userLocalStore.setUserLoggedIn(false);

            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
        }
    };

    protected void onStart(){
        super.onStart();
        if(authenticate()==true){
            displayUserDetails();
        }
        else{
            startActivity(new Intent(MainActivity.this, Login.class));
        }
    }

    private boolean authenticate(){
        return userLocalStore.getUserLoggedIn();
    }

    private void displayUserDetails(){
        User user = userLocalStore.getLoggedInUser();

        name.setText(user.name);
        username.setText(user.username);
        age.setText(user.age + "");
    }


}
