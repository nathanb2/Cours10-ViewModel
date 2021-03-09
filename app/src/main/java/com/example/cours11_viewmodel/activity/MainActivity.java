package com.example.cours11_viewmodel.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.cours11_viewmodel.R;
import com.example.cours11_viewmodel.model.User;
import com.example.cours11_viewmodel.view_mdel.UsersViewModel;

import java.util.List;

/**
 * Affiche les donnees  ou en ajoute suite a un click utilisateur
 * Ne connait que userRepository et n'a aucune idee que userRepository amene le donnees depuis une DataBAse , ce n'est pas son probleme.
 * MainActivity demande des users ou indique en creer un au repository , celui ci se chargera de le faire realiser au responsable des donnees (ic la DB avec son DAO)
 *
 * MainActivity peut reactualiser l'affichage des qu'il y a modification des donnees a afficher grace au LiveData voire ci-dessous
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UsersViewModel usersViewModel = new ViewModelProvider(this).get(UsersViewModel.class);

        TextView textView = findViewById(R.id.AM_tv);

        usersViewModel.getAllUsers().observe(this, new Observer<List<User>>() {
            //onChanged est appele a chaque fois que la valeurs de getALlUsers change et recoit en parametre  la nouvelle valeur de getAllUsers
            @Override
            public void onChanged(List<User> users) {
                // Update the UI, in this case, a TextView.
                textView.setText(users.get(0).getName());
            }
        });

        findViewById(R.id.AM_change_name).setOnClickListener(v -> {
            User user = usersViewModel.getAllUsers().getValue().get(0);
            user.setName("Nathan");
            usersViewModel.updateUser(user);
        });

    }

}
