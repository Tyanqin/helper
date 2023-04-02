package com.zxt.helper.service;

import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author:TanXiao
 * @date:2023/3/21
 */

@Service
public interface TessdataServer {

    public boolean dosoc(String fileName) throws TesseractException, IOException;
}
