package com.estudo.carros.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import com.estudo.carros.domain.Carro
import com.estudo.carros.R;
import com.estudo.carros.utils.loadUrl
import kotlinx.android.synthetic.main.activity_carro.*
import kotlinx.android.synthetic.main.activity_carro_contents.*
import org.jetbrains.anko.startActivity

class CarroActivity : BaseActivity(){
    val carro by lazy { intent.getSerializableExtra("carro") as Carro }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_carro)

        setUpToolbar(R.id.toolbar, carro.nome, true)

        //Atualiza descrição
        tDesc.text = carro.desc
        //Mostra foto do carro
        appBarImg.loadUrl(carro.urlFoto)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_carro, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.action_editar -> {
                //abrimos a tela para edicao
                startActivity<CarroFormActivity>("carro" to carro)
                finish()
            }
            R.id.action_deletar -> {
                toast("deletar carro")
            }
        }

        return super.onOptionsItemSelected(item)
    }
}