package telephonyexercise;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : this.numbers) {
            if (number.matches("[0-9]+")) {
                sb.append("Calling... ");
                sb.append(number);
                sb.append(System.lineSeparator());
            } else {
                sb.append("Invalid number!");
            }
        }
        return sb.toString().trim();
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
            for (String url : this.urls) {
                if (Pattern.compile("[0-9]").matcher(url).find()) {
                    sb.append("Invalid URL!");
                } else {
                    sb.append("Browsing: ");
                    sb.append(url);
                    sb.append("!");
                    sb.append(System.lineSeparator());
                }
            }
        return sb.toString().trim();
    }
}
