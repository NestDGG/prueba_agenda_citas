package com.prueba.prueba.app.util;


import lombok.Getter;

@Getter
public enum ResponseCode {
    CODE_000("Peticion exitosa."),
    CODE_001("No se puede agendar cita en un mismo consultorio a la misma hora."),
    CODE_002("No se puede agendar cita para un mismo Dr. a la misma hora"),
    CODE_003("Un mismo doctor no puede tener más de 8 citas en el día"),
    CODE_004("No se puede agendar cita para un paciente a la una misma hora ni con menos de 2 horas\n" +
            "de diferencia para el mismo día."),
    CODE_005("Cita no encontrada."),
    CODE_006("No se puede cancelar una cita que ya ha ocurrido o está en curso.");


    private final String message;

    ResponseCode(String message) {
        this.message = message;
    }
}
