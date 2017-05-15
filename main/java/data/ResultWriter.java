package main.java.data;

import main.java.business.Student;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ResultWriter {

    private File file;


    public void writeResult(Student student, double wAcc, double wConc) throws IOException{
        String filename = student.getUsername() + "_" + student.getGroup();
        File file = new File("/C:/Issledovanie/results/" + filename + ".txt");
        FileWriter writer = new FileWriter(file);
        String name = "Имя: " + student.getUsername() + System.lineSeparator();
        String gruop = "Группа: " + student.getGroup() + System.lineSeparator();
        String attention = "Коэффициент устойчивости внимания: " + wAcc + System.lineSeparator();
        String conc = "Коэффициент концентрации внимания: " + wConc + System.lineSeparator();
        String found = "Количество найденых символов: " + String.valueOf(student.getSymbolsFound()) + System.lineSeparator();
        String missed = "Количество пропущенных символов: " + String.valueOf(student.getMissedSymbols()) + System.lineSeparator();
        String wrong = "Количество неверно отмеченных символов: " + String.valueOf(student.getWrongSymbols()) + System.lineSeparator();
        writer.write(name);
        writer.write(gruop);
        writer.write(attention);
        writer.write(conc);
        writer.write(found);
        writer.write(missed);
        writer.write(wrong);
        writer.close();
    }

}
