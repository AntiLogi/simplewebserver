package com.ayyovei.simplewebserver;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author chenxiaobin
 * @description
 * @create 2019/7/3
 */
@Setter
@Getter
@NoArgsConstructor
public class Request {

    private Logger logger = LoggerFactory.getLogger(Request.class);

    private InputStream inputStream;

    private String uri;

    private String fullRequestMsg;

    public Request(InputStream inputStream) {
        this.inputStream = inputStream;
    }


    public void parse() {
        byte[] buffer = new byte[2048];
        int read = 0;
        StringBuffer stringBuffer = new StringBuffer();

        try {
            read = inputStream.read(buffer);
        } catch (IOException e) {
            logger.error(" inputStream read nothing");
        }

        for (int i = 0; i < read; i++) {
            stringBuffer.append((char) buffer[i]);
        }

        fullRequestMsg = stringBuffer.toString();

    }

    private void parseUri() {
        int idx = fullRequestMsg.indexOf(" ");
        if (idx == -1) {
            logger.error(" no uri found");
            uri = "";
            return;
        }

        int nextIdx = fullRequestMsg.indexOf(" ", idx + 1);

        if (nextIdx == -1) {
            logger.error(" no uri found");
            uri = "";
            return;
        }
        uri = fullRequestMsg.substring(idx + 1, nextIdx);

    }

}
