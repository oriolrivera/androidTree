package com.maestrodetalle.com.maestrodetalle;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.maestrodetalle.com.maestrodetalle.entidades.PersonajeVo;
import com.maestrodetalle.com.maestrodetalle.fragments.ListaPersonajesFragment;
import com.maestrodetalle.com.maestrodetalle.utilidades.Utilidades;

public class MainActivity extends AppCompatActivity implements ListaPersonajesFragment.OnFragmentInteractionListener {

    ListaPersonajesFragment listaFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Validamos que se trabaja en modo portrait desde un smarthPhone
        if(findViewById(R.id.contenedorFragment)!=null){
            Utilidades.PORTRAIT=true;
            if (savedInstanceState!=null){
                return;
            }
            listaFragment=new ListaPersonajesFragment();
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.contenedorFragment,listaFragment).commit();
        }else{
            Utilidades.PORTRAIT=false;
        }
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
