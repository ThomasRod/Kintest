package app.stwAndo.service.impl;

import org.springframework.stereotype.Component;
import app.stwAndo.service.StwAndoService;

@Component
public class StwAndoServiceImpl implements StwAndoService {

    @Override
    public String buildStwAndo(Integer i) {
        String swtAndo = "";
        if(i % 3 == 0) {
            swtAndo = "Stw";
        }

        if(i % 5 == 0) {
            swtAndo += "Ando";
        }
        return swtAndo;
    }
}
