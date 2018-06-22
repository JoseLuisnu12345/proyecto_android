package d.edu.itla.taskapp.Vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import d.edu.itla.taskapp.R;
import d.edu.itla.taskapp.Repositorio.CategoriaRepositorio;
import d.edu.itla.taskapp.entidad.Categoria;

public class CategoriaActivity extends AppCompatActivity {

    private static final String LOG_TAG = "CategoriaActivity";
    private CategoriaRepositorio categoriaRepositorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

        final EditText txtNombre = (EditText) findViewById(R.id.txtNombreCategoria);
                Button btnGuardar = (Button) findViewById(R.id.btnGuardarCategoria);

                btnGuardar.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                       Categoria categoria = new Categoria ();
                       categoria.setDescripcion(txtNombre.getText().toString());
                       //log
                        Log.i(LOG_TAG, categoria.toString());
                        //guardar
                        categoriaRepositorio.guardar(categoria);
                        //log
                        Log.i(LOG_TAG, categoria.toString());
                        //toast
                        Toast toast = Toast.makeText(getApplicationContext(), "Guardado correctamente", Toast.LENGTH_SHORT);
                        toast.show();
                        //txt en blanco
                        txtNombre.setText("");
                    }
                });

    }
}
