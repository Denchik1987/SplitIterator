package problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LogInfo implements Comparable<LogInfo> {

    private String identifier;
    private String content;

    public LogInfo(String input){
        int spacePos = input.indexOf(" ");
        this.identifier = input.substring(0, spacePos+1).trim();
        this.content = input.substring(spacePos).trim();
    }

    public boolean isNumericOnly(){
        return content.replace(" ", "").matches("^\\d+$");
    }

    public List<String> reorderLines(int logFileSize, List<String> logLines)
    {
        List<LogInfo> allInfo = logLines.stream().map(LogInfo::new).collect(Collectors.toList());

        List<LogInfo> alfaNumeric = allInfo.stream()
                .filter(s -> !s.isNumericOnly())
                .sorted()
                .collect(Collectors.toList());
        List<LogInfo> numericOnly = allInfo.stream()
                .filter(LogInfo::isNumericOnly)
                .collect(Collectors.toList());
        List<LogInfo> combined = new ArrayList<>(alfaNumeric);
        combined.addAll(numericOnly);

        return null;
       /* return combined.stream()
                .map(LogInfo::output)
                .collect(Collectors.toList());*/
    }

    @Override
    public int compareTo(LogInfo o) {
        return 0;
    }
}
