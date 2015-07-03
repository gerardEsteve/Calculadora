
package com.example.gerard.calculadora;

//import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;


public class Calculadora extends ActionBarActivity implements View.OnClickListener {


    //                    String s = "123.25";
//                    double d= Double.parseDouble(s);
//                    Toast.makeText(Calculadora.this, " el double vale : " + d, Toast.LENGTH_SHORT).show();

    Integer decimal;
    String s_primer;
    String s_segon;
    Boolean coma;
    Button bcoma;

    String op;
    Button anss;
    Button delete;
    Button b9;
    Button b8;
    Button b7;
    Button b6;
    Button b5;
    Button b4;
    Button b3;
    Button b2;
    Button b1;
    Button b0;
    Button sumar;
    Button restar;
    Button multiplicar;
    Button dividir;
    Button result;
    Double resultat;
    Integer primer;
    Integer segon;
    Boolean sumatori;
    Boolean restador;
    Boolean multiplicador;
    Boolean divisor;
    TextView resultat_final;
    Button clear;
    Double ans;

    private void number(int num){
        if(!sumatori && !restador && !multiplicador && !divisor ){
            if(!coma){
                primer = (primer*10)+num;
                resultat_final.setText(primer.toString());
            }
            else{
                decimal = (decimal*10)+num;
                resultat_final.setText(primer.toString()+"."+decimal.toString());
            }
            s_primer = primer.toString() + "." + decimal.toString();


        }
        else{
            if(!coma){
                decimal = 0;
                segon = (segon*10)+num;
                resultat_final.setText(s_primer + op + segon.toString());
            }
            else{
                decimal = (decimal*10)+num;
                resultat_final.setText(s_primer + op + segon.toString()+"."+decimal.toString());
            }
            s_segon = segon.toString() + "." + decimal.toString();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Primer", primer);
        outState.putInt("Segon", segon);
        outState.putDouble("resultat", resultat);
        outState.putString("resultat_final", resultat_final.getText().toString());
        outState.putBoolean("sumatori", sumatori);
        outState.putBoolean("restador", restador);
        outState.putBoolean("multiplicador", multiplicador);
        outState.putBoolean("divisor", divisor);
        outState.putString("op", op);
        outState.putDouble("ans", ans);

        outState.putString("s_primer", s_primer);
        outState.putString("s_segon", s_segon);
        outState.putBoolean("coma",coma);
        outState.putInt("decimal",decimal);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState != null){
            op = savedInstanceState.getString("op"," ");
            primer = savedInstanceState.getInt("Primer", 0);
            segon = savedInstanceState.getInt("Segon", 0);
            resultat = savedInstanceState.getDouble("resultat", 0);
            resultat_final.setText(savedInstanceState.getString("resultat_final", "0"));
            sumatori = savedInstanceState.getBoolean("sumatori",false);
            restador = savedInstanceState.getBoolean("restador",false);
            multiplicador = savedInstanceState.getBoolean("multiplicador",false);
            divisor = savedInstanceState.getBoolean("divisor", false);
            ans = savedInstanceState.getDouble("ans", 0);

            coma = savedInstanceState.getBoolean("coma", coma);
            s_primer=savedInstanceState.getString("s_primer",s_primer);
            s_segon=savedInstanceState.getString("s_segon",s_segon);
            decimal= savedInstanceState.getInt("decimal",0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc);
        sumatori = false;
        restador = false;
        multiplicador = false;
        divisor = false;
        primer = 0;
        segon = 0;
        resultat = 0.0;
        ans = 0.0;
        resultat_final = (TextView)findViewById(R.id.textView6);
        op = " ";

        s_primer=" ";
        s_segon=" ";
        coma = false;
        decimal = 0;

        resultat_final.setText(resultat.toString());

        bcoma = (Button)findViewById(R.id.coma);
        bcoma.setOnClickListener(this);

        delete = (Button)findViewById(R.id.delete);
        b9 = (Button)findViewById(R.id.b9);
        b8 = (Button)findViewById(R.id.b8);
        b7 = (Button)findViewById(R.id.b7);
        b6 = (Button)findViewById(R.id.b6);
        b5 = (Button)findViewById(R.id.b5);
        b4 = (Button)findViewById(R.id.b4);
        b3 = (Button)findViewById(R.id.b3);
        b2 = (Button)findViewById(R.id.b2);
        b1 = (Button)findViewById(R.id.b1);
        b0 = (Button)findViewById(R.id.b0);
        anss = (Button)findViewById(R.id.ans);
        sumar = (Button)findViewById(R.id.sum);
        restar = (Button)findViewById(R.id.rest);
        multiplicar = (Button)findViewById(R.id.mult);
        dividir = (Button)findViewById(R.id.div);
        result = (Button)findViewById(R.id.igual);
        clear = (Button)findViewById(R.id.clear);

        anss.setOnClickListener(this);
        delete.setOnClickListener(this);
        b9.setOnClickListener(this);
        b8.setOnClickListener(this);
        b7.setOnClickListener(this);
        b6.setOnClickListener(this);
        b5.setOnClickListener(this);
        b4.setOnClickListener(this);
        b3.setOnClickListener(this);
        b2.setOnClickListener(this);
        b1.setOnClickListener(this);
        b0.setOnClickListener(this);
        sumar.setOnClickListener(this);
        restar.setOnClickListener(this);
        multiplicar.setOnClickListener(this);
        dividir.setOnClickListener(this);
        result.setOnClickListener(this);
        clear.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {



        switch(v.getId()){
            case R.id.coma:
                coma = true;
                if(!sumatori && !restador && !multiplicador && !divisor ) {
                    resultat_final.setText(s_primer);
                }
                else resultat_final.setText(s_primer + op + s_segon);

                break;
            case R.id.b9:
                number(9);
//                if(!sumatori && !restador && !multiplicador && !divisor ){
//                    if(!coma){
//                        primer = (primer*10)+9;
//                        resultat_final.setText(primer.toString());
//                    }
//                    else{
//                        decimal = (decimal*10)+9;
//                        resultat_final.setText(primer.toString()+"."+decimal.toString());
//                    }
//                    s_primer = primer.toString() + "." + decimal.toString();
//
//
//                }
//                else{
//                    if(!coma){
//                        decimal = 0;
//                        segon = (segon*10)+9;
//                        resultat_final.setText(s_primer + op + segon.toString());
//                    }
//                    else{
//                        decimal = (decimal*10)+9;
//                        resultat_final.setText(s_primer + op + segon.toString()+"."+decimal.toString());
//                    }
//                    s_segon = segon.toString() + "." + decimal.toString();
//                }
                //  Toast.makeText(Calculadora.this, "Primer: "+primer +" Segon: "+segon, Toast.LENGTH_SHORT).show();
                break;
            case R.id.b8:
                number(8);
                break;

            case R.id.b7:
              number(7);
                break;

            case R.id.b6:
                number(6);
                break;

            case R.id.b5:
                number(5);
                break;

            case R.id.b4:
               number(4);
                break;

            case R.id.b3:
               number(3);
                break;

            case R.id.b2:
                number(2);
                break;

            case R.id.b1:
                number(1);
                break;

            case R.id.b0:
               number(0);
                break;
            case R.id.ans:
                if(sumatori||restador||multiplicador||divisor){
                //  Toast.makeText(Calculadora.this, "entro en el primer if de ans", Toast.LENGTH_SHORT).show();
                    // segon = resultat;
                    resultat_final.setText(primer.toString() + op + ans.toString());
                }
                else {
                 //   Toast.makeText(Calculadora.this, "entro en el segundo if de ans", Toast.LENGTH_SHORT).show();
                   // primer = resultat;
                    resultat_final.setText(ans.toString());
                }
                break;
            case R.id.sum:
                sumatori = true;
                decimal = 0 ;
                restador = multiplicador = divisor = coma =false;
                op = "+";
                resultat_final.setText(s_primer + op);
                break;
            case R.id.rest:
                op = "-";
                resultat_final.setText(s_primer + op);
                restador = true;
                multiplicador = sumatori = divisor = coma = false;
                decimal = 0 ;

                break;
            case R.id.mult:
                op = "*";
                resultat_final.setText(s_primer + op);
                multiplicador = true;
                sumatori = restador = divisor = coma = false;
                decimal = 0 ;

                break;
            case R.id.div:
                op = "/";
                resultat_final.setText(s_primer + op);
                divisor = true;
                multiplicador = sumatori = restador = coma = false;
                decimal = 0 ;

                break;
            case R.id.igual:
                if( (s_primer.equals("0.0")||s_primer.equals("0")) && ( s_segon.equals("0") || s_segon.equals("0.0")) && divisor){
                    resultat_final.setText(" ERROR, 0 / 0 " );
                    // AQUI TRACTAR MAS ERRORES

                }
                else if(sumatori){

                    resultat = Double.parseDouble(s_primer) + Double.parseDouble(s_segon);
                   // resultat = primer+segon;

                    resultat_final.setText(resultat_final.getText() + " = " + resultat.toString());
                    ans = resultat;
                   // primer = resultat;
                    segon = 0;
                    sumatori=false;
                    decimal = 0 ;
                    coma = false;
                }
                else if(restador){
                    resultat = Double.parseDouble(s_primer) - Double.parseDouble(s_segon);

                   // resultat = primer-segon;
                    resultat_final.setText(resultat_final.getText()+" = " + resultat.toString());
                    ans = resultat;
                   // primer = resultat;
                    segon = 0;
                    restador = false;
                    decimal = 0 ;
                    coma = false;
                }
                else if(multiplicador){
                    resultat = Double.parseDouble(s_primer) * Double.parseDouble(s_segon);

                 //   resultat = primer*segon;
                    resultat_final.setText(resultat_final.getText()+" = " + resultat.toString());
                    ans = resultat;
                  //  primer = resultat;
                    segon = 0;
                    multiplicador = false;
                    decimal = 0 ;
                    coma = false;
                }
                else if(divisor){
                    if(s_segon.equals("0") || s_segon.equals("0.0")){
                        resultat_final.setText("ERROR DIVISION ENTRE 0");
                    }
                    else{
                        resultat = Double.parseDouble(s_primer) / Double.parseDouble(s_segon);

                    //    resultat = primer/segon;
                        resultat_final.setText(resultat_final.getText()+" = " + resultat.toString());
                        ans = resultat;
                    //    primer = resultat;
                        segon = 0;
                        decimal = 0 ;
                        coma = false;
                    }

                    divisor = false;
                }
                else Toast.makeText(Calculadora.this, "Click An Operation Before This", Toast.LENGTH_SHORT).show();

                break;
            case R.id.clear:
                primer = 0;
                segon = 0;
                resultat = 0.0;
                sumatori = coma = multiplicador = divisor = restador = false;
                resultat_final.setText(resultat.toString());
                decimal = 0;
                break;
            case R.id.delete:
                if(!sumatori && !restador && !multiplicador && !divisor ){
                    if(coma){
                        decimal = decimal/10;
                        if(decimal==0)coma = false;
                    }
                    else{
                        primer = primer/10;
                    }

                    s_primer = primer.toString() + "." + decimal.toString();

                    resultat_final.setText(s_primer);
                }
                else if(s_segon.equals("0.0") &&( sumatori || restador || multiplicador || divisor)){
                    resultat_final.setText(s_primer);
                   // String aux[] = s_primer.split(".");
                   // decimal = Integer.valueOf(aux[1]);
                    Boolean trobat = false;
                    char aux2;
                    for(int i = 0; i < s_primer.length();++i){
                        if(s_primer.charAt(i)=='.'){
                            trobat = true;
                            ++i;
                        }
                        if(trobat){
                            aux2 = s_primer.charAt(i);
                            decimal += Integer.valueOf(String.valueOf(aux2));
                            decimal *= 10;
                        }
                    }

                    if(decimal==0)coma = false;
                    else coma = true;
                    sumatori = restador = multiplicador = divisor = false;
                }
                else{
                    if(coma){
                        decimal=decimal/10;
                        if(decimal==0)coma = false;
                    }
                    else{
                        segon = segon / 10;
                    }
                    s_segon = segon.toString() + "." + decimal.toString();
                    resultat_final.setText(s_primer + op + s_segon);
                }
                Toast.makeText(Calculadora.this, "Primer: "+primer +" Segon: "+segon, Toast.LENGTH_SHORT).show();

                break;
            default:
                break;


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculadora, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
