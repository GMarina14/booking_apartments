package com.example.booking_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

import static com.example.booking_server.constant.ServerConstants.RESTART_DB;

@RestController
public class RestartDbController {

    /**
     * Opens the CMD window
     * Select the command to be executed.
     * The selected command is used as a text String.
     * Execute the selected command in the opened CMD window
     */

    @GetMapping(RESTART_DB)
    public void restartDb() {

        String directoryPath = "C:\\Users\\user\\IdeaProjects\\booking_apartments";
        String command = "docker-compose up";

        try {
            Process startCMD = Runtime.getRuntime().exec("cmd.exe /c start");

            startCMD.getOutputStream().write(command.getBytes());

            //   Process startCMD = Runtime.getRuntime().exec(new String[]{ "cmd.exe /c start", command });
            // Runtime.getRuntime().exec(new String[]{directoryPath, command});
            //  BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(startCMD.getOutputStream()));
            //  writer.write(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
