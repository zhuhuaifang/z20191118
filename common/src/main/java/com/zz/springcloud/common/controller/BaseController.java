package com.zz.springcloud.common.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;


public abstract class BaseController {
    Logger LOGGER = LogManager.getLogger(this.getClass());
}
