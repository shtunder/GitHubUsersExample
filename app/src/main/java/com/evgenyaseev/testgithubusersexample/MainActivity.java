package com.evgenyaseev.testgithubusersexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainPresenter.Listener {

    private RecyclerView recyclerView;
    private MainPresenter presenter;
    private Button retryButton;
    private ProgressBar loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.users_recycle);
        retryButton = findViewById(R.id.retry_button);
        retryButton.setOnClickListener(view -> {
            presenter.loadUsers();
            retryButton.setVisibility(View.GONE);
            loadingBar.setVisibility(View.VISIBLE);
        });
        loadingBar = findViewById(R.id.loadingBar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        GitHubService service = ((GitHubApplication) getApplication()).getGitHubService();
        presenter = new MainPresenter(service, this);
        presenter.loadUsers();
        loadingBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onUsersLoaded(List<User> users) {
        loadingBar.setVisibility(View.GONE);
        recyclerView.setAdapter(new UserAdapter(users));
    }

    @Override
    public void onError(String message) {
        loadingBar.setVisibility(View.GONE);
        retryButton.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.stopLoading();
    }
}
