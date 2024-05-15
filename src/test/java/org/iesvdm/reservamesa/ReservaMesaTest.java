package org.iesvdm.reservamesa;

//import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class ReservaMesaTest {
    private ReservaMesa tested;

    private OutputStream output;

    @BeforeEach
    public void beforeEachTest() {
        output = new ByteArrayOutputStream();
        tested = new ReservaMesa();
    }
    @Test
    public void buscarPrimeraMesaVaciaTest(){
        int[] array = new int[3];

        array[0] = 1;
        array[1] = 0;
        array[2] = 3;
        tested.setMesas(array);
        assertThat(tested.buscarPrimeraMesaVacia()).isEqualTo(1);
    }

    @Test
    public void buscarMesaParaCompartirTest(){


        int[] array = new int[3];
        int numPersonas = 2;
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        tested.setTamanioMesa(4);
        tested.setMesas(array);


        assertThat(tested.buscarMesaParaCompartir(numPersonas)).isEqualTo(0);
    }

    @Test
    public void buscarMesaCompartirMasCercaDe(){
        int cercano = 1;
        int[] array = new int[4];
        int numPersonas = 2;
        array[0] = 1;
        array[1] = 4;
        array[2] = 3;
        array[3] = 1;
        tested.setTamanioMesa(4);
        tested.setMesas(array);
        assertThat(tested.buscarMesaCompartirMasCercaDe(0, numPersonas)).isEqualTo(0);
    }

    @Test
    public void buscarMesaCompartirMasAlejadaDe(){
        int[] array = new int[4];
        int numPersonas = 2;
        array[0] = 0;
        array[1] = 4;
        array[2] = 4;
        array[3] = 1;
        tested.setTamanioMesa(4);
        tested.setMesas(array);
        assertThat(tested.buscarMesaCompartirMasAlejadaDe(2, 2)).isEqualTo(0);
    }

    @Test
    public void buscarCompartirNMesasConsecutivasTest(){
        int[] array = new int[4];
        int numPersonas = 2;
        tested.setTamanioMesa(4);
        array[0] = 2;
        array[1] = 2;
        array[2] = 4;
        array[3] = 1;
        tested.setMesas(array);
        assertThat(tested.buscarCompartirNMesasConsecutivas(2, 3)).isEqualTo(0);
    }
    @Test
    public void comensalesTotalesTest(){
        int[] array = new int[4];
        tested.setTamanioMesa(4);
        array[0] = 2;
        array[1] = 2;
        array[2] = 4;
        array[3] = 1;
        tested.setMesas(array);
        assertThat(tested.comensalesTotales()).isEqualTo(9);
    }
}
