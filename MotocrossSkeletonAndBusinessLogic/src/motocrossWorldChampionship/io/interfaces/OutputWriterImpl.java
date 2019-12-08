package motocrossWorldChampionship.io.interfaces;

public class OutputWriterImpl implements OutputWriter {
    @Override
    public void writeLine(String text) {
        System.out.println(text);
    }
}
