package com.logging.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LogController {

//    private final String logFilePath = "C:\\Users\\sushant.raj\\Desktop\\catalina.out"; // Local file path
    private final String logFilePath = "/opt/apache-tomcat-9.0.93/logs/catalina.out"; // Server file path

    private long previousFilePointer = 0;

    @GetMapping("/logs")
    public String getLogsPage(Model model) {
        return "logView";
    }

    @GetMapping("/api/logs")
    @ResponseBody
    public LogResponse getLogsApi(@RequestParam(required = false, defaultValue = "0") long offset) throws IOException {
        Path logFile = Paths.get(logFilePath);
        List<String> newLogs = new ArrayList<>();
        long fileLength = logFile.toFile().length();


        if (offset > fileLength) {
            offset = 0;
        }

        try (RandomAccessFile file = new RandomAccessFile(logFile.toFile(), "r")) {
            file.seek(offset);
            String line;
            while ((line = file.readLine()) != null) {
                newLogs.add(line);
            }
            offset = file.getFilePointer();
        }

        return new LogResponse(newLogs, offset);
    }


    public static class LogResponse {
        private List<String> logs;
        private long offset;

        public LogResponse(List<String> logs, long offset) {
            this.logs = logs;
            this.offset = offset;
        }

        public List<String> getLogs() {
            return logs;
        }

        public long getOffset() {
            return offset;
        }
    }
}
